package com.payu.sdk.utils.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Utility to encapsulate multiple {@link MapDetailsEntry} into elements.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "details")
public class MapDetailsElement {

	/**
	 * The list of details
	 */
	@XmlElement(name = "entry")
	private List<MapDetailsEntry> entries = new ArrayList<MapDetailsEntry>();

	/**
	 * Returns the list of entries
	 * 
	 * @return the entries
	 */
	public List<MapDetailsEntry> getEntries() {
		return entries;
	}

	/**
	 * Sets the list of entries
	 * 
	 * @param entries The entries to be set
	 */
	public void setEntries(List<MapDetailsEntry> entries) {
		this.entries = entries;
	}

	/**
	 * Adds an entry to the list
	 * 
	 * @param key The key the entry will have
	 * @param value The object to be added
	 */
	public void addEntry(String key, Object value) {
		MapDetailsEntry entry = new MapDetailsEntry();
		entry.setKey(key);
		entry.setObject(value);
		entries.add(entry);
	}
}
