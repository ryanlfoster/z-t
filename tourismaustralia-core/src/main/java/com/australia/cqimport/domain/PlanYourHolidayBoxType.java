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
 * <p>Java class for PlanYourHolidayBoxType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlanYourHolidayBoxType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anc_MoreLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hdl_Headline" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="opt_IsOnHomepage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_MenuIconClass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_More" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_PlanYourHolidayTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lst_PageLinks" type="{}lst_PageLinksType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="isTemplate" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlanYourHolidayBoxType", propOrder = {
    "ancMoreLink",
    "hdlHeadline",
    "language",
    "optIsOnHomepage",
    "stfMenuIconClass",
    "stfMore",
    "stfPlanYourHolidayTitle",
    "lstPageLinks"
})
public class PlanYourHolidayBoxType {

    @XmlElement(name = "anc_MoreLink", required = true)
    protected String ancMoreLink;
    @XmlElement(name = "hdl_Headline", required = true)
    protected String hdlHeadline;
    @XmlElement(required = true)
    protected String language;
    @XmlElement(name = "opt_IsOnHomepage", required = true)
    protected String optIsOnHomepage;
    @XmlElement(name = "stf_MenuIconClass", required = true)
    protected String stfMenuIconClass;
    @XmlElement(name = "stf_More", required = true)
    protected String stfMore;
    @XmlElement(name = "stf_PlanYourHolidayTitle", required = true)
    protected String stfPlanYourHolidayTitle;
    @XmlElement(name = "lst_PageLinks", required = true)
    protected LstPageLinksType lstPageLinks;
    @XmlAttribute(name = "isTemplate")
    protected Byte isTemplate;

    /**
     * Gets the value of the ancMoreLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAncMoreLink() {
        return ancMoreLink;
    }

    /**
     * Sets the value of the ancMoreLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAncMoreLink(String value) {
        this.ancMoreLink = value;
    }

    /**
     * Gets the value of the hdlHeadline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHdlHeadline() {
        return hdlHeadline;
    }

    /**
     * Sets the value of the hdlHeadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHdlHeadline(String value) {
        this.hdlHeadline = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the optIsOnHomepage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptIsOnHomepage() {
        return optIsOnHomepage;
    }

    /**
     * Sets the value of the optIsOnHomepage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptIsOnHomepage(String value) {
        this.optIsOnHomepage = value;
    }

    /**
     * Gets the value of the stfMenuIconClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfMenuIconClass() {
        return stfMenuIconClass;
    }

    /**
     * Sets the value of the stfMenuIconClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfMenuIconClass(String value) {
        this.stfMenuIconClass = value;
    }

    /**
     * Gets the value of the stfMore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfMore() {
        return stfMore;
    }

    /**
     * Sets the value of the stfMore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfMore(String value) {
        this.stfMore = value;
    }

    /**
     * Gets the value of the stfPlanYourHolidayTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfPlanYourHolidayTitle() {
        return stfPlanYourHolidayTitle;
    }

    /**
     * Sets the value of the stfPlanYourHolidayTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfPlanYourHolidayTitle(String value) {
        this.stfPlanYourHolidayTitle = value;
    }

    /**
     * Gets the value of the lstPageLinks property.
     * 
     * @return
     *     possible object is
     *     {@link LstPageLinksType }
     *     
     */
    public LstPageLinksType getLstPageLinks() {
        return lstPageLinks;
    }

    /**
     * Sets the value of the lstPageLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link LstPageLinksType }
     *     
     */
    public void setLstPageLinks(LstPageLinksType value) {
        this.lstPageLinks = value;
    }

    /**
     * Gets the value of the isTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getIsTemplate() {
        return isTemplate;
    }

    /**
     * Sets the value of the isTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setIsTemplate(Byte value) {
        this.isTemplate = value;
    }

}
