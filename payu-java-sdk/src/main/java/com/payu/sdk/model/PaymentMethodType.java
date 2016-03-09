package com.payu.sdk.model;

/**
 * Enum representing a payment method type in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum PaymentMethodType {

	/**
	 * Payment with credit card.
	 */
	CREDIT_CARD(2, "CREDIT_CARD"),

	/**
	 * Payment using PSE.
	 */
	PSE(4, "PSE"),

	/**
	 * Cash Payment 
	 */
	CASH(7, "CASH"),

	/**
	 * Referenced payment.
	 */
	REFERENCED(8, "REFERENCED"),
	
	/**
	 * Payment with check account.
	 */
	CHECK_ACCOUNT(1, "CHECK_ACCOUNT"),
	
	/**
	 * Payment using verified by visa.
	 */
	VERIFIED_BY_VISA(3, "VERIFIED_BY_VISA"),
	
	/**
	 * Payment using ACH.
	 */
	ACH(5, "ACH"),
	
	/**
	 * Payment using debit card.
	 */
	DEBIT_CARD(6, "DEBIT_CARD"),
	
	/**
	 * Payment with Special card.
	 */
	SPECIAL_CARD(9, "SPECIAL_CARD");
	
	/**
	 * The payment method identifier.
	 */
	private Integer id;
	
	/** The payment method description. */
	private String description;

	/**
	 * The constructor which receives all the enum data.
	 * 
	 * @param id The payment Method type id.
	 * @param description The payment Method type description.
	 */
	private PaymentMethodType(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	/**
	 * Returns the payment method type identifier.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Returns the payment method type description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
}
