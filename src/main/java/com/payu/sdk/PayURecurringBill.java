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
import com.payu.sdk.paymentplan.model.RecurringBill;
import com.payu.sdk.payments.model.RecurringBillListResponse;
import com.payu.sdk.utils.PaymentPlanRequestUtil;

/**
 * Manages all PayU recurring bill operations.
 *
 * @author PayU Latam
 * @since 1.1.1
 * @version 1.1.1, 07/01/2014
 */
public class PayURecurringBill extends PayU {

	/**
	 * Private constructor.
	 */
	private PayURecurringBill() {
	}

	/**
	 * Finds a recurring bill.
	 *
	 * @param parameters The parameters to be sent to the server
	 * @return the found recurring bill
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static RecurringBill find(Map<String, String> parameters)
			throws PayUException, InvalidParametersException, ConnectionException {

		String[] requiredParams = { PayU.PARAMETERS.RECURRING_BILL_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, requiredParams);

		String xml = HttpClientHelper.sendRequest(PaymentPlanRequestUtil
				.buildRecurringBillRequest(parameters), RequestMethod.GET);

		return RecurringBill.fromXml(xml);
	}

	/**
	 * Find the recurring bill list.
	 *
	 * @param parameters The parameters to be sent to the server
	 * @return the found recurring bills
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static List<RecurringBill> findList(Map<String, String> parameters)
			throws PayUException, InvalidParametersException, ConnectionException {

		PaymentPlanRequestUtil.validateParameters(parameters);

		String xml = HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildRecurringBillListRequest(parameters), RequestMethod.GET);

		return RecurringBillListResponse.fromXml(xml).getRecurringBills();
	}
}