//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.17 at 01:40:13 PM EST 
//

package com.australia.cqimport.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for GettingAroundAustraliaType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="GettingAroundAustraliaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="breadcrumb" type="{}breadcrumbType"/>
 *         &lt;element name="hdl_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="img_Banner" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="img_SearchThumbnail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="img_Thumbnail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="opt_HideInBreadcrumbs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_ExcludedCountries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_hideInXmlSitemap" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_ImageLocation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_IsExternalSiteArticle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_IsMobile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_keywords" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_LinkLearnMore" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_NavigationTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_PageHeading" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_TargetedCountries" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TA_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="txt_Teaser" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="con_Body" type="{}con_BodyType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="pageID" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="isTemplate" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GettingAroundAustraliaType", propOrder = { "breadcrumb", "hdlTitle", "imgBanner",
	"imgSearchThumbnail", "imgThumbnail", "optHideInBreadcrumbs", "stfDescription", "stfExcludedCountries",
	"stfHideInXmlSitemap", "stfImageLocation", "stfIsExternalSiteArticle", "stfIsMobile", "stfKeywords",
	"stfLinkLearnMore", "stfNavigationTitle", "stfPageHeading", "stfTargetedCountries", "taTitle", "txtTeaser",
	"conBody" })
public class GettingAroundAustraliaType {

	@XmlElement(required = true)
	protected BreadcrumbType breadcrumb;
	@XmlElement(name = "hdl_Title", required = true)
	protected String hdlTitle;
	@XmlElement(name = "img_Banner", required = true)
	protected String imgBanner;
	@XmlElement(name = "img_SearchThumbnail", required = true)
	protected String imgSearchThumbnail;
	@XmlElement(name = "img_Thumbnail", required = true)
	protected String imgThumbnail;
	@XmlElement(name = "opt_HideInBreadcrumbs", required = true)
	protected String optHideInBreadcrumbs;
	@XmlElement(name = "stf_description", required = true)
	protected String stfDescription;
	@XmlElement(name = "stf_ExcludedCountries", required = true)
	protected String stfExcludedCountries;
	@XmlElement(name = "stf_hideInXmlSitemap", required = true)
	protected String stfHideInXmlSitemap;
	@XmlElement(name = "stf_ImageLocation", required = true)
	protected String stfImageLocation;
	@XmlElement(name = "stf_IsExternalSiteArticle", required = true)
	protected String stfIsExternalSiteArticle;
	@XmlElement(name = "stf_IsMobile", required = true)
	protected String stfIsMobile;
	@XmlElement(name = "stf_keywords", required = true)
	protected String stfKeywords;
	@XmlElement(name = "stf_LinkLearnMore", required = true)
	protected String stfLinkLearnMore;
	@XmlElement(name = "stf_NavigationTitle", required = true)
	protected String stfNavigationTitle;
	@XmlElement(name = "stf_PageHeading", required = true)
	protected String stfPageHeading;
	@XmlElement(name = "stf_TargetedCountries", required = true)
	protected String stfTargetedCountries;
	@XmlElement(name = "TA_Title", required = true)
	protected String taTitle;
	@XmlElement(name = "txt_Teaser", required = true)
	protected String txtTeaser;
	@XmlElement(name = "con_Body", required = true)
	protected ConBodyType conBody;
	@XmlAttribute(name = "pageID")
	protected Byte pageID;
	@XmlAttribute(name = "isTemplate")
	protected Byte isTemplate;

	/**
	 * Gets the value of the breadcrumb property.
	 * 
	 * @return possible object is {@link BreadcrumbType }
	 * 
	 */
	public BreadcrumbType getBreadcrumb() {
		return breadcrumb;
	}

	/**
	 * Sets the value of the breadcrumb property.
	 * 
	 * @param value allowed object is {@link BreadcrumbType }
	 * 
	 */
	public void setBreadcrumb(BreadcrumbType value) {
		this.breadcrumb = value;
	}

