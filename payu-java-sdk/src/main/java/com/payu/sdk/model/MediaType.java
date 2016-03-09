package com.payu.sdk.model;

/**
 * Enum representing the file media type in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum MediaType {

	/**
	 * Media Type for XML Files
	 */
	XML("application/xml");
	
	/**
	 * Mime Type code for the Media Type
	 */
	private String code;
	
	/**
	 * Constructor for the Media Type
	 * Creates a new Media Type with the given mime type code
	 * 
	 * @param code the mime type code
	 */
	private MediaType(String code) {
		this.code = code;
	}

	/**
	 * Returns the mime type code for the Media Type
	 * 
	 * @return the mime type code
	 */
	public String getCode() {
		return code;
	}
	
}
