package com.payu.sdk.model.request;

/**
 * Represents a command in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum Command {

	//common
	/** Makes a ping to the server testing connectivity. */
	PING,
	
	//payments service
	/** Sends a transaction to process. */
	SUBMIT_TRANSACTION,
	
	/** Returns the active payment methods for a merchant. */
	GET_PAYMENT_METHODS,
	
	/**Return the Payment Method Availability*/
	GET_PAYMENT_METHOD_AVAILABILITY,
	
	//payments service
	/** Returns the active banks. */
	GET_BANKS_LIST,
	
	// Credit card token
	/** Create token */
	CREATE_TOKEN,
	/** Remove token */
	REMOVE_TOKEN,
	/** Create batch tokens */
	CREATE_BATCH_TOKENS,
	/** Process the batch of transactions with tokens */
	PROCESS_BATCH_TRANSACTIONS_TOKEN,
	
	//reporting service
	/** Returns an order detail report. */
	ORDER_DETAIL,
	/** Returns a transaction detail report. */
	TRANSACTION_RESPONSE_DETAIL,
	/** Returns all orders with matching reference code. */
	ORDER_DETAIL_BY_REFERENCE_CODE,
	// reporting batch token
	/** Search batch credit card token. */
	BATCH_CREDIT_CARD_TOKEN,
	
	//Find token by payer
	/** Finds all tokens by payer. */
	GET_TOKENS
	
}
