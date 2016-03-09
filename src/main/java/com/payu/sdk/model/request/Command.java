/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 developers-payu-latam
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
