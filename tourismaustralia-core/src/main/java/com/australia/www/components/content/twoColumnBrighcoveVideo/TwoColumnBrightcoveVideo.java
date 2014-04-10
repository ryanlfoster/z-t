package com.australia.www.components.content.twoColumnBrighcoveVideo;

import com.australia.utils.LinkUtils;
import com.brightcove.proserve.mediaapi.webservices.BrcService;
import com.brightcove.proserve.mediaapi.webservices.BrcUtils;
import com.citytechinc.cq.component.annotations.*;
import com.citytechinc.cq.component.annotations.editconfig.DropTarget;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import java.util.UUID;

/**
 * Created by wma on 4/04/2014.
 */
@Component(value = "Two Column Brightcove Video", disableTargeting = true, tabs = { @Tab(title = "General"),
	@Tab(title = "Account Settings"), @Tab(title = "Video Information") }, dropTargets = @DropTarget(propertyName = "./videoPlayer", groups = "media", nodeName = "brightcovevideo", accept = "[.*]"), listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class TwoColumnBrightcoveVideo {

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

	@DialogField(fieldLabel = "View more videos link path", fieldDescription = "For external links please use prefix http:// or https:// (eg. http://www.google.com)", required = false, tab = 3)
	@PathField
	private String link;

	private boolean linkIsExternal;

	public TwoColumnBrightcoveVideo(SlingHttpServletRequest request) {
		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		BrcService brcService = BrcUtils.getSlingSettingService();

		videoRandomId = new String(UUID.randomUUID().toString().replaceAll("-", ""));
		playerId = properties.get("playerId", brcService.getDefVideoPlayerID());
		playerKey = properties.get("playerKey", brcService.getDefVideoPlayerKey());
		videoPlayer = properties.get("videoPlayer", "");
		title = properties.get("title", StringUtils.EMPTY);
		description = properties.get("description", StringUtils.EMPTY);
		link = LinkUtils.getHrefFromPath(properties.get("link", StringUtils.EMPTY));
		linkIsExternal = LinkUtils.isExternal(properties.get("link", StringUtils.EMPTY));
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

	public String getLink() {
		return link;
	}

	public boolean getLinkIsExternal() {
		return linkIsExternal;
	}
}
