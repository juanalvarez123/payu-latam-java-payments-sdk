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
 * Holds all information for get the banks list in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "bankListInformation")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankListInformation {

	/** the payment method */
	@XmlElement(required = false)
	private PaymentMethod paymentMethod;

	/** the payment country */
	@XmlElement(required = false)
	private PaymentCountry paymentCountry;

	/**
	 * Default empty constructor
	 */
	public BankListInformation() {
	}

	/**
	 * Default full constructor
	 *
	 * @param paymentMethod
	 *            The payment method in the bank
	 * @param paymentCountry
	 *            The payment country in the bank
	 */
	public BankListInformation(PaymentMethod paymentMethod, PaymentCountry paymentCountry) {

		this.paymentMethod = paymentMethod;
		this.paymentCountry = paymentCountry;
	}

	/**
	 * Returns the payment method for the bank.
	 *
	 * @return the payment method.
	 */
	public PaymentMethod getPaymentMethod() {

		return paymentMethod;
	}

	/**
	 * Returns the payment country.
	 *
	 * @return the payment country.
	 */
	public PaymentCountry getPaymentCountry() {

		return paymentCountry;
	}

	/**
	 * Sets the payment method in the bank
	 *
	 * @param paymentMethod
	 *            the payment method to set.
	 */
	public void setPaymentMethod(PaymentMethod paymentMethod) {

		this.paymentMethod = paymentMethod;
	}

	/**
	 * Sets the payment country in the bank
	 *
	 * @param paymentCountry
	 *            the payment country to set.
	 */
	public void setPaymentCountry(PaymentCountry paymentCountry) {

		this.paymentCountry = paymentCountry;
	}

}
