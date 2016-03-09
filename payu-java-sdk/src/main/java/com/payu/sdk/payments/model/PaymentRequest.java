package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.model.BankListInformation;
import com.payu.sdk.model.Transaction;
import com.payu.sdk.model.request.CommandRequest;

/**
 * Represents a payment request in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentRequest extends CommandRequest {

	/** The generated serial version Id */
	private static final long serialVersionUID = -7744394539231049957L;
	
	/** The transaction to be executed */
	@XmlElement(required = false)
	private Transaction transaction;
	
	/** The bank list information */
	@XmlElement(required = false)
	private BankListInformation bankListInformation;

	/**
	 * Returns the transaction
	 * 
	 * @return the transaction
	 */
	public Transaction getTransaction() {
		return transaction;
	}

	/**
	 * Returns the bank list information
	 * 
	 * @return The bank list information
	 */
	public BankListInformation getBankListInformation() {
		return bankListInformation;
	}

	/**
	 * Sets the transaction
	 * 
	 * @param transaction
	 *            the transaction to set
	 */
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	/**
	 * Sets the bank list information
	 * 
	 * @param bankListInformation
	 *            the bank list information to set
	 */
	public void setBankListInformation(BankListInformation bankListInformation) {
		this.bankListInformation = bankListInformation;
	}

}
