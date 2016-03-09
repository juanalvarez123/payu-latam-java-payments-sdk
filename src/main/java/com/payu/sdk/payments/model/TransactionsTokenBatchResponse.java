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

import javax.xml.bind.annotation.XmlElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.response.Response;
import com.payu.sdk.utils.JaxbUtil;

/**
 * Represents a transaction transaction with token batch response in the PayU
 * SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public class TransactionsTokenBatchResponse extends Response {

	/** The generated serial version Id */
	private static final long serialVersionUID = 5674953349886166616L;
	/** The id of the token bath */
	@XmlElement(required = false)
	private String id;

	/**
	 * Returns the id
	 *
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id
	 *
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Converts a xml string into a transactions token batch response object
	 *
	 * @param xml
	 *            The object in a xml format
	 * @return The transactions token batch response object
	 * @throws PayUException
	 */
	public static TransactionsTokenBatchResponse fromXml(String xml)
			throws PayUException {

		return JaxbUtil.convertXmlToJava(TransactionsTokenBatchResponse.class,
				xml);
	}

}