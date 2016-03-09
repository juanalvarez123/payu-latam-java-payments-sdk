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
import com.payu.sdk.paymentplan.model.PaymentPlanCreditCard;
import com.payu.sdk.payments.model.PaymentPlanCreditCardListResponse;
import com.payu.sdk.utils.PaymentPlanRequestUtil;

/**
 * Manages all PayU credit cards operations
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public final class PayUCreditCard extends PayU {

	/**
	 * Private constructor
	 */
	private PayUCreditCard() {
	}

	/**
	 * Creates a credit card
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the created credit card
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static PaymentPlanCreditCard create(Map<String, String> parameters)
			throws PayUException, InvalidParametersException, ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.CUSTOMER_ID, PayU.PARAMETERS.CREDIT_CARD_NUMBER,
				PayU.PARAMETERS.PAYER_NAME, PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE,
				PayU.PARAMETERS.PAYMENT_METHOD };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		String res = HttpClientHelper.sendRequest(PaymentPlanRequestUtil.buildCreditCardRequest(parameters),
				RequestMethod.POST);

		return PaymentPlanCreditCard.fromXml(res);
	}

	/**
	 * Returns a credit card with the given id
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the created credit card
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static PaymentPlanCreditCard find(Map<String, String> parameters)
			throws PayUException, InvalidParametersException, ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.TOKEN_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		String res = HttpClientHelper.sendRequest(PaymentPlanRequestUtil.buildCreditCardRequest(parameters),
				RequestMethod.GET);

		return PaymentPlanCreditCard.fromXml(res);
	}

	/**
	 * Updates a credit card
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the created credit card
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static PaymentPlanCreditCard update(Map<String, String> parameters)
			throws PayUException, InvalidParametersException, ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.TOKEN_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		String[] notAllowed = new String[] { PayU.PARAMETERS.CUSTOMER_ID, PayU.PARAMETERS.CREDIT_CARD_NUMBER,
				PayU.PARAMETERS.PAYMENT_METHOD };

		PaymentPlanRequestUtil.validateNotAllowedParameters(parameters.keySet(), notAllowed);

		String res = HttpClientHelper.sendRequest(PaymentPlanRequestUtil.buildCreditCardRequest(parameters),
				RequestMethod.PUT);

		return PaymentPlanCreditCard.fromXml(res);
	}

	/**
	 * Delete a credit card with the given customer id and token
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 *
	 * @return true if the credit card was deleted
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 * @throws PayUException
	 */
	public static boolean delete(Map<String, String> parameters)
			throws InvalidParametersException, ConnectionException, PayUException {

		String[] required = new String[] { PayU.PARAMETERS.TOKEN_ID, PayU.PARAMETERS.CUSTOMER_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		HttpClientHelper.sendRequest(PaymentPlanRequestUtil.buildCreditCardRequest(parameters), RequestMethod.DELETE);

		return true;
	}

	/**
	 * Returns the credit card list with the query params
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the credit card list
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static List<PaymentPlanCreditCard> findList(Map<String, String> parameters)
			throws PayUException, InvalidParametersException, ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.CUSTOMER_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, required);
		String res = HttpClientHelper.sendRequest(PaymentPlanRequestUtil.buildCreditCardListRequest(parameters),
				RequestMethod.GET);
		PaymentPlanCreditCardListResponse response = PaymentPlanCreditCardListResponse.fromXml(res);

		return response.getCreditCards();
	}
}
