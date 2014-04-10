package com.australia.www.components.content.brightcove;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.brightcove.proserve.mediaapi.webservices.BrcService;
import com.brightcove.proserve.mediaapi.webservices.BrcUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.editconfig.DropTarget;

@Component(value = "Brightcove Video", disableTargeting = true, tabs = { @Tab(title = "General"),
	@Tab(title = "Account Settings"), @Tab(title = "Video Information") }, dropTargets = @DropTarget(propertyName = "./videoPlayer", groups = "media", nodeName = "brightcovevideo", accept = "[.*]"), listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Brightcove {
	@DialogField(fieldLabel = "Player Id", tab = 2, listeners = @Listener(name = "loadcontent", value = "function(field,record,path){ var loadDate = new CQ.Ext.data.JsonStore({ url: '/bin/brightcove/players?group=video', method: 'GET', root: 'items', fields: [{name:'playerId',type:'string'}] }); loadDate.load({ callback: function(r,options,success) { if (typeof field.value === 'undefined' || field.value.trim() == '') field.setValue(loadDate.data.itemAt(0).data.playerId); } }); }"))
	private final String playerId;

	@DialogField(fieldLabel = "Player Key", tab = 2, listeners = @Listener(name = "loadcontent", value = "function(field,record,path){ var loadDate = new CQ.Ext.data.JsonStore({ url: '/bin/brightcove/players?group=video', method: 'GET', root: 'items', fields: [{name:'playerKey',type:'string'}] }); loadDate.load({ callback: function(r,options,success) { if (typeof field.value === 'undefined' || field.value.trim() == '') field.setValue(loadDate.data.itemAt(0).data.playerKey); } }); }"))
	private final String playerKey;

	@DialogField(required = true, tab = 1, xtype = "BrightcoveCombo", fieldLabel = "Video", name = "./video", additionalProperties = @FieldProperty(name = "hiddenName", value = "./videoPlayer"))
	private final String videoPlayer;
	private final String videoRandomId;

	@DialogField(fieldLabel = "Title", required = false, tab = 3)
	private String title;

	@DialogField(fieldLabel = "Description", required = false, tab = 3)
	private String description;

	public Brightcove(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		BrcService brcService = BrcUtils.getSlingSettingService();

		title = properties.get("title", StringUtils.EMPTY);
		description = properties.get("description", StringUtils.EMPTY);

		videoRandomId = new String(UUID.randomUUID().toString().replaceAll("-", ""));
		playerId = properties.get("playerId", brcService.getDefVideoPlayerID());
		playerKey = properties.get("playerKey", brcService.getDefVideoPlayerKey());
		videoPlayer = properties.get("videoPlayer", "");

	}

	public String getPlayerId() {
		return playerId;
	}

	public String getPlayerKey() {
		return playerKey;
	}

	public String getVideoPlayer() {
		return videoPlayer;
	}

	public String getVideoRandomId() {
		return videoRandomId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

}
