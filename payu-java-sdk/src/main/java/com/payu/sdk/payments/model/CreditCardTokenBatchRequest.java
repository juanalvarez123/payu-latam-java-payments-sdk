package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlElement;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.model.request.Request;

/**
 * Represents a concrete credit card token batch in the PayU SDK. This class
 * holds all the payment transaction information.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 * 
 */
public class CreditCardTokenBatchRequest extends Request {

	/** The generated serial version Id */
	private static final long serialVersionUID = -7136953977839080063L;
	/** The file content */
	@XmlElement(required = true)
	private String contentFile;

	/**
	 * Returns the file content
	 * 
	 * @return the file content
	 */
	public String getContentFile() {
		return contentFile;
	}

	/**
	 * Sets the file content
	 * 
	 * @param contentFile
	 *            the content to set
	 */
	public void setContentFile(String contentFile) {
		this.contentFile = contentFile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payu.sdk.model.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants#RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl,
			RequestMethod requestMethod) {

		switch (requestMethod) {
		case POST:
			return String.format("%s%s", baseUrl, Resources.DEFAULT_API_URL);
		default:
			return String.format("%s%s", baseUrl, Resources.DEFAULT_API_URL);
		}

	}

}
