package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.PaymentMethodApi;
import com.payu.sdk.model.response.Response;

/**
 * <p>
 * 	Represents a payment method response in the PayU SDK
 * </p>
 * @author <a href="fernando.moreno@payulatam.com">Fernando Moreno</a>
 * @date 5/09/2014
 */
@XmlRootElement(name = "paymentMethodAvailable")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethodResponse extends Response{
	
	/** The class serial version */
	private static final long serialVersionUID = -4494494959180453709L;
	
	/**Represent the payment method of the API*/
	@XmlElement(name = "paymentMethod")
	private PaymentMethodApi paymentMethod;

	/**
	 * Returns the payment method 
	 * @return
	 */
	public PaymentMethodApi getPaymentMethod() {
		return paymentMethod;
	}
	
	/**
	 * Sets the payment method 
	 * @param paymentMethod
	 */
	public void setPaymentMethod(PaymentMethodApi paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	/**
	 * Converts a xml string into a payment Method Available response object
	 * 
	 * @param xml
	 *            The object in a xml format
	 * @return The payment response object
	 * @throws PayUException
	 */
	public static PaymentMethodResponse fromXml(String xml) throws PayUException {

		return (PaymentMethodResponse) fromBaseXml(new PaymentMethodResponse(), xml);

	}
}
