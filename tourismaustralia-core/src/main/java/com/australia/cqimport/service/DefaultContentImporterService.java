package com.australia.cqimport.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.cqimport.vo.MappingVO;
import com.day.cq.wcm.api.WCMException;
import com.google.common.collect.ImmutableMap;

@Service
@Component
public class DefaultContentImporterService implements ContentImporterService {
	private static final Logger LOG = LoggerFactory.getLogger(DefaultContentImporterService.class);
	private static final Map<String, PageBuilder> templates = ImmutableMap.<String, PageBuilder> builder()
		.put("state", new StateCityBuilder()).put("city", new StateCityBuilder()).put("article", new ArticleBuilder())
		.put("icon", new IconBuilder()).build();
	private static final Map<String, String> languages = ImmutableMap.<String, String> builder()
		.put("en", "csv/mapping_en.csv").put("it", "csv/mapping_it.csv").put("fr", "csv/mapping_fr.csv")
		.put("de", "csv/mapping_de.csv").put("es", "csv/mapping_es.csv").put("id", "csv/mapping_id.csv")
		.put("jp", "csv/mapping_jp.csv").put("ko", "csv/mapping_ko.csv").put("my", "csv/mapping_my.csv")
		.put("pt", "csv/mapping_pt.csv").put("zht", "csv/mapping_zht.csv").build();

	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	@Override
	public void importLanguage(String lang) {
		boolean addMixin = true;
		lang = (lang != null) ? lang.trim().toLowerCase() : "en";

		if ("en".equals(lang)) {
			addMixin = false;
		}
		ResourceResolver resourceResolver = null;
		try {
			resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
            new TagHelper().getTags(resourceResolver,lang);
		} catch (LoginException e) {
			LOG.error(e.getMessage(), e);
		}
		LOG.debug("Start Importing *************************");

		PageBuilder pageBuilder;

		ArrayList<MappingVO> mappingVO = getMappings(lang);



		Collections.sort(mappingVO, new Comparator<MappingVO>() {
			@Override
			public int compare(MappingVO obj1, MappingVO obj2) {
				return obj1.getNewPath().compareTo(obj2.getNewPath());
			}
		});

		for (MappingVO map : mappingVO) {
			// LOG.debug(map.getNewPath());
			pageBuilder = templates.get(map.getTemplate());

			if (pageBuilder == null) {
				continue;
			}

			try {

				pageBuilder.createPage(map.getOldPath(), map.getNewPath(), lang, resourceResolver, addMixin);

			} catch (WCMException e) {
				LOG.error(e.getMessage(), e);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}

		}
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
			LOG.error(e.getMessage(), e);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					LOG.error(e.getMessage(), e);
				}
			}
		}
		return mappingsList;

	}

}
