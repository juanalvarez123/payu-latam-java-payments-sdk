package com.payu.sdk.constants;

/**
 * Holds REST API Constants and Resources
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public interface Resources {

	/**
	 * The API request methods
	 */
	enum RequestMethod {
		/** The get request method. */
		GET,
		/** The post request method. */
		POST,
		/** The delete request method. */
		DELETE,
		/** The put request method. */
		PUT
	}

	// ---------------------------------------------
	// URL (Named) Parameters identifiers
	// ---------------------------------------------

	/**
	 * API Version 4.3
	 */
	String V4_3 = "v4.3";

	/**
	 * API Version 4.0
	 */
	String V4_0 = "4.0";

	/**
	 * Payment Plan Current Version
	 */
	String PAYMENT_PLAN_VERSION = V4_3;

	/**
	 * Default API Current Version
	 */
	String CURRENT_API_VERSION = V4_0;

	// ---------------------------------------------
	// URL (Named) Parameters identifiers
	// ---------------------------------------------

	/**
	 * Default API URI
	 */
	String DEFAULT_API_URL = CURRENT_API_VERSION + "/service.cgi";

	/**
	 * Default entity API URI pattern
	 */
	String ENTITY_API_URL_PATTERN = "%srest/%s/%s";

	/**
	 * Default parameterized entity API URI pattern
	 */
	String PARAM_ENTITY_API_URL_PATTERN = "%srest/%s/%s/%s";
	
	/**
	 * Dependent entity API URI pattern
	 */
	String DEPENDENT_ENTITY_API_URL_PATTERN = "%srest/%s/%s/%s/%s";
	
	/**
	 * Dependent parameterized entity API URI pattern
	 */
	String DEPENDENT_PARAM_ENTITY_API_URL_PATTERN = "%srest/%s/%s/%s/%s/%s";

	/**
	 * Plans Operations URI
	 */
	String URI_PLANS = "plans";

	/**
	 * Subscription URI
	 */
	String URI_SUBSCRIPTIONS = "subscriptions";

	/**
	 * Recurring bill items URI
	 */
	String URI_RECURRING_BILL_ITEMS = "recurringBillItems";

	/**
	 * Recurring bill item URI
	 */
	String URI_RECURRING_BILL = "recurringBill";

	/**
	 * Customers item URI
	 */
	String URI_CUSTOMERS = "customers";

	/**
	 * Credit Card's item URI
	 */
	String URI_CREDIT_CARDS = "creditCards";

	/**
	 * Bank accounts item URI
	 */
	String URI_BANK_ACCOUNTS = "bankAccounts";

}
