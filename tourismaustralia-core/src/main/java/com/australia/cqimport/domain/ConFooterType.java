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
 * <p>Java class for con_FooterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="con_FooterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GlobalFooterControlInclude" type="{}GlobalFooterControlIncludeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "con_FooterType", propOrder = {
    "globalFooterControlInclude"
})
public class ConFooterType {

    @XmlElement(name = "GlobalFooterControlInclude", required = true)
    protected GlobalFooterControlIncludeType globalFooterControlInclude;

    /**
     * Gets the value of the globalFooterControlInclude property.
     * 
     * @return
     *     possible object is
     *     {@link GlobalFooterControlIncludeType }
     *     
     */
    public GlobalFooterControlIncludeType getGlobalFooterControlInclude() {
        return globalFooterControlInclude;
    }

    /**
     * Sets the value of the globalFooterControlInclude property.
     * 
     * @param value
     *     allowed object is
     *     {@link GlobalFooterControlIncludeType }
     *     
     */
    public void setGlobalFooterControlInclude(GlobalFooterControlIncludeType value) {
        this.globalFooterControlInclude = value;
    }

}
