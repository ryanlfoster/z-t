//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.17 at 01:40:13 PM EST 
//


package com.australia.cqimport.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lst_PageLinkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lst_PageLinkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hdl_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="opt_MenuIconClass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lst_PageLinkType", propOrder = {
    "url",
    "hdlTitle",
    "optMenuIconClass"
})
public class LstPageLinkType {

    @XmlElement(required = true)
    protected String url;
    @XmlElement(name = "hdl_Title", required = true)
    protected String hdlTitle;
    @XmlElement(name = "opt_MenuIconClass", required = true)
    protected String optMenuIconClass;

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

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
     * Gets the value of the optMenuIconClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptMenuIconClass() {
        return optMenuIconClass;
    }

    /**
     * Sets the value of the optMenuIconClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptMenuIconClass(String value) {
        this.optMenuIconClass = value;
    }

}
