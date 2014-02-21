package com.australia.asp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Specialist {
	@JsonIgnore
	private final AussieSpecialistType aussieSpecialist;
	private final String uniqueId;
	private final String category;
	private final String countryCode;
	private final String languageCode;
	private final String personName;
	private final String jobTitle;
	private final String companyName;
	private final String addressLine1;
	private final String addressLine2;
	private final String addressLine3;
	private final String city;
	private final String state;
	private final String postcode;
	private final String country;
	private final String phone;
	private final String fax;
	private final String mobile;
	private final String email;
	private final String website;
	private final String longitude;
	private final String latitude;
	private final String description;
	private final String logo;
	private final String aspLogo;

	public Specialist(AussieSpecialistType aussieSpecialist) {
		this.aussieSpecialist = aussieSpecialist;
		uniqueId = getPropertyFromAussieSpecialist("unique_identifier");
		category = getPropertyFromAussieSpecialist("asp_category");
		countryCode = getPropertyFromAussieSpecialist("country_code");
		languageCode = getPropertyFromAussieSpecialist("language_code");
		personName = getPropertyFromAussieSpecialist("person_name");
		jobTitle = getPropertyFromAussieSpecialist("job_title");
		companyName = getPropertyFromAussieSpecialist("company_name");
		addressLine1 = getPropertyFromAussieSpecialist("address_line_1");
		addressLine2 = getPropertyFromAussieSpecialist("address_line_2");
		addressLine3 = getPropertyFromAussieSpecialist("address_line_3");
		city = getPropertyFromAussieSpecialist("city");
		state = getPropertyFromAussieSpecialist("state");
		postcode = getPropertyFromAussieSpecialist("postcode");
		country = getPropertyFromAussieSpecialist("country_name");
		phone = getPropertyFromAussieSpecialist("phone");
		fax = getPropertyFromAussieSpecialist("fax");
		mobile = getPropertyFromAussieSpecialist("mobile");
		email = getPropertyFromAussieSpecialist("email");
		website = getPropertyFromAussieSpecialist("website");
		longitude = getPropertyFromAussieSpecialist("longitude");
		latitude = getPropertyFromAussieSpecialist("latitude");
		description = getPropertyFromAussieSpecialist("description");
		logo = getPropertyFromAussieSpecialist("logo");
		aspLogo = getPropertyFromAussieSpecialist("asp_logo");
	}

	private String getPropertyFromAussieSpecialist(String prop) {
		for (FieldType field : aussieSpecialist.getFields()) {
			if (field.getId() != null && field.getId().equals(prop)) {
				return field.getValue();
			}
		}
		return null;
	}

	public AussieSpecialistType getAussieSpecialist() {
		return aussieSpecialist;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public String getCategory() {
		return category;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public String getPersonName() {
		return personName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getCountry() {
		return country;
	}

	public String getPhone() {
		return phone;
	}

	public String getFax() {
		return fax;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getWebsite() {
		return website;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getDescription() {
		return description;
	}

	public String getLogo() {
		return logo;
	}

	public String getAspLogo() {
		return aspLogo;
	}
}
