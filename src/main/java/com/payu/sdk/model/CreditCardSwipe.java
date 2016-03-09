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

/**
 * Represents a credit card for PUS payment process in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name="creditCardSwipe")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCardSwipe implements Serializable {

	/** The generated serial version Id */
	private static final long serialVersionUID = -233702600080275905L;

	/**
	 * Encrypted information obtained from the credit card.
	 */
	@XmlElement(required=true)
	private String cryptogram;

	/**
	 * The issuer bank of the credit card.
	 */
	@XmlElement(required=false)
	private String issuerBank;

	/**
	 *  The credit card security code.
	 */
	@XmlElement(required=false)
	private String securityCode;

	/**
	 * Returns the encrypted information obtained from the credit card.
	 *
	 * @return the encrypted information.
	 */
	public String getCryptogram() {
		return cryptogram;
	}

	/**
	 * Sets the encrypted information from the credit card.
	 *
	 * @param cryptogram the encrypted information to set.
	 */
	public void setCryptogram(String cryptogram) {
		this.cryptogram = cryptogram;
	}

	/**
	 * Returns the credit card issuer bank.
	 *
	 * @return The issuer bank of the credit card.
	 */
	public String getIssuerBank() {
		return issuerBank;
	}

	/**
	 * Sets the credit card issuer bank.
	 *
	 * @param issuerBank The issuer bank of the credit card.
	 */
	public void setIssuerBank(String issuerBank) {
		this.issuerBank = issuerBank;
	}

	/**
	 * Returns the credit card security code.
	 *
	 * @return The credit card security code.
	 */
	public String getSecurityCode() {
		return securityCode;
	}

	/**
	 * Sets the credit card security code.
	 *
	 * @param securityCode The credit card security code.
	 */
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

}