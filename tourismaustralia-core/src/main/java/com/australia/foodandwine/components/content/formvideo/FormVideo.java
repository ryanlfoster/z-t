package com.australia.foodandwine.components.content.formvideo;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.brightcove.proserve.mediaapi.webservices.BrcService;
import com.brightcove.proserve.mediaapi.webservices.BrcUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Form Video", listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class FormVideo {
	@DialogField(fieldLabel = "Overlay Text for Video", fieldDescription = "Text before hint button")
	private final String textBeforePlayButton;

	@DialogField(fieldLabel = "Overlay Text for Video", fieldDescription = "Text after hint button")
	private final String textAfterPlayButton;
	@DialogField(fieldLabel = "Player Id", listeners = @Listener(name = "loadcontent", value = "function(field,record,path){ var loadDate = new CQ.Ext.data.JsonStore({ url: '/bin/brightcove/players?group=video', method: 'GET', root: 'items', fields: [{name:'playerId',type:'string'}] }); loadDate.load({ callback: function(r,options,success) { if (typeof field.value === 'undefined' || field.value.trim() == '') field.setValue(loadDate.data.itemAt(0).data.playerId); } }); }"))
	private final String playerId;

	@DialogField(fieldLabel = "Player Key", listeners = @Listener(name = "loadcontent", value = "function(field,record,path){ var loadDate = new CQ.Ext.data.JsonStore({ url: '/bin/brightcove/players?group=video', method: 'GET', root: 'items', fields: [{name:'playerKey',type:'string'}] }); loadDate.load({ callback: function(r,options,success) { if (typeof field.value === 'undefined' || field.value.trim() == '') field.setValue(loadDate.data.itemAt(0).data.playerKey); } }); }"))
	private final String playerKey;

	@DialogField(required = true, xtype = "BrightcoveCombo", fieldLabel = "Video", name = "./video", additionalProperties = @FieldProperty(name = "hiddenName", value = "./videoPlayer"))
	private final String videoPlayer;

	private final String videoRandomId;

	public FormVideo(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		textBeforePlayButton = properties.get("textBeforePlayButton", StringUtils.EMPTY);
		textAfterPlayButton = properties.get("textAfterPlayButton", StringUtils.EMPTY);
		BrcService brcService = BrcUtils.getSlingSettingService();
		videoRandomId = new String(UUID.randomUUID().toString().replaceAll("-", StringUtils.EMPTY));
		playerId = properties.get("playerId", brcService.getDefVideoPlayerID());
		playerKey = properties.get("playerKey", brcService.getDefVideoPlayerKey());
		videoPlayer = properties.get("videoPlayer", StringUtils.EMPTY);
	}

	public String getTextBeforePlayButton() {
		return textBeforePlayButton;
	}

	public String getTextAfterPlayButton() {
		return textAfterPlayButton;
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
