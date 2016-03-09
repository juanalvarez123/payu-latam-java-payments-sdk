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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.payu.sdk.utils.xml.AddressAdapter;

/**
 * Represents a buyer in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "buyer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Buyer extends Person {

	/** The generated serial version Id */
	private static final long serialVersionUID = -5137779740502087636L;

	/**
	 * Returns the buyer's id in the merchant
	 *
	 * @return the buyer's id in the merchant
	 */
	@XmlElement(required = false)
	public String getMerchantBuyerId() {
		return getMerchantPersonId();
	}

	/**
	 * Sets the buyer's id in the merchant
	 *
	 * @param merchantBuyerId
	 *            the buyer's id to set
	 */
	public void setMerchantBuyerId(String merchantBuyerId) {
		setMerchantPersonId(merchantBuyerId);
	}

	/**
	 * Returns the buyer's shipping address
	 *
	 * @return the shippingAddress
	 */
	/** The shipping address. */
	@XmlElement(required = false)
	@XmlJavaTypeAdapter(AddressAdapter.class)
	public Address getShippingAddress() {
		return getAddress();
	}

	/**
	 * Sets the buyer's shipping address
	 *
	 * @param shippingAddress
	 *            the shippingAddress to set
	 */
	public void setShippingAddress(Address shippingAddress) {
		setAddress(shippingAddress);
	}

}
