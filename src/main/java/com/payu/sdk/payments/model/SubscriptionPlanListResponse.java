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
package com.payu.sdk.payments.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.response.Response;
import com.payu.sdk.paymentplan.model.SubscriptionPlan;

/**
 * Represents a subscription plan list response in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.1.1
 * @version 1.1.1, 06/06/2014
 */
@XmlRootElement(name = "planListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubscriptionPlanListResponse extends Response {

	/** The generated serial version Id */
	private static final long serialVersionUID = 1L;

	/** The result list */
	@XmlElementWrapper(name = "plans")
	@XmlElement(name = "plan")
	private List<SubscriptionPlan> subscriptionPlanList;

	/**
	 * Returns the subscription plan list
	 *
	 * @return the subscriptionPlanList
	 */
	public List<SubscriptionPlan> getSubscriptionPlanList() {
		return subscriptionPlanList;
	}

	/**
	 * Sets the subscription plan list
	 *
	 * @param subscriptionPlanList the subscription plan list to set
	 */
	public void setSubscriptionPlanList(List<SubscriptionPlan> subscriptionPlanList) {
		this.subscriptionPlanList = subscriptionPlanList;
	}

	/**
	 * Maps the xml string of a subscription plan list response to the object
	 *
	 * @param xml The object in a xml format
	 * @return The java object
	 * @throws PayUException
	 */
	public static SubscriptionPlanListResponse fromXml(String xml)
			throws PayUException {

		return (SubscriptionPlanListResponse) fromBaseXml(new SubscriptionPlanListResponse(), xml);
	}

}
