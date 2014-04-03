package com.australia.www.components.domain;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.widgets.PathField;

public class Link {

    @DialogField(fieldLabel = "Link Path", additionalProperties = @FieldProperty(name = "anchor", value = "100%"))
	@PathField(rootPath = "/content")
	private String path;
    public static final String PROP_PATH = "path";

    @DialogField(fieldLabel = "Title", additionalProperties = @FieldProperty(name = "width", value = "300"))
	private String title;
    public static final String PROP_TITLE = "title";
    
	public Link(String path, String title) {
		super();
		this.path = path;
		this.title = title;
	}
    
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
