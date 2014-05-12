package com.australia.www.link;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.Selection;

/**
 * Created by wma on 30/04/2014.
 */
public class MosaicThemeLink {
	@DialogField(fieldLabel = "Link Text", required = true,
		additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	private String linkText;

	@DialogField(fieldLabel = "Link Path", required = true,
		additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content")
	private String pagePath;

	@DialogField(fieldLabel = "Image", fieldDescription = "Dimensions: 594px x 336px", required = true,
		additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content/dam")
	private String image;

	@DialogField(fieldLabel = "Icon Image", fieldDescription = "Dimensions: 51px x 51px", required = true,
		additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content/dam")
	private String iconImage;

	@DialogField(fieldLabel = "Theme", required = true)
	@Selection(type = Selection.SELECT, options = { @Option(value = "nature", text = "Dark Green"),
		@Option(value = "outback", text = "Dark Yellow"), @Option(value = "aboriginal", text = "Brown"),
		@Option(value = "food", text = "Red"), @Option(value = "arts", text = "Dark Blue"),
		@Option(value = "islands", text = "Light Blue"), @Option(value = "beaches", text = "Yellow"),
		@Option(value = "sports", text = "Light Green"), @Option(value = "adventure", text = "Light Yellow") })
	private String theme;

	private boolean isExternal;

	public String getIconImage() {
		return iconImage;
	}

	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public String getPagePath() {
		return pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public boolean getIsExternal() {
		return isExternal;
	}

	public void setIsExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}
}
