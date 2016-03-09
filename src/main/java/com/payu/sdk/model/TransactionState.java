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
 * Enum representing a transaction state in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum TransactionState {

	/** Approved transaction */
	APPROVED("4"),
	/** Declined transaction */
	DECLINED("6"),
	/** Error in transaction */
	ERROR("104"),
	/** Pending transaction */
	PENDING("7"),
	/** Expired transaction */
	EXPIRED("5"),
	/** Submitted transaction */
	SUBMITTED("103");

	/**
	 * The transaction state code.
	 */
	private String code;

	/**
	 * Sets the transaction state code.
	 *
	 * @param code the transaction state code to set.
	 */
	private TransactionState(String code) {
		this.code = code;
	}

	/**
	 * Returns the transaction state code.
	 *
	 * @return the transaction state code.
	 */
	public String getCode() {
		return code;
	}

}
