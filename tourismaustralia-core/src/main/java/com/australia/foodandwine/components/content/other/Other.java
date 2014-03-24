package com.australia.foodandwine.components.content.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Other Experiences", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Other {
	@DialogField(fieldLabel = "Articles")
	@MultiCompositeField
	private final List<Article> articles;
	public Other(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		String myPath = request.getResource().getPath();
		String itemPath = myPath + "/articles";
		Resource articlesResource = request.getResourceResolver().resolve(itemPath);
		List<Article> myArticles=null;
		if ( articlesResource != null ) { 
			Iterable<Resource> children = articlesResource.getChildren(); 
			myArticles=Collections.synchronizedList(new ArrayList<Article>());
			Iterator<Resource> myIter = children.iterator();
			while (myIter.hasNext()) { 
				Resource child = myIter.next();
				ValueMap vm = child.adaptTo(ValueMap.class);
				myArticles.add(new Article(child));
			}
		}
		articles = myArticles; 
	}
	public List<TagArticle> getTagArticles() {		
		List<TagArticle> rv=null;
		if ((articles != null) && (articles.size() > 0))  { 
			Map<String, List<Article>> tmpMap = Collections.synchronizedMap(new HashMap<String,List<Article>>());
			for (Article article: articles) { 
				String key=article.getTags();
				List<Article> list = tmpMap.get(key);
				if ( list == null ) { 
					list=Collections.synchronizedList(new ArrayList<Article>());
					tmpMap.put(key, list);
				}
				list.add(article);
			}
		    if (!tmpMap.keySet().isEmpty()) { 
				rv=Collections.synchronizedList(new ArrayList<TagArticle>());
				Iterator<String> keys = tmpMap.keySet().iterator();
				while (keys.hasNext()) { 
					String tagKey = keys.next();
					TagArticle tagArticle=new TagArticle(tagKey,tmpMap.get(tagKey));
					rv.add(tagArticle);
				}		    	
		    }
		}
		return rv; 		
	}

}
