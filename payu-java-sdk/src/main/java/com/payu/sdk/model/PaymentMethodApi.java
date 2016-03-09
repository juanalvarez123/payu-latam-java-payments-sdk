package com.payu.sdk.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 	Represents a payment method in the PayU SDK consulted from API.
 * </p>
 * @author <a href="fernando.moreno@payulatam.com">Fernando Moreno</a>
 * @date 8/09/2014
 */
@XmlRootElement(name = "paymentMethod")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethodApi implements Serializable{

	/** The generated serial version Id */
	private static final long serialVersionUID = 6624302145435210417L;

	/** The payment method description. */
	@XmlElement(required=true)
	private String name;
	
	/**
	 * The type of the payment method.
	 */
	@XmlElement(required=true)
	private PaymentMethodType type;
	
	
	/**
	 * Default constructor
	 * 
	 * @param type the payment method type
	 */	
	public PaymentMethodApi() {
		super();
	}

	/**
	 * constructor with params
	 * 
	 * @param type the payment method type
	 */
	public PaymentMethodApi(String description, PaymentMethodType type) {
		this.type = type;
	}
	
	/**
	 * Returns the name of the payment method.
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 *  Sets the name of the payment method.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the type of the payment method.
	 * 
	 * @return the type of the payment method.
	 */
	public PaymentMethodType getType() {
		return type;
	}

	/**
	 * Sets the type of the payment method.
	 * @param type
	 */
	public void setType(PaymentMethodType type) {
		this.type = type;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"PaymentMethodApi [name=%s, type=%s]",
				name, type);
	}
	
}
