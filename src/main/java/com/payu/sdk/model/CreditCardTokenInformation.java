package com.payu.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents the credit card token information in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 * 
 */
@XmlRootElement(name = "creditCardTokenInformation")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCardTokenInformation {

	/** The credit card token identifier. */
	@XmlElement(name = "creditCardTokenId", required = true)
	private String tokenId;

	/** The credit card token payer id */
	@XmlElement(required = true)
	private String payerId;

	/**
	 * The get token list start date
	 */
	@XmlElement(required = true)
	private String startDate;

	/**
	 * The get token list end date
	 */
	@XmlElement(required = true)
	private String endDate;

	/**
	 * Returns the start date
	 * 
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date
	 * 
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the start date
	 * 
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Sets the start date
	 * 
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * Returns the token id
	 * 
	 * @return The token id
	 */
	public String getTokenId() {
		return tokenId;
	}

	/**
	 * Sets the token id
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setTokenId(String id) {
		this.tokenId = id;
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
	 * @param payerId
	 *            the payerId to set
	 */
	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

}