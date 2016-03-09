package com.payu.sdk;

import java.util.List;
import java.util.Map;

import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.exceptions.ConnectionException;
import com.payu.sdk.exceptions.InvalidParametersException;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.helper.HttpClientHelper;
import com.payu.sdk.model.Order;
import com.payu.sdk.model.TransactionResponse;
import com.payu.sdk.model.response.ResponseCode;
import com.payu.sdk.reporting.model.ReportingResponse;
import com.payu.sdk.reporting.model.ReportingResponseOrderList;
import com.payu.sdk.utils.RequestUtil;

/**
 * Manages all PayU reports operations
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public final class PayUReports extends PayU {

	/**
	 * Private constructor
	 */
	private PayUReports() {
	}

	/**
	 * Makes a ping petition
	 * 
	 * @return true if the ping is done successfully
	 * @throws PayUException
	 * @throws ConnectionException
	 * 
	 */
	public static boolean doPing() throws PayUException, ConnectionException {

		String res = HttpClientHelper.sendRequest(
				RequestUtil.buildReportingPingRequest(), RequestMethod.POST);
		ReportingResponse response = ReportingResponse.fromXml(res);

		return ResponseCode.SUCCESS.equals(response.getCode());

	}

	/**
	 * Makes an order details reporting petition by the id
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return The found order
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static Order getOrderDetail(Map<String, String> parameters)
			throws PayUException, ConnectionException,
			InvalidParametersException {

		RequestUtil.validateParameters(parameters, PayU.PARAMETERS.ORDER_ID);

		String res = HttpClientHelper.sendRequest(
				RequestUtil.buildOrderReportingDetails(parameters),
				RequestMethod.POST);

		ReportingResponse response = ReportingResponse.fromXml(res);

		if (response.getResult() != null) {
			return (Order) response.getResult().getPayload();
		}

		return null;
	}

	/**
	 * Makes an order details reporting petition by reference code
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return The order list corresponding whit the given reference code
	 * @throws PayUException
	 * @throws ConnectionException
	 * @throws InvalidParametersException
	 */
	public static List<Order> getOrderDetailByReferenceCode(
			Map<String, String> parameters) throws PayUException,
			ConnectionException, InvalidParametersException {

		RequestUtil.validateParameters(parameters,
				PayU.PARAMETERS.REFERENCE_CODE);

		String res = HttpClientHelper.sendRequest(
				RequestUtil.buildOrderReportingByReferenceCode(parameters),
				RequestMethod.POST);

		ReportingResponseOrderList response = ReportingResponseOrderList
				.fromXml(res);

		if (response != null && response.getResult() != null) {
			return response.getResult().getPayload();
		}

		return null;
	}

	/**
	 * Makes a transaction reporting petition by the id
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return The transaction response to the request sent
	 * @throws PayUException
	 * @throws ConnectionException
	 * @throws InvalidParametersException
	 */
	public static TransactionResponse getTransactionResponse(
			Map<String, String> parameters) throws PayUException,
			ConnectionException, InvalidParametersException {

		RequestUtil.validateParameters(parameters,
				PayU.PARAMETERS.TRANSACTION_ID);

		String res = HttpClientHelper.sendRequest(
				RequestUtil.buildTransactionResponse(parameters),
				RequestMethod.POST);

		ReportingResponse response = ReportingResponse.fromXml(res);

		if (response != null && response.getResult() != null) {
			return (TransactionResponse) response.getResult().getPayload();
		}

		return null;
	}

}
