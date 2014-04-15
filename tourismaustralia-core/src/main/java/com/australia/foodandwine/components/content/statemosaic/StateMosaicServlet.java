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
import javax.servlet.http.HttpSession;

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
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@SlingServlet( resourceTypes="foodandwine/components/content/stateMosaic", selectors="ccs",extensions="json",methods="POST")
public class StateMosaicServlet extends SlingAllMethodsServlet
{
	private String name;
	private Node node;
	private String path,queryString;
	private List<StateMosaiacProperties> propertiesList;
	private LinkedList<String> x;
	private String[] categoryTags;
	private static final JsonFactory FACTORY = new JsonFactory();
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
		
		String stateTags=request.getParameter("stateTag").toLowerCase();
		categoryTags=request.getParameterValues("catogoryArray");
//		TagManager tagManager = request.getResourceResolver().adaptTo(TagManager.class);
//		List<Tag> stateTag = TagUtils.getFoodAndWineCategoryTags(tagManager, categoryTags);
//		//String tagid=stateTag.getTagID();
//		for(Tag tag:stateTag)
//		{
//			String text=tag.getTagID();
//			text.length():
//		}
		//tagid.length();
		//SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE([/content/food-and-wine]) and [cq:tags] like '%victoria%' and [cq:tags] like '%restaurant%'
		 
		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		//Page currentPage = pageManager.getContainingPage(request.getResource());
		//String[] pageTags = currentPage.getProperties().get("cq:tags", new String[0]);
		
		
	
		Session session = request.getResourceResolver().adaptTo(Session.class);
		try {
			QueryManager queryManager = session.getWorkspace().getQueryManager();
			propertiesList=new LinkedList<StateMosaiacProperties>();
			for(String s:categoryTags){
				 queryString="SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE([/content/food-and-wine]) and [cq:tags] like '%"+s.trim().toLowerCase()+"%' and [cq:tags] like '%"+stateTags.trim()+"%'";
				 
			Query query = queryManager.createQuery(queryString,Query.JCR_SQL2);
				query.setLimit(10);
				QueryResult result = query.execute();
				RowIterator rowIterator = result.getRows();
				
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
					propertiesList.add(bean);

				}
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonGenerator generator = FACTORY.createGenerator(response.getWriter());
		MAPPER.writeValue(generator, propertiesList);
		propertiesList.clear();
		
		
		
     
    }
}