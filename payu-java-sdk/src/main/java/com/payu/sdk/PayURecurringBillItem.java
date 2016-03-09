package com.payu.sdk;

import java.util.List;
import java.util.Map;

import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.exceptions.ConnectionException;
import com.payu.sdk.exceptions.InvalidParametersException;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.helper.HttpClientHelper;
import com.payu.sdk.paymentplan.model.RecurringBillItem;
import com.payu.sdk.payments.model.RecurringBillItemListResponse;
import com.payu.sdk.utils.PaymentPlanRequestUtil;

/**
 * Manages all PayU recurring bill items operations
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 26/09/2013
 */
public final class PayURecurringBillItem extends PayU {

	/**
	 * Private constructor
	 */
	private PayURecurringBillItem() {
	}

	/**
	 * Creates a subscription
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the created recurring bill item
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static RecurringBillItem create(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] params;

		// Plan parameters
		params = new String[] { PayU.PARAMETERS.SUBSCRIPTION_ID,
				PayU.PARAMETERS.DESCRIPTION, PayU.PARAMETERS.ITEM_VALUE,
				PayU.PARAMETERS.CURRENCY };

		PaymentPlanRequestUtil.validateParameters(parameters, params);

		String res = HttpClientHelper.sendRequest(PaymentPlanRequestUtil
				.buildRecurringBillItemRequest(parameters), RequestMethod.POST);

		return RecurringBillItem.fromXml(res);
	}

	/**
	 * Find a recurring bill item
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the found recurring bill item
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static RecurringBillItem find(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] params = { PayU.PARAMETERS.RECURRING_BILL_ITEM_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, params);

		String xml = HttpClientHelper.sendRequest(PaymentPlanRequestUtil
				.buildRecurringBillItemRequest(parameters), RequestMethod.GET);

		return RecurringBillItem.fromXml(xml);

	}

	/**
	 * Updates a recurring bill item
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the updated recurring bill item
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static RecurringBillItem update(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] params;

		// Plan parameters
		params = new String[] { PayU.PARAMETERS.RECURRING_BILL_ITEM_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, params);

		String res = HttpClientHelper.sendRequest(PaymentPlanRequestUtil
				.buildRecurringBillItemRequest(parameters), RequestMethod.PUT);

		return RecurringBillItem.fromXml(res);
	}

	/**
	 * Deletes a recurring bill item
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return true if the recurring bill item was deleted
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 * @throws PayUException
	 */
	public static boolean delete(Map<String, String> parameters)
			throws InvalidParametersException, ConnectionException,
			PayUException {

		String[] params;

		// Plan parameters
		params = new String[] { PayU.PARAMETERS.RECURRING_BILL_ITEM_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, params);

		HttpClientHelper.sendRequest(PaymentPlanRequestUtil
				.buildRecurringBillItemRequest(parameters),
				RequestMethod.DELETE);

		return true;
	}
	
	
	/**
	 * Find the recurring bill item list
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the found recurring bill item
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static List<RecurringBillItem> findList(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String xml = HttpClientHelper.sendRequest(PaymentPlanRequestUtil
				.buildRecurringBillItemListRequest(parameters), RequestMethod.GET);
		return RecurringBillItemListResponse.fromXml(xml)
				.getRecurringBillItems();
	}

}
