package com.payu.sdk.model;

/**
 * Enum representing an error code for transactions in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum TransactionErrorCode {

	/** Error associated with an internal problem in the server */
	INTERNAL_ERROR("9999"),
	/** Error associated with not having response from the server */
	ENTITY_NO_RESPONSE("9996"),
	/** Error associated with a bad response from the payment network */
	PAYMENT_NETWORK_BAD_RESPONSE("100"),
	/** Error associated with a connection failure with the payment network */
	PAYMENT_NETWORK_NO_CONNECTION("101"),
	/** Error associated with not having response from the payment network */
	PAYMENT_NETWORK_NO_RESPONSE("102");
	
	/**
	 * The transaction error code.
	 */
	private String code;
	
	/**
	 * Sets the transaction error code.
	 * 
	 * @param code the transaction error code to set.
	 */
	private TransactionErrorCode(String code) {
		this.code = code;
	}
	
	/**
	 * Returns the transaction error code.
	 * 
	 * @return the transaction error code.
	 */
	public String getCode() {
		return code;
	}
	
}
