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

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.AdditionalValue;
import com.payu.sdk.model.request.Request;
import com.payu.sdk.utils.JaxbUtil;

/**
 * Represents a subscription plan in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "plan")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "planCode", "description", "accountId",
		"intervalCount", "interval", "maxPaymentsAllowed", "maxPaymentAttempts",
		"maxPendingPayments", "paymentAttemptsDelay", "trialDays",
		"additionalValues" })
public class SubscriptionPlan extends Request {

	/**
	 * The class serial version
	 */
	private static final long serialVersionUID = -4132558358217220785L;

	/**
	 * The identifier of the order.
	 */
	@XmlElement
	private String id;

	/**
	 * The plan Code
	 */
	@XmlElement
	private String planCode;

	/**
	 * The plan description
	 */
	@XmlElement
	private String description;

	/**
	 * The identifier of the account related to the order.
	 */
	@XmlElement
	private Integer accountId;

	/**
	 * The number of intervals
	 */
	@XmlElement
	private Integer intervalCount;

	/**
	 * The payment interval
	 */
	@XmlElement
	private String interval;

	/**
	 * Number of payments allowed in the interval
	 */
	@XmlElement
	private Integer maxPaymentsAllowed;

	/**
	 * Number of attempts allowed by payment
	 */
	@XmlElement
	private Integer maxPaymentAttempts;

	/**
	 * Hours to delay the next payment Attempt
	 */
	@XmlElement
	private Integer paymentAttemptsDelay;

	/**
	 * Max pending bills allowed
	 */
	@XmlElement
	private Integer maxPendingPayments;

	/**
	 * Number of trial days
	 */
	@XmlElement
	private Integer trialDays;

	/**
	 * The map of the values.
	 */
	@XmlElementWrapper(name = "additionalValues")
	@XmlElement(name = "additionalValue")
	private List<AdditionalValue> additionalValues;

	/**
	 * Returns the subscription plan id
	 *
	 * @return the id
	 */
	public String getId() {

		return id;
	}

	/**
	 * Returns the subscription plan code
	 *
	 * @return the plan code
	 */
	public String getPlanCode() {

		return planCode;
	}

	/**
	 * Returns the subscription plan description
	 *
	 * @return the description
	 */
	public String getDescription() {

		return description;
	}

	/**
	 * Returns the subscription plan account id
	 *
	 * @return the account id
	 */
	public Integer getAccountId() {

		return accountId;
	}

	/**
	 * Returns the subscription plan interval count
	 *
	 * @return the interval count
	 */
	public Integer getIntervalCount() {

		return intervalCount;
	}

	/**
	 * Returns the subscription plan interval
	 *
	 * @return the interval
	 */
	public String getInterval() {

		return interval;
	}

	/**
	 * Returns the subscription plan maximum number of payments allowed
	 *
	 * @return the max payments allowed
	 */
	public Integer getMaxPaymentsAllowed() {

		return maxPaymentsAllowed;
	}

	/**
	 * Returns the subscription plan maximum number of payment attempts
	 *
	 * @return the max payment attempts
	 */
	public Integer getMaxPaymentAttempts() {

		return maxPaymentAttempts;
	}

	/**
	 * Returns the subscription plan payment attempts delay
	 *
	 * @return the payment attempts delay
	 */
	public Integer getPaymentAttemptsDelay() {

		return paymentAttemptsDelay;
	}

	/**
	 * Returns the subscription plan maximum number of pending payments
	 *
	 * @return the max pending payments
	 */
	public Integer getMaxPendingPayments() {

		return maxPendingPayments;
	}

	/**
	 * Returns the subscription plan trial days
	 *
	 * @return the trial days
	 */
	public Integer getTrialDays() {

		return trialDays;
	}

	/**
	 * Returns the subscription plan additional values
	 *
	 * @return the additional values
	 */
	public List<AdditionalValue> getAdditionalValues() {

		return additionalValues;
	}


	/**
	 * Sets the subscription plan id
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {

		this.id = id;
	}

	/**Sets the subscription plan cod
	 *
	 * @param planCode
	 *            the plan code to set
	 */
	public void setPlanCode(String planCode) {

		this.planCode = planCode;
	}

	/**
	 * Sets the subscription plan description
	 *
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {

		this.description = description;
	}

	/**
	 * Sets the subscription plan account id
	 *
	 * @param accountId
	 *            the account id to set
	 */
	public void setAccountId(Integer accountId) {

		this.accountId = accountId;
	}

	/**
	 * Sets the subscription plan interval count
	 *
	 * @param intervalCount
	 *            the interval count to set
	 */
	public void setIntervalCount(Integer intervalCount) {

		this.intervalCount = intervalCount;
	}

	/**
	 * Sets the subscription plan interval
	 *
	 * @param interval
	 *            the interval to set
	 */
	public void setInterval(String interval) {

		this.interval = interval;
	}

	/**
	 * Sets the subscription plan maximum number of payments allowed
	 *
	 * @param maxPaymentsAllowed
	 *            the max payments allowed to set
	 */
	public void setMaxPaymentsAllowed(Integer maxPaymentsAllowed) {

		this.maxPaymentsAllowed = maxPaymentsAllowed;
	}

	/**
	 * Sets the subscription plan maximum payment attempts
	 *
	 * @param maxPaymentAttempts
	 *            the max payment attempts to set
	 */
	public void setMaxPaymentAttempts(Integer maxPaymentAttempts) {

		this.maxPaymentAttempts = maxPaymentAttempts;
	}

	/**
	 * Sets the subscription plan payment attempts delay
	 *
	 * @param paymentAttemptsDelay
	 *            the payment attempts delay to set
	 */
	public void setPaymentAttemptsDelay(Integer paymentAttemptsDelay) {

		this.paymentAttemptsDelay = paymentAttemptsDelay;
	}

	/**
	 * Sets the subscription plan maximum number of panding payments
	 *
	 * @param maxPendingPayments
	 *            the max pending payments to set
	 */
	public void setMaxPendingPayments(Integer maxPendingPayments) {

		this.maxPendingPayments = maxPendingPayments;
	}

	/**
	 * Sets the subscription plan trial days
	 *
	 * @param trialDays
	 *            the trial days to set
	 */
	public void setTrialDays(Integer trialDays) {

		this.trialDays = trialDays;
	}

	/**
	 * Sets the subscription plan additional values
	 *
	 * @param additionalValues
	 *            the additional values to set
	 */
	public void setAdditionalValues(List<AdditionalValue> additionalValues) {

		this.additionalValues = additionalValues;
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
					Resources.URI_PLANS);
		default:
			return String.format(
					Resources.PARAM_ENTITY_API_URL_PATTERN, baseUrl,
					Resources.PAYMENT_PLAN_VERSION, Resources.URI_PLANS,
					this.planCode);
		}
	}

	/**
	 * Converts a xml string into a SubscriptionPlan response object
	 *
	 * @param xml
	 *            The object in a xml format
	 * @return The SubscriptionPlan response format
	 * @throws PayUException
	 */
	public static SubscriptionPlan fromXml(String xml) throws PayUException {

		return JaxbUtil.convertXmlToJava(SubscriptionPlan.class, xml);

	}

}
