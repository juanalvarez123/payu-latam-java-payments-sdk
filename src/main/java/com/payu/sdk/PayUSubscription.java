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
import com.payu.sdk.paymentplan.model.Subscription;
import com.payu.sdk.payments.model.SubscriptionListResponse;
import com.payu.sdk.utils.CollectionsUtil;
import com.payu.sdk.utils.PaymentPlanRequestUtil;

/**
 * Manages all PayU subscriptions operations
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 09/09/2013
 */
public final class PayUSubscription extends PayU {

	/**
	 * Private constructor
	 */
	private PayUSubscription() {
	}

	/**
	 * Creates a subscription
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the created subscription
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static Subscription create(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] params;

		// Plan parameters
		params = new String[] { PayU.PARAMETERS.PLAN_INTERVAL,
				PayU.PARAMETERS.PLAN_CODE, PayU.PARAMETERS.PLAN_INTERVAL_COUNT,
				PayU.PARAMETERS.PLAN_CURRENCY, PayU.PARAMETERS.PLAN_VALUE,
				PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY,
				PayU.PARAMETERS.PLAN_DESCRIPTION,
				PayU.PARAMETERS.PLAN_MAX_PAYMENTS };

		if (parameters.containsKey(PayU.PARAMETERS.PLAN_ID)) {

			PaymentPlanRequestUtil.validateNotAllowedParameters(
					parameters.keySet(), params);
		} else if (!parameters.containsKey(PayU.PARAMETERS.PLAN_CODE)) {
			params = new String[] { PayU.PARAMETERS.PLAN_INTERVAL,
					PayU.PARAMETERS.PLAN_CODE, PayU.PARAMETERS.PLAN_INTERVAL_COUNT,
					PayU.PARAMETERS.PLAN_CURRENCY, PayU.PARAMETERS.PLAN_VALUE,
					PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY,
					PayU.PARAMETERS.PLAN_DESCRIPTION,
					PayU.PARAMETERS.PLAN_MAX_PAYMENTS,
					PayU.PARAMETERS.ACCOUNT_ID};
			PaymentPlanRequestUtil.validateParameters(parameters, params);
		}

		// Customer parameters
		if (parameters.containsKey(PayU.PARAMETERS.CUSTOMER_ID)) {

			params = new String[] { PayU.PARAMETERS.CUSTOMER_EMAIL,
					PayU.PARAMETERS.CUSTOMER_NAME };
			PaymentPlanRequestUtil.validateNotAllowedParameters(
					parameters.keySet(), params);
		} else if (parameters.get(PayU.PARAMETERS.CUSTOMER_NAME) == null
				&& parameters.get(PayU.PARAMETERS.CUSTOMER_EMAIL) == null) {

			throw new InvalidParametersException(
					"You must register the [customerName] or [customerEmail]");
		}


		params = new String[] { PayU.PARAMETERS.CREDIT_CARD_NUMBER,
				PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE,
				PayU.PARAMETERS.PAYMENT_METHOD, PayU.PARAMETERS.PAYER_NAME,
				PayU.PARAMETERS.PAYER_STREET,
				PayU.PARAMETERS.PAYER_STREET_2,
				PayU.PARAMETERS.PAYER_STREET_3, PayU.PARAMETERS.PAYER_CITY,
				PayU.PARAMETERS.PAYER_STATE, PayU.PARAMETERS.PAYER_COUNTRY,
				PayU.PARAMETERS.PAYER_POSTAL_CODE,
				PayU.PARAMETERS.PAYER_PHONE };
		// CreditCard parameters
		if (parameters.containsKey(PayU.PARAMETERS.TOKEN_ID)) {

			PaymentPlanRequestUtil.validateNotAllowedParameters(
					parameters.keySet(), params);
		} else if(CollectionsUtil.interceptMaps(parameters.keySet(), params)){

			String[] validateParamsCreditCard = new String[] { PayU.PARAMETERS.CREDIT_CARD_NUMBER,
					PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE,
					PayU.PARAMETERS.PAYMENT_METHOD, PayU.PARAMETERS.PAYER_NAME };

			PaymentPlanRequestUtil.validateParameters(parameters, validateParamsCreditCard);
		}

		//BankAccount parameters
		if (parameters.containsKey(PayU.PARAMETERS.BANK_ACCOUNT_ID)) {

			params = new String[] { PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
					PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE,
					PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME,
					PayU.PARAMETERS.BANK_ACCOUNT_AGENCY_NUMBER,
					PayU.PARAMETERS.BANK_ACCOUNT_AGENCY_DIGIT,
					PayU.PARAMETERS.BANK_ACCOUNT_ACCOUNT_DIGIT,
					PayU.PARAMETERS.BANK_ACCOUNT_NUMBER,
					PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME,
					PayU.PARAMETERS.BANK_ACCOUNT_TYPE,
					PayU.PARAMETERS.BANK_ACCOUNT_STATE };

			PaymentPlanRequestUtil.validateNotAllowedParameters(
					parameters.keySet(), params);
		}


		String res = HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildSubscriptionRequest(parameters),
				RequestMethod.POST);

		return Subscription.fromXml(res);
	}

	/**
	 * Cancel a subscription
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return true if the subscription was canceled
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 * @throws PayUException
	 */
	public static boolean cancel(Map<String, String> parameters)
			throws InvalidParametersException, ConnectionException,
			PayUException {

		String[] params = { PayU.PARAMETERS.SUBSCRIPTION_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, params);

		HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildSubscriptionRequest(parameters),
				RequestMethod.DELETE);

		return true;

	}

	/**
	 * Update a subscription
	 * @param parameters The parameters to be sent to the server
	 * @return
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 * @throws PayUException
	 */
	public static Subscription update(Map<String, String> parameters)
			throws InvalidParametersException, ConnectionException,
			PayUException {

		String[] params;

		// Plan parameters
		params = new String[] { PayU.PARAMETERS.SUBSCRIPTION_ID};

		PaymentPlanRequestUtil.validateParameters(parameters, params);


		String res = HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildSubscriptionUpdateRequest(parameters),
				RequestMethod.PUT);

		return Subscription.fromXml(res);

	}

	/**
	 * Find a subscription based in its identifier
	 *
	 * @param parameters The parameters to be sent to the server
	 * @return The subscription with the given identifier if found
	 *
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static Subscription find(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.SUBSCRIPTION_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		String res = HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildSubscriptionRequest(parameters),
				RequestMethod.GET);

		return Subscription.fromXml(res);

	}

	/**
	 * Finds a subscription list based on some parameters
	 *
	 * @param parameters The parameters to be sent to the server
	 * @return The subscription list
	 *
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static List<Subscription> findList(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String res = HttpClientHelper
				.sendRequest(PaymentPlanRequestUtil
						.buildSubscriptionListRequest(parameters),
						RequestMethod.GET);

		return SubscriptionListResponse.fromXml(res).getSubscriptionList();

	}
}
