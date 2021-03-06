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
 * <p>Java class for BEGenericFeaturedLinksContainerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BEGenericFeaturedLinksContainerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anc_TitleLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_Header" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_SubHeader" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="con_FeaturedLinks" type="{}con_FeaturedLinksType"/>
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
@XmlType(name = "BEGenericFeaturedLinksContainerType", propOrder = {
    "ancTitleLink",
    "stfHeader",
    "stfSubHeader",
    "stfTitle",
    "conFeaturedLinks"
})
public class BEGenericFeaturedLinksContainerType {

    @XmlElement(name = "anc_TitleLink", required = true)
    protected String ancTitleLink;
    @XmlElement(name = "stf_Header", required = true)
    protected String stfHeader;
    @XmlElement(name = "stf_SubHeader", required = true)
    protected String stfSubHeader;
    @XmlElement(name = "stf_Title", required = true)
    protected String stfTitle;
    @XmlElement(name = "con_FeaturedLinks", required = true)
    protected ConFeaturedLinksType conFeaturedLinks;
    @XmlAttribute(name = "isTemplate")
    protected Byte isTemplate;

    /**
     * Gets the value of the ancTitleLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAncTitleLink() {
        return ancTitleLink;
    }

    /**
     * Sets the value of the ancTitleLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAncTitleLink(String value) {
        this.ancTitleLink = value;
    }

    /**
     * Gets the value of the stfHeader property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfHeader() {
        return stfHeader;
    }

    /**
     * Sets the value of the stfHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfHeader(String value) {
        this.stfHeader = value;
    }

    /**
     * Gets the value of the stfSubHeader property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfSubHeader() {
        return stfSubHeader;
    }

    /**
     * Sets the value of the stfSubHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfSubHeader(String value) {
        this.stfSubHeader = value;
    }

    /**
     * Gets the value of the stfTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfTitle() {
        return stfTitle;
    }

    /**
     * Sets the value of the stfTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfTitle(String value) {
        this.stfTitle = value;
    }

    /**
     * Gets the value of the conFeaturedLinks property.
     * 
     * @return
     *     possible object is
     *     {@link ConFeaturedLinksType }
     *     
     */
    public ConFeaturedLinksType getConFeaturedLinks() {
        return conFeaturedLinks;
    }

    /**
     * Sets the value of the conFeaturedLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConFeaturedLinksType }
     *     
     */
    public void setConFeaturedLinks(ConFeaturedLinksType value) {
        this.conFeaturedLinks = value;
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
