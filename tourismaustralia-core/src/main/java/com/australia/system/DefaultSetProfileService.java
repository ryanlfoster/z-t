package com.australia.system;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.settings.SlingSettingsService;

@Component(label = "Set Profile Service", immediate = true)
@Service
public class DefaultSetProfileService implements SetProfileService {
	@Reference
	private SlingSettingsService slingSettings;

	@Activate
	@Modified
	protected void activate() {
		StringBuilder sb = new StringBuilder();
		String[] runmodes = slingSettings.getRunModes().toArray(new String[0]);
		for (int i = 0; i < runmodes.length; i++) {
			sb.append(runmodes[i]);
			if (i != runmodes.length - 1) {
				sb.append(",");
			}
		}
		System.setProperty("spring.profiles.active", sb.toString());
	}
}
