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
package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.CreditCardToken;
import com.payu.sdk.model.response.Response;

/**
 * Represents a create token response in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "creditCardTokenResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCardTokenResponse extends Response {

	/** The generated serial version Id */
	private static final long serialVersionUID = -3448043108729600494L;
	/** The result token */
	@XmlElement(required = false)
	private CreditCardToken creditCardToken;

	/**
	 * Returns the credit card token
	 *
	 * @return the creditCardToken
	 */
	public CreditCardToken getCreditCardToken() {
		return creditCardToken;
	}

	/**
	 * Sets the credit card token
	 *
	 * @param creditCardToken
	 *            the creditCardToken to set
	 */
	public void setCreditCardToken(CreditCardToken creditCardToken) {
		this.creditCardToken = creditCardToken;
	}

	/**
	 * Converts a xml string into a credit card token response object
	 *
	 * @param xml
	 *            The object in a xml format
	 * @return The credit card token response format
	 * @throws PayUException
	 */
	public static CreditCardTokenResponse fromXml(String xml)
			throws PayUException {

		return (CreditCardTokenResponse) fromBaseXml(
				new CreditCardTokenResponse(), xml);
	}

}