/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 developers-payu-latam
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.payu.sdk.paymentplan.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.Address;
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
@XmlType(propOrder = { "id", "trialDays", "quantity", "installments", "currentPeriodStart", "currentPeriodEnd", "customer",
		"plan", "creditCardToken", "bankAccountId", "termsAndConditionsAcepted", "immediatePayment", "deliveryAddress",
		"notifyUrl", "sourceReference", "recurringBillItems", "extra1", "extra2", "sourceId", "description", "sourceBuyerIp",
		"sourceNumberOfPayments", "sourceNextPaymentNumber", "creationSource" })
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
	
	/**
	 *  If the client accepted the terms and conditions document.
	 */
	private Boolean termsAndConditionsAcepted;
	
	/**
	 * Allows to process an immediate payment when the subscription is created
	 */
	private Boolean immediatePayment;
	
	/**
	 * Subscription delivery address
	 */
	private Address deliveryAddress;
	
	/**
	 * The subscription notify url
	 */
	private String notifyUrl;
	
	/**
	 * The subscription source reference
	 */
	private String sourceReference;
	
	/**
	 * The extra charges of a subscription
	 */
	private List<RecurringBillItem> recurringBillItems;
	
	/**
	 * The extra1 field
	 */
	private String extra1;
	
	/**
	 * The extra2 field
	 */
	private String extra2;
	
	/**
	 * The susbscription ID in POL
	 */
	private Long sourceId;
	
	/**
	 * The subscription's description / comments 
	 */
	private String description;
	
	/**
	 * To be used by migrated subscriptions. The buyer IP as 
	 * informed by the origin platform.
	 */
	private String sourceBuyerIp;
	
	/**
	 * To be used by migrated subscriptions. The number of payments 
	 * charged on the origin platform at the moment that the subscription 
	 * was migrated.
	 */
	private Integer sourceNumberOfPayments;

	/**
	 * To be used by migrated subscriptions. The number of the next payment
	 * to be charged on the origin platform at the moment that the subscription 
	 * was migrated. 
	 */
	private Integer sourceNextPaymentNumber;

	/**
	 * The subscriptions's creation source
	 */
	private String creationSource;
	
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
	 * Returns a flag to indicate an inmmediate payment
	 * 
	 * @return the immediate payment flag
	 */
	public Boolean getImmediatePayment() {

		return immediatePayment;
	}
	
	/**
	 * Returns the subscription delivery address
	 * 
	 * @return the object delivery address
	 */
	public Address getDeliveryAddress() {
		
		return deliveryAddress;
	}
	
	/**
	 * Returns the subscription notify url
	 * 
	 * @return the notifyUrl
	 */
	public String getNotifyUrl() {
	
		return notifyUrl;
	}

	/**
	 * Returns the subscription source reference
	 * 
	 * @return the sourceReference
	 */
	public String getSourceReference() {
		
		return sourceReference;
	}
	
	/**
	 * Returns the subscription recurring bill items
	 * 
	 * @return the recurringBillItems
	 */
	public List<RecurringBillItem> getRecurringBillItems() {
		
		return recurringBillItems;
	}
	
	/**
	 * Returns the subscription extra1 field
	 * 
	 * @return the extra1
	 */
	public String getExtra1() {

		return extra1;
	}

	/**
	 * Returns the subscription's extra2 field
	 * 
	 * @return the extra2
	 */
	public String getExtra2() {

		return extra2;
	}
	
	/**
	 * Returns the source id. Represents the subscription ID in POL when subscription is migrated
	 * 
	 * @return the source id
	 */
	public Long getSourceId() {
		
		return sourceId; 
	}
	
	/**
	 * Returns the subscription description
	 * 
	 * @return the subscription description
	 */
	public String getDescription() {
		
		return description;
	}

	/**
	 * Returns the source buyer IP
	 * 
	 * @return the sourceBuyerIp
	 */
	public String getSourceBuyerIp() {
		return sourceBuyerIp;
	}

	/**
	 * Returns the source number of payments
	 * 
	 * @return the sourceNumberOfPayments
	 */
	public Integer getSourceNumberOfPayments() {
		return sourceNumberOfPayments;
	}

	/**
	 * Returns the source next payment number
	 * 
	 * @return the sourceNextPaymentNumber
	 */
	public Integer getSourceNextPaymentNumber() {
		return sourceNextPaymentNumber;
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
	
	/**
	 * Sets the inmmediate payment
	 * 
	 * @param immediatePayment
	 *            the immediate payment flag
	 */
	public void setImmediatePayment(Boolean immediatePayment) {

		this.immediatePayment = immediatePayment;
	}

	/**
	 * Sets the subscription deliveryAddres
	 * 
	 * @param deliveryAddress
	 *            the delivery address
	 */
	public void setDeliveryAddress(Address deliveryAddress) {

		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * Sets the subscription notify url
	 * 
	 * @param notifyUrl
	 *            the notifyUrl to set
	 */
	public void setNotifyUrl(String notifyUrl) {

		this.notifyUrl = notifyUrl;
	}

	/**
	 * Sets the subscription source reference
	 * 
	 * @param sourceReference
	 *            the source reference to set
	 */
	public void setSourceReference(String sourceReference) {

		this.sourceReference = sourceReference;
	}

	/**
	 * Sets the suscription recurring bill items
	 * 
	 * @param recurringBillItems
	 *            the recurringBillItems to set
	 */
	public void setRecurringBillItems(List<RecurringBillItem> recurringBillItems) {

		this.recurringBillItems = recurringBillItems;
	}

	/**
	 * Sets the extra1 field
	 * 
	 * @param extra1
	 *            the extra1 to set
	 */
	public void setExtra1(String extra1) {

		this.extra1 = extra1;
	}

	/**
	 * Sets the extra2 field
	 * 
	 * @param extra2
	 *            the extra2 to set
	 */
	public void setExtra2(String extra2) {

		this.extra2 = extra2;
	}
	
	/**
	 * Sets the source id. Represents the subscription ID in POL when subscription is migrated
	 * 
	 * @param sourceId
	 *            The subscription ID in POL
	 */
	public void setSourceId(Long sourceId) {

		this.sourceId = sourceId;
	}

	/**
	 * Sets the subscription description
	 * 
	 * @param description
	 *            The subscription description
	 */
	public void setDescription(String description) {

		this.description = description;
	}

	/**
	 * @return the creationSource
	 */
	public String getCreationSource() {

		return creationSource;
	}

	/**
	 * @param creationSource the creationSource to set
	 */
	public void setCreationSource(String creationSource) {

		this.creationSource = creationSource;
	}
	
	/**
	 * Sets the source buyer IP
	 * 
	 * @param sourceBuyerIp
	 * 			The source buyer IP
	 */
	public void setSourceBuyerIp(String sourceBuyerIp) {
		this.sourceBuyerIp = sourceBuyerIp;
	}

	/**
	 * Sets the source number of payments
	 * 
	 * @param sourceNumberOfPayments
	 * 			The source number of payments
	 */
	public void setSourceNumberOfPayments(Integer sourceNumberOfPayments) {
		this.sourceNumberOfPayments = sourceNumberOfPayments;
	}

	/**
	 * Sets the source next payment number
	 * 
	 * @param sourceNextPaymentNumber
	 * 			The source next payment number
	 */
	public void setSourceNextPaymentNumber(Integer sourceNextPaymentNumber) {
		this.sourceNextPaymentNumber = sourceNextPaymentNumber;
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
