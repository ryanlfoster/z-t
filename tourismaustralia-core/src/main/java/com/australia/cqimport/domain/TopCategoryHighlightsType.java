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
 * <p>Java class for TopCategoryHighlightsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TopCategoryHighlightsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stf_Heading" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_InformationTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="txt_Information" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="con_CenterContent" type="{}con_CenterContentType" minOccurs="0"/>
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
@XmlType(name = "TopCategoryHighlightsType", propOrder = {
    "stfHeading",
    "stfInformationTitle",
    "txtInformation",
    "conCenterContent"
})
public class TopCategoryHighlightsType {

    @XmlElement(name = "stf_Heading", required = true)
    protected String stfHeading;
    @XmlElement(name = "stf_InformationTitle", required = true)
    protected String stfInformationTitle;
    @XmlElement(name = "txt_Information", required = true)
    protected String txtInformation;
    @XmlElement(name = "con_CenterContent")
    protected ConCenterContentType conCenterContent;
    @XmlAttribute(name = "isTemplate")
    protected Byte isTemplate;

    /**
     * Gets the value of the stfHeading property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfHeading() {
        return stfHeading;
    }

    /**
     * Sets the value of the stfHeading property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfHeading(String value) {
        this.stfHeading = value;
    }

    /**
     * Gets the value of the stfInformationTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfInformationTitle() {
        return stfInformationTitle;
    }

    /**
     * Sets the value of the stfInformationTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfInformationTitle(String value) {
        this.stfInformationTitle = value;
    }

    /**
     * Gets the value of the txtInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxtInformation() {
        return txtInformation;
    }

    /**
     * Sets the value of the txtInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxtInformation(String value) {
        this.txtInformation = value;
    }

    /**
     * Gets the value of the conCenterContent property.
     * 
     * @return
     *     possible object is
     *     {@link ConCenterContentType }
     *     
     */
    public ConCenterContentType getConCenterContent() {
        return conCenterContent;
    }

    /**
     * Sets the value of the conCenterContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConCenterContentType }
     *     
     */
    public void setConCenterContent(ConCenterContentType value) {
        this.conCenterContent = value;
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
