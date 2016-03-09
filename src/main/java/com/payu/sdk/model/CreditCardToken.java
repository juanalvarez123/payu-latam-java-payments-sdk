package com.payu.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a credit card token in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "creditCardToken")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCardToken {

	/** The credit card token identifier. */
	@XmlElement(name = "creditCardTokenId", required = false)
	private String tokenId;
	/** The name on the credit card. */
	@XmlElement(required = true)
	private String name;
	/** The credit card token payer id */
	@XmlElement(required = true)
	private String payerId;
	/** The document on the credit card. */
	@XmlElement(required = false)
	private String identificationNumber;
	/** The credit card token payment method */
	@XmlElement(required = true)
	private PaymentMethod paymentMethod;
	/** The credit card number. */
	@XmlElement(required = false)
	private String number;
	/** The credit card expiration date. */
	@XmlElement(required = false)
	private String expirationDate;
	/** The masked credit card number. */
	@XmlElement(required = false)
	private String maskedNumber;
	/** The credit card token error description */
	@XmlElement(required = false)
	private String errorDescription;

	/**
	 * Returns the credit card token id.
	 * 
	 * @return the generated id of credit card token
	 */
	public String getTokenId() {
		return tokenId;
	}

	/**
	 * Returns the credit card name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
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

	/**
	 * Returns the credit card document.
	 * 
	 * @return the document
	 */
	public String getIdentificationNumber() {
		return identificationNumber;
	}

	/**
	 * Returns the credit card payment method main.
	 * 
	 * @return the paymentMethodMain
	 */
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Returns the credit card number.
	 * 
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Returns the credit card expiration date.
	 * 
	 * @return the expirationDate
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Returns the credit card token masked number.
	 * 
	 * @return the maskedNumber
	 */
	public String getMaskedNumber() {
		return maskedNumber;
	}

	/**
	 * Returns the credit card token error description.
	 * 
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the credit card document.
	 * 
	 * @param document
	 *            the document to set
	 */
	public void setIdentificationNumber(String document) {
		this.identificationNumber = document;
	}

	/**
	 * Sets the credit card payment method.
	 * 
	 * @param paymentMethod
	 *            the paymentMethod to set
	 */
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @param expirationDate
	 *            the expirationDate to set
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @param maskedNumber
	 *            the maskedNumber to set
	 */
	public void setMaskedNumber(String maskedNumber) {
		this.maskedNumber = maskedNumber;
	}

	/**
	 * Sets the credit card token error description.
	 * 
	 * @param errorDescription
	 *            the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}