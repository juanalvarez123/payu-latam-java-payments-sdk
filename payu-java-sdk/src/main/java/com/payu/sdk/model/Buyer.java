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
