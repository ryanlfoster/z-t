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
 * Java class for AtaGlanceType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="AtaGlanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hdl_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="img_Map" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stf_Title1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stf_Title2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stf_Title3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stf_Title4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stf_Title5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="txt_Description1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="txt_Description2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="txt_Description3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="txt_Description4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="txt_Description5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "AtaGlanceType", propOrder = { "hdlTitle", "imgMap", "stfTitle1", "stfTitle2", "stfTitle3",
	"stfTitle4", "stfTitle5", "txtDescription1", "txtDescription2", "txtDescription3", "txtDescription4",
	"txtDescription5" })
public class AtaGlanceType {

	@XmlElement(name = "hdl_Title", required = true)
	protected String hdlTitle;
	@XmlElement(name = "img_Map")
	protected String imgMap;
	@XmlElement(name = "stf_Title1")
	protected String stfTitle1;
	@XmlElement(name = "stf_Title2")
	protected String stfTitle2;
	@XmlElement(name = "stf_Title3")
	protected String stfTitle3;
	@XmlElement(name = "stf_Title4")
	protected String stfTitle4;
	@XmlElement(name = "stf_Title5")
	protected String stfTitle5;
	@XmlElement(name = "txt_Description1")
	protected String txtDescription1;
	@XmlElement(name = "txt_Description2")
	protected String txtDescription2;
	@XmlElement(name = "txt_Description3")
	protected String txtDescription3;
	@XmlElement(name = "txt_Description4")
	protected String txtDescription4;
	@XmlElement(name = "txt_Description5")
	protected String txtDescription5;
	@XmlAttribute(name = "isTemplate")
	protected Byte isTemplate;

	/**
	 * Gets the value of the hdlTitle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHdlTitle() {
		return hdlTitle;
	}

	/**
	 * Sets the value of the hdlTitle property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setHdlTitle(String value) {
		this.hdlTitle = value;
	}

	/**
	 * Gets the value of the imgMap property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getImgMap() {
		return imgMap;
	}

	/**
	 * Sets the value of the imgMap property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setImgMap(String value) {
		this.imgMap = value;
	}

	/**
	 * Gets the value of the stfTitle1 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfTitle1() {
		return stfTitle1;
	}

	/**
	 * Sets the value of the stfTitle1 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfTitle1(String value) {
		this.stfTitle1 = value;
	}

	/**
	 * Gets the value of the stfTitle2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfTitle2() {
		return stfTitle2;
	}

	/**
	 * Sets the value of the stfTitle2 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfTitle2(String value) {
		this.stfTitle2 = value;
	}

	/**
	 * Gets the value of the stfTitle3 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfTitle3() {
		return stfTitle3;
	}

	/**
	 * Sets the value of the stfTitle3 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfTitle3(String value) {
		this.stfTitle3 = value;
	}

	/**
	 * Gets the value of the stfTitle4 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfTitle4() {
		return stfTitle4;
	}

	/**
	 * Sets the value of the stfTitle4 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfTitle4(String value) {
		this.stfTitle4 = value;
	}

	/**
	 * Gets the value of the stfTitle5 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfTitle5() {
		return stfTitle5;
	}

	/**
	 * Sets the value of the stfTitle5 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfTitle5(String value) {
		this.stfTitle5 = value;
	}

	/**
	 * Gets the value of the txtDescription1 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTxtDescription1() {
		return txtDescription1;
	}

	/**
	 * Sets the value of the txtDescription1 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTxtDescription1(String value) {
		this.txtDescription1 = value;
	}

	/**
	 * Gets the value of the txtDescription2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTxtDescription2() {
		return txtDescription2;
	}

	/**
	 * Sets the value of the txtDescription2 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTxtDescription2(String value) {
		this.txtDescription2 = value;
	}

	/**
	 * Gets the value of the txtDescription3 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTxtDescription3() {
		return txtDescription3;
	}

	/**
	 * Sets the value of the txtDescription3 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTxtDescription3(String value) {
		this.txtDescription3 = value;
	}

	/**
	 * Gets the value of the txtDescription4 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTxtDescription4() {
		return txtDescription4;
	}

	/**
	 * Sets the value of the txtDescription4 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTxtDescription4(String value) {
		this.txtDescription4 = value;
	}

	/**
	 * Gets the value of the txtDescription5 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTxtDescription5() {
		return txtDescription5;
	}

	/**
	 * Sets the value of the txtDescription5 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setTxtDescription5(String value) {
		this.txtDescription5 = value;
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
