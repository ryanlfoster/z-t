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
 * Java class for con_GlobalHeaderType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="con_GlobalHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GlobalHeaderControlInclude" type="{}GlobalHeaderControlIncludeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "con_GlobalHeaderType", propOrder = { "globalHeaderControlInclude" })
public class ConGlobalHeaderType {

	@XmlElement(name = "GlobalHeaderControlInclude", required = true)
	protected GlobalHeaderControlIncludeType globalHeaderControlInclude;

	/**
	 * Gets the value of the globalHeaderControlInclude property.
	 * 
	 * @return possible object is {@link GlobalHeaderControlIncludeType }
	 * 
	 */
	public GlobalHeaderControlIncludeType getGlobalHeaderControlInclude() {
		return globalHeaderControlInclude;
	}

	/**
	 * Sets the value of the globalHeaderControlInclude property.
	 * 
	 * @param value allowed object is {@link GlobalHeaderControlIncludeType }
	 * 
	 */
	public void setGlobalHeaderControlInclude(GlobalHeaderControlIncludeType value) {
		this.globalHeaderControlInclude = value;
	}

}