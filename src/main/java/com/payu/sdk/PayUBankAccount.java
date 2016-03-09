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
import com.payu.sdk.paymentplan.model.BankAccount;
import com.payu.sdk.payments.model.BankAccountListResponse;
import com.payu.sdk.utils.PaymentPlanRequestUtil;

/**
 * Manages all PayU bank accounts operations
 *
 * @author PayU Latam
 * @since 1.1.1
 * @version 1.1.1, 11/06/2014
 */
public class PayUBankAccount extends PayU {

	/**
	 * Private constructor
	 */
	private PayUBankAccount() {
	}

	/**
	 * Create a bank account
	 *
	 * @param parameters The parameters to be sent to the server
	 * @return the created bank account
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static BankAccount create(Map<String, String> parameters)
			throws PayUException, InvalidParametersException, ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME,
				PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
				PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE,
				PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME,
				PayU.PARAMETERS.BANK_ACCOUNT_TYPE,
				PayU.PARAMETERS.BANK_ACCOUNT_NUMBER,
				PayU.PARAMETERS.COUNTRY };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		String res = HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildBankAccountRequest(parameters),
				RequestMethod.POST);

		return BankAccount.fromXml(res);
	}

	/**
	 * Return a bank account with the given id
	 *
	 * @param parameters The parameters to be sent to the server
	 * @return the find bank account
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static BankAccount find(Map<String, String> parameters)
			throws PayUException, InvalidParametersException, ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.BANK_ACCOUNT_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		String res = HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildBankAccountRequest(parameters),
				RequestMethod.GET);

		return BankAccount.fromXml(res);
	}

	/**
	 * Update a bank account
	 *
	 * @param parameters The parameters to be sent to the server
	 * @return the updated bank account
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static BankAccount update(Map<String, String> parameters)
			throws PayUException, InvalidParametersException, ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.BANK_ACCOUNT_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		String[] notAllowed = new String[] { PayU.PARAMETERS.CUSTOMER_ID,
				PayU.PARAMETERS.BANK_ACCOUNT_STATE,
				PayU.PARAMETERS.COUNTRY,
				PayU.PARAMETERS.ACCOUNT_ID };

		PaymentPlanRequestUtil.validateNotAllowedParameters(parameters.keySet(), notAllowed);

		String res = HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildBankAccountRequest(parameters),
				RequestMethod.PUT);

		return BankAccount.fromXml(res);
	}

	/**
	 * Delete a bank account with the given customer id and token
	 *
	 * @param parameters The parameters to be sent to the server
	 * @return true if the bank account was deleted
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 * @throws PayUException
	 */
	public static boolean delete(Map<String, String> parameters)
			throws InvalidParametersException, ConnectionException, PayUException {

		String[] required = new String[] { PayU.PARAMETERS.CUSTOMER_ID,
				PayU.PARAMETERS.BANK_ACCOUNT_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildBankAccountRequest(parameters),
				RequestMethod.DELETE);

		return true;
	}

	/**
	 * Returns the bank account list with the query params
	 *
	 * @param parameters The parameters to be sent to the server
	 * @return the bank account list
	 * @throws PayUException
	 * @throws InvalidParametersException
	 * @throws ConnectionException
	 */
	public static List<BankAccount> findList(Map<String, String> parameters)
			throws PayUException, InvalidParametersException, ConnectionException {

		String[] required = new String[] { PayU.PARAMETERS.CUSTOMER_ID };

		PaymentPlanRequestUtil.validateParameters(parameters, required);

		String res = HttpClientHelper.sendRequest(
				PaymentPlanRequestUtil.buildBankAccountListRequest(parameters),
				RequestMethod.GET);

		BankAccountListResponse response = BankAccountListResponse
				.fromXml(res);

		return response.getBankAccountList();
	}

}
