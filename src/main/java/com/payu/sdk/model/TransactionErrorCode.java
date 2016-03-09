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

/**
 * Enum representing an error code for transactions in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum TransactionErrorCode {

	/** Error associated with an internal problem in the server */
	INTERNAL_ERROR("9999"),
	/** Error associated with not having response from the server */
	ENTITY_NO_RESPONSE("9996"),
	/** Error associated with a bad response from the payment network */
	PAYMENT_NETWORK_BAD_RESPONSE("100"),
	/** Error associated with a connection failure with the payment network */
	PAYMENT_NETWORK_NO_CONNECTION("101"),
	/** Error associated with not having response from the payment network */
	PAYMENT_NETWORK_NO_RESPONSE("102");

	/**
	 * The transaction error code.
	 */
	private String code;

	/**
	 * Sets the transaction error code.
	 *
	 * @param code the transaction error code to set.
	 */
	private TransactionErrorCode(String code) {
		this.code = code;
	}

	/**
	 * Returns the transaction error code.
	 *
	 * @return the transaction error code.
	 */
	public String getCode() {
		return code;
	}

}
