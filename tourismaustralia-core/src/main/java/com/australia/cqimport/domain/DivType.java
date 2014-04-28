//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.17 at 01:40:13 PM EST 
//


package com.australia.cqimport.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for divType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="divType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="img" type="{}imgType"/>
 *         &lt;element name="p">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="span" type="{}spanType" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="style" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="div" type="{}divType"/>
 *         &lt;element name="a" type="{}aType"/>
 *         &lt;element name="h3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_ItemTeaserText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="anc_ReadMoreLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="img_ItemImage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="img_LightboxImage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="med_Listing_Item_PDF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stf_ItemReadMoreLinkText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_ItemTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_LightboxEmailAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_LightboxEmailLabel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_LightboxPartnerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_LightboxWebsiteLabel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_LightboxWebsiteURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="txt_LightboxContentBody" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ul" type="{}ulType"/>
 *       &lt;/choice>
 *       &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="runat" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isTemplate" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="style" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "divType", propOrder = {
    "content"
})
public class DivType {

    @XmlElementRefs({
        @XmlElementRef(name = "med_Listing_Item_PDF", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stf_LightboxPartnerId", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stf_ItemTitle", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stf_LightboxEmailAddress", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "anc_ReadMoreLink", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "img_LightboxImage", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stf_LightboxEmailLabel", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "img", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "div", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "h3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stf_LightboxWebsiteLabel", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ul", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "txt_LightboxContentBody", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stf_LightboxWebsiteURL", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "a", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stf_ItemReadMoreLinkText", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "img_ItemImage", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "p", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "stf_ItemTeaserText", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute(name = "class")
    protected String clazz;
    @XmlAttribute(name = "runat")
    protected String runat;
    @XmlAttribute(name = "isTemplate")
    protected Byte isTemplate;
    @XmlAttribute(name = "style")
    protected String style;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link DivType }{@code >}
     * {@link JAXBElement }{@code <}{@link ImgType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link AType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link UlType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link DivType.P }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the runat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRunat() {
        return runat;
    }

    /**
     * Sets the value of the runat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRunat(String value) {
        this.runat = value;
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

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="span" type="{}spanType" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="style" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class P {

        @XmlElementRef(name = "span", type = JAXBElement.class, required = false)
        @XmlMixed
        protected List<Serializable> content;
        @XmlAttribute(name = "class")
        protected String clazz;
        @XmlAttribute(name = "style")
        protected String style;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * {@link JAXBElement }{@code <}{@link SpanType }{@code >}
         * 
         * 
         */
        public List<Serializable> getContent() {
            if (content == null) {
                content = new ArrayList<Serializable>();
            }
            return this.content;
        }

        /**
         * Gets the value of the clazz property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getClazz() {
            return clazz;
        }

        /**
         * Sets the value of the clazz property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setClazz(String value) {
            this.clazz = value;
        }

        /**
         * Gets the value of the style property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStyle() {
            return style;
        }

        /**
         * Sets the value of the style property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStyle(String value) {
            this.style = value;
        }

    }

}
