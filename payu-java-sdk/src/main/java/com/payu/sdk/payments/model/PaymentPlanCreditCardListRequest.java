/**
 * PayU Latam
 * Date: 09/06/2014
 */
package com.payu.sdk.payments.model;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.model.request.Request;
/**
 * Credit card representation List
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 10/06/2013
 */
public class PaymentPlanCreditCardListRequest extends Request    {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7785916427376989864L;

	/*The customer id*/
	private String customerId=null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payu.sdk.model.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants#RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl,
			RequestMethod requestMethod) {

		return String.format(Resources.DEPENDENT_ENTITY_API_URL_PATTERN,
				baseUrl, Resources.PAYMENT_PLAN_VERSION,
				Resources.URI_CUSTOMERS, this.getCustomerId(),
				Resources.URI_CREDIT_CARDS);
	}
 
	/** 
	 * Gets the customerId
	 * @param customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/** 
	 * Set the customerId
	 * @param customerId
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


}
