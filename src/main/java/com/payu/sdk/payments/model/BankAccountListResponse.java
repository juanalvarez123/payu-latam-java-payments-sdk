package com.payu.sdk.payments.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.response.Response;
import com.payu.sdk.paymentplan.model.BankAccount;

/**
 * Represents a bank accounts list response in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.1.1
 * @version 1.1.1, 11/06/2014
 */
@XmlRootElement(name = "bankAccountListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankAccountListResponse extends Response {

	/** The generated serial version Id */
	private static final long serialVersionUID = 1L;
	
	/** The result list */
	@XmlElementWrapper(name = "bankAccounts")
	@XmlElement(name = "bankAccount")
	private List<BankAccount> bankAccountList;

	/**
	 * Returns the bank account list
	 * 
	 * @return the bankAccountList
	 */
	public List<BankAccount> getBankAccountList() {
		return bankAccountList;
	}

	/**
	 * Sets the bank account list
	 * 
	 * @param bankAccountList the subscription plan list to set
	 */
	public void setBankAccountList(List<BankAccount> bankAccountList) {
		this.bankAccountList = bankAccountList;
	}

	/**
	 * Maps the xml string of a bank account list response to the object
	 * 
	 * @param xml The object in a xml format
	 * @return The java object
	 * @throws PayUException
	 */
	public static BankAccountListResponse fromXml(String xml)
			throws PayUException {

		return (BankAccountListResponse) fromBaseXml(new BankAccountListResponse(), xml);
	}

}
