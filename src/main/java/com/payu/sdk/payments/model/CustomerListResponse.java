package com.payu.sdk.payments.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.response.Response;
import com.payu.sdk.paymentplan.model.Customer;

/**
 * Represents a customer list response in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.1.1
 * @version 1.1.1, 11/06/2014
 */
@XmlRootElement(name = "customerListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerListResponse extends Response {

	/** The generated serial version Id */
	private static final long serialVersionUID = 1L;
	
	/** The result list */
	@XmlElementWrapper(name = "customers")
	@XmlElement(name = "customer")
	private List<Customer> customerList;

	/**
	 * Returns the customer list
	 * 
	 * @return the customerList
	 */
	public List<Customer> getCustomerList() {
		return customerList;
	}

	/**
	 * Sets the customer list
	 * 
	 * @param customerList to set
	 */
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	/**
	 * Maps the xml string of a customer list response to the object
	 * 
	 * @param xml The object in a xml format
	 * @return The java object
	 * @throws PayUException
	 */
	public static CustomerListResponse fromXml(String xml)
			throws PayUException {

		return (CustomerListResponse) fromBaseXml(new CustomerListResponse(), xml);
	}

}
