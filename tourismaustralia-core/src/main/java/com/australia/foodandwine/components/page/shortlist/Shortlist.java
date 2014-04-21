package com.australia.foodandwine.components.page.shortlist;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.Selection;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", path = "page", value = "Shortlist", editConfig = false, fileName = "shortlist_dialog")
public class Shortlist {

	@DialogField(fieldLabel = "Add to Shortlist")
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private boolean addToShortlist;

}
