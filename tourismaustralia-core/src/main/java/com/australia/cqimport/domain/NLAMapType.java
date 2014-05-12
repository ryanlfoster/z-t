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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for NLAMapType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="NLAMapType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stf_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_TitleTagLine" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_MapLink" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="anc_Overlay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="con_Description" type="{}con_DescriptionType"/>
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
@XmlType(name = "NLAMapType", propOrder = { "stfTitle", "stfTitleTagLine", "stfMapLink", "ancOverlay", "conDescription" })
public class NLAMapType {

	@XmlElement(name = "stf_Title", required = true)
	protected String stfTitle;
	@XmlElement(name = "stf_TitleTagLine", required = true)
	protected String stfTitleTagLine;
	@XmlElement(name = "stf_MapLink", required = true)
	@XmlSchemaType(name = "anyURI")
	protected String stfMapLink;
	@XmlElement(name = "anc_Overlay", required = true)
	protected String ancOverlay;
	@XmlElement(name = "con_Description", required = true)
	protected ConDescriptionType conDescription;
	@XmlAttribute(name = "isTemplate")
	protected Byte isTemplate;

	/**
	 * Gets the value of the stfTitle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfTitle() {
		return stfTitle;
	}

	/**
	 * Sets the value of the stfTitle property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfTitle(String value) {
		this.stfTitle = value;
	}

	/**
	 * Gets the value of the stfTitleTagLine property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfTitleTagLine() {
		return stfTitleTagLine;
	}

	/**
	 * Sets the value of the stfTitleTagLine property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfTitleTagLine(String value) {
		this.stfTitleTagLine = value;
	}

	/**
	 * Gets the value of the stfMapLink property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfMapLink() {
		return stfMapLink;
	}

	/**
	 * Sets the value of the stfMapLink property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfMapLink(String value) {
		this.stfMapLink = value;
	}

	/**
	 * Gets the value of the ancOverlay property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAncOverlay() {
		return ancOverlay;
	}

	/**
	 * Sets the value of the ancOverlay property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAncOverlay(String value) {
		this.ancOverlay = value;
	}

	/**
	 * Gets the value of the conDescription property.
	 * 
	 * @return possible object is {@link ConDescriptionType }
	 * 
	 */
	public ConDescriptionType getConDescription() {
		return conDescription;
	}

	/**
	 * Sets the value of the conDescription property.
	 * 
	 * @param value allowed object is {@link ConDescriptionType }
	 * 
	 */
	public void setConDescription(ConDescriptionType value) {
		this.conDescription = value;
	}

	/**
	 * Gets the value of the isTemplate property.
	 * 
	 * @return possible object is {@link Byte }
	 * 
	 */
	public Byte getIsTemplate() {
		return isTemplate;
	}

	/**
	 * Sets the value of the isTemplate property.
	 * 
	 * @param value allowed object is {@link Byte }
	 * 
	 */
	public void setIsTemplate(Byte value) {
		this.isTemplate = value;
	}

}
