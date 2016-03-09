package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.model.request.Request;

/**
 * Subscription plan representation List
 * 
 * @author PayU Latam
 * @since 1.1.1
 * @version 1.1.1, 06/06/2014
 */
@XmlRootElement(name = "planListResponse")
@XmlType(propOrder = {"planList"})
public class SubscriptionPlanListRequest extends Request {
	
	/** The generated serial version Id */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payu.sdk.model.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants#RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl, RequestMethod requestMethod) {

		return String.format(Resources.ENTITY_API_URL_PATTERN,
				baseUrl, Resources.PAYMENT_PLAN_VERSION,
				Resources.URI_PLANS + this.getQueryString());
	}

}
