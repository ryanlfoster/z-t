package com.australia.foodandwine.components.content.statemosaic;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import javax.jcr.query.Row;
import javax.jcr.query.RowIterator;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import com.australia.utils.LinkUtils;
import com.australia.utils.TagUtils;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.foundation.Image;

@SlingServlet( resourceTypes="foodandwine/components/content/stateMosaic", selectors="ccs",extensions="json",methods="POST")
public class StateMosaicServlet extends SlingAllMethodsServlet
{
	private String name;
	private Node node;
	private String path;
	private List<StateMosaiacProperties> properiesList;

	@Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
		
		String stateTags=request.getParameter("stateTag").toLowerCase();
		
		//SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE([/content/food-and-wine]) and [cq:tags] like '%victoria%' and [cq:tags] like '%restaurant%'
		String queryString="SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE([/content/food-and-wine]) and [cq:tags] like '%"+stateTags.trim()+"%'";
		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		//Page currentPage = pageManager.getContainingPage(request.getResource());
		//String[] pageTags = currentPage.getProperties().get("cq:tags", new String[0]);
		TagManager tagManager = request.getResourceResolver().adaptTo(TagManager.class);
		//Tag stateTag = TagUtils.getStateTag(tagManager, pageTags);
	
		Session session = request.getResourceResolver().adaptTo(Session.class);
		try {
			QueryManager queryManager = session.getWorkspace().getQueryManager();
			Query query = queryManager.createQuery(queryString, Query.JCR_SQL2);
				//query.setLimit(4);
				QueryResult result = query.execute();
				RowIterator rowIterator = result.getRows();
				properiesList=new LinkedList<StateMosaiacProperties>();
				while (rowIterator != null && rowIterator.hasNext()) {
					Row row = rowIterator.nextRow();
					path=row.getPath().replace("/jcr:content", "");
					Page articlePage = pageManager.getPage(path);
					ValueMap pageProperties = articlePage.getProperties();
					String title = articlePage.getTitle();
					String description=articlePage.getDescription();
					//description.length();
					String pagePth=LinkUtils.getHrefFromPath(articlePage.getPath());
					String image = null;
					Resource jcrResource = articlePage.adaptTo(Resource.class).getChild(JcrConstants.JCR_CONTENT);
					Image pageImage = new Image(jcrResource, "image");
					if (pageImage != null && pageImage.hasContent()) {
						image = pageImage.getPath() + ".img.jpg";
					}
					StateMosaiacProperties bean=new  StateMosaiacProperties(title,description,image,pagePth);
					properiesList.add(bean);

				}
			
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
     
    }
}