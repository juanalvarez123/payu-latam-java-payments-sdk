package com.payu.sdk.model;

/**
 * Enum representing an order status in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum OrderStatus {

	/**
	 * Status for an order recently created.
	 */
	NEW,
	
	/**
	 * Status for an order being processed.
	 */
	IN_PROGRESS,
	
	/**
	 * Status for an authorized order.
	 */
	AUTHORIZED,
	
	/**
	 * Status for a captured order.
	 */
	CAPTURED,
	
	/**
	 * Status for an order that was cancelled.
	 */
	CANCELLED,
	
	/**
	 * Status for an order that was declined.
	 */
	DECLINED,
	
	/**
	 * Status for a refunded order.
	 */
	REFUNDED
	
}
