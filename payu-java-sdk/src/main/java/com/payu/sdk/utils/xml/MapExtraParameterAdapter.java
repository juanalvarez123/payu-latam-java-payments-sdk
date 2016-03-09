package com.payu.sdk.utils.xml;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Utility to adapt Extra Parameter into {@link MapExtraParameterElement} and
 * vice versa.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public class MapExtraParameterAdapter extends
		XmlAdapter<MapExtraParameterElement, Map<String, Object>> {

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public MapExtraParameterElement marshal(Map<String, Object> v) {

		if (v == null || v.isEmpty()) {
			return null;
		}

		MapExtraParameterElement map = new MapExtraParameterElement();

		for (String key : v.keySet()) {
			map.addEntry(key, v.get(key));
		}

		return map;
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public Map<String, Object> unmarshal(MapExtraParameterElement v) {
		if (v == null) {
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>(v.getEntries().size());

		for (MapExtraParameterEntry entry : v.getEntries()) {
			map.put(entry.getKey(), entry.getValue());
		}

		return map;
	}

}