	/**
	 * Gets the value of the hdlTitle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHdlTitle() {
		return hdlTitle;
	}

	/**
	 * Sets the value of the hdlTitle property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setHdlTitle(String value) {
		this.hdlTitle = value;
	}

	/**
	 * Gets the value of the imgBanner property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getImgBanner() {
		return imgBanner;
	}

	/**
	 * Sets the value of the imgBanner property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setImgBanner(String value) {
		this.imgBanner = value;
	}

	/**
	 * Gets the value of the imgSearchThumbnail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getImgSearchThumbnail() {
		return imgSearchThumbnail;
	}

	/**
	 * Sets the value of the imgSearchThumbnail property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setImgSearchThumbnail(String value) {
		this.imgSearchThumbnail = value;
	}

	/**
	 * Gets the value of the imgThumbnail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getImgThumbnail() {
		return imgThumbnail;
	}

	/**
	 * Sets the value of the imgThumbnail property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setImgThumbnail(String value) {
		this.imgThumbnail = value;
	}

	/**
	 * Gets the value of the optHideInBreadcrumbs property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOptHideInBreadcrumbs() {
		return optHideInBreadcrumbs;
	}

	/**
	 * Sets the value of the optHideInBreadcrumbs property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setOptHideInBreadcrumbs(String value) {
		this.optHideInBreadcrumbs = value;
	}

	/**
	 * Gets the value of the stfDescription property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfDescription() {
		return stfDescription;
	}

	/**
	 * Sets the value of the stfDescription property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfDescription(String value) {
		this.stfDescription = value;
	}

	/**
	 * Gets the value of the stfExcludedCountries property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfExcludedCountries() {
		return stfExcludedCountries;
	}

	/**
	 * Sets the value of the stfExcludedCountries property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfExcludedCountries(String value) {
		this.stfExcludedCountries = value;
	}

	/**
	 * Gets the value of the stfHideInXmlSitemap property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfHideInXmlSitemap() {
		return stfHideInXmlSitemap;
	}

	/**
	 * Sets the value of the stfHideInXmlSitemap property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfHideInXmlSitemap(String value) {
		this.stfHideInXmlSitemap = value;
	}

	/**
	 * Gets the value of the stfImageLocation property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfImageLocation() {
		return stfImageLocation;
	}

	/**
	 * Sets the value of the stfImageLocation property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfImageLocation(String value) {
		this.stfImageLocation = value;
	}

	/**
	 * Gets the value of the stfIsExternalSiteArticle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfIsExternalSiteArticle() {
		return stfIsExternalSiteArticle;
	}

	/**
	 * Sets the value of the stfIsExternalSiteArticle property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfIsExternalSiteArticle(String value) {
		this.stfIsExternalSiteArticle = value;
	}

	/**
	 * Gets the value of the stfIsMobile property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfIsMobile() {
		return stfIsMobile;
	}

	/**
	 * Sets the value of the stfIsMobile property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfIsMobile(String value) {
		this.stfIsMobile = value;
	}

	/**
	 * Gets the value of the stfKeywords property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfKeywords() {
		return stfKeywords;
	}

	/**
	 * Sets the value of the stfKeywords property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfKeywords(String value) {
		this.stfKeywords = value;
	}

	/**
	 * Gets the value of the stfLinkLearnMore property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfLinkLearnMore() {
		return stfLinkLearnMore;
	}

	/**
	 * Sets the value of the stfLinkLearnMore property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfLinkLearnMore(String value) {
		this.stfLinkLearnMore = value;
	}

	/**
	 * Gets the value of the stfNavigationTitle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfNavigationTitle() {
		return stfNavigationTitle;
	}

	/**
	 * Sets the value of the stfNavigationTitle property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfNavigationTitle(String value) {
		this.stfNavigationTitle = value;
	}

	/**
	 * Gets the value of the stfPageHeading property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfPageHeading() {
		return stfPageHeading;
	}

	/**
	 * Sets the value of the stfPageHeading property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfPageHeading(String value) {
		this.stfPageHeading = value;
	}

	/**
	 * Gets the value of the stfTargetedCountries property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfTargetedCountries() {
		return stfTargetedCountries;
	}

	/**
	 * Sets the value of the stfTargetedCountries property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfTargetedCountries(String value) {
		this.stfTargetedCountries = value;
	}

	/**
	 * Gets the value of the taTitle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTATitle() {
		return taTitle;
	}

	/**
	 * Sets the value of the taTitle property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTATitle(String value) {
		this.taTitle = value;
	}

	/**
	 * Gets the value of the txtTeaser property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTxtTeaser() {
		return txtTeaser;
	}

	/**
	 * Sets the value of the txtTeaser property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTxtTeaser(String value) {
		this.txtTeaser = value;
	}

	/**
	 * Gets the value of the conBody property.
	 * 
	 * @return possible object is {@link ConBodyType }
	 * 
	 */
	public ConBodyType getConBody() {
		return conBody;
	}

	/**
	 * Sets the value of the conBody property.
	 * 
	 * @param value allowed object is {@link ConBodyType }
	 * 
	 */
	public void setConBody(ConBodyType value) {
		this.conBody = value;
	}

	/**
	 * Gets the value of the pageID property.
	 * 
	 * @return possible object is {@link Byte }
	 * 
	 */
	public Byte getPageID() {
		return pageID;
	}

	/**
	 * Sets the value of the pageID property.
	 * 
	 * @param value allowed object is {@link Byte }
	 * 
	 */
	public void setPageID(Byte value) {
		this.pageID = value;
	}

	/**
	 * Gets the value of the isTemplate property.
	 * 
	 * @return possible object is {@link Byte }
	 * 
	 */
	public Byte getIsTemplate() {
		return isTemplate;
	}

	/**
	 * Sets the value of the isTemplate property.
	 * 
	 * @param value allowed object is {@link Byte }
	 * 
	 */
	public void setIsTemplate(Byte value) {
		this.isTemplate = value;
	}

}
