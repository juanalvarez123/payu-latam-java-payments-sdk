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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.model.request.CommandRequest;

/**
 * <p>
 * 	Represents a payment method request in the PayU SDK.
 * </p>
 * @author <a href="fernando.moreno@payulatam.com">Fernando Moreno</a>
 * @date 5/09/2014
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethodRequest extends CommandRequest {

	/** The generated serial version Id */
	private static final long serialVersionUID = -2023556452232177400L;

	/** The payment Method */
	@XmlElement(required = false)
	private String paymentMethod;

	/**
	 * Return the payment method
	 * @return
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Sets the payment method
	 * @param paymentMethod
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
