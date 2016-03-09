/**
 * PayU Latam
 * Date: 07/01/2014
 */
package com.payu.sdk.payments.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.response.Response;
import com.payu.sdk.paymentplan.model.RecurringBill;

/**
 * Recurring bill list representation.
 * 
 * @author PayU Latam
 * @since 1.1.1
 * @version 1.1.1, 07/01/2014
 */
@XmlRootElement(name = "recurringBillListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class RecurringBillListResponse extends Response {

	/** The class serial version */
	private static final long serialVersionUID = 1L;

	/** The recurring bill list */
	@XmlElementWrapper(name = "recurringBills")
	@XmlElement(name = "recurringBill")
	private List<RecurringBill> recurringBills;

	/**
	 * Return the Recurring Bills.
	 * 	
	 * @return the {@link RecurringBill} List representation.
	 */
	public List<RecurringBill> getRecurringBills() {
		return recurringBills;
	}
 
	/**
	 * Maps the xml of the recurring bill list response to the object.
	 * 
	 * @param xml The object in a xml format
	 * @return The java object
	 * @throws PayUException
	 */
	public static RecurringBillListResponse fromXml(String xml) throws PayUException {
		return (RecurringBillListResponse) fromBaseXml(new RecurringBillListResponse(), xml);
	}

	/**
	 * Set the Recurring Bill list.
	 * 
	 * @param recurringBills Recurring Bill list to set.
	 */
	public void setRecurringBills(List<RecurringBill> recurringBills) {
		this.recurringBills = recurringBills;
	}
}