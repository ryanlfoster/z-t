package com.australia.www.components.content.brightcove;

import java.util.UUID;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.brightcove.proserve.mediaapi.webservices.BrcService;
import com.brightcove.proserve.mediaapi.webservices.BrcUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;

@Component(value = "Brightcove Video", tabs = { @Tab(title = "General"), @Tab(title = "Account Settings") })
public class Brightcove {
	@DialogField(fieldLabel = "Player Id", listeners = @Listener(name = "loadcontent", value = "function(field,record,path){ var loadDate = new CQ.Ext.data.JsonStore({ url: '/bin/brightcove/players?group=video', method: 'GET', root: 'items', fields: [{name:'playerId',type:'string'}] }); loadDate.load({ callback: function(r,options,success) { if (typeof field.value === 'undefined' || field.value.trim() == '') field.setValue(loadDate.data.itemAt(0).data.playerId); } }); }"))
	private final String playerId;
	
	@DialogField(fieldLabel = "Player Key",listeners = @Listener(name = "loadcontent", value = "function(field,record,path){ var loadDate = new CQ.Ext.data.JsonStore({ url: '/bin/brightcove/players?group=video', method: 'GET', root: 'items', fields: [{name:'playerKey',type:'string'}] }); loadDate.load({ callback: function(r,options,success) { if (typeof field.value === 'undefined' || field.value.trim() == '') field.setValue(loadDate.data.itemAt(0).data.playerKey); } }); }"))
	private final String playerKey;

	@DialogField(required = true, xtype = "BrightcoveCombo", fieldLabel = "Video")
	private final String videoPlayer;
	private final String videoRandomId;

	public Brightcove(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		BrcService brcService = BrcUtils.getSlingSettingService();

		videoRandomId = new String(UUID.randomUUID().toString().replaceAll("-", ""));
		playerId = properties.get("playerId", brcService.getDefVideoPlayerID());
		playerKey = properties.get("playerKey", brcService.getDefVideoPlayerKey());
		videoPlayer = properties.get("video", "");
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
}
