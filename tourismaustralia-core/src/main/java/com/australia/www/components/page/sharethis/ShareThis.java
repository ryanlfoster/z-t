package com.australia.www.components.page.sharethis;

import java.util.List;

import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.DialogFieldSet;

@Component(value = "ShareThis", dialogWidth = 600, path = "page", group = ".hidden", editConfig = false, fileName = "share_dialog", tabs = {
	@Tab(title = "Default"), @Tab(title = "Custom") })
public class ShareThis {
	@DialogField(tab = 1, hideLabel = true)
	@DialogFieldSet(border = false, collapsible = false)
	private DefaultShareThisConfig defaultConfig;

	@DialogField(tab = 2, fieldLabel = "Social Networks By Country")
	@MultiCompositeField
	private List<LanguageShareThisConfig> shareThis;

}
