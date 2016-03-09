package com.payu.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a credit card token removal in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name="removeCreditCardToken")
@XmlAccessorType(XmlAccessType.FIELD)
public class RemoveCreditCardToken {

	/** The credit card token identifier. */
	@XmlElement(required=true)
	private String creditCardTokenId;
	/** The credit card token payer id */
	@XmlElement(required=true)
	private String payerId;

	/**
	 * Returns the generated id of credit card token
	 * 
	 * @return the id
	 */
	public String getCreditCardTokenId() {
		return creditCardTokenId;
	}
	
	/**
	 * Sets the generated id of credit card token
	 * 
	 * @param id the id to set
	 */
	public void setCreditCardTokenId(String id) {
		this.creditCardTokenId = id;
	}

	/**
	 * Returns the credit card token payer id. 
	 * 
	 * @return the payerId
	 */
	public String getPayerId() {
		return payerId;
	}

	/**
	 * Sets the credit card token payer id. 
	 * 
	 * @param payerId the payerId to set
	 */
	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

}