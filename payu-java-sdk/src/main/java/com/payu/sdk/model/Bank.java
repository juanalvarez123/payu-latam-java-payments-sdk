package com.payu.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a bank in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "bank")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bank {

	/** The identifier of the bank. */
	@XmlElement(required = false)
	private String id;
	/** The description of the bank. */
	@XmlElement(required = false)
	private String description;
	/** The code of the bank. */
	@XmlElement(required = false)
	private String pseCode;

	/**
	 * Default constructor
	 */
	public Bank() {
	}

	/**
	 * Default full constructor.
	 * 
	 * @param id The bank's id
	 * @param description The bank's description
	 * @param pseCode The bank's pse code
	 */
	public Bank(String id, String description, String pseCode) {

		this.id = id;
		this.description = description;
		this.pseCode = pseCode;
	}

	/**
	 * Returns the ID of the bank.
	 * 
	 * @return the ID
	 */
	public String getId() {

		return id;
	}

	/**
	 * Returns the description of the bank.
	 * 
	 * @return the description
	 */
	public String getDescription() {

		return description;
	}

	/**
	 * Returns the code of the bank.
	 * 
	 * @return the code
	 */
	public String getPseCode() {

		return pseCode;
	}

	/**
	 * Sets the bank's id
	 * 
	 * @param id the ID to set
	 */
	public void setId(String id) {

		this.id = id;
	}

	/**
	 * Sets the bank's description
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {

		this.description = description;
	}

	/**
	 * Sets the bank pse code
	 * 
	 * @param pseCode
	 *            the code to set
	 */
	public void setPseCode(String pseCode) {

		this.pseCode = pseCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Bank [id={%s}, description={%s}, pseCode={%s}]",
				id, description, pseCode);
	}

}
