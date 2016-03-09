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
package com.payu.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a payment method in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "paymentMethodComplete")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethodComplete {

	/** The identifier. */
	@XmlElement
	private String id;
	/** The payment method description. */
	@XmlElement
	private String description;
	/** The payment method country. */
	@XmlElement
	private String country;

	/**
	 * Default constructor with no params.
	 */
	public PaymentMethodComplete() {
	}

	/**
	 * Default full constructor
	 *
	 * @param id The complete payment method id
	 * @param description The complete payment method description
	 * @param country The complete payment method country
	 */
	public PaymentMethodComplete(String id, String description, String country) {

		this.id = id;
		this.description = description;
		this.country = country;
	}

	/**
	 * Returns the payment method id
	 *
	 * @return the id
	 */
	public String getId() {

		return id;
	}

	/**
	 * Sets the payment method id
	 *
	 * @param id the id to set
	 */
	public void setId(String id) {

		this.id = id;
	}

	/**
	 * Returns the payment method description
	 *
	 * @return the description
	 */
	public String getDescription() {

		return description;
	}

	/**
	 * Sets the payment method description
	 *
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {

		this.description = description;
	}

	/**
	 * Returns the payment method country
	 *
	 * @return the country
	 */
	public String getCountry() {

		return country;
	}

	/**
	 * Sets the payment method country
	 *
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {

		this.country = country;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"PaymentMethodComplete [id=%s, description=%s, country=%s]",
				id, description, country);
	}

}
