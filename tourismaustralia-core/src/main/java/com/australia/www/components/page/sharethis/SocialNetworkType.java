package com.australia.www.components.page.sharethis;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.citytechinc.cq.component.annotations.Option;

public enum SocialNetworkType {
	@Option(text = "Facebook")
	FACEBOOK("st_facebook_large"),

	@Option(text = "Facebook Like")
	FBLIKE("st_fblike_large"),

	@Option(text = "Twitter")
	TWITTER("st_twitter_large"),

	@Option(text = "LinkedIn")
	LINKEDIN("st_linkedin_large"),

	@Option(text = "Google Bookmarks")
	GOOGLE_BMARKS("st_google_bmarks"),

	@Option(text = "GooglePlus")
	GOOGLEPLUS("st_googleplus_large"),

	@Option(text = "Email")
	EMAIL("st_email_large");

	private String site;
	private static final Map<String, SocialNetworkType> lookup = new HashMap<String, SocialNetworkType>();

	static {
		for (SocialNetworkType s : EnumSet.allOf(SocialNetworkType.class)) {
			lookup.put(s.getSite(), s);
		}
	}

	private SocialNetworkType(String site) {
		this.site = site;
	}

	public String getSite() {
		return site;
	}

	public static SocialNetworkType get(String site) {
		return lookup.get(site);
	}

	@Override
	public String toString() {
		return site;
	}

}
