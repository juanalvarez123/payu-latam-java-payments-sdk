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

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Represents a physical address in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = { "line1", "line2", "line3", "city", "state", "country",
		"postalCode", "phone" })
public class Address implements Serializable {

	/**
	 * Serial version uid
	 */
	private static final long serialVersionUID = -695720432535806958L;

	/**
	 * Address line 1
	 */
	private String line1;

	/**
	 * Address line 2
	 */
	private String line2;

	/**
	 * Address line 3
	 */
	private String line3;

	/**
	 * The city name
	 */
	private String city;

	/**
	 * The state or province name
	 */
	private String state;

	/**
	 * ISO Country code
	 */
	private String country;

	/**
	 * The postal code
	 */
	private String postalCode;

	/**
	 * The phone number
	 */
	private String phone;

	// ----------------------------------------------
	// CONSTRUCTORS
	// ----------------------------------------------

	/**
	 * Default Constructor
	 */
	public Address() {
	}

	// ----------------------------------------------
	// GETTERS AND SETTERS
	// ----------------------------------------------

	/**
	 * Returns the address line 1
	 *
	 * @return the line1
	 */
	@XmlElement
	public String getLine1() {
		return line1;
	}

	/**
	 * Returns the address line 2
	 *
	 * @return the line2
	 */
	@XmlElement
	public String getLine2() {
		return line2;
	}

	/**
	 * Returns the address line 3
	 *
	 * @return the line3
	 */
	@XmlElement
	public String getLine3() {
		return line3;
	}

	/**
	 * Returns the city name
	 *
	 * @return the city
	 */
	@XmlElement
	public String getCity() {
		return city;
	}

	/**
	 * Returns the state name
	 *
	 * @return the state
	 */
	@XmlElement
	public String getState() {
		return state;
	}

	/**
	 * Returns the ISO country code
	 *
	 * @return the country
	 */
	@XmlElement
	public String getCountry() {
		return country;
	}

	/**
	 * Returns the postal code
	 *
	 * @return the postalCode
	 */
	@XmlElement
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Returns the phone number
	 *
	 * @return the phone
	 */
	@XmlElement
	public String getPhone() {
		return phone;
	}

	/**
	 * Set the address line 1
	 *
	 * @param line1
	 *            the line1 to set
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	/**
	 * Set the address line 2
	 *
	 * @param line2
	 *            the line2 to set
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	/**
	 * Set the address line 3
	 *
	 * @param line3
	 *            the line3 to set
	 */
	public void setLine3(String line3) {
		this.line3 = line3;
	}

	/**
	 * Set the city name
	 *
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Set the state name
	 *
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Set the ISO country code
	 *
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Set the postal code
	 *
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Set the phone number
	 *
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

}