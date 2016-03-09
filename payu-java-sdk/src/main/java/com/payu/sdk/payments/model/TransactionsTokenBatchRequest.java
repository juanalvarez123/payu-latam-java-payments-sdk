package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Represents a concrete transaction with token batch request in the PayU SDK. This
 * class holds all the payment transaction information.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public class TransactionsTokenBatchRequest {

	/** The file content */
	@XmlElement(required = true)
	private String contentFile;

	/**
	 * Returns the file content
	 * 
	 * @return The file content
	 */
	public String getContentFile() {
		return contentFile;
	}

	/**
	 * Sets the file content
	 * 
	 * @param contentFile
	 *            The file content
	 */
	public void setContentFile(String contentFile) {
		this.contentFile = contentFile;
	}

}
