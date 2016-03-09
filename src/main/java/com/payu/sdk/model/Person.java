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
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents a person in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Person implements Serializable {

	/** The generated serial version Id */
	private static final long serialVersionUID = 4829970257837450633L;

	/** The person identifier in the merchant system. */
	@XmlTransient
	private String merchantPersonId;
	/** The payer full name. */
	@XmlElement(required = false)
	private String fullName;
	/** The payer billing address. */
	@XmlTransient
	private Address address;
	/** The payer email address. */
	@XmlElement(required = false)
	private String emailAddress;
	/** The payer contact phone. */
	@XmlElement(required = false)
	private String contactPhone;
	/** DNI number. */
	@XmlElement(required = false)
	private String dniNumber;
	/** The payer CNPJ business number */
	@XmlElement(required = false, name = "cnpj")
	private String CNPJ;

	/**
	 * Returns the buyer/payer id in the merchant system
	 *
	 * @return the person identifier
	 */
	public String getMerchantPersonId() {
		return merchantPersonId;
	}

	/**
	 * Returns the persons name
	 *
	 * @return the name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Returns the person's address
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Returns the person's e-mail
	 *
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Returns the person's contact phone
	 *
	 * @return the contactPhone
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * Returns the person's DNI number
	 *
	 * @return the DNI number
	 */
	public String getDniNumber() {
		return dniNumber;
	}

	/**
	 * Sets the person's DNI number
	 * @param dniNumber
	 *            the DNI number to set
	 */
	public void setDniNumber(String dniNumber) {
		this.dniNumber = dniNumber;
	}

	/**
	 * Set's the pers'ns CNPJ
	 *
	 * @param cNPJ
	 *            the cNPJ to set
	 */
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	/**
	 * Sets the buyer/payer id in the merchant system
	 *
	 * @param merchantPersonId the person identifier to set
	 */
	public void setMerchantPersonId(String merchantPersonId) {
		this.merchantPersonId = merchantPersonId;
	}

	/**
	 * Sets the person's name
	 * @param fullName
	 *            the name to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Sets the person's billing address
	 *
	 * @param address
	 *            the billingAddress to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Sets the person's e-mail
	 *
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Sets the person's contact phone
	 *
	 * @param contactPhone
	 *            the contact phone to set
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	/**
	 * Returns the person's CNPJ
	 *
	 * @return the CNPJ
	 */
	public String getCNPJ() {
		return CNPJ;
	}
}
