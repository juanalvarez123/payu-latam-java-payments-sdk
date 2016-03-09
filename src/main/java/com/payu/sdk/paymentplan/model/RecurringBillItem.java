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
 * Represents a recurring bill item in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 10/10/2013
 */
@XmlRootElement(name = "recurringBillItem")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = { "id", "description", "subscriptionId",
		"additionalValues","recurringBillId" })
public class RecurringBillItem extends Request {

	/**
	 * Serail version uid
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The recurring bill item identifier
	 */
	private String id;

	/**
	 * The recurring bill item description
	 */
	private String description;

	/**
	 * The subscription identifier
	 */
	private String subscriptionId;

	/**
	 * The recurring bill identifier
	 */
	private String recurringBillId;


	/**
	 * Recurring bill item values list
	 */
	private List<AdditionalValue> additionalValues;

	// ------------------------------------------------------
	// GETTERS
	// ------------------------------------------------------

	/**
	 * Returns recurring bill item identifier
	 *
	 * @return the recurring bill item id
	 */
	public String getId() {

		return id;
	}

	/**
	 * Returns recurring bill item description
	 *
	 * @return the recurring bill item description
	 */
	@XmlElement
	public String getDescription() {

		return description;
	}

	/**
	 * Returns subscription identifier
	 *
	 * @return the subscription id
	 */
	@XmlElement
	public String getSubscriptionId() {

		return subscriptionId;
	}
	/**
	 * Returns recurring bill identifier
	 *
	 * @return the  recurring bill id
	 */
	public String getRecurringBillId() {

		return recurringBillId;
	}

	/**
	 * Recurring bill item values list
	 *
	 * @return Recurring bill item values list
	 */
	@XmlElementWrapper(name = "additionalValues")
	@XmlElement(name = "additionalValue")
	public List<AdditionalValue> getAdditionalValues() {

		return additionalValues;
	}

	// ------------------------------------------------------
	// SETTERS
	// ------------------------------------------------------

	/**
	 * Sets recurring bill item identifier
	 *
	 * @param id
	 *            recurring bill item identifier to set
	 */
	public void setId(String id) {

		this.id = id;
	}

	/**
	 * Sets the subscription identifier
	 *
	 * @param subscription
	 *            identifier to set
	 */
	public void setSubscriptionId(String subscriptionId) {

		this.subscriptionId = subscriptionId;
	}

	/**
	 * Sets the recurring bill identifier
	 *
	 * @param recurring bill
	 *            identifier to set
	 */
	public void setRecurringBillId(String recurringBillId) {

		this.recurringBillId = recurringBillId;
	}

	/**
	 * Sets recurring bill item description
	 *
	 * @param recurring
	 *            bill item description to set
	 */
	public void setDescription(String description) {

		this.description = description;
	}

	/**
	 * Sets recurring bill item values list
	 *
	 * @param recurring
	 *            bill item values list to set
	 */
	public void setAdditionalValues(List<AdditionalValue> additionalValues) {

		this.additionalValues = additionalValues;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.payu.sdk.model.request.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants.Resources.RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl,
			RequestMethod requestMethod) {
		switch (requestMethod) {
		case POST:
			return String.format(
					Resources.DEPENDENT_ENTITY_API_URL_PATTERN, baseUrl,
					Resources.PAYMENT_PLAN_VERSION,
					Resources.URI_SUBSCRIPTIONS, this.subscriptionId,
					Resources.URI_RECURRING_BILL_ITEMS);
		default:
			return String.format(Resources.PARAM_ENTITY_API_URL_PATTERN,
					baseUrl, Resources.PAYMENT_PLAN_VERSION,
					Resources.URI_RECURRING_BILL_ITEMS, this.id);
		}
	}

	/**
	 * Converts a XML string into a recurring bill item response object
	 *
	 * @param xml
	 *            The object in a XML format
	 * @return The recurring bill item response format
	 * @throws PayUException
	 */
	public static RecurringBillItem fromXml(String xml) throws PayUException {

		return JaxbUtil.convertXmlToJava(RecurringBillItem.class, xml);

	}

}
