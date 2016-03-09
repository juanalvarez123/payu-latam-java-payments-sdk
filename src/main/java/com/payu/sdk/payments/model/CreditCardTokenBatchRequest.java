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

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.model.request.Request;

/**
 * Represents a concrete credit card token batch in the PayU SDK. This class
 * holds all the payment transaction information.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 *
 */
public class CreditCardTokenBatchRequest extends Request {

	/** The generated serial version Id */
	private static final long serialVersionUID = -7136953977839080063L;
	/** The file content */
	@XmlElement(required = true)
	private String contentFile;

	/**
	 * Returns the file content
	 *
	 * @return the file content
	 */
	public String getContentFile() {
		return contentFile;
	}

	/**
	 * Sets the file content
	 *
	 * @param contentFile
	 *            the content to set
	 */
	public void setContentFile(String contentFile) {
		this.contentFile = contentFile;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.payu.sdk.model.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants#RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl,
			RequestMethod requestMethod) {

		switch (requestMethod) {
		case POST:
			return String.format("%s%s", baseUrl, Resources.DEFAULT_API_URL);
		default:
			return String.format("%s%s", baseUrl, Resources.DEFAULT_API_URL);
		}

	}

}
