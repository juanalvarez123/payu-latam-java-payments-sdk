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

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Utility to map Extra Parameter into entry.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapExtraParameterEntry {

	/**
	 * The value of the extra parameter. Only if value is Date.
	 */
	@XmlElement(name = "date")
	private Date date;

	/**
	 * The values of the extra parameter key - value. Only if value is String.
	 */
	@XmlElement(name = "string")
	private String[] values = new String[2];

	/**
	 * The value of the extra parameter. Only if value is int.
	 */
	@XmlElement(name = "int")
	private Integer intValue;

	/**
	 * The value of the extra parameter. Only if value is integer.
	 */
	@XmlElement(name = "integer")
	private Integer integer;

	/**
	 * The value of the extra parameter. Only if value is BigDecimal.
	 */
	@XmlElement(name = "bigDecimal")
	private BigDecimal bigDecimal;

	/**
	 * The value of the extra parameter. Only if value is Short.
	 */
	@XmlElement(name = "short")
	private Short shortValue;

	/**
	 * The value of the extra parameter. Only if value is Boolean.
	 */
	@XmlElement(name = "boolean")
	private Boolean booleanValue;

	/**
	 * The value of the extra parameter. Only if value is Float.
	 */
	@XmlElement(name = "float")
	private Float floatValue;

	/**
	 * The value of the extra parameter. Only if value is Long.
	 */
	@XmlElement(name = "long")
	private Long longValue;

	/**
	 * Returns the key of the extra parameter
	 *
	 * @return the key of the extra parameter
	 */
	public String getKey() {
		return values[0];
	}

	/**
	 * Returns the value of the extra parameter
	 *
	 * @return the value of the extra parameter
	 */
	public Object getValue() {
		Object value = null;
		if (date != null) {
			value = date;
		} else if (intValue != null) {
			value = intValue;
		} else if (integer != null) {
			value = integer;
		} else if (bigDecimal != null) {
			value = bigDecimal;
		} else if (booleanValue != null) {
			value = booleanValue;
		} else if (longValue != null) {
			value = longValue;
		} else if (shortValue != null) {
			value = shortValue;
		} else if (floatValue != null) {
			value = floatValue;
		} else if (values.length == 2) {
			value = values[1];
		}

		return value;
	}

	/**
	 * Sets the key of the extra parameter
	 *
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		values[0] = key;
	}

	/**
	 * Sets the value of the extra parameter
	 *
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {

		if (value instanceof Integer) {
			integer = (Integer) value;
		} else if (value instanceof Date) {
			date = (Date) value;
		} else if (value instanceof BigDecimal) {
			bigDecimal = (BigDecimal) value;
		} else if (value instanceof Short) {
			shortValue = (Short) value;
		} else if (value instanceof Boolean) {
			booleanValue = (Boolean) value;
		} else if (value instanceof Float) {
			floatValue = (Float) value;
		} else if (value instanceof Long) {
			longValue = (Long) value;
		} else if (value instanceof String) {
			values[1] = (String) value;
		}
	}
}
