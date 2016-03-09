package com.payu.sdk.exceptions;

/**
 * The PayU SDK basic exception
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public class PayUException extends SDKException {

	/**
	 * The class serial version
	 */
	private static final long serialVersionUID = 1L;

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
	public PayUException(ErrorCode errorCode, String message,
			Exception innerException) {

		super(errorCode, message, innerException);
	}

	/**
	 * The exception constructor
	 * 
	 * @param errorCode
	 *            the exception's error code
	 * @param message
	 *            the exception's message
	 */
	public PayUException(ErrorCode errorCode, String message) {

		super(errorCode, message);

	}

	/**
	 * The exception constructor
	 * 
	 * @param errorCode
	 *            the exception's error code
	 * @param innerException
	 *            the exception that will be embedded
	 */
	public PayUException(ErrorCode errorCode, Exception innerException) {

		super(errorCode, innerException);

	}

}
