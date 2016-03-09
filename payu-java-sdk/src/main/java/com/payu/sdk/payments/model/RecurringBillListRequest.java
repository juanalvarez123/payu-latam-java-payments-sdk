/**
 * PayU Latam
 * Date: 07/01/2014
 */
package com.payu.sdk.payments.model;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.model.request.Request;

/**
 * Recurrent Bill representation List
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 07/01/2014
 */
public class RecurringBillListRequest extends Request {

	/** The class serial version */
	private static final long serialVersionUID = 1;

	/*
	 * (non-Javadoc)
	 * @see com.payu.sdk.model.request.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants.Resources.RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl, RequestMethod requestMethod) {
		return String.format(Resources.ENTITY_API_URL_PATTERN,
				baseUrl, Resources.PAYMENT_PLAN_VERSION,
				Resources.URI_RECURRING_BILL+this.getQueryString());
	}
}