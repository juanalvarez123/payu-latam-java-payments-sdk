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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.payu.sdk.utils.xml.AddressAdapter;

/**
 * Represents a payer in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "payer")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Payer extends Person {

	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = 4398582439364251025L;

	/** The payer's business name */
	private String businessName;

	/** The payer type, can be natural or legal */
	private PersonType payerType;

	/**	The payer's birthdate */
	private String birthdate;

	/**
	 * Returns the payer's id in the merchant
	 *
	 * @return the payer's id
	 */
	@XmlElement(required = false)
	public String getMerchantPayerId() {
		return getMerchantPersonId();
	}

	/**
	 * Sets the payer's id in the merchant
	 *
	 * @param merchantPayerId
	 *            the payer's id to set
	 */
	public void setMerchantPayerId(String merchantPayerId) {
		setMerchantPersonId(merchantPayerId);
	}

	/**
	 * Returns the payer's business name
	 *
	 * @return The business name
	 */
	@XmlElement(required = false)
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * Sets the payer's business name
	 *
	 * @param businessName The busines name to set
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * Returns the payer's type
	 *
	 * @return The payer's type
	 */
	@XmlElement(required = false)
	public PersonType getPayerType() {
		return payerType;
	}

	/**
	 * Sets the payer's type
	 *
	 * @param payerType The payer's type to set
	 */
	public void setPayerType(PersonType payerType) {
		this.payerType = payerType;
	}

	/**
	 * Returns the payer's billing address
	 *
	 * @return the billing address
	 */
	/** The shipping address. */
	@XmlElement(required = false)
	@XmlJavaTypeAdapter(AddressAdapter.class)
	public Address getBillingAddress() {
		return getAddress();
	}

	/**
	 * Sets the payer's billing address
	 *
	 * @param address the payer's address
	 */
	public void setBillingAddress(Address address) {
		setAddress(address);
	}
	/**
	 * Return the payer's birthdate
	 * @return
	 */
	@XmlElement(required = false)
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 *  Sets the payer's birthdate
	 * @param birthdate
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

}
