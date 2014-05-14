package com.australia.foodandwine.components.page.shortlist;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.Selection;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", path = "page", name = "articlepage", value = "Experience Properties", editConfig = false, fileName = "shortlist_dialog")
public class Shortlist {

	@DialogField(fieldLabel = "Add to Shortlist")
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private boolean addToShortlist;

	@DialogField(fieldLabel = "Exclude From Search")
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private boolean excludeFromSearch;

	@DialogField(fieldLabel = "Exclude From Mosaic")
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private boolean excludeFromMosaic;
}
