package com.payu.sdk.payments.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.response.Response;
import com.payu.sdk.paymentplan.model.Subscription;

/**
 * Represents a subscription list response in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.1.1
 * @version 1.1.1, 06/06/2014
 */
@XmlRootElement(name = "subscriptionsListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubscriptionListResponse extends Response {

	/** The generated serial version Id */
	private static final long serialVersionUID = 6878145146131L;
	
	/** The result list */
	@XmlElementWrapper(name = "subscriptions")
	@XmlElement(name = "subscription")
	private List<Subscription> subscriptionList;

	/**
	 * Returns the subscription list
	 * 
	 * @return the subscriptionList
	 */
	public List<Subscription> getSubscriptionList() {
		return subscriptionList;
	}

	/**
	 * Sets the subscription  list
	 * 
	 * @param subscriptionList the subscription  list to set
	 */
	public void setSubscriptionList(List<Subscription> subscriptionList) {
		this.subscriptionList = subscriptionList;
	}

	/**
	 * Maps the xml string of a subscription list response to the object
	 * 
	 * @param xml The object in a xml format
	 * @return The java object
	 * @throws PayUException
	 */
	public static SubscriptionListResponse fromXml(String xml)
			throws PayUException {

		return (SubscriptionListResponse) fromBaseXml(new SubscriptionListResponse(), xml);
	}

}
