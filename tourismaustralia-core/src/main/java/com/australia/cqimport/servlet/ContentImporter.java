package com.australia.cqimport.servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import javax.servlet.ServletException;

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

import com.australia.cqimport.service.ArticleBuilder;
import com.australia.cqimport.service.IconBuilder;
import com.australia.cqimport.service.PageBuilder;
import com.australia.cqimport.service.StateCityBuilder;
import com.australia.cqimport.vo.MappingVO;
import com.day.cq.wcm.api.WCMException;
import com.google.common.collect.ImmutableMap;

/**
 * Created by Viren Pushpanayagam on 27/03/2014.
 */

/**
 * Paths to be created before you can call this servlet
 * /content/australia/places /content/australia/articles
 * /content/australia/facts /content/australia/facts/australias-seasons
 * /content/australia/planning
 */

@SlingServlet(methods = { "POST" }, paths = "/apps/ta/servlets/ContentImporter")
@Properties({
	@Property(name = "service.pid", value = "com.australia.cqimport.servlet.ContentImporter", propertyPrivate = false),
	@Property(name = "service.description", value = "Content Importer", propertyPrivate = false),
	@Property(name = "service.vendor", value = "DT Digital", propertyPrivate = false) })
public class ContentImporter extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;

	@Reference
	private ResourceResolverFactory resourceResolverFactory;
	Map<String, PageBuilder> templates = ImmutableMap.<String, PageBuilder> builder()
		.put("state", new StateCityBuilder()).put("city", new StateCityBuilder()).put("article", new ArticleBuilder())
		.put("icon", new IconBuilder()).build();
	Map<String, String> languages = ImmutableMap.<String, String> builder().put("en", "csv/mapping_en.csv")
		.put("it", "csv/mapping_it.csv").put("fr", "csv/mapping_fr.csv").put("de", "csv/mapping_de.csv")
		.put("es", "csv/mapping_es.csv").put("id", "csv/mapping_id.csv").put("jp", "csv/mapping_jp.csv")
		.put("ko", "csv/mapping_ko.csv").put("my", "csv/mapping_my.csv").put("pt", "csv/mapping_pt.csv")
		.put("zht", "csv/mapping_zht.csv").build();

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
		IOException {
		ResourceResolver resourceResolver = null;

		String lang = request.getParameter("lang");
		boolean addMixin = false;

		lang = (lang != null) ? lang.trim().toLowerCase() : "en";

		if (!"en".equals(lang)) {
			addMixin = true;
		}

		try {
			resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
		} catch (LoginException e) {
			e.printStackTrace();
		}
		System.out.println("Start Importing *************************");

		PageBuilder pageBuilder;

		ArrayList<MappingVO> mappingVO = getMappings(lang);

		Collections.sort(mappingVO, new Comparator<MappingVO>() {
			@Override
			public int compare(MappingVO obj1, MappingVO obj2) {
				return obj1.getNewPath().compareTo(obj2.getNewPath());
			}
		});

		for (MappingVO map : mappingVO) {
			// System.out.println(map.getNewPath());
			pageBuilder = templates.get(map.getTemplate());

			if (pageBuilder == null) {
				continue;
			}

			try {

				pageBuilder.createPage(map.getOldPath(), map.getNewPath(), resourceResolver, addMixin);

			} catch (WCMException e) {
				System.out.println(e);
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e);
			}

		}

		System.out.println("Importing Finished *************************");

	}

	private ArrayList<MappingVO> getMappings(String lang) {

		InputStream file = this.getClass().getClassLoader().getResourceAsStream(languages.get(lang));
		BufferedReader br = null;
		String line;
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
