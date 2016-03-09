/**
 * PayU Latam
 * Date: 09/06/2014
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
import com.payu.sdk.paymentplan.model.RecurringBillItem;
/**
 * recurring bill item representation List
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 10/06/2013
 */
@XmlRootElement(name = "recurringBillItemListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class RecurringBillItemListResponse extends Response    {
	
	private static final long serialVersionUID = 7195986427376989864L;
	
	/** The recurring bill item list */
	@XmlElementWrapper(name = "recurringBillItems")
	@XmlElement(name = "recurringBillItem")
	private List<RecurringBillItem> recurringBillItems;
	
	/**
	 * Return the Recurring Bill Items  list	
	 * @return the Recurring Bill Items representation List
	 */
	public List<RecurringBillItem> getRecurringBillItems() {
		return recurringBillItems;
	}
 

	/**
	 * Maps the xml of the recurring bill item list response to the object
	 * 
	 * @param xml
	 *            The object in a xml format
	 * @return The java object
	 * @throws PayUException
	 */
	public static RecurringBillItemListResponse fromXml(String xml)
			throws PayUException {
		return (RecurringBillItemListResponse) fromBaseXml(
				new RecurringBillItemListResponse(), xml);
	}
	
	/** 
	 * Set the Recurring Bill Item  list
	 * @param recurringBillItems
	 */
	public void setRecurringBillItems(
			List<RecurringBillItem> recurringBillItems) {
		this.recurringBillItems = recurringBillItems;
	}


}
