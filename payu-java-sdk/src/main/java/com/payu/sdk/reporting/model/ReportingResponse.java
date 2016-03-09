package com.payu.sdk.reporting.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.response.Response;

/**
 * Represents a concrete reporting response in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "reportingResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportingResponse extends Response {

	/** The generated serial version Id */
	private static final long serialVersionUID = -5425109306677736362L;
	/** The reporting result sent by the server */
	@XmlElement(required = false)
	private ReportingResult result;

	/**
	 * Returns the result
	 * 
	 * @return the result
	 */
	public ReportingResult getResult() {
		return result;
	}

	/**
	 * Sets the result
	 * 
	 * @param result
	 *            the report to set
	 */
	public void setResult(ReportingResult result) {
		this.result = result;
	}

	/**
	 * Converts a xml string into a reporting response object
	 * 
	 * @param xml
	 *            The object in a xml format
	 * @return The reporting response object
	 * @throws PayUException
	 */
	public static ReportingResponse fromXml(String xml) throws PayUException {

		return (ReportingResponse) fromBaseXml(new ReportingResponse(), xml);
	}

}