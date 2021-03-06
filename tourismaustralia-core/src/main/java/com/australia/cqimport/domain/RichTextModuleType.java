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
 * <p>Java class for RichTextModuleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RichTextModuleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="txt_rhs_content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="txt_custom_styling" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="txt_main" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "RichTextModuleType", propOrder = {
    "txtRhsContent",
    "txtCustomStyling",
    "txtMain"
})
public class RichTextModuleType {

    @XmlElement(name = "txt_rhs_content", required = true)
    protected String txtRhsContent;
    @XmlElement(name = "txt_custom_styling", required = true)
    protected String txtCustomStyling;
    @XmlElement(name = "txt_main", required = true)
    protected String txtMain;
    @XmlAttribute(name = "isTemplate")
    protected Byte isTemplate;

    /**
     * Gets the value of the txtRhsContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxtRhsContent() {
        return txtRhsContent;
    }

    /**
     * Sets the value of the txtRhsContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxtRhsContent(String value) {
        this.txtRhsContent = value;
    }

    /**
     * Gets the value of the txtCustomStyling property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxtCustomStyling() {
        return txtCustomStyling;
    }

    /**
     * Sets the value of the txtCustomStyling property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxtCustomStyling(String value) {
        this.txtCustomStyling = value;
    }

    /**
     * Gets the value of the txtMain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxtMain() {
        return txtMain;
    }

    /**
     * Sets the value of the txtMain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxtMain(String value) {
        this.txtMain = value;
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
