package com.payu.sdk.paymentplan.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.Address;
import com.payu.sdk.model.request.Request;
import com.payu.sdk.utils.JaxbUtil;

/**
 * Represents a credit card in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "creditCard")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = { "token", "customerId", "number", "name", "document",
		"expMonth", "expYear", "type", "issuerBank", "address" })
public class PaymentPlanCreditCard extends Request {

	/**
	 * The class serial version
	 */
	private static final long serialVersionUID = 7546916427371720564L;

	/**
	 * Credit card token
	 */
	private String token;

	/**
	 * Customer identification code
	 */
	private String customerId;

	/**
	 * Credit card number
	 */
	private String number;

	/**
	 * Expiration month
	 */
	private Integer expMonth;

	/**
	 * Expiration year
	 */
	private Integer expYear;

	/**
	 * Credit card type
	 */
	private String type;

	/**
	 * The issuer bank
	 */
	private String issuerBank;

	/**
	 * Card holder namer
	 */
	private String name;

	/**
	 * Card holder identification document number
	 */
	private String document;

	/**
	 * Credit card billing address
	 */
	private Address address;

	// ----------------------------------------------
	// GETTERS AND SETTERS
	// ----------------------------------------------

	/**
	 * Returns the credit card token
	 * 
	 * @return the token
	 */
	@XmlElement
	public String getToken() {
		return token;
	}

	/**
	 * Returns the customer identifier
	 * 
	 * @return the customerId
	 */
	@XmlElement
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Returns the credit card number
	 * 
	 * @return the credit card number
	 */
	@XmlElement
	public String getNumber() {
		return number;
	}

	/**
	 * Returns the expMonth
	 * 
	 * @return the expMonth
	 */
	@XmlElement
	public Integer getExpMonth() {
		return expMonth;
	}

	/**
	 * Returns the expYear
	 * 
	 * @return the expYear
	 */
	@XmlElement
	public Integer getExpYear() {
		return expYear;
	}

	/**
	 * Returns the type
	 * 
	 * @return the type
	 */
	@XmlElement
	public String getType() {
		return type;
	}

	/**
	 * Returns the address
	 * 
	 * @return the address
	 */
	@XmlElement
	public Address getAddress() {
		return address;
	}

	/**
	 * Returns the credit card issuer bank
	 * 
	 * @return the issuerBank
	 */
	public String getIssuerBank() {
		return issuerBank;
	}

	/**
	 * Returns the card holder's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the card holder identification document
	 * 
	 * @return the document
	 */
	public String getDocument() {

		return document;
	}

	/**
	 * Sets the token
	 * 
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Sets the customerId
	 * 
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * Sets the number
	 * 
	 * @param number
	 *            the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Sets the expMonth
	 * 
	 * @param expMonth
	 *            the expMonth to set
	 */
	public void setExpMonth(Integer expMonth) {
		this.expMonth = expMonth;
	}

	/**
	 * Sets the expYear
	 * 
	 * @param expYear
	 *            the expYear to set
	 */
	public void setExpYear(Integer expYear) {
		this.expYear = expYear;
	}

	/**
	 * Sets the type
	 * 
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Sets the address
	 * 
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Sets the credit card issuer bank
	 * 
	 * @param issuerBank
	 *            the issuerBank to set
	 */
	public void setIssuerBank(String issuerBank) {
		this.issuerBank = issuerBank;
	}

	/**
	 * Sets the card holder's name
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the card holder document
	 * 
	 * @param document
	 *            the card holder document to set
	 */
	public void setDocument(String document) {

		this.document = document;
	}

	/**
	 * Returns the credit card expiration date in AAAA/MM format.
	 * 
	 * @return The expiration date in AAAA/MM format.
	 */
	public String convertExpirationDate() {

		StringBuilder expDate = new StringBuilder();

		if (getExpYear() != null) {
			expDate.append(getExpYear() < 100 ? getExpYear() < 10 ? "200"
					: "20" : "");
			expDate.append(getExpYear());
		} else {
			expDate.append("0000");
		}
		expDate.append("/");

		if (getExpMonth() != null) {
			expDate.append(getExpMonth() < 10 ? "0" : "");
			expDate.append(getExpMonth());
		} else {
			expDate.append("00");
		}

		return expDate.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payu.sdk.model.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants#RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl,
			RequestMethod requestMethod) {

		switch (requestMethod) {
		case POST:
			return String.format(Resources.DEPENDENT_ENTITY_API_URL_PATTERN,
					baseUrl, Resources.PAYMENT_PLAN_VERSION,
					Resources.URI_CUSTOMERS, this.customerId,
					Resources.URI_CREDIT_CARDS);
		case DELETE:
			return String.format(
					Resources.DEPENDENT_PARAM_ENTITY_API_URL_PATTERN, baseUrl,
					Resources.PAYMENT_PLAN_VERSION, Resources.URI_CUSTOMERS,
					this.customerId, Resources.URI_CREDIT_CARDS, this.token);
		default:
			return String.format(Resources.PARAM_ENTITY_API_URL_PATTERN,
					baseUrl, Resources.PAYMENT_PLAN_VERSION,
					Resources.URI_CREDIT_CARDS, this.token);
		}
	}

	/**
	 * Converts a xml string into a credit card response object
	 * 
	 * @param xml
	 *            The object in a xml format
	 * @return The credit card response format
	 * @throws PayUException
	 */
	public static PaymentPlanCreditCard fromXml(String xml) throws PayUException {

		return JaxbUtil.convertXmlToJava(PaymentPlanCreditCard.class, xml);

	}

}
