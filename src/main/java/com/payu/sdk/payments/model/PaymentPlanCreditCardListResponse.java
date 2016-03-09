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
import com.payu.sdk.paymentplan.model.PaymentPlanCreditCard;
/**
 * Credit card representation List
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 10/06/2013
 */
@XmlRootElement(name = "creditCardListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentPlanCreditCardListResponse extends Response    {

	
	private static final long serialVersionUID = 7195986427376989864L;
	
	/** The credit card item list */
	@XmlElementWrapper(name = "creditCards")
	@XmlElement(name = "creditCard")
	private List<PaymentPlanCreditCard> creditCards;
	
	/**
	 * Return the Credit Cards  list	
	 * @return the Credit Cards representation List
	 */
	public List<PaymentPlanCreditCard> getCreditCards() {
		return creditCards;
	}
 

	/**
	 * Maps the xml of a credit card token list response to the object
	 * 
	 * @param xml
	 *            The object in a xml format
	 * @return The java object
	 * @throws PayUException
	 */
	public static PaymentPlanCreditCardListResponse fromXml(String xml)
			throws PayUException {

		return (PaymentPlanCreditCardListResponse) fromBaseXml(
				new PaymentPlanCreditCardListResponse(), xml);
	}
	
	/** 
	 * Set the Credit Cards  list
	 * @param creditCardList
	 */
	public void setCreditCardList(
			List<PaymentPlanCreditCard> creditCards) {
		this.creditCards = creditCards;
	}


}
