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
 * <p>Java class for BEHomeStoriesContainerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BEHomeStoriesContainerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hdl_headline" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_linkText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="con_stories" type="{}con_storiesType"/>
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
@XmlType(name = "BEHomeStoriesContainerType", propOrder = {
    "hdlHeadline",
    "stfLinkText",
    "stfTitle",
    "conStories"
})
public class BEHomeStoriesContainerType {

    @XmlElement(name = "hdl_headline", required = true)
    protected String hdlHeadline;
    @XmlElement(name = "stf_linkText", required = true)
    protected String stfLinkText;
    @XmlElement(name = "stf_Title", required = true)
    protected String stfTitle;
    @XmlElement(name = "con_stories", required = true)
    protected ConStoriesType conStories;
    @XmlAttribute(name = "isTemplate")
    protected Byte isTemplate;

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
     * Gets the value of the stfLinkText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfLinkText() {
        return stfLinkText;
    }

    /**
     * Sets the value of the stfLinkText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfLinkText(String value) {
        this.stfLinkText = value;
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
     * Gets the value of the conStories property.
     * 
     * @return
     *     possible object is
     *     {@link ConStoriesType }
     *     
     */
    public ConStoriesType getConStories() {
        return conStories;
    }

    /**
     * Sets the value of the conStories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConStoriesType }
     *     
     */
    public void setConStories(ConStoriesType value) {
        this.conStories = value;
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