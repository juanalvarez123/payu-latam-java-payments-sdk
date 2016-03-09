package com.payu.sdk.utils.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.model.AdditionalValue;

/**
 * Utility to map {@link AdditionalValue} into entry.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapAdditionalValueEntry {

	/** The key of the additional value entry */
	@XmlElement(name = "string")
	private String key;

	/** The entry additional value */
	@XmlElement(name = "additionalValue")
	private AdditionalValue additionalValue;

	/**
	 * Returns the additional value key
	 * 
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the additional value key
	 * 
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Returns the additional value
	 * 
	 * @return the additionalValue
	 */
	public AdditionalValue getAdditionalValue() {
		return additionalValue;
	}

	/**
	 * Sets the additional value
	 * 
	 * @param additionalValue
	 *            the additionalValue to set
	 */
	public void setAdditionalValue(AdditionalValue additionalValue) {
		this.additionalValue = additionalValue;
	}

}
