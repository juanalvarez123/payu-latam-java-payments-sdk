package com.payu.sdk.model;

/**
 * Enum representing a payment country in the PayU SDK. Sometimes when a payment
 * method is processed by several countries is necessary to specify the country
 * due currency issues.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum PaymentCountry {

	/**
	 * When the payment country is Argentina.
	 */
	AR,
	/**
	 * When the payment country is Brazil.
	 */
	BR,
	/**
	 * When the payment country is Chile.
	 */
	CL,
	/**
	 * When the payment country is Colombia.
	 */
	CO,
	/**
	 * When the payment country is Mexico.
	 */
	MX,
	/**
	 * When the payment country is Panama.
	 */
	PA,
	/**
	 * When the payment country is Peru.
	 */
	PE,
	/**
	 * When the payment country is United States.
	 */
	US

}
