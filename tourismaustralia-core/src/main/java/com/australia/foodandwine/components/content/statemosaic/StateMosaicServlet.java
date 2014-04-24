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
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.foodandwine.components.content.otherExperiences.OtherExperiences;
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
	/**
	 * Constants
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(StateMosaicServlet.class);
	private static final JsonFactory FACTORY = new JsonFactory();
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	/**
	 * Instance variables
	 */
	private String categoryTagName="";
	private String path,queryString;
	private List<StateMosaiacProperties> propertiesList;
	private  long limit=10,offset=0;
	private String[] categoryTags;
	private String cityTagName,stateTitle;
	

	@Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)   {
		
		process(request,response);
				
    }
	/**
	 * Process method to get 10 set of pages based on tags
	 * each time servlet called.
	 */
	private void process(SlingHttpServletRequest request,SlingHttpServletResponse response)   {
		String stateTags=request.getParameter("stateTag").toLowerCase();
		String flag=request.getParameter("flag");
		if(flag.equals("default"))
		{
			limit=10;
			offset=0;
		}
		if(flag.equals("showMore"))
		{
			limit+=10;
			offset+=10;
		}
		categoryTags=request.getParameterValues("catogoryArray");
		TagManager tagManager = request.getResourceResolver().adaptTo(TagManager.class);
		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		Session session = request.getResourceResolver().adaptTo(Session.class);
		try {
			QueryManager queryManager = session.getWorkspace().getQueryManager();
			propertiesList=new LinkedList<StateMosaiacProperties>();
			for(String s:categoryTags){
				queryString="SELECT * FROM [nt:base] AS s WHERE ISDESCENDANTNODE([/content/food-and-wine]) and ([cq:tags] like '%/"+s.trim()+"%' and [cq:tags] like '%"+stateTags.trim()+"%')";
				Query query = queryManager.createQuery(queryString,Query.JCR_SQL2);
				query.setOffset(offset);
				query.setLimit(limit);
				QueryResult result = query.execute();
				RowIterator rowIterator = result.getRows();
				while (rowIterator != null && rowIterator.hasNext()) {
					Row row = rowIterator.nextRow();
					path=row.getPath().replace("/jcr:content", "");
					Page articlePage = pageManager.getPage(path);
					
					ValueMap pageProperties = articlePage.getProperties();
					String[] tagsArray=pageProperties.get("cq:tags", new String[0]);
					String categoryLogo =pageProperties.get("categoryLogoPath","");
					Tag stateTag=TagUtils.getStateTag(tagManager, tagsArray);
					if(stateTag!=null)
						stateTitle =stateTag.getTitle().toString();
					List<Tag> categoryTagList = TagUtils.getFoodAndWineCategoryTags(tagManager, tagsArray);
					for(Tag tag:categoryTagList)
					{   
						if(!categoryTagName.contains(tag.getTitle()))
							categoryTagName+=tag.getTitle()+",";
					}
					Tag cityTag=TagUtils.getCityTag(tagManager, tagsArray);
					if(cityTag!=null)
						cityTagName=cityTag.getTitle().toString()+","+stateTitle;
					String templateName = articlePage.getTemplate().getName();
					if(!templateName.equals("facebookpage") && (!templateName.equals("instagrampagepage")) && (!templateName.equals("twitterpage")))
						templateName=null;
					else
						templateName=templateName.replace("page", "");
					String title = articlePage.getTitle();
					String description=articlePage.getDescription();
					String pagePth=LinkUtils.getHrefFromPath(articlePage.getPath());
					String image = null;
					Resource jcrResource = articlePage.adaptTo(Resource.class).getChild(JcrConstants.JCR_CONTENT);
					Image pageImage = new Image(jcrResource, "image");
					if (pageImage != null && pageImage.hasContent()) {
						image = pageImage.getPath() + ".img.jpg";
					}
					StateMosaiacProperties bean=new  StateMosaiacProperties(title,description,image,pagePth,stateTitle,categoryTagName,cityTagName,categoryLogo,templateName);
					categoryTagName="";
					propertiesList.add(bean);
					
				}
			}
		} catch (RepositoryException e) {
			LOG.error("Exception in query execution {0}",e.getMessage());
		} 
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JsonGenerator generator;
		try {
			generator = FACTORY.createGenerator(response.getWriter());
			MAPPER.writeValue(generator, propertiesList);
		} catch (IOException e) {
			LOG.error("Exception in IO oerations {0}",e.getMessage());
		}
		propertiesList.clear();
	}
}