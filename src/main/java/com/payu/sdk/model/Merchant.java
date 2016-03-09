package com.payu.sdk.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a merchant in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name="merchant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Merchant implements Serializable {

	/** The generated serial version Id */	
	private static final long serialVersionUID = 3905306384001367781L;
	/** The merchant apiLogin to use in the system */
	@XmlElement
	private String apiLogin;
	/** The merchant apiKey to use in the system */
	@XmlElement
	private String apiKey;
	
	/**
	 * Returns the merchant apiLogin
	 * 
	 * @return the apiMerchantId
	 */
	public String getApiLogin() {
		return apiLogin;
	}
	
	/**
	 * Returns the merchant apiKey
	 * 
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}
	
	/**
	 * Sets the merchant apiLogin
	 * 
	 * @param apiMerchantId the apiMerchantId to set
	 */
	public void setApiLogin(String apiLogin) {
		this.apiLogin = apiLogin;
	}
	
	/**
	 * Sets the merchant apiKey
	 * 
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
}
