package com.australia.asp.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.australia.asp.domain.AussieSpecialistType;
import com.australia.asp.domain.AussieSpecialistsType;
import com.australia.asp.domain.Specialist;

@Component(label = "Default ASP Repository", description = "Default ASP Repository", immediate = true, metatype = true)
@Service
@Properties({ @Property(name = "scheduler.expression", value = "0 0 0 * * ?"),
	@Property(name = "scheduler.concurrent", propertyPrivate = true, boolValue = false) })
public class DefaultAspRepository implements AspRepository, Runnable {
	private static final Logger LOG = LoggerFactory.getLogger(DefaultAspRepository.class);
	private static final String DEFAULT_ASP_XML_LOCATION = "http://www.aussiespecialist.com/auscomprofiles/auscomxml/aussiespecialists.xml";
	private static final String SEPERATOR = "~";
	@Property(label = "ASP XML File Location", description = "The external location ASP XML file")
	protected static final String ASP_XML_LOCATION = "aspXMLLocation";
	private String aspXMLLocation;

	private List<Specialist> specialists = new ArrayList<Specialist>();
	private Map<String, List<Specialist>> specialistsByCountry = new HashMap<String, List<Specialist>>();
	private Map<String, List<Specialist>> specialistsByCountryAndState = new HashMap<String, List<Specialist>>();
	private Map<String, List<Specialist>> specialistsByCountryAndStateAndCity = new HashMap<String, List<Specialist>>();

	public List<Specialist> getSpecialists() {
		return specialists;
	}

	public List<Specialist> getSpecialistsByCountry(String country) {
		List<Specialist> specialists = specialistsByCountry.get(country);
		return specialists != null ? specialists : new ArrayList<Specialist>();
	}

	public List<Specialist> getSpecialistsByCountryAndState(String country, String state) {
		String stateKey = country + SEPERATOR + state;
		List<Specialist> specialists = specialistsByCountryAndState.get(stateKey);
		return specialists != null ? specialists : new ArrayList<Specialist>();
	}

	public List<Specialist> getSpecialistsByCountryAndStateAndCity(String country, String state, String city) {
		String cityKey = country + SEPERATOR + state + SEPERATOR + city;
		List<Specialist> specialists = specialistsByCountryAndStateAndCity.get(cityKey);
		return specialists != null ? specialists : new ArrayList<Specialist>();
	}

	protected void setSpecialists() {
		try {
			specialists = convertAussieSpecialistsDataToSpecialists(getAussieSpecialistsData());
			for (Specialist specialist : specialists) {
				String country = specialist.getCountry();
				String state = specialist.getState();
				String city = specialist.getCity();

				List<Specialist> countryList = specialistsByCountry.get(country);
				if (countryList == null) {
					countryList = new ArrayList<Specialist>();
				}
				countryList.add(specialist);
				specialistsByCountry.put(country, countryList);

				String stateKey = country + SEPERATOR + state;
				List<Specialist> countryandStateList = specialistsByCountryAndState.get(stateKey);
				if (countryandStateList == null) {
					countryandStateList = new ArrayList<Specialist>();
				}
				countryandStateList.add(specialist);
				specialistsByCountryAndState.put(stateKey, countryandStateList);

				String cityKey = stateKey + SEPERATOR + city;
				List<Specialist> countryandStateandCityList = specialistsByCountryAndStateAndCity.get(cityKey);
				if (countryandStateandCityList == null) {
					countryandStateandCityList = new ArrayList<Specialist>();
				}
				countryandStateandCityList.add(specialist);
				specialistsByCountryAndStateAndCity.put(cityKey, countryandStateandCityList);
			}
		} catch (Exception e) {
			LOG.error("Error getting ASP XML data", e);
		}
	}

	protected AussieSpecialistsType getAussieSpecialistsData() throws JAXBException, IllegalStateException, IOException {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet aspGet = new HttpGet(aspXMLLocation);
		HttpResponse response = client.execute(aspGet);
		JAXBContext jaxbContext = JAXBContext.newInstance(AussieSpecialistsType.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return (AussieSpecialistsType) jaxbUnmarshaller.unmarshal(response.getEntity().getContent());
	}

	protected List<Specialist> convertAussieSpecialistsDataToSpecialists(AussieSpecialistsType aussieSpecialists) {
		List<Specialist> specialists = new ArrayList<Specialist>();
		if (aussieSpecialists != null && aussieSpecialists.getAussieSpecialists() != null) {
			for (AussieSpecialistType aussie : aussieSpecialists.getAussieSpecialists()) {
				specialists.add(new Specialist(aussie));
			}
		}
		return specialists;
	}

	@Activate
	@Modified
	protected void activate(final Map<String, Object> properties) throws Exception {
		aspXMLLocation = PropertiesUtil.toString(properties.get(ASP_XML_LOCATION), DEFAULT_ASP_XML_LOCATION);
		new Thread(this).start();
	}

	@Override
	public void run() {
		setSpecialists();
	}

}
