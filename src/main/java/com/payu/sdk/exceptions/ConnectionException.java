package com.payu.sdk.exceptions;

/**
 * The PayU SDK connection exception
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public class ConnectionException extends SDKException {

	/**
	 * The class serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Exception Constructor
	 * 
	 * @param innerException
	 *            the exception that will be embedded
	 */
	public ConnectionException(Exception innerException) {

		super(ErrorCode.CONNECTION_EXCEPTION, innerException);

	}

	/**
	 * Default constructor
	 */
	public ConnectionException() {

		super(ErrorCode.CONNECTION_EXCEPTION);

	}

	/**
	 * Default constructor with message
	 * 
	 * @param message
	 *            the exception's message
	 */
	public ConnectionException(String message) {

		super(ErrorCode.CONNECTION_EXCEPTION, message);

	}

	/**
	 * Default constructor with message and exception
	 * 
	 * @param message
	 *            the exception's message
	 * @param innerException
	 *            the exception that will be embedded
	 */
	public ConnectionException(String message, Exception innerException) {

		super(ErrorCode.CONNECTION_EXCEPTION, message, innerException);

	}

}
