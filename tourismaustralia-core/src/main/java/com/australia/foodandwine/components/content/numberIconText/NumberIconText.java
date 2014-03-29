package com.australia.foodandwine.components.content.numberIconText;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.foodandwine.link.IconLink;
import com.australia.utils.LinkUtils;
import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.widgets.NumberField;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Number with Icon & Text", dialogWidth = 850, dialogHeight = 500, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class NumberIconText {

	@DialogField(fieldLabel = "Number", required = true)
	@NumberField(allowDecimals = false, allowNegative = false)
	private final int number;

	@DialogField(fieldLabel = "Icons", additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@MultiCompositeField
	private final List<IconLink> icons = new ArrayList<IconLink>();

	@DialogField(fieldLabel = "Text", additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@RichTextEditor
	private final String text;

	public NumberIconText(SlingHttpServletRequest request) {
		ValueMap props = request.getResource().adaptTo(ValueMap.class);
		number = props.get("number", 1);
		text = props.get("text", StringUtils.EMPTY);
		Resource iconResource = request.getResource().getChild("icons");
		if (iconResource != null) {
			for (Resource r : iconResource.getChildren()) {
				ValueMap properties = r.adaptTo(ValueMap.class);
				if (properties != null) {
					String icon = properties.get("icon", StringUtils.EMPTY);
					String alt = properties.get("alt", StringUtils.EMPTY);
					String link = properties.get("link", StringUtils.EMPTY);
					icons.add(new IconLink(icon, alt, LinkUtils.getHrefFromPath(link), LinkUtils.isExternal(link)));
				}
			}
		}
	}

	public int getNumber() {
		return number;
	}

	public List<IconLink> getIcons() {
		return icons;
	}

	public String getText() {
		return text;
	}
}
