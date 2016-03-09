package com.payu.sdk.payments.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.exceptions.SDKException.ErrorCode;
import com.payu.sdk.model.Bank;

/**
 * Represents a bank list request in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "bankListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankListResponse extends PaymentResponse {

	/** The generated serial version Id */
	private static final long serialVersionUID = 8598772429684669362L;
	/** the pse banks */
	@XmlElementWrapper(name = "banks")
	@XmlElement(name = "bank")
	private List<Bank> banks;

	/**
	 * Returns the pse banks
	 * 
	 * @return the pse banks
	 */
	public List<Bank> getBanks() {

		return banks;
	}

	/**
	 * Sets the pse banks
	 * @param banks
	 *            the pse banks to set
	 */
	public void setBanks(List<Bank> banks) {

		this.banks = banks;
	}

	/**
	 * Converts a xml string into a BankListResponse
	 * 
	 * @param xml
	 *            The object in a xml format
	 * @return The bank list response object
	 * @throws PayUException
	 */
	public static BankListResponse fromXml(String xml) throws PayUException {

		try {

			return (BankListResponse) fromBaseXml(new BankListResponse(), xml);
		} catch (Exception e) {
			throw new PayUException(ErrorCode.XML_DESERIALIZATION_ERROR, e);
		}
	}

}
