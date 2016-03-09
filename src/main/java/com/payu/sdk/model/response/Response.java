package com.payu.sdk.model.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.exceptions.SDKException.ErrorCode;
import com.payu.sdk.payments.model.PaymentResponse;
import com.payu.sdk.reporting.model.ReportingResponse;
import com.payu.sdk.utils.JaxbUtil;

/**
 * Represents a response in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response implements Serializable {

	/** The generated serial version Id */
	private static final long serialVersionUID = -3399914855691352540L;
	/** The response code sent by the server */
	@XmlElement
	private ResponseCode code;
	/** The error message sent by the server */
	@XmlElement(required = false)
	private String error;

	/**
	 * Returns the code
	 * 
	 * @return the code
	 */
	public ResponseCode getCode() {
		return code;
	}

	/**
	 * Returns the error message
	 * 
	 * @return the error message
	 */
	public String getError() {
		return error;
	}

	/**
	 * Sets the error message
	 * 
	 * @param error
	 *            the error message to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * Sets the code
	 * 
	 * @param code
	 *            the code to set
	 */
	public void setCode(ResponseCode code) {
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Response [code=%s, error=%s]", code, error);
	}

	/**
	 * Converts the response to string response
	 * 
	 * @return The response in a xml format
	 * @throws PayUException
	 */
	public String toXml() throws PayUException {

		try {
			return JaxbUtil.convertJavaToXml(this, true);
		} catch (Exception e) {
			throw new PayUException(ErrorCode.XML_SERIALIZATION_ERROR, e);
		}
	}

	/**
	 * Converts a string response to the response
	 * 
	 * @param xmlData
	 *            The response in a xml format
	 * @return The response object
	 * @throws PayUException
	 */
	protected static Response fromBaseXml(Response response, String xmlData)
			throws PayUException {

		try {

			// Response code
			ResponseCode responseCode = ResponseCode.SUCCESS;
			Response baseResponse = null;

			if (xmlData.contains("<response>")) {
				baseResponse = JaxbUtil.convertXmlToJava(Response.class,
						xmlData);
				responseCode = baseResponse.getCode();
			} else if (xmlData.contains("<paymentResponse>")) {
				baseResponse = JaxbUtil.convertXmlToJava(PaymentResponse.class,
						xmlData);
				responseCode = baseResponse.getCode();
			} else if (xmlData.contains("<reportingResponse>")) {
				baseResponse = JaxbUtil.convertXmlToJava(
						ReportingResponse.class, xmlData);
				responseCode = baseResponse.getCode();
			}

			if (ResponseCode.SUCCESS.equals(responseCode)) {
				return JaxbUtil.convertXmlToJava(response.getClass(), xmlData);
			} else {
				throw new PayUException(ErrorCode.API_ERROR,
						baseResponse.getError());
			}

		} catch (PayUException e) {
			throw e;
		} catch (Exception e) {
			throw new PayUException(ErrorCode.XML_DESERIALIZATION_ERROR, e);
		}
	}
}
