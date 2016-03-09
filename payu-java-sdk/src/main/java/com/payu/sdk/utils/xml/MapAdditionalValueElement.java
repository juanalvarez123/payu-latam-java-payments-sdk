package com.payu.sdk.utils.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.model.AdditionalValue;

/**
 * Utility to encapsulate multiple {@link MapAdditionalValueEntry} into elements.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "additionalValue")
public class MapAdditionalValueElement {

	/**
	 * The list of additional values
	 */
	@XmlElement(name = "entry")
	private List<MapAdditionalValueEntry> entries = new ArrayList<MapAdditionalValueEntry>();

	/**
	 * Returns the list of entries
	 * 
	 * @return the entries
	 */
	public List<MapAdditionalValueEntry> getEntries() {
		return entries;
	}

	/**
	 * Sets the list of entries
	 * 
	 * @param entries The entries to be set
	 */
	public void setEntries(List<MapAdditionalValueEntry> entries) {
		this.entries = entries;
	}

	/**
	 * Adds an entry to the list
	 * 
	 * @param key The key the entry will have
	 * @param additionalValue The additional value to be added
	 */
	public void addEntry(String key, AdditionalValue additionalValue) {
		MapAdditionalValueEntry entry = new MapAdditionalValueEntry();
		entry.setKey(key);
		entry.setAdditionalValue(additionalValue);
		entries.add(entry);
	}
}
