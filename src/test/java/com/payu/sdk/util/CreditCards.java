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

package com.payu.sdk.util;

/**
 * @author oscar.romero
 *
 */
/**
 * Some possible credit cards to be used in the tests
 *
 */
public enum CreditCards {

	// Colombian Visa
	VISA("4005580000029205", "2017/01", "495"),

	// Panama Visa
	VISA_PA("4111111111111111", "2017/01", "123"),

	// Amex
	AMEX("378263031085366", "2017/01", "1234"),

	// Discover
	DISCOVER("6011954843652373", "2017/01", "123"),

	// Master card
	MASTERCARD("5156187105437715", "2017/01", "123"),

	// Diners
	DINERS("30039546070543", "2017/01", "123"),

	// ELO
	ELO("4462784368283422", "2017/01", "123"),

	//CENCOSUD
	CENCOSUD("6034932224222422", "2017/01", "495");

	/**
	 * Credit card number
	 */
	private String creditCardNumber;

	/**
	 * Credit card expiration date
	 */
	private String expirationDate;

	/**
	 * credit card security code
	 */
	private String securityCode;

	/**
	 * The credit card constructor
	 *
	 * @param creditCardNumber
	 *            The credit card's number
	 * @param expirationDate
	 *            The credit card's expiration date
	 * @param securityCode
	 *            The credit card's security code
	 */
	CreditCards(String creditCardNumber, String expirationDate,
			String securityCode) {
		this.creditCardNumber = creditCardNumber;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
	}

	/**
	 * @return the credit card number
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * @return the expirationDate
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @return the securityCode
	 */
	public String getSecurityCode() {
		return securityCode;
	}

}
