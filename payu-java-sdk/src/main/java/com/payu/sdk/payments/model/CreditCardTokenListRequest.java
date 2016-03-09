package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.model.CreditCardTokenInformation;
import com.payu.sdk.model.request.CommandRequest;

/**
 * Represents a token list request in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCardTokenListRequest extends CommandRequest {

	/** The generated serial version Id */
	private static final long serialVersionUID = -6616455676998943311L;
	/** The credit card token identifier. */
	@XmlElement(required = true)
	private CreditCardTokenInformation creditCardTokenInformation;

	/**
	 * Returns the credit card token identifier
	 * 
	 * @return the credit Card token information
	 */
	public CreditCardTokenInformation getCreditCardTokenInformation() {
		return creditCardTokenInformation;
	}

	/**
	 * Sets the credit card token identifier
	 * 
	 * @param creditCardTokenInformation
	 *            the credit card token information to set
	 */
	public void setCreditCardTokenInformation(
			CreditCardTokenInformation creditCardTokenInformation) {
		this.creditCardTokenInformation = creditCardTokenInformation;
	}

}