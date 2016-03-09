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
import com.payu.sdk.paymentplan.model.SubscriptionPlan;
import com.payu.sdk.payments.model.SubscriptionPlanListResponse;
import com.payu.sdk.utils.PaymentPlanRequestUtil;

/**
 * Manages all PayU plans operations
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 05/09/2013
 */
public final class PayUPlans extends PayU {

	/**
	 * Private constructor
	 */
	private PayUPlans() {
	}

	/**
	 * Creates a subscription plan with the specified parameters values
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return The created subscription plan
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static SubscriptionPlan create(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.PLAN_INTERVAL,
				PayU.PARAMETERS.PLAN_CODE, PayU.PARAMETERS.PLAN_INTERVAL_COUNT,
				PayU.PARAMETERS.PLAN_CURRENCY, PayU.PARAMETERS.PLAN_VALUE,
				PayU.PARAMETERS.ACCOUNT_ID,
				PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY,
				PayU.PARAMETERS.PLAN_DESCRIPTION,
				PayU.PARAMETERS.PLAN_MAX_PAYMENTS };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		String res = HttpClientHelper
				.sendRequest(PaymentPlanRequestUtil
						.buildSubscriptionPlanRequest(parameters),
						RequestMethod.POST);

		return SubscriptionPlan.fromXml(res);
	}

	/**
	 * Finds a subscription plan based on its plan code
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the found subscription plan
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static SubscriptionPlan find(Map<String, String> parameters)
			throws PayUException, InvalidParametersException, ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.PLAN_CODE };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		String res = HttpClientHelper
				.sendRequest(PaymentPlanRequestUtil
						.buildSubscriptionPlanRequest(parameters),
						RequestMethod.GET);

		return SubscriptionPlan.fromXml(res);
	}

	/**
	 * Updates a subscription plan with the specified parameters values
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the updated subscription plan
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static SubscriptionPlan update(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.PLAN_CODE };
		PaymentPlanRequestUtil.validateParameters(parameters, required);

		String[] notAllowed = new String[] {
				PayU.PARAMETERS.PLAN_INTERVAL_COUNT,
				PayU.PARAMETERS.ACCOUNT_ID, PayU.PARAMETERS.PLAN_MAX_PAYMENTS,
				PayU.PARAMETERS.PLAN_INTERVAL };
		PaymentPlanRequestUtil.validateNotAllowedParameters(
				parameters.keySet(), notAllowed);

		String res = HttpClientHelper
				.sendRequest(PaymentPlanRequestUtil
						.buildSubscriptionPlanRequest(parameters),
						RequestMethod.PUT);

		return SubscriptionPlan.fromXml(res);
	}

	/**
	 * Delete a subscription plan based on its plan code
	 *
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return true if the plan was deleted
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 * @throws PayUException
	 */
	public static boolean delete(Map<String, String> parameters)
			throws InvalidParametersException, ConnectionException,
			PayUException {

		String[] required = new String[] { PayU.PARAMETERS.PLAN_CODE };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		HttpClientHelper
				.sendRequest(PaymentPlanRequestUtil
						.buildSubscriptionPlanRequest(parameters),
						RequestMethod.DELETE);

		return true;
	}

	/**
	 * Finds all subscription plans based on its merchant
	 *
	 * @return the subscription plan list
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static List<SubscriptionPlan> findList(Map<String, String> parameters)
			throws PayUException, InvalidParametersException, ConnectionException {

		String res = HttpClientHelper.sendRequest(PaymentPlanRequestUtil
				.buildSubscriptionPlanListRequest(parameters), RequestMethod.GET);

		SubscriptionPlanListResponse response = SubscriptionPlanListResponse.fromXml(res);

		return response.getSubscriptionPlanList();
	}

}
