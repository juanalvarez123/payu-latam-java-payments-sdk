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
 * The PayU SDK authentication exception
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public class AuthenticationException extends SDKException {

	/**
	 * The class serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Exception Constructor
	 *
	 * @param innerException
	 *            the exception that will be embedded
	 */
	public AuthenticationException(Exception innerException) {

		super(ErrorCode.CONNECTION_EXCEPTION, innerException);

	}

	/**
	 * Default constructor
	 */
	public AuthenticationException() {

		super(ErrorCode.CONNECTION_EXCEPTION);

	}

	/**
	 * Default constructor with message
	 *
	 * @param message
	 *            the exception's message
	 */
	public AuthenticationException(String message) {

		super(ErrorCode.CONNECTION_EXCEPTION, message);

	}

	/**
	 * Default constructor with message and exception
	 *
	 * @param message
	 *            the exception's message
	 * @param innerException
	 *            the exception that will be embedded
	 */
	public AuthenticationException(String message, Exception innerException) {

		super(ErrorCode.CONNECTION_EXCEPTION, message, innerException);

	}

}
