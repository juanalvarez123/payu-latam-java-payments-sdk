package com.payu.sdk.reporting.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.model.Order;

/**
 * Represents a order list result in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportingResultOrderList implements Serializable {

	/** The generated serial version Id */
	private static final long serialVersionUID = 4667244283136969734L;
	/** The list of orders of the result */
	@XmlElementWrapper(name = "payload")
	@XmlElement(name = "order")
	private List<Order> payload;

	/**
	 * Returns the list of orders
	 * 
	 * @return the payLoad
	 */
	public List<Order> getPayload() {
		return payload;
	}

	/**
	 * Sets the list of orders
	 * 
	 * @param payLoad
	 *            the payLoad to set
	 */
	public void setPayload(List<Order> payload) {
		this.payload = payload;
	}

}
