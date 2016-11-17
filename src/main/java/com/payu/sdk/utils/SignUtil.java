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
package com.payu.sdk.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.payu.sdk.PayU;
import com.payu.sdk.constants.Constants;
import com.payu.sdk.helper.SignatureHelper;
import com.payu.sdk.model.Order;
import com.payu.sdk.model.Transaction;

/**
 * Utility for create signature in the PayU SDK.
 * 
 * @author <a href="mario.murillo@payulatam.com">Mario Andres Murillo</a>
 * @version 1.0
 * @since 1.0
 * @date 16/11/2016
 */
public final class SignUtil {
	
	/** The format to use for decimal values */
	private static final String VALUE_FORMAT = "###.00";

	/** The default algorithm. */
	private static final String DEFAULT_ALGORITHM = Constants.ALGORITHM_MD5;
	
	/* Separator character to use on signature validation. */
	private static final char SIGNATURE_SEPARATOR = '~';

	/**
	 * Default Constructor
	 */
	private SignUtil() {
		// Default empty constructor
	}
	
	/**
	 * Creates the signature based on information received.
	 *
	 * @param key The merchant API Key
	 * @param merchantId The merchant ID
	 * @param referenceCode The reference
	 * @param amount The payment amount
	 * @param currency The currency
	 * @return the signature created.
	 */
	public static String createSignature(final String key, final Integer merchantId, final String referenceCode, final
	String amount, final String currency) {

		return createSignature(Constants.ALGORITHM_MD5, key,
				buildMessage(merchantId.toString(), referenceCode, amount, currency));
	}
	
	/**
	 * Generates the signature based on information received.
	 *
	 * @param algorithm The algorithm used to generate the sign.
	 * @param key The message key.
	 * @param message The message to create the signature.
	 * @return the signature created.
	 */
	public static String createSignature(final String algorithm, final String key, final String message) {

		final String str = key + SIGNATURE_SEPARATOR + message;
		String signature = null;

		final String localAlgorithm = StringUtils.isBlank(algorithm) ? DEFAULT_ALGORITHM : algorithm;
		if (Constants.ALGORITHM_MD5.equalsIgnoreCase(localAlgorithm)) {
			signature = DigestUtils.md5Hex(str);
		} else if (Constants.ALGORITHM_SHA.equalsIgnoreCase(localAlgorithm)) {
			signature = DigestUtils.shaHex(str);
		} else if (Constants.ALGORITHM_SHA_256.equalsIgnoreCase(localAlgorithm)) {
			signature = DigestUtils.sha256Hex(str);
		} else {
			throw new IllegalArgumentException("Could not create signature. Invalid algorithm " + localAlgorithm);
		}
		return signature;
	}
	
	/**
	 * Generates the signature based from the transaction.
	 *
	 * @param transaction
	 * @return the signature created
	 */
	public static String createSignature(final Transaction transaction) {

		final Order order = transaction.getOrder();
		
		Integer merchantId = new Integer(PayU.merchantId);
		
		return SignatureHelper.buildSignature(order, merchantId, PayU.apiKey, VALUE_FORMAT, DEFAULT_ALGORITHM);
	}
	
	/**
	 * Creates a signature message
	 *
	 * @param merchantId The merchant ID
	 * @param referenceCode The reference
	 * @param amount The payment amount
	 * @param currency The currency
	 * @return The message for signature
	 */
	private static String buildMessage(final String merchantId, final String referenceCode, final String amount,
			final String currency) {

		final StringBuilder message = new StringBuilder(64);
		message.append(merchantId);
		message.append(SIGNATURE_SEPARATOR);
		message.append(referenceCode);
		message.append(SIGNATURE_SEPARATOR);
		message.append(amount);
		message.append(SIGNATURE_SEPARATOR);
		message.append(currency);

		return message.toString();
	}

}
