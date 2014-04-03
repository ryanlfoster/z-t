package com.australia.www.components.page.sharethis;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.citytechinc.cq.component.annotations.Option;

public enum SocialNetworkType {

	@Option(text = "Facebook")
	FACEBOOK("facebook"),

	@Option(text = "Twitter")
	TWITTER("twitter"),

	@Option(text = "LinkedIn")
	LINKEDIN("linkedin"),

	@Option(text = "GooglePlus")
	GOOGLEPLUS("googleplus"),

	@Option(text = "Orkut")
	ORKUT("orkut"),

	@Option(text = "MySpace")
	MYSPACE("myspace"),

	@Option(text = "Xing")
	XING("xing"),

	@Option(text = "Reddit")
	REDDIT("reddit"),

	@Option(text = "Tumblr")
	TUMBLR("tumblr");

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
