package com.payu.sdk.model;

/**
 * Enum representing a transaction type in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum TransactionType {

	/** Only authorization transaction. */
	AUTHORIZATION,

	/** Authorization and capture transaction. */
	AUTHORIZATION_AND_CAPTURE,

	/** Only capture transaction. */
	CAPTURE,

	/** Cancel transaction. */
	CANCELLATION,

	/** Void transaction. */
	VOID,

	/** Refund transaction. */
	REFUND,

	/** Credit transaction. */
	CREDIT

}
