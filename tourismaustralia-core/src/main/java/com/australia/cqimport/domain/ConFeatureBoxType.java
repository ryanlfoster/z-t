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
 * <p>
 * Java class for con_FeatureBoxType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="con_FeatureBoxType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FeatureBoxHolder" type="{}FeatureBoxHolderType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "con_FeatureBoxType", propOrder = { "featureBoxHolder" })
public class ConFeatureBoxType {

	@XmlElement(name = "FeatureBoxHolder", required = true)
	protected FeatureBoxHolderType featureBoxHolder;

	/**
	 * Gets the value of the featureBoxHolder property.
	 * 
	 * @return possible object is {@link FeatureBoxHolderType }
	 * 
	 */
	public FeatureBoxHolderType getFeatureBoxHolder() {
		return featureBoxHolder;
	}

	/**
	 * Sets the value of the featureBoxHolder property.
	 * 
	 * @param value allowed object is {@link FeatureBoxHolderType }
	 * 
	 */
	public void setFeatureBoxHolder(FeatureBoxHolderType value) {
		this.featureBoxHolder = value;
	}

}
