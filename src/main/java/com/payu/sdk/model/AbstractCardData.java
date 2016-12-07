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

/**
 * Abstract class to hold card data.
 * <ul>See:
 * 	<li>DebitCard</li>
 * 	<li>CreditCard</li>
 * </ul>
 *
 * @author PayU Latam
 * @since 1.1.18
 * @version 1.1.18, 07/12/2016
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractCardData {

	/**The credit card number. */
	@XmlElement(required=false)
	private String number;
	/** The credit card security code. */
	@XmlElement(required=false)
	private String securityCode;
	/** The credit card expiration date. */
	@XmlElement(required=false)
	private String expirationDate;
	/** The name on the credit card. */
	@XmlElement(required=false)
	private String name;
	/** The issuer bank of the credit card. */
	@XmlElement(required=false)
	private String issuerBank;
	/** The credit card masked number. */
	@XmlElement(required=false)
	private String maskedNumber;
	/** Process transactions without cvv2 **/
	@XmlElement(required=false)
	private Boolean processWithoutCvv2;
	
	/**
	 * Returns the credit card number.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Returns the credit card security code
	 *
	 * @return the securityCode
	 */
	public String getSecurityCode() {
		return securityCode;
	}

	/**
	 * Returns the credit card expiration date
	 *
	 * @return the expiration date
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Returns the name on the credit card
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the credit card issuer bank
	 *
	 * @return the issuer bank
	 */
	public String getIssuerBank() {
		return issuerBank;
	}

	/**
	 * Returns the credit card masked number
	 *
	 * @return the masked number
	 */
	public String getMaskedNumber() {
		return maskedNumber;
	}

	/**
	 * @return the processWithoutCvv2
	 */
	public Boolean getProcessWithoutCvv2() {
		return processWithoutCvv2;
	}

	/**
	 * Sets the credit card number
	 *
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Sets the credit card security code
	 *
	 * @param securityCode the security code to set
	 */
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	/**
	 * Sets the credit card expiration date
	 *
	 * @param expirationDate the expiration date to set
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Sets the name on the credit card
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the credit card issuer bank
	 *
	 * @param issuerBank the issuer bank to set
	 */
	public void setIssuerBank(String issuerBank) {
		this.issuerBank = issuerBank;
	}

	/**
	 * Sets the credit card masked number
	 *
	 * @param maskedNumber the masked number to set
	 */
	public void setMaskedNumber(String maskedNumber) {
		this.maskedNumber = maskedNumber;
	}

	/**
	 * @param processWithoutCvv2 the processWithoutCvv2 to set
	 */
	public void setProcessWithoutCvv2(Boolean processWithoutCvv2) {
		this.processWithoutCvv2 = processWithoutCvv2;
	}
	
	/**
	 * <ul>Get the card type:
	 * 	<li>Credit card</li>
	 * 	<li>Debit card</li>
	 * </ul>
	 * @return {@link CardType} Card type
	 */
	public abstract CardType getCardType();
	
}
