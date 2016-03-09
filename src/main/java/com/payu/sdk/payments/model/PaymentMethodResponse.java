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
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.PaymentMethodApi;
import com.payu.sdk.model.response.Response;

/**
 * <p>
 * 	Represents a payment method response in the PayU SDK
 * </p>
 * @author <a href="fernando.moreno@payulatam.com">Fernando Moreno</a>
 * @date 5/09/2014
 */
@XmlRootElement(name = "paymentMethodAvailable")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethodResponse extends Response{

	/** The class serial version */
	private static final long serialVersionUID = -4494494959180453709L;

	/**Represent the payment method of the API*/
	@XmlElement(name = "paymentMethod")
	private PaymentMethodApi paymentMethod;

	/**
	 * Returns the payment method
	 * @return
	 */
	public PaymentMethodApi getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Sets the payment method
	 * @param paymentMethod
	 */
	public void setPaymentMethod(PaymentMethodApi paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * Converts a xml string into a payment Method Available response object
	 *
	 * @param xml
	 *            The object in a xml format
	 * @return The payment response object
	 * @throws PayUException
	 */
	public static PaymentMethodResponse fromXml(String xml) throws PayUException {

		return (PaymentMethodResponse) fromBaseXml(new PaymentMethodResponse(), xml);

	}
}
