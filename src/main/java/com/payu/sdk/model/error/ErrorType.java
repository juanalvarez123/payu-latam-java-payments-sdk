package com.payu.sdk.model.error;

/**
 * Enum representing the error types in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public enum ErrorType {

	/**
	 * Bad request: <br>
	 * The request can not be parsed (Malformed request).
	 */
	MALFORMED_REQUEST,

	/**
	 * Not found: <br>
	 * If the requested content was not found on the server or there is
	 * no controller able to process the requested URI.
	 */
	NOT_FOUND,

	/**
	 * Bad request: <br>
	 * Errors arise when the client request has invalid parameters.
	 */
	BAD_REQUEST,

	/**
	 * Internal server error: <br>
	 * Any type of error that is not included in the previous types
	 */
	INTERNAL_SERVER_ERROR,

	/**
	 * Authorization Error
	 */
	UNAUTHORIZED

}
