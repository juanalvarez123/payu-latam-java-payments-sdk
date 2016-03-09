package com.payu.sdk.model;

/**
 * 
 * The PSE Person Types
 * 
 * @author PayU Latam
 *
 */
public enum PersonType {

	LEGAL("J"), NATURAL("N");
	
	/**
	 * Codigo PSE 
	 **/
	String pseCode;
	
	/**
	 * PSE code constructor
	 * @param pseCode
	 */
	private PersonType(String pseCode){
		this.pseCode = pseCode;
	}
	
	/**
	 * 
	 * @return the pse code
	 */
	public String getPseCode(){
		return pseCode;
	}
	
}
