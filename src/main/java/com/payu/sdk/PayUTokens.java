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
package com.payu.sdk;

import java.util.List;
import java.util.Map;

import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.exceptions.ConnectionException;
import com.payu.sdk.exceptions.InvalidParametersException;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.helper.HttpClientHelper;
import com.payu.sdk.model.CreditCardToken;
import com.payu.sdk.payments.model.CreditCardTokenListResponse;
import com.payu.sdk.payments.model.CreditCardTokenResponse;
import com.payu.sdk.utils.RequestUtil;

/**
 * Manages all PayU tokens operations
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public final class PayUTokens extends PayU {

	/**
	 * Private constructor
	 */
	private PayUTokens() {
	}

	/**
	 *
	 * Creates a credit card token
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return The created credit card token
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static CreditCardToken create(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.CREDIT_CARD_NUMBER,
				PayU.PARAMETERS.PAYER_NAME, PayU.PARAMETERS.PAYMENT_METHOD,
				PayU.PARAMETERS.PAYER_ID,
				PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE };

		RequestUtil.validateParameters(parameters, required);

		String res = HttpClientHelper.sendRequest(
				RequestUtil.buildCreateTokenRequest(parameters),
				RequestMethod.POST);

		CreditCardTokenResponse response = CreditCardTokenResponse.fromXml(res);

		return response.getCreditCardToken();
	}

	/**
	 *
	 * Finds a credit card token
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return The result credit card token list
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static List<CreditCardToken> find(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] required = new String[] {};

		if (parameters.get(PayU.PARAMETERS.TOKEN_ID) == null
				&& parameters.get(PayU.PARAMETERS.PAYER_ID) == null) {
			required = new String[] { PayU.PARAMETERS.START_DATE,
					PayU.PARAMETERS.END_DATE };
		}

		RequestUtil.validateParameters(parameters, required);

		String res = HttpClientHelper.sendRequest(
				RequestUtil.buildGetCreditCardTokensRequest(parameters),
				RequestMethod.POST);
		CreditCardTokenListResponse response = CreditCardTokenListResponse
				.fromXml(res);
		return response.getCreditCardTokenList();
	}

	/**
	 *
	 * Removes a credit card token
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return The removed credit card token
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static CreditCardToken remove(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.PAYER_ID,
				PayU.PARAMETERS.TOKEN_ID };

		RequestUtil.validateParameters(parameters, required);

		String res = HttpClientHelper.sendRequest(
				RequestUtil.buildRemoveTokenRequest(parameters),
				RequestMethod.POST);

		CreditCardTokenResponse response = CreditCardTokenResponse.fromXml(res);

		return response.getCreditCardToken();
	}

}
