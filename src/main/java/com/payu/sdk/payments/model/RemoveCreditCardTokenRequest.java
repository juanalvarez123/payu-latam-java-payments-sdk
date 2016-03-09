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

import com.payu.sdk.model.RemoveCreditCardToken;
import com.payu.sdk.model.request.CommandRequest;

/**
 * Represents a concrete payment request in the PayU SDK. This class holds all
 * the payment transaction information.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class RemoveCreditCardTokenRequest extends CommandRequest {

	/** The generated serial version Id */
	private static final long serialVersionUID = -2784925354134880784L;
	/** The credit card's token */
	@XmlElement(required = true)
	private RemoveCreditCardToken removeCreditCardToken;

	/**
	 * Returns the credit card's token
	 *
	 * @return the removeCreditCardToken
	 */
	public RemoveCreditCardToken getRemoveCreditCardToken() {
		return removeCreditCardToken;
	}

	/**
	 * Sets the credit card's token
	 *
	 * @param removeCreditCardToken
	 *            the removeCreditCardToken to set
	 */
	public void setRemoveCreditCardToken(
			RemoveCreditCardToken removeCreditCardToken) {
		this.removeCreditCardToken = removeCreditCardToken;
	}

}
