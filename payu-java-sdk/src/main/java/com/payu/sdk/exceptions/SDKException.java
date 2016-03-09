package com.payu.sdk.exceptions;

/**
 * The PayU SDK generic exception
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public class SDKException extends Exception {

	/**
	 * The class serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The exception error code.
	 * @see ErrorCode
	 */
	private ErrorCode errorCode;

	/**
	 * The exception constructor
	 * 
	 * @param errorCode
	 *            the exception's error code
	 * @param message
	 *            the exception's message
	 * @param innerException
	 *            the exception that will be embedded
	 */
	public SDKException(ErrorCode errorCode, String message,
			Exception innerException) {

		super(message, innerException);
		this.errorCode = errorCode;
	}

	/**
	 * The exception constructor
	 * 
	 * @param errorCode
	 *            the exception's error code
	 * @param message
	 *            the exception's message
	 */
	public SDKException(ErrorCode errorCode, String message) {

		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * The exception constructor
	 * 
	 * @param errorCode
	 *            the exception's error code
	 * @param innerException
	 *            the exception that will be embedded
	 */
	public SDKException(ErrorCode errorCode, Exception innerException) {

		super(innerException);
		this.errorCode = errorCode;
	}

	/**
	 * Returns the api error code
	 * 
	 * @param errorCode
	 *            the exception's error code
	 */
	public SDKException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Returns the error code
	 * 
	 * @return the errorCode
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	/**
	 * The types of Error codes to use inside a SDK Exception.
	 */
	public enum ErrorCode {

		/** Error associated to a problem serializing an object. */
		XML_SERIALIZATION_ERROR,
		/** Error associated to a problem deserializing an object. */
		XML_DESERIALIZATION_ERROR,
		/** Error associated to an invalid parameter sent. */
		INVALID_PARAMETERS,
		/** Error associated to a connection problem with the server. */
		CONNECTION_EXCEPTION,
		/** Error associated to an internal API error. */
		API_ERROR,
		/** Error associated to an no found entity. */
		NO_RESULTS_FOUND		
	}
}
