package com.payu.sdk.model;

/**
 * Enum representing a order cancellation code in the PayU SDK.
 * 
 * This code must be setted when the status of an order is
 * {@link OrderStatus#CANCELLED} or {@link OrderStatus#REFUNDED}.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public enum OrderCancellationCode {

	/** The order expired. */
	EXPIRED,
	/** Could not verify the order and can probably be a fraud. */
	UNABLE_TO_VERIFY,
	/** The merchant requested to cancel the order. */
	REQUESTED_BY_MERCHANT,
	/** The buyer requested to cancel the order. */
	REQUESTED_BY_BUYER,
	/** The order is fraudulent and must not be processed anymore. */
	FRAUDULENT,
	/** The order was disputed by the buyer. */
	DISPUTED

}
