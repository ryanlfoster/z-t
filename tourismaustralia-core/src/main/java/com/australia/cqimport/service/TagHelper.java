package com.australia.cqimport.service;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.google.common.collect.ImmutableMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.*;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;
import java.util.*;

/**
 * Created by Viren Pushpanayagam on 17/04/2014.
 */
public class TagHelper {
    private static final Logger LOG = LoggerFactory.getLogger(TagHelper.class);
    private final static String SQL = "select * from cq:Tag where jcr:path like '/etc/tags/ta/%'";

    static ArrayList<String> ids;
    private static final Map<String, String> tagTileMap = ImmutableMap.<String, String> builder()
            .put("en", "jcr:title.en").put("it", "jcr:title.it").put("fr", "jcr:title.fr")
            .put("de", "jcr:title.de").put("es", "jcr:title.es").put("id", "csv/mapping_id.csv")
            .put("jp", "jcr:title.ja").put("ko", "cr:title.ko_kr").put("my", "csv/mapping_my.csv")
            .put("pt", "csv/mapping_pt.csv").put("zht", "jcr:title.zh_cn").build();

    public ArrayList<String> getTags(ResourceResolver resourceResolver, String lang){
        ids = new  ArrayList<String>();
        Session session = resourceResolver.adaptTo(Session.class);
        QueryManager qm;
        try {
            qm = session.getWorkspace().getQueryManager();
            Query query = qm.createQuery(SQL, Query.SQL);
            QueryResult result = query.execute();
            NodeIterator nodes = result.getNodes();
            String tempStr;

            while (nodes.hasNext()) {

                Node node = (Node) nodes.next();
                try{
                    tempStr = node.getProperty(tagTileMap.get(lang)).getString();

                    if(tempStr != null){
                        tempStr = tempStr.trim();
                        ids.add(tempStr);
                    }

                } catch(PathNotFoundException e){
                    LOG.error(e.getMessage(), e);
                }
            }

        } catch (RepositoryException e) {
            LOG.error(e.getMessage(), e);
        }

        return ids;
    }

    private void updateTags(ResourceResolver resourceResolver, String path, ArrayList<String> tags, String[] keywords){
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        Page page = pageManager.getPage(PageBuilder.CRX_ROOT_PATH + path);
        Resource pageResource;
        ArrayList<String> ids = new ArrayList<String>();

        if (page != null) {

            for(String s : keywords){

                if(tags.contains(s)){
                    ids.add(s);
                }
            }

            if(ids.size()>0){
                pageResource = page.adaptTo(Resource.class);
                Resource jcrContentResource = pageResource.getChild(JcrConstants.JCR_CONTENT);
                Node pageNode = jcrContentResource.adaptTo(Node.class);

                try {
                    String[] tempIds = ids.toArray(new String[ids.size()]);
                    pageNode.setProperty("cq:tags", tempIds);
                    resourceResolver.commit();

                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                }
            }

        }
    }

    public void addTagsToLanguage(ResourceResolver resourceResolver, String lang, String path, String keywords){

        updateTags(resourceResolver,path,ids, getKeywordsAsArray(keywords));
    }

    private String[] getKeywordsAsArray(String keywords){

        List<String> items = Arrays.asList(keywords.split("\\s*,\\s*"));
        return  items.toArray(new String[items.size()]);
    }
}
