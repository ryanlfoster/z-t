package com.australia.foodandwine.components.page.shortlist;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.Selection;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", path = "page", name = "articlepage", value = "Experience Properties", editConfig = false, fileName = "experience_dialog")
public class ExperienceShortlist extends Shortlist {
	@DialogField(fieldLabel = "Link From Contributors List")
	@Selection(type = Selection.CHECKBOX, options = @Option(value = "true"))
	private boolean linkFromContributorsList;
}
