package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.model.RemoveCreditCardToken;
import com.payu.sdk.model.request.CommandRequest;

/**
 * Represents a concrete payment request in the PayU SDK. This class holds all
 * the payment transaction information.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class RemoveCreditCardTokenRequest extends CommandRequest {

	/** The generated serial version Id */
	private static final long serialVersionUID = -2784925354134880784L;
	/** The credit card's token */
	@XmlElement(required = true)
	private RemoveCreditCardToken removeCreditCardToken;

	/**
	 * Returns the credit card's token
	 * 
	 * @return the removeCreditCardToken
	 */
	public RemoveCreditCardToken getRemoveCreditCardToken() {
		return removeCreditCardToken;
	}

	/**
	 * Sets the credit card's token
	 * 
	 * @param removeCreditCardToken
	 *            the removeCreditCardToken to set
	 */
	public void setRemoveCreditCardToken(
			RemoveCreditCardToken removeCreditCardToken) {
		this.removeCreditCardToken = removeCreditCardToken;
	}

}
