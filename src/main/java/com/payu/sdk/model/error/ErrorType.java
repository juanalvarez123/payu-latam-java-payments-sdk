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
package com.payu.sdk.model.error;

/**
 * Enum representing the error types in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public enum ErrorType {

	/**
	 * Bad request: <br>
	 * The request can not be parsed (Malformed request).
	 */
	MALFORMED_REQUEST,

	/**
	 * Not found: <br>
	 * If the requested content was not found on the server or there is
	 * no controller able to process the requested URI.
	 */
	NOT_FOUND,

	/**
	 * Bad request: <br>
	 * Errors arise when the client request has invalid parameters.
	 */
	BAD_REQUEST,

	/**
	 * Internal server error: <br>
	 * Any type of error that is not included in the previous types
	 */
	INTERNAL_SERVER_ERROR,

	/**
	 * Authorization Error
	 */
	UNAUTHORIZED

}
