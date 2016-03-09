package com.payu.sdk.payments.model;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.model.request.Request;

/**
 * Customer representation List
 * 
 * @author PayU Latam
 * @since 1.1.1
 * @version 1.1.1, 06/06/2014
 */
public class CustomerListRequest extends Request {
	
	/** The generated serial version Id */
	private static final long serialVersionUID = 2345236232134235231L;
	
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
				Resources.URI_CUSTOMERS+ this.getQueryString());
	}

}
