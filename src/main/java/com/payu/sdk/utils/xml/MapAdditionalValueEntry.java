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
