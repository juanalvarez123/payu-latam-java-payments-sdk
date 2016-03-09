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

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 	Represents a payment method in the PayU SDK consulted from API.
 * </p>
 * @author <a href="fernando.moreno@payulatam.com">Fernando Moreno</a>
 * @date 8/09/2014
 */
@XmlRootElement(name = "paymentMethod")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethodApi implements Serializable{

	/** The generated serial version Id */
	private static final long serialVersionUID = 6624302145435210417L;

	/** The payment method description. */
	@XmlElement(required=true)
	private String name;

	/**
	 * The type of the payment method.
	 */
	@XmlElement(required=true)
	private PaymentMethodType type;


	/**
	 * Default constructor
	 *
	 * @param type the payment method type
	 */
	public PaymentMethodApi() {
		super();
	}

	/**
	 * constructor with params
	 *
	 * @param type the payment method type
	 */
	public PaymentMethodApi(String description, PaymentMethodType type) {
		this.type = type;
	}

	/**
	 * Returns the name of the payment method.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 *  Sets the name of the payment method.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the type of the payment method.
	 *
	 * @return the type of the payment method.
	 */
	public PaymentMethodType getType() {
		return type;
	}

	/**
	 * Sets the type of the payment method.
	 * @param type
	 */
	public void setType(PaymentMethodType type) {
		this.type = type;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"PaymentMethodApi [name=%s, type=%s]",
				name, type);
	}

}
