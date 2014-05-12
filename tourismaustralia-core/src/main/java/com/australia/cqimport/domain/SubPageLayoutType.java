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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SubPageLayoutType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="SubPageLayoutType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="con_Banner">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ImageBanner" type="{}ImageBannerType" minOccurs="0"/>
 *                   &lt;element name="MapControlBodyContent" type="{}MapControlBodyContentType" minOccurs="0"/>
 *                   &lt;element name="HomepageBannerCountryHolder" type="{}HomepageBannerCountryHolderType" minOccurs="0"/>
 *                   &lt;element name="HomepageBannerHolder" type="{}HomepageBannerHolderType" minOccurs="0"/>
 *                   &lt;element name="RichTextModule" type="{}RichTextModuleType" minOccurs="0"/>
 *                   &lt;element name="GenericHTML" type="{}GenericHTMLType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="con_RHSModules" type="{}con_RHSModulesType"/>
 *         &lt;element name="con_Video">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Video" type="{}VideoType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="con_Body" type="{}con_BodyType"/>
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
@XmlType(name = "SubPageLayoutType", propOrder = { "conBanner", "conRHSModules", "conVideo", "conBody" })
public class SubPageLayoutType {

	@XmlElement(name = "con_Banner", required = true)
	protected SubPageLayoutType.ConBanner conBanner;
	@XmlElement(name = "con_RHSModules", required = true)
	protected ConRHSModulesType conRHSModules;
	@XmlElement(name = "con_Video", required = true)
	protected SubPageLayoutType.ConVideo conVideo;
	@XmlElement(name = "con_Body", required = true)
	protected ConBodyType conBody;
	@XmlAttribute(name = "isTemplate")
	protected Byte isTemplate;

	/**
	 * Gets the value of the conBanner property.
	 * 
	 * @return possible object is {@link SubPageLayoutType.ConBanner }
	 * 
	 */
	public SubPageLayoutType.ConBanner getConBanner() {
		return conBanner;
	}

	/**
	 * Sets the value of the conBanner property.
	 * 
	 * @param value allowed object is {@link SubPageLayoutType.ConBanner }
	 * 
	 */
	public void setConBanner(SubPageLayoutType.ConBanner value) {
		this.conBanner = value;
	}

	/**
	 * Gets the value of the conRHSModules property.
	 * 
	 * @return possible object is {@link ConRHSModulesType }
	 * 
	 */
	public ConRHSModulesType getConRHSModules() {
		return conRHSModules;
	}

	/**
	 * Sets the value of the conRHSModules property.
	 * 
	 * @param value allowed object is {@link ConRHSModulesType }
	 * 
	 */
	public void setConRHSModules(ConRHSModulesType value) {
		this.conRHSModules = value;
	}

	/**
	 * Gets the value of the conVideo property.
	 * 
	 * @return possible object is {@link SubPageLayoutType.ConVideo }
	 * 
	 */
	public SubPageLayoutType.ConVideo getConVideo() {
		return conVideo;
	}

	/**
	 * Sets the value of the conVideo property.
	 * 
	 * @param value allowed object is {@link SubPageLayoutType.ConVideo }
	 * 
	 */
	public void setConVideo(SubPageLayoutType.ConVideo value) {
		this.conVideo = value;
	}

	/**
	 * Gets the value of the conBody property.
	 * 
	 * @return possible object is {@link ConBodyType }
	 * 
	 */
	public ConBodyType getConBody() {
		return conBody;
	}

	/**
	 * Sets the value of the conBody property.
	 * 
	 * @param value allowed object is {@link ConBodyType }
	 * 
	 */
	public void setConBody(ConBodyType value) {
		this.conBody = value;
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

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="ImageBanner" type="{}ImageBannerType" minOccurs="0"/>
	 *         &lt;element name="MapControlBodyContent" type="{}MapControlBodyContentType" minOccurs="0"/>
	 *         &lt;element name="HomepageBannerCountryHolder" type="{}HomepageBannerCountryHolderType" minOccurs="0"/>
	 *         &lt;element name="HomepageBannerHolder" type="{}HomepageBannerHolderType" minOccurs="0"/>
	 *         &lt;element name="RichTextModule" type="{}RichTextModuleType" minOccurs="0"/>
	 *         &lt;element name="GenericHTML" type="{}GenericHTMLType" minOccurs="0"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "content" })
	public static class ConBanner {

		@XmlElementRefs({ @XmlElementRef(name = "RichTextModule", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "GenericHTML", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "ImageBanner", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "HomepageBannerHolder", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "HomepageBannerCountryHolder", type = JAXBElement.class, required = false),
			@XmlElementRef(name = "MapControlBodyContent", type = JAXBElement.class, required = false) })
		@XmlMixed
		protected List<Serializable> content;

		/**
		 * Gets the value of the content property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the content property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getContent().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link JAXBElement }{@code <}{@link RichTextModuleType }{@code >}
		 * {@link JAXBElement }{@code <}{@link GenericHTMLType }{@code >}
		 * {@link JAXBElement }{@code <}{@link ImageBannerType }{@code >}
		 * {@link String } {@link JAXBElement }{@code <}
		 * {@link HomepageBannerHolderType }{@code >} {@link JAXBElement }{@code <}
		 * {@link HomepageBannerCountryHolderType }{@code >} {@link JAXBElement }
		 * {@code <}{@link MapControlBodyContentType }{@code >}
		 * 
		 * 
		 */
		public List<Serializable> getContent() {
			if (content == null) {
				content = new ArrayList<Serializable>();
			}
			return this.content;
		}

	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="Video" type="{}VideoType" minOccurs="0"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "content" })
	public static class ConVideo {

		@XmlElementRef(name = "Video", type = JAXBElement.class, required = false)
		@XmlMixed
		protected List<Serializable> content;

		/**
		 * Gets the value of the content property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the content property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getContent().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link String } {@link JAXBElement }{@code <}{@link VideoType }{@code >}
		 * 
		 * 
		 */
		public List<Serializable> getContent() {
			if (content == null) {
				content = new ArrayList<Serializable>();
			}
			return this.content;
		}

	}

}
