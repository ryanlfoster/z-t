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
 * <p>Java class for BELayoutT3Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BELayoutT3Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stf_Header" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_SubHeader" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="con_centre_content" type="{}con_centre_contentType"/>
 *         &lt;element name="con_right_sidebar" type="{}con_right_sidebarType"/>
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
@XmlType(name = "BELayoutT3Type", propOrder = {
    "stfHeader",
    "stfSubHeader",
    "conCentreContent",
    "conRightSidebar"
})
public class BELayoutT3Type {

    @XmlElement(name = "stf_Header", required = true)
    protected String stfHeader;
    @XmlElement(name = "stf_SubHeader", required = true)
    protected String stfSubHeader;
    @XmlElement(name = "con_centre_content", required = true)
    protected ConCentreContentType conCentreContent;
    @XmlElement(name = "con_right_sidebar", required = true)
    protected ConRightSidebarType conRightSidebar;
    @XmlAttribute(name = "isTemplate")
    protected Byte isTemplate;

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
     * Gets the value of the conCentreContent property.
     * 
     * @return
     *     possible object is
     *     {@link ConCentreContentType }
     *     
     */
    public ConCentreContentType getConCentreContent() {
        return conCentreContent;
    }

    /**
     * Sets the value of the conCentreContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConCentreContentType }
     *     
     */
    public void setConCentreContent(ConCentreContentType value) {
        this.conCentreContent = value;
    }

    /**
     * Gets the value of the conRightSidebar property.
     * 
     * @return
     *     possible object is
     *     {@link ConRightSidebarType }
     *     
     */
    public ConRightSidebarType getConRightSidebar() {
        return conRightSidebar;
    }

    /**
     * Sets the value of the conRightSidebar property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConRightSidebarType }
     *     
     */
    public void setConRightSidebar(ConRightSidebarType value) {
        this.conRightSidebar = value;
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
