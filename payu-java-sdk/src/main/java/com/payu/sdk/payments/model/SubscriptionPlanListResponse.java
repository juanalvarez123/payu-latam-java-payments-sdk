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
