package com.payu.sdk.utils.xml;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.payu.sdk.model.AdditionalValue;

/**
 * Utility to adapt {@link AdditionalValue} into {@link MapAdditionalValueElement}
 * and vice versa.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public class MapAdditionalValueAdapter extends
		XmlAdapter<MapAdditionalValueElement, Map<String, AdditionalValue>> {

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public MapAdditionalValueElement marshal(Map<String, AdditionalValue> v) {

		if (v == null || v.isEmpty()) {
			return null;
		}

		MapAdditionalValueElement map = new MapAdditionalValueElement();

		for (String key : v.keySet()) {
			AdditionalValue value = v.get(key);
			value.setName(null);
			map.addEntry(key, value);
		}

		return map;
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public Map<String, AdditionalValue> unmarshal(MapAdditionalValueElement v) {
		if (v == null) {
			return null;
		}

		Map<String, AdditionalValue> map = new HashMap<String, AdditionalValue>(
				v.getEntries().size());

		for (MapAdditionalValueEntry entry : v.getEntries()) {
			AdditionalValue addValue = entry.getAdditionalValue();
			addValue.setName(entry.getKey());
			map.put(entry.getKey(), entry.getAdditionalValue());
		}

		return map;
	}

}
