package com.payu.sdk.reporting.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.payu.sdk.utils.xml.PayloadAdapter;

/**
 * Represents a reporting result in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportingResult {

	/** The content of the result */
	@XmlAnyElement
	@XmlJavaTypeAdapter(PayloadAdapter.class)
	private Object payload;

	/**
	 * Returns the payload
	 * 
	 * @return the payLoad
	 */
	public Object getPayload() {
		return payload;
	}

	/**
	 * Sets the payload
	 * 
	 * @param payLoad
	 *            the payLoad to set
	 */
	public void setPayload(Object payLoad) {
		this.payload = payLoad;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReportingResult [payload=" + payload + "]";
	}

}
