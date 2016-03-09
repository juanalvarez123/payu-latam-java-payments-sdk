package com.payu.sdk.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a new physical address in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name="address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressV4 implements Serializable {

	/** The generated serial version Id */
	private static final long serialVersionUID = -7553678962378372959L;
	/** The street line 1. */
	@XmlElement(required=false)
	private String street1;
	/** The street line 2. */
	@XmlElement(required=false)
	private String street2;
	/** The street line 3. */
	@XmlElement(required=false)
	private String street3;
	/** The city. */
	@XmlElement(required=false)
	private String city;
	/** The state/province. */
	@XmlElement(required=false)
	private String state;
	/** The iso code of the country. */
	@XmlElement(required=false)
	private String country;
	/** The postal code. */
	@XmlElement(required=false)
	private String postalCode;
	/** The phone number. */
	@XmlElement(required=false)
	private String phone;

	/**
	 * Returns the address street 1
	 * 
	 * @return the street1
	 */
	public String getStreet1() {
		return street1;
	}
	
	/**
	 * Returns the address street 2
	 * 
	 * @return the street2
	 */
	public String getStreet2() {
		return street2;
	}
	
	/**
	 * Returns the address street 3
	 * 
	 * @return the street3
	 */
	public String getStreet3() {
		return street3;
	}

	/**
	 * Returns the city name
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Returns the state name
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Returns the country ISO code
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Returns the postal code
	 * 
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	
	/**
	 * Returns the contact phone
	 * 
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the address street 1
	 * 
	 * @param street1 the street 1 to set
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	
	/**
	 * Sets the address street 2
	 * 
	 * @param street2 the street 2 to set
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	
	/**
	 * Sets the address street 3
	 * 
	 * @param street3 the street 3 to set
	 */
	public void setStreet3(String street3) {
		this.street3 = street3;
	}

	/**
	 * Sets the city name
	 * 
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Sets the state name
	 * 
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Sets the country ISO code
	 * 
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Sets the postal code
	 * 
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Sets the contact phone
	 * 
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
