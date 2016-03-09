package com.payu.sdk.model.error;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Enum representing the error response messages in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "error")
@XmlType(propOrder = { "type", "description", "errorList" })
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponse implements Serializable {

	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The error type
	 */
	@XmlElement
	private ErrorType type;

	/**
	 * The error description message
	 */
	@XmlElement
	private String description;

	/**
	 * The list containing a detailed description of errors
	 */
	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "description")
	private String[] errorList;

	// ----------------------------------------------
	// GETTERS AND SETTERS
	// ----------------------------------------------

	/**
	 * Returns the type
	 * 
	 * @return the type
	 */
	public ErrorType getType() {
		return type;
	}

	/**
	 * Returns the error description
	 * 
	 * @return the error description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the errorList
	 * 
	 * @return the errorList
	 */
	public String[] getErrorList() {
		return errorList;
	}

	/**
	 * Sets the type
	 * 
	 * @param type
	 *            the type to set
	 */
	public void setType(ErrorType type) {
		this.type = type;
	}

	/**
	 * Sets the error description
	 * 
	 * @param description
	 *            the error description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the errorList
	 * 
	 * @param errorList
	 *            the errorList to set
	 */
	public void setErrorList(String[] errorList) {
		this.errorList = errorList;
	}
}
