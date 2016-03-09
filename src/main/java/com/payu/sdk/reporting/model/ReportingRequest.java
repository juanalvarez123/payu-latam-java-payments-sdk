package com.payu.sdk.reporting.model;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.payu.sdk.model.request.CommandRequest;
import com.payu.sdk.utils.xml.MapDetailsAdapter;

/**
 * Represents a concrete reporting request in the PayU SDK. This class holds all
 * the payment transaction information.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportingRequest extends CommandRequest {

	/** The generated serial version Id */
	private static final long serialVersionUID = 8785742346784456309L;
	
	/** The details of the reporting request */
	@XmlJavaTypeAdapter(MapDetailsAdapter.class)
	private Map<String, Object> details;

	/**
	 * Returns the details
	 * 
	 * @return the details
	 */
	public Map<String, Object> getDetails() {
		return details;
	}

	/**
	 * Sets the details map
	 * 
	 * @param details
	 *            the details to set
	 */
	public void setDetails(Map<String, Object> details) {
		this.details = details;
	}
}
