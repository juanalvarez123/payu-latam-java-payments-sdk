package com.payu.sdk.model;

/**
 * Enum representing the pending reasons for a transaction in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum TransactionPendingReason {

	/** 
	 * Used when a Transaction is waiting for a notification.
	 */
	AWAITING_NOTIFICATION,
	/**
	 * Used when a Transaction is waiting for a review.
	 */
	PENDING_REVIEW,
	/**
	 * Used when a Transaction is waiting for a transmission.
	 */
	PENDING_TRANSMISSION
	
}
