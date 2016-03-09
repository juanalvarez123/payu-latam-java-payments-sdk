/**
 * 
 */
package com.payu.sdk.util;

/**
 * @author oscar.romero
 *
 */
/**
 * Some possible credit cards to be used in the tests
 * 
 */
public enum CreditCards {

	// Colombian Visa
	VISA("4005580000029205", "2017/01", "495"),

	// Panama Visa
	VISA_PA("4111111111111111", "2017/01", "123"),

	// Amex
	AMEX("378263031085366", "2017/01", "1234"),

	// Discover
	DISCOVER("6011954843652373", "2017/01", "123"),

	// Master card
	MASTERCARD("5156187105437715", "2017/01", "123"),

	// Diners
	DINERS("30039546070543", "2017/01", "123"),

	// ELO
	ELO("4462784368283422", "2017/01", "123"),
	
	//CENCOSUD
	CENCOSUD("6034932224222422", "2017/01", "495");

	/**
	 * Credit card number
	 */
	private String creditCardNumber;

	/**
	 * Credit card expiration date
	 */
	private String expirationDate;

	/**
	 * credit card security code
	 */
	private String securityCode;

	/**
	 * The credit card constructor
	 * 
	 * @param creditCardNumber
	 *            The credit card's number
	 * @param expirationDate
	 *            The credit card's expiration date
	 * @param securityCode
	 *            The credit card's security code
	 */
	CreditCards(String creditCardNumber, String expirationDate,
			String securityCode) {
		this.creditCardNumber = creditCardNumber;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
	}

	/**
	 * @return the credit card number
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * @return the expirationDate
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @return the securityCode
	 */
	public String getSecurityCode() {
		return securityCode;
	}

}
