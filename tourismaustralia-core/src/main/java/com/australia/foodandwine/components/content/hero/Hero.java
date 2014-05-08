package com.australia.foodandwine.components.content.hero;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.australia.utils.LinkUtils;
import com.brightcove.proserve.mediaapi.webservices.BrcService;
import com.brightcove.proserve.mediaapi.webservices.BrcUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.day.cq.wcm.foundation.Image;

@Component(disableTargeting = true, group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Hero Home", tabs = {
	@Tab(title = "Background Image"), @Tab(title = "Big Title"), @Tab(title = "Register Text"),
	@Tab(title = "Video Path") }, listeners = { @Listener(name = "aftercopy", value = "REFRESH_PAGE"),
	@Listener(name = "afterdelete", value = "REFRESH_PAGE"), @Listener(name = "afteredit", value = "REFRESH_PAGE"),
	@Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Hero {
	@DialogField(fieldLabel = "Image Path", tab = 1,required=true)
	@Html5SmartImage(allowUpload = false, name = "backgroundImage")
	private String imagePath;

	@DialogField(fieldLabel = "Image Alt Tag", tab = 2, fieldDescription = "Image Alt tag for the Background Image", required = true)
	private final String imageAltTag;

	@DialogField(fieldLabel = "Title", required = true, tab = 2)
	private final String title;

	@DialogField(fieldLabel = "Small Text in Circle", tab = 3)
	private final String smallText;

	@DialogField(fieldLabel = "Large Text in Circle", tab = 3)
	private final String largeText;

	@DialogField(fieldLabel = "Text above Button", tab = 3)
	private final String aboveButtonText;
	
	@DialogField(fieldLabel = "Button Text ", tab = 3, required=true)
	private final String buttonText;

	@DialogField(fieldLabel = "Button Link ", tab = 3,required=true)
	@PathField
	private final String buttonLink;

	@DialogField(fieldLabel = "Text below Button", tab = 3)
	private final String belowButtonText;

	@DialogField(fieldLabel = "Player Id", tab = 4, listeners = @Listener(name = "loadcontent", value = "function(field,record,path){ var loadDate = new CQ.Ext.data.JsonStore({ url: '/bin/brightcove/players?group=video', method: 'GET', root: 'items', fields: [{name:'playerId',type:'string'}] }); loadDate.load({ callback: function(r,options,success) { if (typeof field.value === 'undefined' || field.value.trim() == '') field.setValue(loadDate.data.itemAt(0).data.playerId); } }); }"))
	private final String playerId;

	@DialogField(fieldLabel = "Player Key", tab = 4, listeners = @Listener(name = "loadcontent", value = "function(field,record,path){ var loadDate = new CQ.Ext.data.JsonStore({ url: '/bin/brightcove/players?group=video', method: 'GET', root: 'items', fields: [{name:'playerKey',type:'string'}] }); loadDate.load({ callback: function(r,options,success) { if (typeof field.value === 'undefined' || field.value.trim() == '') field.setValue(loadDate.data.itemAt(0).data.playerKey); } }); }"))
	private final String playerKey;

	@DialogField(required = true, tab = 4, xtype = "BrightcoveCombo", fieldLabel = "Video", name = "./video", additionalProperties = @FieldProperty(name = "hiddenName", value = "./videoPlayer"))
	private final String videoPlayer;
	private final String videoRandomId;

	private static final String TITLE = "title";
	private static final String SMALL_TEXT = "smallText";
	private static final String LARGE_TEXT = "largeText";
	private static final String BUTTON_TEXT = "buttonText";
	private static final String BUTTON_LINK = "buttonLink";
	// private static final String BYLINETEXT = "byLineText";
	private static final String ABOVE_BUTTON_TEXT = "aboveButtonText";
	private static final String BELOW_BUTTON_TEXT = "belowButtonText";
	private static final String PLAYER_ID = "playerId";
	private static final String PLAYER_KEY = "playerKey";
	private static final String VIDEO_PLAYER = "videoPlayer";
	private static final String CHARACTER_HYPHEN = "-";
	private final static String IMAGE_ALT_TAG = "imageAltTag";

	public Hero(SlingHttpServletRequest request) {

		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		Image backgroundImage = new Image(request.getResource(), "backgroundImage");
		if (backgroundImage != null && backgroundImage.hasContent()) {
			imagePath = backgroundImage.getPath();
		}
		title = properties.get(TITLE, StringUtils.EMPTY);
		smallText = properties.get(SMALL_TEXT, StringUtils.EMPTY);
		largeText = properties.get(LARGE_TEXT, StringUtils.EMPTY);
		aboveButtonText = properties.get(ABOVE_BUTTON_TEXT, StringUtils.EMPTY);
		buttonText = properties.get(BUTTON_TEXT, StringUtils.EMPTY);
		buttonLink = LinkUtils.getHrefFromPath(properties.get(BUTTON_LINK, StringUtils.EMPTY));
		belowButtonText = properties.get(BELOW_BUTTON_TEXT, StringUtils.EMPTY);

		BrcService brcService = BrcUtils.getSlingSettingService();
		videoRandomId = new String(UUID.randomUUID().toString().replaceAll(CHARACTER_HYPHEN, StringUtils.EMPTY));
		playerId = properties.get(PLAYER_ID, brcService.getDefVideoPlayerID());
		playerKey = properties.get(PLAYER_KEY, brcService.getDefVideoPlayerKey());
		videoPlayer = properties.get(VIDEO_PLAYER, StringUtils.EMPTY);
		imageAltTag = properties.get(IMAGE_ALT_TAG, StringUtils.EMPTY);
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getImageAltTag() {
		return imageAltTag;
	}

	public String getTitle() {
		return title;
	}

	public String getSmallText() {
		return smallText;
	}

	public String getLargeText() {
		return largeText;
	}

	public String getAboveButtonText() {
		return aboveButtonText;
	}

	public String getButtonText() {
		return buttonText;
	}

	public String getButtonLink() {
		return buttonLink;
	}

	public String getBelowButtonText() {
		return belowButtonText;
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
