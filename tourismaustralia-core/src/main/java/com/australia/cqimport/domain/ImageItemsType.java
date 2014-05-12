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
 * <p>
 * Java class for ImageItemsType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ImageItemsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anc_link" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="img_MainImage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_Caption" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "ImageItemsType", propOrder = { "ancLink", "imgMainImage", "stfCaption" })
public class ImageItemsType {

	@XmlElement(name = "anc_link", required = true)
	protected String ancLink;
	@XmlElement(name = "img_MainImage", required = true)
	protected String imgMainImage;
	@XmlElement(name = "stf_Caption", required = true)
	protected String stfCaption;
	@XmlAttribute(name = "isTemplate")
	protected Byte isTemplate;

	/**
	 * Gets the value of the ancLink property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAncLink() {
		return ancLink;
	}

	/**
	 * Sets the value of the ancLink property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAncLink(String value) {
		this.ancLink = value;
	}

	/**
	 * Gets the value of the imgMainImage property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getImgMainImage() {
		return imgMainImage;
	}

	/**
	 * Sets the value of the imgMainImage property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setImgMainImage(String value) {
		this.imgMainImage = value;
	}

	/**
	 * Gets the value of the stfCaption property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfCaption() {
		return stfCaption;
	}

	/**
	 * Sets the value of the stfCaption property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfCaption(String value) {
		this.stfCaption = value;
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
