package com.australia.foodandwine.components.content.hero;
/**
 * 
 */
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ValueMap;

import com.brightcove.proserve.mediaapi.webservices.BrcService;
import com.brightcove.proserve.mediaapi.webservices.BrcUtils;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Listener;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.PathField;

@Component(group = "Food and Wine", basePath = "jcr_root/apps/foodandwine/components", value = "Hero Home", tabs = {
	@Tab(title = "Big Title"), @Tab(title = "Register Text"), @Tab(title = "Video Path") }, listeners = {
	@Listener(name = "aftercopy", value = "REFRESH_PAGE"), @Listener(name = "afterdelete", value = "REFRESH_PAGE"),
	@Listener(name = "afteredit", value = "REFRESH_PAGE"), @Listener(name = "afterinsert", value = "REFRESH_PAGE") })
public class Hero {
	@DialogField(fieldLabel = "Image Path", fieldDescription = "Image for the background(optional)" ,name="./imagePath")
	@PathField(rootPath = "/content/dam")
	private  String imagePath;
	@DialogField(fieldLabel = "Big Title", required = true)
	private  String bigTitle;

	@DialogField(fieldLabel = "Ovaerlay Small Text", fieldDescription = "Text to be displayed in small font", tab = 2)
	private  String smallFontText;

	@DialogField(fieldLabel = "Ovaerlay Large Text", fieldDescription = "Text to be displayed in large font", tab = 2)
	private  String largeFontText;

	@DialogField(fieldLabel = "Ovaerlay Small Text", fieldDescription = "Text to be displayed after large font", tab = 2)
	private  String smallFont;

	@DialogField(fieldLabel = "Register Button Text ", tab = 2)
	private  String buttonText;

	@DialogField(fieldLabel = "Register Button Link ", tab = 2)
	@PathField
	private  String buttonLink;

	@DialogField(fieldLabel = "Byline", tab = 2)
	private  String byLineText;

	@DialogField(fieldLabel = "Overlay Text for Video", fieldDescription = "Text before play button", tab = 3)
	private  String textBeforePlayButton;

	@DialogField(fieldLabel = "Overlay Text for Video", fieldDescription = "Text after play button", tab = 3)
	private  String textAfterPlayButton;
	@DialogField(fieldLabel = "Player Id", tab = 3, listeners = @Listener(name = "loadcontent", value = "function(field,record,path){ var loadDate = new CQ.Ext.data.JsonStore({ url: '/bin/brightcove/players?group=video', method: 'GET', root: 'items', fields: [{name:'playerId',type:'string'}] }); loadDate.load({ callback: function(r,options,success) { if (typeof field.value === 'undefined' || field.value.trim() == '') field.setValue(loadDate.data.itemAt(0).data.playerId); } }); }"))
	private  String playerId;

	@DialogField(fieldLabel = "Player Key", tab = 3, listeners = @Listener(name = "loadcontent", value = "function(field,record,path){ var loadDate = new CQ.Ext.data.JsonStore({ url: '/bin/brightcove/players?group=video', method: 'GET', root: 'items', fields: [{name:'playerKey',type:'string'}] }); loadDate.load({ callback: function(r,options,success) { if (typeof field.value === 'undefined' || field.value.trim() == '') field.setValue(loadDate.data.itemAt(0).data.playerKey); } }); }"))
	private  String playerKey;
	@DialogField(required = true, tab = 3, xtype = "BrightcoveCombo", fieldLabel = "Video", name = "./video", additionalProperties = @FieldProperty(name = "hiddenName", value = "./videoPlayer"))
	private  String videoPlayer;
	private  String videoRandomId;

	/**
	 * Constants
	 */
	private static final String IMAGEPATH = "imagePath";
	private static final String BIGTITLE = "bigTitle";
	private static final String SMALLFONTTEXT = "smallFontText";
	private static final String LARGEFONTTEXT = "largeFontText";
	private static final String SMALLFONT = "smallFont";
	private static final String BUTTONTEXT = "buttonText";
	private static final String BUTTONLINK = "buttonLink";
	private static final String BYLINETEXT = "byLineText";
	private static final String TEXTBEFOREPLAYBUTTON = "textBeforePlayButton";
	private static final String TEXTAFTERPLAYBUTTON = "textAfterPlayButton";
	private static final String PLAYERID = "playerId";
	private static final String PLAYERKEY = "playerKey";
	private static final String VIDEOPLAYER = "videoPlayer";
	private static final String CHARACTERHYPHEN = "-";
	/**
	 * 
	 * @param request
	 */
	public Hero(SlingHttpServletRequest request) {

		ValueMap properties = request.getResource().adaptTo(ValueMap.class);
		if(properties!=null)
		{
		imagePath = properties.get(IMAGEPATH, StringUtils.EMPTY);
		bigTitle = properties.get(BIGTITLE, StringUtils.EMPTY);
		smallFontText = properties.get(SMALLFONTTEXT, StringUtils.EMPTY);
		largeFontText = properties.get(LARGEFONTTEXT, StringUtils.EMPTY);
		smallFont = properties.get(SMALLFONT, StringUtils.EMPTY);
		buttonText = properties.get(BUTTONTEXT, StringUtils.EMPTY);
		buttonLink = properties.get(BUTTONLINK, StringUtils.EMPTY);
		byLineText = properties.get(BYLINETEXT, StringUtils.EMPTY);
		textBeforePlayButton = properties.get(TEXTBEFOREPLAYBUTTON, StringUtils.EMPTY);
		textAfterPlayButton = properties.get(TEXTAFTERPLAYBUTTON, StringUtils.EMPTY);
		BrcService brcService = BrcUtils.getSlingSettingService();
		videoRandomId = new String(UUID.randomUUID().toString().replaceAll(CHARACTERHYPHEN, StringUtils.EMPTY));
		playerId = properties.get(PLAYERID, brcService.getDefVideoPlayerID());
		playerKey = properties.get(PLAYERKEY, brcService.getDefVideoPlayerKey());
		videoPlayer = properties.get(VIDEOPLAYER, StringUtils.EMPTY);
		}
		
		
	}
	/**
	 * 
	 * @return
	 */
	public String getButtonLink() {
		return buttonLink;
	}

	public String getVideoPlayer() {
		return videoPlayer;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getBigTitle() {
		return bigTitle;
	}

	public String getSmallFontText() {
		return smallFontText;
	}

	public String getLargeFontText() {
		return largeFontText;
	}

	public String getSmallFont() {
		return smallFont;
	}

	public String getButtonText() {
		return buttonText;
	}

	public String getByLineText() {
		return byLineText;
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

	public String getVideoRandomId() {
		return videoRandomId;
	}

}
