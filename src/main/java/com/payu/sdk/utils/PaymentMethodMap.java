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
package com.payu.sdk.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.payu.sdk.model.PaymentMethodApi;
import com.payu.sdk.model.PaymentMethodType;

/**
 * <p>
 * 	Maps the payment methods by name
 * </p>
 * @author <a href="fernando.moreno@payulatam.com">Fernando Moreno</a>
 * @date 8/09/2014
 */
public class PaymentMethodMap {

	/**Map of Payment methods*/
	private Map <String, PaymentMethodApi> mapPaymentMethods;

	/**Instance of the class for implementing Singleton pattern*/
	private static PaymentMethodMap instance;

	/**
	 * private constructor
	 */
	private PaymentMethodMap(){
		mapPaymentMethods = new HashMap<String, PaymentMethodApi>();
	}

	/**
	 * Returns the instance of the Singleton class
	 * @return the instance class
	 */
	public static PaymentMethodMap getInstance(){
		if (instance == null){
			instance = new PaymentMethodMap();
		}
		return instance;
	}

	/**
	 * Gets the payment method from the description
	 * @param paymentMethod
	 * @return the object PaymentMethodApi
	 */
	public PaymentMethodApi getPaymentMethod(String paymentMethod){
		return mapPaymentMethods.get(paymentMethod);
	}

	/**
	 * Puts the object PaymentMethodApi in the map
	 * @param paymentMethod Object to put to the map
	 */
	public void putPaymentMethod(PaymentMethodApi paymentMethod){
		mapPaymentMethods.put(paymentMethod.getName(), paymentMethod);
	}

	/**
	 * Returns the payments methods list by type.
	 *
	 * @param type the filter type.
	 * @return the list of the payments method given type.
	 */
	public List<PaymentMethodApi> getPaymentMethods(PaymentMethodType type) {
		List<PaymentMethodApi> paymentMethods = new ArrayList<PaymentMethodApi>();
		Collection<PaymentMethodApi> colPaymentMethods = mapPaymentMethods.values();
		for (PaymentMethodApi value: colPaymentMethods){
			if (value.getType() == type) {
				paymentMethods.add(value);
			}
		}
		return paymentMethods;
	}
}
