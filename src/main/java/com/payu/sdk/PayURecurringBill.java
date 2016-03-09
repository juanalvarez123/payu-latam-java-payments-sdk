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