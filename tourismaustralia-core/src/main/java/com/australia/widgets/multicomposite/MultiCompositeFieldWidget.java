/**
 * Copyright 2014, CITYTECH, Inc.
 * All rights reserved - Do Not Redistribute
 * Confidential and Proprietary
 */
package com.australia.widgets.multicomposite;

import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.config.Widget;
import com.citytechinc.cq.component.dialog.AbstractWidget;

@Widget(annotationClass = MultiCompositeField.class, makerClass = MultiCompositeFieldWidgetMaker.class, xtype = MultiCompositeFieldWidget.XTYPE)
public final class MultiCompositeFieldWidget extends AbstractWidget {

	public static final String XTYPE = "multicompositefield";

	private final boolean matchBaseName;

	private final String prefix;

	public MultiCompositeFieldWidget(final MultiCompositeFieldWidgetParameters parameters) {
		super(parameters);

		this.matchBaseName = parameters.isMatchBaseName();
		this.prefix = parameters.getPrefix();
	}

	public String getPrefix() {
		return prefix;
	}

	public boolean isMatchBaseName() {
		return matchBaseName;
	}
}