package com.payu.sdk.paymentplan.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.request.Request;
import com.payu.sdk.utils.JaxbUtil;

/**
 * Represents a Subscription (Recurrent Payment) in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "subscription")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = { "id", "trialDays", "quantity", "installments",
		"currentPeriodStart", "currentPeriodEnd", "customer", "plan",
		"creditCardToken", "bankAccountId","termsAndConditionsAcepted" })
public class Subscription extends Request {

	/**
	 * The class serial version
	 */
	private static final long serialVersionUID = -8304427947413149816L;

	/**
	 * The subscription identifier
	 */
	private String id;
	
	/**
	 * The subscription identifier to use oinly on URLs
	 */
	private String urlId;

	/**
	 * Subscription Plan
	 */
	private SubscriptionPlan plan;

	/**
	 * Customer
	 */
	private Customer customer;

	/**
	 * Number of trial days
	 */
	private Integer trialDays;

	/**
	 * Quantity
	 */
	private Integer quantity;

	/**
	 * Installments
	 */
	private Integer installments;

	/**
	 * The date, the current period started
	 */
	private Date currentPeriodStart;

	/**
	 * The date, the current period end
	 */
	private Date currentPeriodEnd;

	/**
	 * The credit card token
	 */
	private String creditCardToken;
	
	/**
	 * Bank account identifier to modify for the subscription 
	 */
	private String  bankAccountId;
	
	
	/*
	 *  If the client accepted the terms and conditions document.
	 */
	private Boolean termsAndConditionsAcepted;

	// -------------------------------------------------------
	// GETTERS AND SETTERS
	// -------------------------------------------------------

	/**
	 * Returns the subscription identifier
	 * 
	 * @return the subscription id
	 */
	public String getId() {
		return id;
	}
	
	
	/**
	 * Returns the urlId
	 * @return the urlId
	 */
	@XmlTransient
	public String getUrlId() {
		return urlId;
	}

	/**
	 * @return the termsAndConditionsAcepted
	 */
	public Boolean getTermsAndConditionsAcepted() {
	
		return termsAndConditionsAcepted;
	}
	/**
	 * Returns the subscription plan
	 * 
	 * @return the subscription plan
	 */
	public SubscriptionPlan getPlan() {
		return plan;
	}

	/**
	 * Returns the customer
	 * 
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Returns the trialDays
	 * 
	 * @return the trialDays
	 */
	public Integer getTrialDays() {
		return trialDays;
	}

	/**
	 * Returns the installments
	 * 
	 * @return the installments
	 */
	public Integer getInstallments() {
		return installments;
	}

	/**
	 * Returns the quantity
	 * 
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Returns the current period start date
	 * 
	 * @return the current period start date
	 */
	public Date getCurrentPeriodStart() {
		return currentPeriodStart;
	}

	/**
	 * Returns the current period end date
	 * 
	 * @return the current period end date
	 */
	public Date getCurrentPeriodEnd() {
		return currentPeriodEnd;
	}

	/**
	 * Returns the credit card token
	 * 
	 * @return the credit card token
	 */
	public String getCreditCardToken() {
		return creditCardToken;
	}
	/**
	 * Returns the subscription bank account identifier
	 * 
	 * @return the bank account identifier
	 */
	public String getBankAccountId() {

		return bankAccountId;
	}

	/**
	 * Sets the subscription identifier
	 * 
	 * @param id the subcription id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	/**
	 * Sets the urlId
	 * @param urlId the urlId to set
	 */
	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	/**
	 * Sets the subscription plan
	 * 
	 * @param plan
	 *            the subscription Plan to set
	 */
	public void setPlan(SubscriptionPlan plan) {
		this.plan = plan;
	}

	/**
	 * Sets the customer
	 * 
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Sets the trialDays
	 * 
	 * @param trialDays
	 *            the trialDays to set
	 */
	public void setTrialDays(Integer trialDays) {
		this.trialDays = trialDays;
	}

	/**
	 * Sets the installments
	 * 
	 * @param installments
	 *            the installments to set
	 */
	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

	/**
	 * Sets the quantity
	 * 
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Sets the current period start date
	 * 
	 * @param currentPeriodStart
	 */
	public void setCurrentPeriodStart(Date currentPeriodStart) {
		this.currentPeriodStart = currentPeriodStart;
	}

	/**
	 * Sets the current period end date
	 * 
	 * @param currentPeriodEnd
	 */
	public void setCurrentPeriodEnd(Date currentPeriodEnd) {
		this.currentPeriodEnd = currentPeriodEnd;
	}

	/**
	 * Sets the credit card token
	 * 
	 * @param creditCardToken
	 */
	public void setCreditCardToken(String creditCardToken) {
		this.creditCardToken = creditCardToken;
	}
	
	/**
	 * @param termsAndConditionsAcepted the termsAndConditionsAcepted to set
	 */
	public void setTermsAndConditionsAcepted(Boolean termsAndConditionsAcepted) {
	
		this.termsAndConditionsAcepted = termsAndConditionsAcepted;
	}
	
	/**
	 * Sets the subscription bank account identifier
	 * 
	 */
	public void setBankAccountId(String bankAccountId) {

		this.bankAccountId = bankAccountId;
	}
	

	/* (non-Javadoc)
	 * @see com.payu.sdk.model.request.Request#getBaseRequestUrl(java.lang.String, com.payu.sdk.constants.Resources.RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl,
			RequestMethod requestMethod) {

		switch (requestMethod) {
		case POST:
			return String.format(Resources.ENTITY_API_URL_PATTERN,
					baseUrl, Resources.PAYMENT_PLAN_VERSION,
					Resources.URI_SUBSCRIPTIONS);
		case PUT:
			return String.format(
					Resources.PARAM_ENTITY_API_URL_PATTERN, baseUrl,
					Resources.PAYMENT_PLAN_VERSION, Resources.URI_SUBSCRIPTIONS,
					this.getId()!=null ? this.getId() : this.getUrlId());
		default:
			return String.format(
					Resources.PARAM_ENTITY_API_URL_PATTERN, baseUrl,
					Resources.PAYMENT_PLAN_VERSION, Resources.URI_SUBSCRIPTIONS,
					this.getId());
		}
	}

	/**
	 * Converts a XML string into a subscription response object
	 * 
	 * @param xml
	 *            The object in a XML format
	 * @return The subscription response format
	 * @throws PayUException
	 */
	public static Subscription fromXml(String xml) throws PayUException {

		return JaxbUtil.convertXmlToJava(Subscription.class, xml);

	}

}
