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
