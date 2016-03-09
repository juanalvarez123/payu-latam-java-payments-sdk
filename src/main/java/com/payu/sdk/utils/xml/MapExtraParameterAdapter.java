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
