//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.17 at 01:40:13 PM EST 
//


package com.australia.cqimport.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BEGenericToolkitSummaryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BEGenericToolkitSummaryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="anc_Link" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lst_Items" type="{}lst_ItemsType"/>
 *         &lt;element name="stf_ViewMore" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *       &lt;attribute name="isTemplate" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BEGenericToolkitSummaryType", propOrder = {
    "ancLinkOrStfTitleOrLstItems"
})
public class BEGenericToolkitSummaryType {

    @XmlElementRefs({
        @XmlElementRef(name = "stf_ViewMore", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "anc_Link", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "lst_Items", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stf_Title", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> ancLinkOrStfTitleOrLstItems;
    @XmlAttribute(name = "isTemplate")
    protected Byte isTemplate;

    /**
     * Gets the value of the ancLinkOrStfTitleOrLstItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ancLinkOrStfTitleOrLstItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAncLinkOrStfTitleOrLstItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link LstItemsType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getAncLinkOrStfTitleOrLstItems() {
        if (ancLinkOrStfTitleOrLstItems == null) {
            ancLinkOrStfTitleOrLstItems = new ArrayList<JAXBElement<?>>();
        }
        return this.ancLinkOrStfTitleOrLstItems;
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
