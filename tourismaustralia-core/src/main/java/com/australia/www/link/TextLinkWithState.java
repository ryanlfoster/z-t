package com.australia.www.link;

import com.australia.utils.LinkUtils;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Option;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.Selection;

/**
 * Created by wma on 2/05/2014.
 */
public class TextLinkWithState {
	@DialogField(fieldLabel = "Title", required = true,
		additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	private String linkText;

	@DialogField(fieldLabel = "Link Path", required = true,
		additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content")
	private String pagePath;

	@DialogField(fieldLabel = "State", required = true)
	@Selection(type = Selection.SELECT,
		options = { @Option(value = "vic", text = "Victoria"), @Option(value = "nsw", text = "New South Wales"),
			@Option(value = "qld", text = "Queensland"), @Option(value = "sa", text = "South Australia"),
			@Option(value = "nt", text = "Northern Territory"),
			@Option(value = "wa", text = "Western Australia"),
			@Option(value = "act", text = "Australian Capital Territory"),
			@Option(value = "tas", text = "Tasmania") })
	private String state;

	private boolean isExternal;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean getIsExternal() {
		return isExternal;
	}

	public void setIsExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}
}
