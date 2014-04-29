package com.australia.observation;

import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.observation.ObservationManager;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.apache.sling.settings.SlingSettingsService;
import org.apache.tika.detect.Detector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, metatype = true, label = "Observation Service", description = "Observation Service")
@Property(name = "service.description", value = "Observation Service")
public final class ObservationService {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(ObservationService.class);

	@Reference
	private SlingRepository repository;

	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	@Reference
	private SlingSettingsService slingSettings;

	@Reference
	private Detector detector;

	private Session session;

	/**
	 * Login to an admin session and register the page event listener.
	 * 
	 * @param componentContext context
	 * @throws RepositoryException
	 */
	protected void activate(final Map<String, Object> properties) throws RepositoryException {
		session = repository.loginAdministrative(null);
		final ObservationManager observationManager = session.getWorkspace().getObservationManager();
		registerExperienceCreationListener(observationManager);
		LOG.info("activate() registered event listeners");
	}

	private void registerExperienceCreationListener(final ObservationManager observationManager)
		throws RepositoryException {
		// if (slingSettings.getRunModes().contains(ServerUtils.AUTHOR)) {
		// observationManager.addEventListener(new
		// ExperienceCreationListener(resourceResolverFactory, detector),
		// ExperienceCreationListener.EVENTS,
		// PathUtils.FOOD_AND_WINE_USER_GENERATED, true, null,
		// new String[] { "cq:Page" }, false);
		// }
	}

	protected void deactivate() {
		if (session != null) {
			session.logout();
		}
	}
}