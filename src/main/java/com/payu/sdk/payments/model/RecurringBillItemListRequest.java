/**
 * PayU Latam
 * Date: 09/06/2014
 */
package com.payu.sdk.payments.model;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.model.request.Request;
/**
 * Recurrent Bill Items representation List
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 10/06/2013
 */
public class RecurringBillItemListRequest extends Request    {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7785916427895469864L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payu.sdk.model.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants#RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl,
			RequestMethod requestMethod) {
		return String.format(Resources.ENTITY_API_URL_PATTERN,
				baseUrl, Resources.PAYMENT_PLAN_VERSION,
				Resources.URI_RECURRING_BILL_ITEMS+this.getQueryString());
	}



}
