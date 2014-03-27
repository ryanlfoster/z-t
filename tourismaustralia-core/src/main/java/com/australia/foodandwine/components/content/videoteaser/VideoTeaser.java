package com.australia.foodandwine.components.content.videoteaser;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Video Te", tabs = {
	@Tab(title = "Background Image"), @Tab(title = "Other Properties") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class VideoTeaser {
	@DialogField(fieldLabel = "Image Path", tab = 1)
	@Html5SmartImage(allowUpload = false, name = "backgroundImage")
	private String imagePath;

	@DialogField(fieldLabel = "Overlay Text for Video", fieldDescription = "Text before play button", tab = 2)
	private String textBeforePlayButton;

	@DialogField(fieldLabel = "Overlay Text for Video", fieldDescription = "Text after play button", tab = 2)
	private String textAfterPlayButton;
	@DialogField(fieldLabel = "Player Id", tab = 2, listeners = @Listener(name = "loadcontent", value = "function(field,record,path){ var loadDate = new CQ.Ext.data.JsonStore({ url: '/bin/brightcove/players?group=video', method: 'GET', root: 'items', fields: [{name:'playerId',type:'string'}] }); loadDate.load({ callback: function(r,options,success) { if (typeof field.value === 'undefined' || field.value.trim() == '') field.setValue(loadDate.data.itemAt(0).data.playerId); } }); }"))
	private String playerId;

	@DialogField(fieldLabel = "Player Key", tab = 2, listeners = @Listener(name = "loadcontent", value = "function(field,record,path){ var loadDate = new CQ.Ext.data.JsonStore({ url: '/bin/brightcove/players?group=video', method: 'GET', root: 'items', fields: [{name:'playerKey',type:'string'}] }); loadDate.load({ callback: function(r,options,success) { if (typeof field.value === 'undefined' || field.value.trim() == '') field.setValue(loadDate.data.itemAt(0).data.playerKey); } }); }"))
	private String playerKey;
	@DialogField(required = true, tab = 2, xtype = "BrightcoveCombo", fieldLabel = "Video", name = "./video", additionalProperties = @FieldProperty(name = "hiddenName", value = "./videoPlayer"))
	private String videoPlayer;
	private String videoRandomId;
}
