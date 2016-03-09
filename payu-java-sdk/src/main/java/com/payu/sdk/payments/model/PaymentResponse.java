package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.TransactionResponse;
import com.payu.sdk.model.response.Response;

/**
 * Represents a payment response in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "paymentResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentResponse extends Response {

	/** The generated serial version Id */
	private static final long serialVersionUID = 1157400679436549655L;
	/** The transaction response sent by the server */
	@XmlElement(required = false)
	private TransactionResponse transactionResponse;

	/**
	 * Returns the transaction response
	 * 
	 * @return the transactionResponse
	 */
	public TransactionResponse getTransactionResponse() {
		return transactionResponse;
	}

	/**
	 * Sets the transaction response
	 * 
	 * @param transactionResponse
	 *            the transactionResponse to set
	 */
	public void setTransactionResponse(TransactionResponse transactionResponse) {
		this.transactionResponse = transactionResponse;
	}

	/**
	 * Converts a xml string into a payment response object
	 * 
	 * @param xml
	 *            The object in a xml format
	 * @return The payment response object
	 * @throws PayUException
	 */
	public static PaymentResponse fromXml(String xml) throws PayUException {

		return (PaymentResponse) fromBaseXml(new PaymentResponse(), xml);

	}

}
