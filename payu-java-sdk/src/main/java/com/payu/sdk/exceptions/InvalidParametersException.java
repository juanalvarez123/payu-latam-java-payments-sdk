package com.payu.sdk.exceptions;

/**
 * The invalid parameters exception
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public class InvalidParametersException extends SDKException {

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
	public InvalidParametersException(Exception innerException) {

		super(ErrorCode.INVALID_PARAMETERS, innerException);

	}

	/**
	 * Default constructor
	 */
	public InvalidParametersException() {

		super(ErrorCode.INVALID_PARAMETERS);

	}

	/**
	 * Default constructor with message
	 * 
	 * @param message
	 *            the exception's message
	 */
	public InvalidParametersException(String message) {

		super(ErrorCode.INVALID_PARAMETERS, message);

	}

	/**
	 * Default constructor with message and exception
	 * 
	 * @param message
	 *            the exception's message
	 * @param innerException
	 *            the exception that will be embedded
	 */
	public InvalidParametersException(String message, Exception innerException) {

		super(ErrorCode.INVALID_PARAMETERS, message, innerException);

	}

}
