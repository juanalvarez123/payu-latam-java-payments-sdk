package com.payu.sdk.helper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.codec.digest.DigestUtils;

import com.payu.sdk.model.Order;

/**
 * The PayU SDK Helper for signature creation
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public final class SignatureHelper {

	/** MD5 algorithm used */
	public static final String MD5_ALGORITHM = "md5";
	/** SHA algorithm used */
	public static final String SHA_ALGORITHM = "sha";
	
	/** Decimal format with no decimals */
	public static final String DECIMAL_FORMAT_1 = "###";
	/** Decimal format with one decimal */
	public static final String DECIMAL_FORMAT_2 = "###.0";
	/** Decimal format with two decimals */
	public static final String DECIMAL_FORMAT_3 = "###.00";
	
	/** The transaction value */
	public static final String TX_VALUE = "TX_VALUE";
	
	/**
	 * Private constructor
	 */
	private SignatureHelper() {}
	
	/**
	 * builds the signature for the transaction
	 * 
	 * @param order The order that will have the signature
	 * @param merchantId The merchantId into the signature
	 * @param key The apiKey of the merchant
	 * @param valueFormat The format to use for decimal values
	 * @param algorithm The algorithm to use
	 * @return the full signature to use
	 */
	public static String buildSignature(Order order, Integer merchantId, String key, 
			String valueFormat, String algorithm) {
		
		String message = buildMessage(order, merchantId, key, valueFormat);
		
		if (MD5_ALGORITHM.equalsIgnoreCase(algorithm)) {
			return DigestUtils.md5Hex(message);
		} 
		else if (SHA_ALGORITHM.equalsIgnoreCase(algorithm)) {
			return DigestUtils.shaHex(message);
		} 
		else {
			throw new IllegalArgumentException("Could not create signature. Invalid algoritm");
		}
	}
	
	/**
	 * The message the signature will use
	 * 
	 * @param order The order that will have the signature
	 * @param merchantId The merchantId into the signature
	 * @param key The apiKey of the merchant
	 * @param valueFormat The format to use for decimal values
	 * @return the message that will go into the signature
	 */
	private static String buildMessage(Order order, Integer merchantId,
			String key, String valueFormat) {

		validateOrder(order, merchantId);

		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		df.applyPattern(valueFormat);

		StringBuffer message = new StringBuffer();
		message.append(key);
		message.append("~");
		message.append(merchantId);
		message.append("~");
		message.append(order.getReferenceCode());
		message.append("~");
		message.append(df.format(order.getAdditionalValue(TX_VALUE).getValue()
				.doubleValue()));
		message.append("~");
		message.append(order.getAdditionalValue(TX_VALUE).getCurrency().toString());
		
		return message.toString();
	}
	
	/**
	 * Validates that the order is valid
	 * 
	 * @param order The order to be validated
	 * @param merchantId The merchantId to be validated
	 */
	private static void validateOrder(Order order, Integer merchantId) {
		
		if (merchantId == null) {
			throw new IllegalArgumentException("The merchant id may not be null");
		} else if (order.getReferenceCode() == null) {
			throw new IllegalArgumentException("The reference code may not be null");
		} else if (order.getAdditionalValue(TX_VALUE) == null) {
			throw new IllegalArgumentException("The order additional value TX_VALUE may not be null");
		} else if (order.getAdditionalValue(TX_VALUE).getCurrency() == null) {
			throw new IllegalArgumentException("The order currency may not be null");
		} else if (order.getAdditionalValue(TX_VALUE).getValue() == null) {
			throw new IllegalArgumentException("The order value may not be null");
		}
	}
	
}
