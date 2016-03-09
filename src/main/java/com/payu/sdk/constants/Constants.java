package com.payu.sdk.constants;

/**
 * Holds all SDK constants
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public interface Constants {

	/**
	 * Default encoding format for the http connection
	 */
	String DEFAULT_ENCODING = "UTF-8";

	/**
	 * Empty string value
	 */
	String EMPTY_STRING = "";

	/**
	 * Space string value
	 */
	String SPACE_STRING = " ";

	/**
	 * Line break string value
	 */
	String LINE_BREAK = "\n";
	
	/**
	 * The Api request default date format
	 */
	String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	/**
	 * The Api request secundary date format
	 */
	String SECUNDARY_DATE_FORMAT = "yyyy/MM";

	/**
	 * The Api request default date format without hour
	 */
	String DEFAULT_DATE_WITHOUT_HOUR_FORMAT = "yyyy-MM-dd";

	/**
	 * SSL security provider
	 */
	String SSL_PROVIDER = "TLS";

	/**
	 * The line separator system property
	 */
	String LINE_SEPARATOR = System.getProperty("line.separator");

	/**
	 * The default HTTPS port to use
	 */
	int HTTPS_PORT = 443;

	/**
	 * The plan value variable
	 */
	String PLAN_VALUE = "PLAN_VALUE";

	/**
	 * The plan tax variable
	 */
	String PLAN_TAX = "PLAN_TAX";

	/**
	 * The plan tax return base variable
	 */
	String PLAN_TAX_RETURN_BASE = "PLAN_TAX_RETURN_BASE";

	/**
	 * The item value variable
	 */
	String ITEM_VALUE = "ITEM_VALUE";

	/**
	 * The item tax variable
	 */
	String ITEM_TAX = "ITEM_TAX";

	/**
	 * The item tax return base variable
	 */
	String ITEM_TAX_RETURN_BASE = "ITEM_TAX_RETURN_BASE";
}
