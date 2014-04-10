package com.australia.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.australia.www.components.domain.Link;

public class LinkUtils {

	private LinkUtils() {
	}

	public static final String getHrefFromPath(String path) {
		if (path.startsWith("/")) {
			return path + ".html";
		} else {
			return path;
		}
	}

	public static final boolean isExternal(String path) {
		return !path.startsWith("/");
	}

	public static final List<Link> populateLinksFromMultiComposite(final List<Link> links, final Resource resource,
		final String rootNodeName, final String hrefProp, final String textProp) {
		List<Link> returnList = new ArrayList<Link>();
		if (resource.getChild(rootNodeName) != null) {
			Iterable<Resource> resources = resource.getChild(rootNodeName).getChildren();
			for (Resource r : resources) {
				ValueMap linkProps = r.adaptTo(ValueMap.class);
				String href = linkProps.get(hrefProp, StringUtils.EMPTY);
				href = LinkUtils.getHrefFromPath(href);
				String linkText = linkProps.get(textProp, StringUtils.EMPTY);
				Link link = new Link(href, linkText);
				returnList.add(link);
			}
		}
		return returnList;
	}
}
