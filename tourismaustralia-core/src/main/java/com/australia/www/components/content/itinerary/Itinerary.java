package com.australia.www.components.content.itinerary;

import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.annotations.widgets.RichTextEditor;
import com.day.cq.wcm.foundation.Image;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing bean for the Itinerary component
 */
@Component(value = "Itinerary", isContainer = true)
public final class Itinerary {

	@DialogField(fieldLabel = "Title")
	private final String title;

	@DialogField(fieldLabel = "Text")
	private final String text;

	@DialogField(fieldLabel = "Map Image")
	@Html5SmartImage(tab = false, name = Constants.NAME_MAP_IMAGE, height = Constants.IMAGE_WIDGET_HEIGHT)
	private final String mapImage;

	@DialogField(fieldLabel = "Best Time To Go", xtype = "textarea")
	private final String bestTime;

	@DialogField(fieldLabel = "Total Distance")
	private final Integer totalDistance;

	@DialogField(fieldLabel = "Mode of Transport")
	private final String modeOfTransport;

	@DialogField(fieldLabel = "More Info")
	@RichTextEditor
	private final String moreInfo;

	private final List<Resource> days = new ArrayList<Resource>();

	public Itinerary(final SlingHttpServletRequest request) {

		final Resource resource = request.getResource();
		final ValueMap properties = resource.adaptTo(ValueMap.class);

		title = properties.get(Constants.NAME_TITLE, "");
		text = properties.get(Constants.NAME_TEXT, "");

		Image imageObj = new Image(request.getResource(), Constants.NAME_MAP_IMAGE);
		mapImage = imageObj.hasContent() ? imageObj.getPath() : null;

		bestTime = properties.get(Constants.NAME_BEST_TIME, "");
		totalDistance = properties.get(Constants.NAME_TOTAL_DISTANCE, Integer.class);
		modeOfTransport = properties.get(Constants.NAME_MODE_OF_TRANSPORT, "");
		moreInfo = properties.get(Constants.NAME_MORE_INFO, "");

		for (final Resource child: resource.getChildren()) {
			if (child.isResourceType(Constants.ITINERARY_DAY_RESOURCE_TYPE)) {
				days.add(child);
			}
		}

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

	public Integer getTotalDistance() {
		return totalDistance;
	}

	public String getModeOfTransport() {
		return modeOfTransport;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public int getDayCount() {
		return days.size();
	}
}
