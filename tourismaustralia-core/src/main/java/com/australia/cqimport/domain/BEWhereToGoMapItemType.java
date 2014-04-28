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
 * <p>Java class for BEWhereToGoMapItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BEWhereToGoMapItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anc_DestinationLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="img_DestinationItem1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="img_DestinationItem2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="img_DestinationItem3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="opt_DestinationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_DestinationItem1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_DestinationItem2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_DestinationItem3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_DestinationTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "BEWhereToGoMapItemType", propOrder = {
    "ancDestinationLink",
    "imgDestinationItem1",
    "imgDestinationItem2",
    "imgDestinationItem3",
    "optDestinationId",
    "stfDestinationItem1",
    "stfDestinationItem2",
    "stfDestinationItem3",
    "stfDestinationTitle"
})
public class BEWhereToGoMapItemType {

    @XmlElement(name = "anc_DestinationLink", required = true)
    protected String ancDestinationLink;
    @XmlElement(name = "img_DestinationItem1", required = true)
    protected String imgDestinationItem1;
    @XmlElement(name = "img_DestinationItem2", required = true)
    protected String imgDestinationItem2;
    @XmlElement(name = "img_DestinationItem3", required = true)
    protected String imgDestinationItem3;
    @XmlElement(name = "opt_DestinationId", required = true)
    protected String optDestinationId;
    @XmlElement(name = "stf_DestinationItem1", required = true)
    protected String stfDestinationItem1;
    @XmlElement(name = "stf_DestinationItem2", required = true)
    protected String stfDestinationItem2;
    @XmlElement(name = "stf_DestinationItem3", required = true)
    protected String stfDestinationItem3;
    @XmlElement(name = "stf_DestinationTitle", required = true)
    protected String stfDestinationTitle;
    @XmlAttribute(name = "isTemplate")
    protected Byte isTemplate;

    /**
     * Gets the value of the ancDestinationLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAncDestinationLink() {
        return ancDestinationLink;
    }

    /**
     * Sets the value of the ancDestinationLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAncDestinationLink(String value) {
        this.ancDestinationLink = value;
    }

    /**
     * Gets the value of the imgDestinationItem1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgDestinationItem1() {
        return imgDestinationItem1;
    }

    /**
     * Sets the value of the imgDestinationItem1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgDestinationItem1(String value) {
        this.imgDestinationItem1 = value;
    }

    /**
     * Gets the value of the imgDestinationItem2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgDestinationItem2() {
        return imgDestinationItem2;
    }

    /**
     * Sets the value of the imgDestinationItem2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgDestinationItem2(String value) {
        this.imgDestinationItem2 = value;
    }

    /**
     * Gets the value of the imgDestinationItem3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgDestinationItem3() {
        return imgDestinationItem3;
    }

    /**
     * Sets the value of the imgDestinationItem3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgDestinationItem3(String value) {
        this.imgDestinationItem3 = value;
    }

    /**
     * Gets the value of the optDestinationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptDestinationId() {
        return optDestinationId;
    }

    /**
     * Sets the value of the optDestinationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptDestinationId(String value) {
        this.optDestinationId = value;
    }

    /**
     * Gets the value of the stfDestinationItem1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfDestinationItem1() {
        return stfDestinationItem1;
    }

    /**
     * Sets the value of the stfDestinationItem1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfDestinationItem1(String value) {
        this.stfDestinationItem1 = value;
    }

    /**
     * Gets the value of the stfDestinationItem2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfDestinationItem2() {
        return stfDestinationItem2;
    }

    /**
     * Sets the value of the stfDestinationItem2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfDestinationItem2(String value) {
        this.stfDestinationItem2 = value;
    }

    /**
     * Gets the value of the stfDestinationItem3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfDestinationItem3() {
        return stfDestinationItem3;
    }

    /**
     * Sets the value of the stfDestinationItem3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfDestinationItem3(String value) {
        this.stfDestinationItem3 = value;
    }

    /**
     * Gets the value of the stfDestinationTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStfDestinationTitle() {
        return stfDestinationTitle;
    }

    /**
     * Sets the value of the stfDestinationTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStfDestinationTitle(String value) {
        this.stfDestinationTitle = value;
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
