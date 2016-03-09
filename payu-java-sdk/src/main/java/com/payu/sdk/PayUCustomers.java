package com.payu.sdk;

import java.util.List;
import java.util.Map;

import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.exceptions.ConnectionException;
import com.payu.sdk.exceptions.InvalidParametersException;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.helper.HttpClientHelper;
import com.payu.sdk.paymentplan.model.Customer;
import com.payu.sdk.payments.model.CustomerListResponse;
import com.payu.sdk.utils.PaymentPlanRequestUtil;

/**
 * Manages all PayU customers operations
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 05/09/2013
 */
public final class PayUCustomers extends PayU {

	/**
	 * Private constructor
	 */
	private PayUCustomers() {
	}

	/**
	 * Creates a customer
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the created customer
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static Customer create(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] required = new String[] {};

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		if (parameters.get(PayU.PARAMETERS.CUSTOMER_NAME) == null
				&& parameters.get(PayU.PARAMETERS.CUSTOMER_EMAIL) == null) {
			throw new InvalidParametersException(
					"You must register the [customerName] or [customerEmail]");
		}

		String res = HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildCustomerRequest(parameters),
				RequestMethod.POST);

		return Customer.fromXml(res);
	}

	/**
	 * Returns a customer with the given id
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the created customer
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static Customer find(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.CUSTOMER_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		String res = HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildCustomerRequest(parameters),
				RequestMethod.GET);

		return Customer.fromXml(res);
	}

	/**
	 * Returns a customer with the given id
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the created customer
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static List<Customer> findList(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String res = HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildCustomerListRequest(parameters),
				RequestMethod.GET);

		return CustomerListResponse.fromXml(res).getCustomerList();
	}
	/**
	 * Creates a Customer with a CreditCard
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the created Customer with a CreditCard
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static Customer createCustomerWithCreditCard(
			Map<String, String> parameters) throws PayUException,
			InvalidParametersException, ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.CREDIT_CARD_NUMBER,
				PayU.PARAMETERS.PAYER_NAME,
				PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE,
				PayU.PARAMETERS.PAYMENT_METHOD };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME,
				parameters.get(PayU.PARAMETERS.PAYER_NAME));

		String res = HttpClientHelper.sendRequest(PaymentPlanRequestUtil
				.buildCustomerWithCreditCardRequest(parameters),
				RequestMethod.POST);

		return Customer.fromXml(res);
	}
	
	
	/**
	 * Creates a Customer with a BankAccount
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the created Customer with a BankAccount
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static Customer createCustomerWithBankAccount(
			Map<String, String> parameters) throws PayUException,
			InvalidParametersException, ConnectionException {


		String res = HttpClientHelper.sendRequest(PaymentPlanRequestUtil
				.buildCustomerWithBankAccountRequest(parameters),
				RequestMethod.POST);

		return Customer.fromXml(res);
	}
	

	/**
	 * Update a customer with the given id
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return the created customer
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static Customer update(Map<String, String> parameters)
			throws PayUException, InvalidParametersException,
			ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.CUSTOMER_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		if (parameters.get(PayU.PARAMETERS.CUSTOMER_NAME) == null
				&& parameters.get(PayU.PARAMETERS.CUSTOMER_EMAIL) == null) {
			throw new InvalidParametersException(
					"You must register the [customerName] or [customerEmail]");
		}

		String res = HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildCustomerRequest(parameters),
				RequestMethod.PUT);

		return Customer.fromXml(res);
	}

	/**
	 * Deletes a customer with the given id
	 * 
	 * @param parameters
	 *            The parameters to be sent to the server
	 * @return true if the customer was deleted
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 * @throws PayUException
	 */
	public static boolean delete(Map<String, String> parameters)
			throws InvalidParametersException, ConnectionException, PayUException {

		String[] required = new String[] { PayU.PARAMETERS.CUSTOMER_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildCustomerRequest(parameters),
				RequestMethod.DELETE);

		return true;
	}
}
