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
 * Java class for BELayoutT7Type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="BELayoutT7Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stf_Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stf_subHeader" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="con_right_content" type="{}con_right_contentType"/>
 *         &lt;element name="con_left_sidebar" type="{}con_left_sidebarType"/>
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
@XmlType(name = "BELayoutT7Type", propOrder = { "stfTitle", "stfSubHeader", "conRightContent", "conLeftSidebar" })
public class BELayoutT7Type {

	@XmlElement(name = "stf_Title", required = true)
	protected String stfTitle;
	@XmlElement(name = "stf_subHeader", required = true)
	protected String stfSubHeader;
	@XmlElement(name = "con_right_content", required = true)
	protected ConRightcontentType conRightContent;
	@XmlElement(name = "con_left_sidebar", required = true)
	protected ConLeftSidebarType conLeftSidebar;
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
	 * Gets the value of the stfSubHeader property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStfSubHeader() {
		return stfSubHeader;
	}

	/**
	 * Sets the value of the stfSubHeader property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setStfSubHeader(String value) {
		this.stfSubHeader = value;
	}

	/**
	 * Gets the value of the conRightContent property.
	 * 
	 * @return possible object is {@link ConRightContentType }
	 * 
	 */
	public ConRightcontentType getConRightContent() {
		return conRightContent;
	}

	/**
	 * Sets the value of the conRightContent property.
	 * 
	 * @param value allowed object is {@link ConRightContentType }
	 * 
	 */
	public void setConRightContent(ConRightcontentType value) {
		this.conRightContent = value;
	}

	/**
	 * Gets the value of the conLeftSidebar property.
	 * 
	 * @return possible object is {@link ConLeftSidebarType }
	 * 
	 */
	public ConLeftSidebarType getConLeftSidebar() {
		return conLeftSidebar;
	}

	/**
	 * Sets the value of the conLeftSidebar property.
	 * 
	 * @param value allowed object is {@link ConLeftSidebarType }
	 * 
	 */
	public void setConLeftSidebar(ConLeftSidebarType value) {
		this.conLeftSidebar = value;
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
