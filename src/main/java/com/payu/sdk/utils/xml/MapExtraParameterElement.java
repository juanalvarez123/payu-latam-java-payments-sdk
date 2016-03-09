package com.payu.sdk.utils.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Utility to encapsulate multiple {@link MapExtraParameterEntry} into elements.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "extraParameters")
public class MapExtraParameterElement {

	/**
	 * The list of extra parameters
	 */
	@XmlElement(name = "entry")
	private List<MapExtraParameterEntry> entries = new ArrayList<MapExtraParameterEntry>();

	/**
	 * Returns the list of entries
	 * 
	 * @return the entries
	 */
	public List<MapExtraParameterEntry> getEntries() {
		return entries;
	}

	/**
	 * Sets the list of entries
	 * 
	 * @param entries The entries to be set
	 */
	public void setEntries(List<MapExtraParameterEntry> entries) {
		this.entries = entries;
	}

	/**
	 * Adds an entry to the list
	 * 
	 * @param key The key the entry will have
	 * @param value The extra parameter to be added
	 */
	public void addEntry(String key, Object value) {
		MapExtraParameterEntry entry = new MapExtraParameterEntry();
		entry.setKey(key);
		entry.setValue(value);
		entries.add(entry);
	}
		
}
