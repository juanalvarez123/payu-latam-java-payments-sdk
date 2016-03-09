/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 developers-payu-latam
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
