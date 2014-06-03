//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.17 at 01:40:13 PM EST 
//

package com.australia.cqimport.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for con_itemsType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="con_itemsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BEHomeNewsItem" type="{}BEHomeNewsItemType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BEGenericListWithHeaderItem" type="{}BEGenericListWithHeaderItemType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "con_itemsType", propOrder = { "beHomeNewsItem", "beGenericListWithHeaderItem" })
public class ConItemsType {

	@XmlElement(name = "BEHomeNewsItem")
	protected List<BEHomeNewsItemType> beHomeNewsItem;
	@XmlElement(name = "BEGenericListWithHeaderItem")
	protected List<BEGenericListWithHeaderItemType> beGenericListWithHeaderItem;

	/**
	 * Gets the value of the beHomeNewsItem property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the beHomeNewsItem property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBEHomeNewsItem().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link BEHomeNewsItemType }
	 * 
	 * 
	 */
	public List<BEHomeNewsItemType> getBEHomeNewsItem() {
		if (beHomeNewsItem == null) {
			beHomeNewsItem = new ArrayList<BEHomeNewsItemType>();
		}
		return this.beHomeNewsItem;
	}

	/**
	 * Gets the value of the beGenericListWithHeaderItem property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the beGenericListWithHeaderItem property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBEGenericListWithHeaderItem().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link BEGenericListWithHeaderItemType }
	 * 
	 * 
	 */
	public List<BEGenericListWithHeaderItemType> getBEGenericListWithHeaderItem() {
		if (beGenericListWithHeaderItem == null) {
			beGenericListWithHeaderItem = new ArrayList<BEGenericListWithHeaderItemType>();
		}
		return this.beGenericListWithHeaderItem;
	}

}