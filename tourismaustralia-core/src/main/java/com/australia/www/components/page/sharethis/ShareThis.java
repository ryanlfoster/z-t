package com.australia.www.components.page.sharethis;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;
import com.day.cq.wcm.api.Page;

@Component(value = "ShareThis", dialogWidth = 600, path = "page", group = ".hidden", editConfig = false, fileName = "share_dialog", tabs = {
	@Tab(title = "Default"), @Tab(title = "Custom") })
public class ShareThis {
	@DialogField(tab = 1, hideLabel = true)
	@DialogFieldSet(border = false, collapsible = false)
	private final DefaultShareThisConfig defaultConfig;

	@DialogField(tab = 2, fieldLabel = "Social Networks By Country")
	@MultiCompositeField
	private List<LanguageShareThisConfig> shareThis;

	public ShareThis(Page parent, Resource resource) {
		defaultConfig = new DefaultShareThisConfig(parent.getProperties());
		if (resource != null) {
			shareThis = new ArrayList<LanguageShareThisConfig>();
			for (Resource res : resource.getChildren()) {
				ValueMap jcrProp = res.adaptTo(ValueMap.class);
				LanguageShareThisConfig customConfig = new LanguageShareThisConfig(jcrProp);
				shareThis.add(customConfig);
			}
		}
	}

	public DefaultShareThisConfig getDefaultConfig() {
		return defaultConfig;
	}

	public List<LanguageShareThisConfig> getShareThis() {
		return shareThis;
	}

}
