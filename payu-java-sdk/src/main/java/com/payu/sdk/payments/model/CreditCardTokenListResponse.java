package com.payu.sdk.payments.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.CreditCardToken;
import com.payu.sdk.model.response.Response;

/**
 * Represents a token list response in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "creditCardTokenListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCardTokenListResponse extends Response {

	/** The generated serial version id */
	private static final long serialVersionUID = 7605652969816185581L;
	/** The result token */
	@XmlElementWrapper(name = "creditCardTokenList")
	@XmlElement(name = "creditCardToken")
	private List<CreditCardToken> creditCardTokenList;

	/**
	 * Returns the credit card token list
	 * 
	 * @return the creditCardTokenList
	 */
	public List<CreditCardToken> getCreditCardTokenList() {
		return creditCardTokenList;
	}

	/**
	 * Sets the credit card tokens list
	 * 
	 * @param creditCardTokens
	 *            the credit card token list to set
	 */
	public void setCreditCardTokenList(List<CreditCardToken> creditCardTokens) {
		this.creditCardTokenList = creditCardTokens;
	}

	/**
	 * Maps the xml of a credit card token list response to the object
	 * 
	 * @param xml
	 *            The object in a xml format
	 * @return The java object
	 * @throws PayUException
	 */
	public static CreditCardTokenListResponse fromXml(String xml)
			throws PayUException {

		return (CreditCardTokenListResponse) fromBaseXml(
				new CreditCardTokenListResponse(), xml);
	}

}