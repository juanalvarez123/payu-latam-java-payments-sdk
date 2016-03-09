package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.model.CreditCardToken;
import com.payu.sdk.model.request.CommandRequest;

/**
 * Represents a conrete payment request in the PayU SDK. This class holds all
 * the payment transaction information.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCardTokenRequest extends CommandRequest {

	/** The generated serial version Id */
	private static final long serialVersionUID = 121443382353458839L;
	/** The credit card's token */
	@XmlElement(required = true)
	private CreditCardToken creditCardToken;

	/**
	 * Returns the credit card's token
	 * 
	 * @return the credit card's token
	 */
	public CreditCardToken getCreditCardToken() {
		return creditCardToken;
	}

	/**
	 * Sets the credit card's token
	 * 
	 * @param creditCardToken
	 *            the credit card's token
	 */
	public void setCreditCardToken(CreditCardToken creditCardToken) {
		this.creditCardToken = creditCardToken;
	}

}
