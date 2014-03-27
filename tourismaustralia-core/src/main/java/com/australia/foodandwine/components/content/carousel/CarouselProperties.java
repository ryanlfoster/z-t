package com.australia.foodandwine.components.content.carousel;

import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.widgets.PathField;
import com.citytechinc.cq.component.annotations.widgets.TextArea;

/**
 *
 */
public class CarouselProperties {

	@DialogField(fieldLabel = "Courosel Header Lockup Small Title", name = "smallTitle")
	private String carouselHeaderLockupSmallTitle;

	@DialogField(fieldLabel = "Courosel Header Lockup Big Title", name = "largeTitle")
	private String carouselHeaderLockupLargeTitle;

	@DialogField(fieldLabel = "Courosel Header Lockup Description", name = "description")
	@TextArea
	private String carouselHeaderLockupDescription;

	@DialogField(fieldLabel = "Courosel Button Text", name = "buttonText", fieldDescription = "If empty Default text is set to 'Find Out More'")
	private String carouselButtonText;

	@DialogField(fieldLabel = "Courosel Button Text Link", name = "buttonTextLink")
	@PathField
	private String carouselButtonTextLink;

	private boolean external;

	public String getCarouselHeaderLockupSmallTitle() {
		return carouselHeaderLockupSmallTitle;
	}

	public void setCarouselHeaderLockupSmallTitle(String carouselHeaderLockupSmallTitle) {
		this.carouselHeaderLockupSmallTitle = carouselHeaderLockupSmallTitle;
	}

	public String getCarouselHeaderLockupLargeTitle() {
		return carouselHeaderLockupLargeTitle;
	}

	public void setCarouselHeaderLockupLargeTitle(String carouselHeaderLockupLargeTitle) {
		this.carouselHeaderLockupLargeTitle = carouselHeaderLockupLargeTitle;
	}

	public String getCarouselHeaderLockupDescription() {
		return carouselHeaderLockupDescription;
	}

	public void setCarouselHeaderLockupDescription(String carouselHeaderLockupDescription) {
		this.carouselHeaderLockupDescription = carouselHeaderLockupDescription;
	}

	public String getCarouselButtonText() {
		return carouselButtonText;
	}

	public void setCarouselButtonText(String carouselButtonText) {
		this.carouselButtonText = carouselButtonText;
	}

	public String getCarouselButtonTextLink() {
		return carouselButtonTextLink;
	}

	public void setCarouselButtonTextLink(String carouselButtonTextLink) {
		this.carouselButtonTextLink = carouselButtonTextLink;
	}

	public void setExternal(boolean external) {
		this.external = external;
	}

	public boolean isExtenral() {
		return external;
	}
}
