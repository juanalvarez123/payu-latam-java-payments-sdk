package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.response.Response;
import com.payu.sdk.utils.JaxbUtil;

/**
 * Represents a transaction transaction with token batch response in the PayU
 * SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public class TransactionsTokenBatchResponse extends Response {

	/** The generated serial version Id */
	private static final long serialVersionUID = 5674953349886166616L;
	/** The id of the token bath */
	@XmlElement(required = false)
	private String id;

	/**
	 * Returns the id
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Converts a xml string into a transactions token batch response object
	 * 
	 * @param xml
	 *            The object in a xml format
	 * @return The transactions token batch response object
	 * @throws PayUException
	 */
	public static TransactionsTokenBatchResponse fromXml(String xml)
			throws PayUException {

		return JaxbUtil.convertXmlToJava(TransactionsTokenBatchResponse.class,
				xml);
	}

}