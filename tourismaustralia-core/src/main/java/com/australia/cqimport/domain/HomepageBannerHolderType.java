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
 * <p>Java class for HomepageBannerHolderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HomepageBannerHolderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hdl_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="con_Banner" type="{}con_BannerType"/>
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
@XmlType(name = "HomepageBannerHolderType", propOrder = {
    "hdlTitle",
    "conBanner"
})
public class HomepageBannerHolderType {

    @XmlElement(name = "hdl_Title", required = true)
    protected String hdlTitle;
    @XmlElement(name = "con_Banner", required = true)
    protected ConBannerType conBanner;
    @XmlAttribute(name = "isTemplate")
    protected Byte isTemplate;

    /**
     * Gets the value of the hdlTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHdlTitle() {
        return hdlTitle;
    }

    /**
     * Sets the value of the hdlTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHdlTitle(String value) {
        this.hdlTitle = value;
    }

    /**
     * Gets the value of the conBanner property.
     * 
     * @return
     *     possible object is
     *     {@link ConBannerType }
     *     
     */
    public ConBannerType getConBanner() {
        return conBanner;
    }

    /**
     * Sets the value of the conBanner property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConBannerType }
     *     
     */
    public void setConBanner(ConBannerType value) {
        this.conBanner = value;
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
