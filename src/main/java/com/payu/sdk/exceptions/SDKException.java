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
package com.payu.sdk.exceptions;

/**
 * The PayU SDK generic exception
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public class SDKException extends Exception {

	/**
	 * The class serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The exception error code.
	 * @see ErrorCode
	 */
	private ErrorCode errorCode;

	/**
	 * The exception constructor
	 *
	 * @param errorCode
	 *            the exception's error code
	 * @param message
	 *            the exception's message
	 * @param innerException
	 *            the exception that will be embedded
	 */
	public SDKException(ErrorCode errorCode, String message,
			Exception innerException) {

		super(message, innerException);
		this.errorCode = errorCode;
	}

	/**
	 * The exception constructor
	 *
	 * @param errorCode
	 *            the exception's error code
	 * @param message
	 *            the exception's message
	 */
	public SDKException(ErrorCode errorCode, String message) {

		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * The exception constructor
	 *
	 * @param errorCode
	 *            the exception's error code
	 * @param innerException
	 *            the exception that will be embedded
	 */
	public SDKException(ErrorCode errorCode, Exception innerException) {

		super(innerException);
		this.errorCode = errorCode;
	}

	/**
	 * Returns the api error code
	 *
	 * @param errorCode
	 *            the exception's error code
	 */
	public SDKException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Returns the error code
	 *
	 * @return the errorCode
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	/**
	 * The types of Error codes to use inside a SDK Exception.
	 */
	public enum ErrorCode {

		/** Error associated to a problem serializing an object. */
		XML_SERIALIZATION_ERROR,
		/** Error associated to a problem deserializing an object. */
		XML_DESERIALIZATION_ERROR,
		/** Error associated to an invalid parameter sent. */
		INVALID_PARAMETERS,
		/** Error associated to a connection problem with the server. */
		CONNECTION_EXCEPTION,
		/** Error associated to an internal API error. */
		API_ERROR,
		/** Error associated to an no found entity. */
		NO_RESULTS_FOUND
	}
}
