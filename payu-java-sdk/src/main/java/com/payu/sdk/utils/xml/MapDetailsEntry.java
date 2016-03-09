package com.payu.sdk.utils.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Utility to map Objects into entry.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapDetailsEntry {

	/** The key of the detail entry */
	@XmlElement(name = "string")
	private String key;

	/** The entry object */
	@XmlElement(name = "object")
	private Object object;

	/**
	 * Returns the entry key
	 * 
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the entry key
	 * 
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Return the entry object
	 * 
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * Sets the entry object
	 * 
	 * @param object
	 *            the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}

}
