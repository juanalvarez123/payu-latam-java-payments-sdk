package com.payu.sdk.model;

/**
 * Enum representing a transaction state in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum TransactionState {

	/** Approved transaction */
	APPROVED("4"),
	/** Declined transaction */
	DECLINED("6"),
	/** Error in transaction */
	ERROR("104"),
	/** Pending transaction */
	PENDING("7"),
	/** Expired transaction */
	EXPIRED("5"),
	/** Submitted transaction */
	SUBMITTED("103");
	
	/**
	 * The transaction state code.
	 */
	private String code;
	
	/**
	 * Sets the transaction state code.
	 * 
	 * @param code the transaction state code to set.
	 */
	private TransactionState(String code) {
		this.code = code;
	}
	
	/**
	 * Returns the transaction state code.
	 * 
	 * @return the transaction state code.
	 */
	public String getCode() {
		return code;
	}
	
}
