package com.australia.atdw.jms;

import java.io.InputStream;

import javax.jcr.ImportUUIDBehavior;
import javax.jcr.Session;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.australia.atdw.domain.products.Product;
import com.australia.atdw.service.AtdwService;
import com.australia.utils.PathUtils;
import com.day.cq.replication.Replicator;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AtdwMessageConsumer {
	private static final Logger LOG = LoggerFactory.getLogger(AtdwMessageConsumer.class);
	private static final String ATDW_TEMPLATE = "/apps/tourismaustralia/templates/atdw";
	private final ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private AtdwService atdwService;

	@Autowired
	private Replicator replicator;

	@Autowired
	private ResourceResolverFactory resourceResolverFactory;

	@Transactional("jmsTransactionManager")
	public void saveProduct(String jsonProduct) throws Exception {
		ResourceResolver resourceResolver = null;
		try {
			Product product = objectMapper.readValue(jsonProduct, Product.class);
			InputStream productXML = atdwService.getProductXml(product.getRealProductId());
			if (productXML != null && productXML.available() > 0) {
				LOG.debug("Starting Product Save Of Product: {}", product.getRealProductId());
				resourceResolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
				PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
				StringBuilder pagePathBuilder = new StringBuilder();
				pagePathBuilder.append(PathUtils.ATDW_DATA_PATH).append("/")
					.append(product.getProductCategoryId().toLowerCase()).append("/")
					.append(product.getRealProductId().substring(0, 3).toLowerCase());
				String parentPath = pagePathBuilder.toString();
				pagePathBuilder.append("/").append(product.getRealProductId());
				String pagePath = pagePathBuilder.toString();
				Page productPage = pageManager.getPage(pagePath);
				if (productPage == null) {
					createIntermediatePage(pageManager, parentPath);
					productPage = pageManager.create(parentPath, product.getRealProductId(), ATDW_TEMPLATE, null, true);
				}
				Resource jcrContent = productPage.adaptTo(Resource.class).getChild("jcr:content");
				ModifiableValueMap jcrContentProperties = jcrContent.adaptTo(ModifiableValueMap.class);
				if (StringUtils.isNotEmpty(product.getProductName())) {
					jcrContentProperties.put("jcr:title", product.getProductName());
				}
				if (StringUtils.isNotEmpty(product.getProductDescription())) {
					jcrContentProperties.put("jcr:description", product.getProductDescription());
				}
				if (StringUtils.isNotEmpty(product.getProductImage())) {
					jcrContentProperties.put("image", product.getProductImage());
				}
				jcrContentProperties.put("tqual", product.isTqual());
				resourceResolver.commit();

				Session session = resourceResolver.adaptTo(Session.class);
				session.importXML(jcrContent.getPath(), productXML,
					ImportUUIDBehavior.IMPORT_UUID_COLLISION_REMOVE_EXISTING);
				session.save();

				Resource productRecord = jcrContent.getChild("atdw_data_results/product_distribution/product_record");
				Resource city = productRecord.getChild("city_name/jcr:xmltext");
				if (city != null) {
					jcrContentProperties.put("city", city.adaptTo(ValueMap.class).get("jcr:xmlcharacters"));
				}

				Resource state = productRecord.getChild("state_name/jcr:xmltext");
				if (state != null) {
					jcrContentProperties.put("state", state.adaptTo(ValueMap.class).get("jcr:xmlcharacters"));
				}

				Resource region = productRecord.getChild("area_name/jcr:xmltext");
				if (region != null) {
					jcrContentProperties.put("region", region.adaptTo(ValueMap.class).get("jcr:xmlcharacters"));
				}
				Resource category = productRecord.getChild("product_category_description/jcr:xmltext");
				if (category != null) {
					jcrContentProperties.put("category", category.adaptTo(ValueMap.class).get("jcr:xmlcharacters"));
				}
				String website = null;
				Resource productCommunication = jcrContent
					.getChild("atdw_data_results/product_distribution/product_communication");
				if (productCommunication != null) {
					for (Resource resource : productCommunication.getChildren()) {
						Resource communicationIdXML = resource.getChild("attribute_id_communication/jcr:xmltext");
						if (communicationIdXML != null) {
							ValueMap idProps = communicationIdXML.adaptTo(ValueMap.class);
							if (idProps.get("jcr:xmlcharacters", String.class) != null
								&& idProps.get("jcr:xmlcharacters", String.class).equals("CAURENQUIR")) {
								Resource communicationDetail = resource.getChild("communication_detail/jcr:xmltext");
								if (communicationDetail != null) {
									ValueMap detailProps = communicationDetail.adaptTo(ValueMap.class);
									if (detailProps.get("jcr:xmlcharacters") != null) {
										website = detailProps.get("jcr:xmlcharacters", String.class);
										break;
									}
								}
							}
						}
					}
				}
				if (website != null) {
					jcrContentProperties.put("website", website);
				}
				resourceResolver.commit();
				// replicator.replicate(session, ReplicationActionType.ACTIVATE,
				// productPage.getPath());
			}
		} catch (Exception e) {
			LOG.error("There was an error creating/updating the product", e);
			throw e;
		} finally {
			if (resourceResolver != null && resourceResolver.isLive()) {
				resourceResolver.close();
			}
		}
	}

	private static synchronized void createIntermediatePage(PageManager pageManager, String pagePath)
		throws WCMException {
		String parentPath = pagePath.substring(0, pagePath.lastIndexOf("/"));
		if (pageManager.getPage(parentPath) == null) {
			createIntermediatePage(pageManager, parentPath);
		}
		String pageName = pagePath.substring(pagePath.lastIndexOf("/") + 1);
		pageManager.create(parentPath, pageName, null, null, true);
	}
}
