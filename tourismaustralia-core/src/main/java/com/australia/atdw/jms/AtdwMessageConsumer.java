package com.australia.atdw.jms;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Session;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.australia.atdw.remote.domain.product.AtdwDataResultsType;
import com.australia.atdw.remote.domain.product.ProductCommunicationType;
import com.australia.atdw.remote.domain.product.ProductCommunicationTypeRowType;
import com.australia.atdw.remote.domain.product.ProductRecordType;
import com.australia.atdw.remote.domain.products.Product;
import com.australia.atdw.remote.service.AtdwService;
import com.australia.utils.PathUtils;
import com.day.cq.replication.ReplicationActionType;
import com.day.cq.replication.Replicator;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;

public class AtdwMessageConsumer {
	private static final Logger LOG = LoggerFactory.getLogger(AtdwMessageConsumer.class);
	private static final String ATDW_TEMPLATE = "/apps/tourismaustralia/templates/atdw";
	@Autowired
	private AtdwService atdwService;

	@Autowired
	private Replicator replicator;

	@Autowired
	private ResourceResolverFactory resourceResolverFactory;

	@Transactional("jmsTransactionManager")
	public void saveProduct(Product product) throws Exception {
		ResourceResolver resourceResolver = null;
		try {
			AtdwDataResultsType productDetails = atdwService.getProduct(product.getRealProductId());
			if (productDetails != null) {
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
					jcrContentProperties.put("atdwImage", product.getProductImage());
				}
				jcrContentProperties.put("tqual", product.isTqual());
				if (productDetails.getProductDistribution() != null
					&& productDetails.getProductDistribution().getProductRecord() != null) {

					ProductRecordType productRecord = productDetails.getProductDistribution().getProductRecord();
					if (StringUtils.isNotEmpty(productRecord.getCityName())) {
						jcrContentProperties.put("city", productRecord.getCityName());
					}

					if (StringUtils.isNotEmpty(productRecord.getStateName())) {
						jcrContentProperties.put("state", productRecord.getStateName());
					}

					if (StringUtils.isNotEmpty(productRecord.getAreaName())) {
						jcrContentProperties.put("region", productRecord.getAreaName());
					}

					if (StringUtils.isNotEmpty(productRecord.getProductCategoryDescription())) {
						jcrContentProperties.put("category", productRecord.getProductCategoryDescription());
					}

					String website = null;
					List<String> phoneNumbers = new ArrayList<String>();
					if (productDetails.getProductDistribution() != null
						&& productDetails.getProductDistribution().getProductCommunication() != null) {
						ProductCommunicationType productCommunication = productDetails.getProductDistribution()
							.getProductCommunication();
						for (ProductCommunicationTypeRowType row : productCommunication.getRow()) {

							if (row.getAttributeIdCommunication() != null) {
								if (row.getAttributeIdCommunication().equals("CAURENQUIR")
									&& StringUtils.isNotEmpty(row.getCommunicationDetail())) {

									website = row.getCommunicationDetail();
								}
								if ((row.getAttributeIdCommunication().equals("CAPHENQUIR") || row
									.getAttributeIdCommunication().equals("CAMBENQUIR"))
									&& StringUtils.isNotEmpty(row.getCommunicationDetail())) {

									phoneNumbers.add(row.getCommunicationDetail());
								}
							}
						}
					}
					if (website != null) {
						jcrContentProperties.put("website", website);
					}
					if (phoneNumbers.size() > 0) {
						jcrContentProperties.put("phoneNumbers", phoneNumbers.toArray(new String[0]));
					}
				}
				resourceResolver.commit();
				replicator.replicate(resourceResolver.adaptTo(Session.class), ReplicationActionType.ACTIVATE,
					productPage.getPath());
			}
		} catch (Exception e) {
			LOG.error("There was an error creating/updating the product:" + product.getRealProductId(), e);
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
