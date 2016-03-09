package com.payu.sdk.paymentplan.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.request.Request;
import com.payu.sdk.utils.JaxbUtil;

/**
 * Represents a customer in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "customer")
@XmlType(propOrder = { "id", "fullName", "email", "creditCards", "bankAccounts",
		"subscriptions" })
public class Customer extends Request {

	/**
	 * The class serial version
	 */
	private static final long serialVersionUID = -4613305248015627453L;

	/**
	 * The customer identifier
	 */
	@XmlElement(required = false)
	private String id;

	/**
	 * The customer full name
	 */
	@XmlElement(required = true)
	private String fullName;

	/**
	 * The customer email
	 */
	@XmlElement(required = true)
	private String email;

	/**
	 * The customer credit cards
	 */
	@XmlElementWrapper(name = "creditCards")
	@XmlElement(name = "creditCard")
	private List<PaymentPlanCreditCard> creditCards;
	
	/**
	 * The customer bank accounts
	 */
	@XmlElementWrapper(name = "bankAccounts")
	@XmlElement(name = "bankAccount")
	private List<BankAccount> bankAccounts;


	/**
	 * The subscription credit cards
	 */
	@XmlElementWrapper(name = "subscriptions")
	@XmlElement(name = "subscription")
	private List<Subscription> subscriptions;

	// ------------------------------------------------------
	// GETTERS
	// ------------------------------------------------------

	/**
	 * Returns the customer identifier
	 * 
	 * @return the customer id
	 */
	public String getId() {

		return id;
	}

	/**
	 * Returns the full name of the customer
	 * 
	 * @return the customer name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Returns the email of the customer
	 * 
	 * @return the customer email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Returns the list of credit cards associated to the customer
	 * 
	 * @return the credit cards of the customer
	 */
	public List<PaymentPlanCreditCard> getCreditCards() {
		return creditCards;
	}
	
	/**
	 * Returns the list of bank accounts associated to the customer
	 * 
	 * @return the bank accounts of the customer
	 */
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	

	/**
	 * Returns the list of credit cards associated to the customer
	 * 
	 * @return the credit cards of the customer
	 */
	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	// ------------------------------------------------------
	// SETTERS
	// ------------------------------------------------------

	/**
	 * Sets the customer identifier
	 * 
	 * @param id the customer id
	 */
	public void setId(String id) {

		this.id = id;

	}

	/**
	 * Sets the full name
	 * 
	 * @param fullName the customer name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Sets the email
	 * 
	 * @param email the customer email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the list of credit cards associated to the customer
	 * 
	 * @param creditCards
	 *            the creditCards list to set
	 */
	public void setCreditCards(List<PaymentPlanCreditCard> creditCards) {

		this.creditCards = creditCards;
	}

	/**
	 * Sets the list of bank accounts associated to the customer
	 * 
	 * @param bankAccounts
	 *            the bankAccounts list to set
	 */
	public void setBankAccounts(List<BankAccount> bankAccounts) {

		this.bankAccounts = bankAccounts;
	}

	/**
	 * Sets the list of subscriptions associates to the customer
	 * 
	 * @param subscriptions
	 */
	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	/**
	 * Add a creditCard object to the associated credit card list. <br/>
	 * <b>Important!</b>This method is only for presentation purposes.
	 * 
	 * @param creditCard
	 *            The credit card to associate with the customer
	 */
	public void addCreditCard(PaymentPlanCreditCard creditCard) {
		if (creditCards == null) {
			creditCards = new ArrayList<PaymentPlanCreditCard>();
		}
		creditCards.add(creditCard);
	}
	
	/**
	 * Add a bankAccount object to the associated bankAccount list. <br/>
	 * <b>Important!</b>This method is only for presentation purposes.
	 * 
	 * @param bankAccount
	 *            The bank account to associate with the customer
	 */
	public void addBankAccount(BankAccount bankAccount) {
		if (bankAccounts == null) {
			bankAccounts = new ArrayList<BankAccount>();
		}
		bankAccounts.add(bankAccount);
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
			return String.format(Resources.ENTITY_API_URL_PATTERN,
					baseUrl, Resources.PAYMENT_PLAN_VERSION,
					Resources.URI_CUSTOMERS);
		default:
			return String.format(
					Resources.PARAM_ENTITY_API_URL_PATTERN, baseUrl,
					Resources.PAYMENT_PLAN_VERSION, Resources.URI_CUSTOMERS,
					this.id);
		}
	}

	/**
	 * Converts a xml string into a customer response object
	 * 
	 * @param xml
	 *            The object in a xml format
	 * @return The customer response format
	 * @throws PayUException
	 */
	public static Customer fromXml(String xml) throws PayUException {

		return JaxbUtil.convertXmlToJava(Customer.class, xml);

	}

}
