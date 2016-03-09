package com.payu.sdk.paymentplan.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.request.Request;
import com.payu.sdk.utils.JaxbUtil;

/**
 * Represents a bank account in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.1.1
 * @version 1.1.1, 06/11/2014
 */
@XmlRootElement(name = "bankAccount")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = { "id","accountId","customerId", "name", "documentNumber", "documentNumberType", "bank",
		"type", "accountNumber", "state", "country", "accountDigit", "agencyDigit", "agencyNumber" })
public class BankAccount extends Request {

	/** The class serial version */
	private static final long serialVersionUID = 1L;
	/** Id of the bank account holder */
	private String id;
	/** Name of the account holder */
	private String customerId;
	/** Id of the payu account holder */
	private String accountId;
	/** Name of the account holder */
	private String name;
	/** Document Number of the account holder */
	private String documentNumber;
	/** Document number type of the account holder */
	private String documentNumberType;
	/** ACH Bank */
	private String bank;
	/** ACH bank account type */
	private String type;
	/** ACH bank account number */
	private String accountNumber;
	/** ACH bank state */
	private String state;
	/** ISO Country code */
	private String country;
	/** Account digit (Only valid for Brazil) */
	private String accountDigit;
	/** Agency digit (Only valid for Brazil) */
	private String agencyDigit;
	/** Agency number (Only valid for Brazil) */
	private String agencyNumber;

	/**
	 * @return the id
	 */
	@XmlElement
	public String getId() {
		return id;
	}

	/**
	 * @return the customer identifier
	 */
	@XmlElement
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @return the payu account identifier
	 */
	@XmlElement
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @return the name
	 */
	@XmlElement
	public String getName() {
		return name;
	}

	/**
	 * @return the documentNumber
	 */
	@XmlElement
	public String getDocumentNumber() {
		return documentNumber;
	}

	/**
	 * @return the documentNumberType
	 */
	@XmlElement
	public String getDocumentNumberType() {
		return documentNumberType;
	}

	/**
	 * @return the bank
	 */
	@XmlElement
	public String getBank() {
		return bank;
	}

	/**
	 * @return the type
	 */
	@XmlElement
	public String getType() {
		return type;
	}

	/**
	 * @return the accountNumber
	 */
	@XmlElement
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the state
	 */
	@XmlElement
	public String getState() {
		return state;
	}

	/**
	 * @return the country
	 */
	@XmlElement
	public String getCountry() {
		return country;
	}

	/**
	 * @return the accountDigit
	 */
	@XmlElement
	public String getAccountDigit() {
		return accountDigit;
	}

	/**
	 * @return the agencyDigit
	 */
	@XmlElement
	public String getAgencyDigit() {
		return agencyDigit;
	}

	/**
	 * @return the agencyNumber
	 */
	@XmlElement
	public String getAgencyNumber() {
		return agencyNumber;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param documentNumber the documentNumber to set
	 */
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	/**
	 * @param documentNumberType the documentNumberType to set
	 */
	public void setDocumentNumberType(String documentNumberType) {
		this.documentNumberType = documentNumberType;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @param accountDigit the accountDigit to set
	 */
	public void setAccountDigit(String accountDigit) {
		this.accountDigit = accountDigit;
	}

	/**
	 * @param agencyDigit the agencyDigit to set
	 */
	public void setAgencyDigit(String agencyDigit) {
		this.agencyDigit = agencyDigit;
	}

	/**
	 * @param agencyNumber the agencyNumber to set
	 */
	public void setAgencyNumber(String agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payu.sdk.model.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants#RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl, RequestMethod requestMethod) {
		
		switch (requestMethod) {
			case DELETE:
				return String.format(Resources.DEPENDENT_PARAM_ENTITY_API_URL_PATTERN,
						baseUrl, Resources.PAYMENT_PLAN_VERSION,
						Resources.URI_CUSTOMERS, this.customerId,
						Resources.URI_BANK_ACCOUNTS, this.id);
			case POST:
				return String.format(Resources.DEPENDENT_ENTITY_API_URL_PATTERN,
						baseUrl, Resources.PAYMENT_PLAN_VERSION,
						Resources.URI_CUSTOMERS, this.customerId,
						Resources.URI_BANK_ACCOUNTS);
			case PUT:
				return String.format(Resources.PARAM_ENTITY_API_URL_PATTERN,
						baseUrl, Resources.PAYMENT_PLAN_VERSION,
						Resources.URI_BANK_ACCOUNTS, this.id);
			default:
				return String.format(Resources.PARAM_ENTITY_API_URL_PATTERN,
						baseUrl, Resources.PAYMENT_PLAN_VERSION,
						Resources.URI_BANK_ACCOUNTS, this.id);
		}
	}

	/**
	 * Converts a xml string into a bank account response object
	 * 
	 * @param xml The object in a xml format
	 * @return The bank account response format
	 * @throws PayUException
	 */
	public static BankAccount fromXml(String xml) throws PayUException {
		return JaxbUtil.convertXmlToJava(BankAccount.class, xml);
	}

}
