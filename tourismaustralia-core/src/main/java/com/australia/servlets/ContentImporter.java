package com.australia.servlets;

import com.australia.cqimport.service.ArticleBuilder;
import com.australia.cqimport.service.IconBuilder;
import com.australia.cqimport.service.PageBuilder;
import com.australia.cqimport.service.StateCityBuilder;
import com.australia.cqimport.vo.MappingVO;
import com.day.cq.wcm.api.WCMException;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;


import javax.servlet.ServletException;
import java.io.*;
import java.util.*;

/**
 * Created by Viren Pushpanayagam on 27/03/2014.
 */

/**
 * Paths to be created before you can call this servlet
 * /content/australia/places
 * /content/australia/articles
 * /content/australia/facts
 * /content/australia/facts/australias-seasons
 * /content/australia/planning
 *
  */


@SlingServlet(methods = {"POST"}, paths = "/apps/ta/servlets/ContentImporter")

@Properties({
        @Property(name = "service.pid", value = "au.com.dtdigital.ta.servlets.ContentImporter",
                propertyPrivate = false),
        @Property(name = "service.description", value = "Content Importer", propertyPrivate = false),
        @Property(name = "service.vendor", value = "DT Digital", propertyPrivate = false)})

public class ContentImporter extends SlingAllMethodsServlet {

    @Reference
    private ResourceResolverFactory resourceResolverFactory;
    Map<String,PageBuilder> templates = new Hashtable<String,PageBuilder>();

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
            IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
            IOException {
        ResourceResolver resourceResolver = null;

        // Add templates and builders
        templates.put("state",new StateCityBuilder());
        templates.put("city",new StateCityBuilder());
        templates.put("article", new ArticleBuilder());
        templates.put("icon", new IconBuilder());

        try {
            resourceResolver= resourceResolverFactory.getAdministrativeResourceResolver(null);
        } catch (LoginException e) {
            e.printStackTrace();
        }
        System.out.println("Start Importing *************************");

        PageBuilder pageBuilder;

        ArrayList<MappingVO> mappingVO = getMappings();

        Collections.sort(mappingVO,
                new Comparator<MappingVO>() {
                    public int compare(MappingVO obj1, MappingVO obj2) {
                        return obj1.getNewPath().compareTo(obj2.getNewPath());
                    }
                }
        );

        for(MappingVO map: mappingVO){

            pageBuilder = templates.get(map.getTemplate());

            if(pageBuilder == null){
                continue;
            }

            try {
                pageBuilder.createPage(map.getOldPath(), map.getNewPath(),
                        resourceResolver);

            } catch (WCMException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }


        System.out.println("Importing Finished *************************");
    }

    private ArrayList<MappingVO> getMappings(){

        InputStream file = this.getClass().getClassLoader().getResourceAsStream("prod-content/mapping.csv");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<MappingVO> mappingsList = new ArrayList<MappingVO>();
        try {

            br = new BufferedReader(new InputStreamReader(file));
            while ((line = br.readLine()) != null) {
                MappingVO mappingVO = new MappingVO();
                // use comma as separator
                String[] items = line.split(cvsSplitBy);
                mappingVO.setOldPath(items[2]);
                mappingVO.setNewPath(items[1]);
                mappingVO.setTemplate(items[0]);

                mappingsList.add(mappingVO);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return mappingsList;

    }
}
