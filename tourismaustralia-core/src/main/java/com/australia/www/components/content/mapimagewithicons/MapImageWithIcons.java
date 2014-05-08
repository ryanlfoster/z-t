package com.australia.www.components.content.mapimagewithicons;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Tab;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;
import com.citytechinc.cq.component.annotations.widgets.TextArea;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

/**
 * Backing bean for the Itinerary component
 */
@Component(value = "Map Image With Icons", tabs = {
	@Tab(title = Constants.TAB_GENERAL),
	@Tab(title = Constants.TAB_MAP_IMAGE),
	@Tab(title = Constants.TAB_BUTTONS)
})
public final class MapImageWithIcons {

	@DialogField(fieldLabel = "Title", tab = Constants.TAB_INDEX_GENERAL)
	private final String title;

	@DialogField(fieldLabel = "Text", tab = Constants.TAB_INDEX_GENERAL,
		additionalProperties = @FieldProperty(name = "grow", value = "true"))
	@TextArea
	private final String text;

	@DialogField(fieldLabel = "Map Image", tab = Constants.TAB_INDEX_MAP_IMAGE)
	@Html5SmartImage(tab = false, name = Constants.NAME_MAP_IMAGE, height = Constants.IMAGE_WIDGET_HEIGHT)
	private final String mapImage;

	@DialogField(fieldLabel = "Best Time To Go", tab = Constants.TAB_INDEX_BUTTONS)
	@RichTextEditor
	private final String bestTime;

	@DialogField(fieldLabel = "Total Distance", tab = Constants.TAB_INDEX_BUTTONS)
	@RichTextEditor
	private final String totalDistance;

	@DialogField(fieldLabel = "Duration", tab = Constants.TAB_INDEX_BUTTONS)
	@RichTextEditor
	private final String duration;

	@DialogField(fieldLabel = "Mode of Transport", tab = Constants.TAB_INDEX_BUTTONS)
	@RichTextEditor
	private final String modeOfTransport;

	@DialogField(fieldLabel = "More Info", tab = Constants.TAB_INDEX_BUTTONS)
	@RichTextEditor
	private final String moreInfo;

	public MapImageWithIcons(final SlingHttpServletRequest request) {

		final Resource resource = request.getResource();
		final ValueMap properties = resource.adaptTo(ValueMap.class);

		title = properties.get(Constants.NAME_TITLE, "");
		text = properties.get(Constants.NAME_TEXT, "");

		mapImage = properties.get(Constants.NAME_MAP_IMAGE + "/fileReference", "");

		bestTime = properties.get(Constants.NAME_BEST_TIME, "");
		totalDistance = properties.get(Constants.NAME_TOTAL_DISTANCE, "");
		duration = properties.get(Constants.NAME_DURATION, "");
		modeOfTransport = properties.get(Constants.NAME_MODE_OF_TRANSPORT, "");
		moreInfo = properties.get(Constants.NAME_MORE_INFO, "");

	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public String getMapImage() {
		return mapImage;
	}

	public String getBestTime() {
		return bestTime;
	}

	public String getDuration() {
		return duration;
	}

	public String getTotalDistance() {
		return totalDistance;
	}

	public String getModeOfTransport() {
		return modeOfTransport;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

}
