package com.payu.sdk.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Represents an additional value in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "additionalValue")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = { "name", "value", "currency" })
public class AdditionalValue implements Serializable{

	/**
	 * Serial version  uid
	 */
	private static final long serialVersionUID = 7601481960349762273L;
	
	/** The name. */
	private String name;
	/** The value. */
	private BigDecimal value;
	/** The currency. */
	private Currency currency;

	/**
	 * @return the name
	 */
	@XmlElement
	public String getName() {

		return name;
	}

	/**
	 * @return the value
	 */
	@XmlElement
	public BigDecimal getValue() {

		return value;
	}

	/**
	 * @return the currency
	 */
	@XmlElement
	public Currency getCurrency() {

		return currency;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(BigDecimal value) {

		this.value = value;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(Currency currency) {

		this.currency = currency;
	}

}
