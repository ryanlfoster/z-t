/**
 * Copyright 2014, CITYTECH, Inc.
 * All rights reserved - Do Not Redistribute
 * Confidential and Proprietary
 */
package com.australia.widgets.multicomposite;

import com.citytechinc.cq.component.dialog.widget.WidgetParameters;
import com.citytechinc.cq.component.util.Constants;

public final class MultiCompositeFieldWidgetParameters extends WidgetParameters {

	private boolean matchBaseName;

	private String prefix;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(final String prefix) {
		this.prefix = prefix;
	}

	@Override
	public String getPrimaryType() {
		return Constants.CQ_WIDGET;
	}

	@Override
	public void setPrimaryType(final String primaryType) {
		throw new UnsupportedOperationException("PrimaryType is Static for DialogFieldSetWidget");
	}

	@Override
	public String getXtype() {
		return MultiCompositeFieldWidget.XTYPE;
	}

	@Override
	public void setXtype(final String xtype) {
		throw new UnsupportedOperationException("xtype is Static for DialogFieldSetWidget");
	}

	public boolean isMatchBaseName() {
		return matchBaseName;
	}

	public void setMatchBaseName(final boolean matchBaseName) {
		this.matchBaseName = matchBaseName;
	}
}