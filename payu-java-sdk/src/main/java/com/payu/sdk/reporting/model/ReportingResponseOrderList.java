package com.payu.sdk.reporting.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.response.Response;
import com.payu.sdk.utils.JaxbUtil;

/**
 * Represents a order list response in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "reportingResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportingResponseOrderList extends Response {

	/** The generated serial version Id */
	private static final long serialVersionUID = 373502511893869080L;
	/** The reporting result order list sent by the server */
	@XmlElement(required = false)
	private ReportingResultOrderList result;

	/**
	 * Returns the result
	 * 
	 * @return the result
	 */
	public ReportingResultOrderList getResult() {
		return result;
	}

	/**
	 * Sets the result
	 * 
	 * @param result
	 *            the report to set
	 */
	public void setResult(ReportingResultOrderList result) {
		this.result = result;
	}

	/**
	 * Converts a xml string into a reporting response order list object
	 * 
	 * @param xml
	 *            The object in a xml format
	 * @return The reporting response order list object
	 * @throws PayUException
	 */
	public static ReportingResponseOrderList fromXml(String xml)
			throws PayUException {

		return JaxbUtil.convertXmlToJava(ReportingResponseOrderList.class, xml);
	}

}
