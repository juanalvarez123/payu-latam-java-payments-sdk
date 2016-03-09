package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.model.request.CommandRequest;

/**
 * <p>
 * 	Represents a payment method request in the PayU SDK.
 * </p>
 * @author <a href="fernando.moreno@payulatam.com">Fernando Moreno</a>
 * @date 5/09/2014
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethodRequest extends CommandRequest {

	/** The generated serial version Id */
	private static final long serialVersionUID = -2023556452232177400L;
	
	/** The payment Method */
	@XmlElement(required = false)
	private String paymentMethod;
	
	/**
	 * Return the payment method
	 * @return
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Sets the payment method
	 * @param paymentMethod
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
