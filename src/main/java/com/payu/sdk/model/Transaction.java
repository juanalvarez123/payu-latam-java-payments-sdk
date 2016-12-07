/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 developers-payu-latam
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.payu.sdk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.payu.sdk.exceptions.InvalidParametersException;
import com.payu.sdk.utils.xml.DateAdapter;
import com.payu.sdk.utils.xml.MapAdditionalValueAdapter;
import com.payu.sdk.utils.xml.MapExtraParameterAdapter;

/**
 * Represents a transaction in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction implements Serializable {

	/** The generated serial version Id */
	private static final long serialVersionUID = -6954674089900251114L;
	/** The transaction order */
	@XmlElement(required = false)
	private Order order;
	/** The transaction credit card */
	@XmlElement(required = false)
	private CreditCard creditCard;
	@XmlElement(required = false)
	/** The transaction debit card */
	private DebitCard debitCard;
	/** The transaction credit card swipe */
	@XmlElement(required = false)
	private CreditCardSwipe creditCardSwipe;
	// Token stuff
	/** The transaction credit card token id */
	@XmlElement(required = false)
	private String creditCardTokenId;
	/** If the transaction credit card token was created */
	@XmlElement(required = false)
	private Boolean createCreditCardToken;
	/** The transaction type */
	@XmlElement(required = false)
	private TransactionType type;
	/** The transaction parent id */
	@XmlElement(required = false)
	private String parentTransactionId;
	/** The transaction payment method */
	@XmlElement(required = false)
	private String paymentMethod;

	/** The transaction source */
	@XmlElement(required = false)
	private TransactionSource source;
	/** The transaction payment country */
	@XmlElement(required = false)
	private PaymentCountry paymentCountry;
	/** The transaction response */
	@XmlElement(required = false)
	private TransactionResponse transactionResponse;

	/** The transaction payer. */
	@XmlElement(required = false)
	private Payer payer;

	/** The transaction device session id */
	@XmlElement(required = false)
	private String deviceSessionId;
	/** The buyer IP address. */
	@XmlElement(required = false)
	private String ipAddress;
	/** The browser cookie. */
	@XmlElement(required = false)
	private String cookie;
	/** The browser user agent. */
	@XmlElement(required = false)
	private String userAgent;
	/** The expiration date of the transaction. */
	@XmlElement(required = false)
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date expirationDate;

	/** The map of the values. */
	@XmlJavaTypeAdapter(MapAdditionalValueAdapter.class)
	private Map<String, AdditionalValue> additionalValues;

	/** The extra parameters. */
	@XmlJavaTypeAdapter(MapExtraParameterAdapter.class)
	private Map<String, String> extraParameters;

	/** the related transaction id. */
	@XmlElement(required = false)
	private String id;

	/**
	 * Explains why a transaction is requested to be cancelled
	 */
	@XmlElement(required = false)
	private String reason;

	/** The Bcash request */
	@XmlElement
	private BcashRequest bcashRequest;

	@XmlElement(required = false)
	private Boolean termsAndConditionsAcepted;

	/**
	 * Returns the transaction order
	 *
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Returns the transaction credit card
	 *
	 * @return the creditCard
	 */
	public CreditCard getCreditCard() {
		return creditCard;
	}
	
	/**
	 * Returns the transaction debit card.
	 *
	 * @return the debit card
	 */
	public DebitCard getDebitCard() {
		return debitCard;
	}

	/**
	 * Returns the transaction credit card swipe
	 *
	 * @return the credit card swipe
	 */
	public CreditCardSwipe getCreditCardSwipe() {
		return creditCardSwipe;
	}

	/**
	 * Returns the transaction credit card token id
	 *
	 * @return the credit card token Id for recurrent payments.
	 */
	public String getCreditCardTokenId() {
		return creditCardTokenId;
	}

	/**
	 * Returns the create credit card token flag for recurrent payments
	 *
	 * @return the flag.
	 */
	public Boolean getCreateCreditCardToken() {
		return createCreditCardToken;
	}

	/**
	 * Returns the transaction type
	 *
	 * @return the type
	 */
	public TransactionType getType() {
		return type;
	}

	/**
	 * Returns the transaction parent id
	 *
	 * @return the parent transaction
	 */
	public String getParentTransactionId() {
		return parentTransactionId;
	}

	/**
	 * Returns the transaction payment method
	 *
	 * @return the payment method
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Returns the transaction source
	 *
	 * @return the source
	 */
	public TransactionSource getSource() {
		return source;
	}

	/**
	 * Returns the transaction payment country
	 *
	 * @return the payment country
	 */
	public PaymentCountry getPaymentCountry() {
		return paymentCountry;
	}

	/**
	 * Returns the transaction response
	 *
	 * @return the transaction response
	 */
	public TransactionResponse getTransactionResponse() {
		return transactionResponse;
	}

	/**
	 * Returns the transaction payer
	 *
	 * @return the payer
	 */
	public Payer getPayer() {
		return payer;
	}

	/**
	 * Returns the transaction device session id
	 *
	 * @return the device session id
	 */
	public String getDeviceSessionId() {
		return deviceSessionId;
	}

	/**
	 * Returns the buyer IP address.
	 *
	 * @return the IP address
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Returns the browser cookie
	 *
	 * @return the cookie
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * Returns the browser user agent
	 *
	 * @return the user agent
	 */
	public String getUserAgent() {
		return userAgent;
	}

	/**
	 * Returns the transaction expiration date
	 *
	 * @return the expiration date
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Returns the transaction additional values
	 *
	 * @return the additional values
	 */
	public Map<String, AdditionalValue> getAdditionalValues() {
		return additionalValues;
	}

	/**
	 * Returns the transaction extra parameters
	 *
	 * @return the extra parameters
	 */
	public Map<String, String> getExtraParameters() {
		return extraParameters;
	}

	/**
	 * Returns the Bcash request
	 *
	 * @return the Bcash request
	 */
	public BcashRequest getBcashRequest() {

		return bcashRequest;
	}

	/**
	 * Return the terms and conditions accepted
	 *
	 * @return the terms and conditions accepted
	 */
	public Boolean getTermsAndConditionsAcepted() {

		return termsAndConditionsAcepted;
	}

	/**
	 * Sets the transaction order
	 *
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * Sets the transaction credit card
	 *
	 * @param creditCard
	 *            the credit card to set
	 */
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	/**
	 * Sets the transaction debit card.
	 *
	 * @param debitCard the new debit card
	 */
	public void setDebitCard(DebitCard debitCard) {
		this.debitCard = debitCard;
	}
	
	/**
	 * Sets the transaction credit card swipe
	 *
	 * @param creditCardSwipe
	 *            the credit card swipe to set
	 */
	public void setCreditCardSwipe(CreditCardSwipe creditCardSwipe) {
		this.creditCardSwipe = creditCardSwipe;
	}

	/**
	 * Sets the transaction credit card token id
	 *
	 * @param creditCardTokenId
	 *            the creditCardTokenId to set
	 */
	public void setCreditCardTokenId(String creditCardTokenId) {
		this.creditCardTokenId = creditCardTokenId;
	}

	/**
	 * Sets the transaction create credit card token flag
	 *
	 * @param createCreditCardToken
	 *            the flag to set
	 */
	public void setCreateCreditCardToken(Boolean createCreditCardToken) {
		this.createCreditCardToken = createCreditCardToken;
	}

	/**
	 * Sets the transaction type
	 *
	 * @param type
	 *            the type to set
	 */
	public void setType(TransactionType type) {
		this.type = type;
	}

	/**
	 * Sets the transaction parent id
	 *
	 * @param parentTransaction
	 *            the parent transaction to set
	 */
	public void setParentTransactionId(String parentTransactionId) {
		this.parentTransactionId = parentTransactionId;
	}

	/**
	 * Sets the transaction payment method
	 *
	 * @param paymentMethod
	 *            the payment method to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * Sets the transaction source
	 *
	 * @param source
	 *            the source to set
	 */
	public void setSource(TransactionSource source) {
		this.source = source;
	}

	/**
	 * Sets the transaction payment country
	 *
	 * @param paymentCountry
	 *            the payment country to set
	 */
	public void setPaymentCountry(PaymentCountry paymentCountry) {
		this.paymentCountry = paymentCountry;
	}

	/**
	 * Sets the transaction response
	 *
	 * @param transactionResponse
	 *            the transaction response to set
	 */
	public void setTransactionResponse(TransactionResponse transactionResponse) {
		this.transactionResponse = transactionResponse;
	}

	/**
	 * Sets the transactions payer
	 *
	 * @param payer
	 *            the payer to set
	 */
	public void setPayer(Payer payer) {
		this.payer = payer;
	}

	/**
	 * Sets the transaction device session id
	 *
	 * @param deviceSessionId
	 *            the device session id to set
	 */
	public void setDeviceSessionId(String deviceSessionId) {
		this.deviceSessionId = deviceSessionId;
	}

	/**
	 * Sets the buyer IP address.
	 *
	 * @param ipAddress
	 *            the IP address to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Sets the browser cookie
	 *
	 * @param cookie
	 *            the cookie to set
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	/**
	 * Sets the browser user agent
	 *
	 * @param userAgent
	 *            the user agent to set
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/**
	 * Sets the transaction expiration date
	 *
	 * @param expirationDate
	 *            the expiration date to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Sets the transaction additional values
	 *
	 * @param additionalValues
	 *            the additional values to set
	 */
	public void setAdditionalValues(
			Map<String, AdditionalValue> additionalValues) {
		this.additionalValues = additionalValues;
	}

	/**
	 * Sets the transaction extra parameters
	 *
	 * @param extraParameters
	 *            the extra parameters to set
	 */
	public void setExtraParameters(Map<String, String> extraParameters) {
		this.extraParameters = extraParameters;
	}

	/**
	 * Adds an extra parameter to the transaction
	 *
	 * @param name
	 *            The name of the extra parameter
	 * @param value
	 *            The value of the extra parameter
	 * @throws InvalidParametersException
	 */
	public synchronized void addExtraParameter(String name, String value)
			throws InvalidParametersException {

		if (name == null || value == null) {
			throw new InvalidParametersException(
					"neither the name nor the value of the extra parameter "
							+ "can be null");
		}

		if (extraParameters == null) {
			extraParameters = new HashMap<String, String>();
		}

		extraParameters.put(name, value);
	}

	/**
	 * @return the reason
	 */
	public String getReason() {

		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {

		this.reason = reason;
	}

	/**
	 * Sets the transaction id
	 *
	 * @param transactionId
	 *            the transactionId to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the transaction id
	 *
	 * @return the transactionId
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the Bcash request
	 *
	 * @param bcashRequest the Bcash request to set
	 */
	public void setBcashRequest(BcashRequest bcashRequest) {

		this.bcashRequest = bcashRequest;
	}

	/**
	 * Sets the terms and conditions accepted
	 *
	 * @param termsAndConditionsAcepted
	 *            the terms and conditions accepted to set
	 */
	public void setTermsAndConditionsAcepted(Boolean termsAndConditionsAcepted) {

		this.termsAndConditionsAcepted = termsAndConditionsAcepted;
	}

}
