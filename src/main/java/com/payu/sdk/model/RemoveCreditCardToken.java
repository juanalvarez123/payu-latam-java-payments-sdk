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
 * Represents a credit card token removal in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name="removeCreditCardToken")
@XmlAccessorType(XmlAccessType.FIELD)
public class RemoveCreditCardToken {

	/** The credit card token identifier. */
	@XmlElement(required=true)
	private String creditCardTokenId;
	/** The credit card token payer id */
	@XmlElement(required=true)
	private String payerId;

	/**
	 * Returns the generated id of credit card token
	 *
	 * @return the id
	 */
	public String getCreditCardTokenId() {
		return creditCardTokenId;
	}

	/**
	 * Sets the generated id of credit card token
	 *
	 * @param id the id to set
	 */
	public void setCreditCardTokenId(String id) {
		this.creditCardTokenId = id;
	}

	/**
	 * Returns the credit card token payer id.
	 *
	 * @return the payerId
	 */
	public String getPayerId() {
		return payerId;
	}

	/**
	 * Sets the credit card token payer id.
	 *
	 * @param payerId the payerId to set
	 */
	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

}