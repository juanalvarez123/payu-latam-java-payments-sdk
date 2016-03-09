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
 * Enum representing a payment country in the PayU SDK. Sometimes when a payment
 * method is processed by several countries is necessary to specify the country
 * due currency issues.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum PaymentCountry {

	/**
	 * When the payment country is Argentina.
	 */
	AR,
	/**
	 * When the payment country is Brazil.
	 */
	BR,
	/**
	 * When the payment country is Chile.
	 */
	CL,
	/**
	 * When the payment country is Colombia.
	 */
	CO,
	/**
	 * When the payment country is Mexico.
	 */
	MX,
	/**
	 * When the payment country is Panama.
	 */
	PA,
	/**
	 * When the payment country is Peru.
	 */
	PE,
	/**
	 * When the payment country is United States.
	 */
	US

}
