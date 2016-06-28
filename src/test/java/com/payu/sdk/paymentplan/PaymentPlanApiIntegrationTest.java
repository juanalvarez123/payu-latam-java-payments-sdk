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
package com.payu.sdk.paymentplan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.payu.sdk.PayU;
import com.payu.sdk.PayUBankAccount;
import com.payu.sdk.PayUCreditCard;
import com.payu.sdk.PayUCustomers;
import com.payu.sdk.PayUPlans;
import com.payu.sdk.PayURecurringBill;
import com.payu.sdk.PayURecurringBillItem;
import com.payu.sdk.PayUSubscription;
import com.payu.sdk.constants.Constants;
import com.payu.sdk.exceptions.AuthenticationException;
import com.payu.sdk.exceptions.ConnectionException;
import com.payu.sdk.exceptions.InvalidParametersException;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.exceptions.SDKException;
import com.payu.sdk.exceptions.SDKException.ErrorCode;
import com.payu.sdk.model.Language;
import com.payu.sdk.model.PaymentCountry;
import com.payu.sdk.model.PaymentMethodType;
import com.payu.sdk.paymentplan.model.BankAccount;
import com.payu.sdk.paymentplan.model.Customer;
import com.payu.sdk.paymentplan.model.PaymentPlanCreditCard;
import com.payu.sdk.paymentplan.model.RecurringBill;
import com.payu.sdk.paymentplan.model.RecurringBillItem;
import com.payu.sdk.paymentplan.model.Subscription;
import com.payu.sdk.paymentplan.model.SubscriptionPlan;
import com.payu.sdk.util.TestEnvironment;
import com.payu.sdk.utils.LoggerUtil;

/**
 *
 * @author PayULatam
 * @since 1.0.0
 * @date 04/09/2013
 * @version 1.0
 */
public class PaymentPlanApiIntegrationTest {

	/**
	 * Default response log message
	 */
	private static final String RESPONSE_LOG_MESSAGE = "{0}";

	/**
	 * the created customer id
	 */
	protected static String customerId;

	/**
	 * the created plan id
	 */
	protected static String planId;

	/**
	 * the created plan code
	 */
	protected static String planCode;

	/**
	 * the created subscriptionId
	 */
	protected static String subscriptionId;

	/**
	 * the created recurringBillItemId
	 */
	protected static String recurringBillItemId;

	/**
	 * the created recurringBillId
	 */
	protected static String recurringBillId;

	/**
	 * The created token id
	 */
	protected static String tokenId;

	private String customerIdWithBankAccount;

	private String customerIdWithBanckAccountBrazil;

	private String bankAccountIdBrazil;

	@BeforeClass
	private void init() {
		PayU.apiKey = "012345678901";
		PayU.apiLogin = "012345678901";
		PayU.merchantId = "1";
		PayU.language = Language.en;
		PayU.isTest = false;

		TestEnvironment enviroment = TestEnvironment.STG;
		PayU.paymentsUrl = enviroment.getPaymentsApiUrl();

		LoggerUtil.setLogLevel(Level.ALL);
	}

	/**
	 * Create customer test
	 */
	@Test(priority = 1)
	public void createCustomer() {

		Thread.currentThread().setName("createCustomer");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Test");
		parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL, "prueba@payulatam.com");

		try {
			Customer response = PayUCustomers.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty customer response");

			customerId = response.getId();

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Create customer test
	 */
	@Test(expectedExceptions = InvalidParametersException.class)
	public void createCustomerInvalidParameters() throws SDKException {

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, "aBC");

		PayUCustomers.create(parameters);

		Assert.fail("No exception thrown");

	}

	/**
	 * get customer test
	 */
	@Test(dependsOnMethods = "createCustomer")
	public void getCustomer() {

		Thread.currentThread().setName("getCustomer");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);

		try {
			Customer response = PayUCustomers.find(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			customerId = response.getId();

			Assert.assertNotNull(response, "Null customer response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * update customer test
	 */
	@Test(dependsOnMethods = "createCustomer")
	public void updateCustomer() {

		Thread.currentThread().setName("updateCustomer");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Pepito");

		try {
			Customer response = PayUCustomers.update(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			customerId = response.getId();

			Assert.assertNotNull(response, "Empty customer response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Delete a customer test
	 */
	@Test(dependsOnMethods = { "updateCustomer", "deleteCreditCard",
			"cancelSubscription" })
	public void deleteCustomer() {

		Thread.currentThread().setName("deleteCustomer");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);

		try {
			boolean response = PayUCustomers.delete(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertTrue(response, "Can't delete the customer");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Error deleting a customer
	 *
	 * @throws PayUException
	 * @throws InvalidParametersException
	 */
	@Test(dependsOnMethods = "updateCustomer", expectedExceptions = SDKException.class)
	public void invalidDeleteCustomer() throws InvalidParametersException,
			PayUException {

		Thread.currentThread().setName("invalidDeleteCustomer");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, "123");

		try {
			PayUCustomers.delete(parameters);

			Assert.fail("is valid?");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		}

	}

	/**
	 * Update customer test
	 */
	@Test(expectedExceptions = InvalidParametersException.class)
	public void updateCustomerInvalidParameters() throws SDKException {

		Thread.currentThread().setName("updateCustomerInvalidParameters");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, "aBC");

		PayUCustomers.update(parameters);

		Assert.fail("No exception thrown");

	}

	/**
	 * Authentication exception
	 *
	 * @throws PayUException
	 */
	@Test(expectedExceptions = { AuthenticationException.class,
			ConnectionException.class })
	public void testAuthenticationException() throws SDKException {

		String currentApiKey = PayU.apiKey;

		try {

			PayU.apiKey = Constants.EMPTY_STRING;

			Thread.currentThread().setName("testAuthenticationException");

			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Name");
			parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL,
					"email@payulatam.com");

			PayUCustomers.create(parameters);
			Assert.fail("No exception was thrown");

		} finally {
			PayU.apiKey = currentApiKey;
		}

	}

	/**
	 * Create a plan test
	 */
	@Test(priority = 2)
	public void createPlan() {

		Thread.currentThread().setName("createPlan");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.PLAN_DESCRIPTION, "Basic Plan");
		parameters.put(PayU.PARAMETERS.PLAN_CODE,
				"ASd456" + System.currentTimeMillis());
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL, "MONTH");
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL_COUNT, "12");
		parameters.put(PayU.PARAMETERS.PLAN_CURRENCY, "COP");
		parameters.put(PayU.PARAMETERS.PLAN_VALUE, "50000");
		parameters.put(PayU.PARAMETERS.PLAN_TAX, "10000");
		parameters.put(PayU.PARAMETERS.PLAN_TAX_RETURN_BASE, "40000");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "2");
		parameters.put(PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PAYMENTS, "2");

		parameters.put(PayU.PARAMETERS.PLAN_MAX_PAYMENT_ATTEMPTS, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PENDING_PAYMENTS, "2");

		try {
			SubscriptionPlan response = PayUPlans.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty plan response");

			planId = response.getId();
			planCode = response.getPlanCode();

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Find a plan test
	 */
	@Test(dependsOnMethods = "createPlan")
	public void findPlan() {

		Thread.currentThread().setName("findPlan");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.PLAN_CODE, planCode);

		try {
			SubscriptionPlan response = PayUPlans.find(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty plan response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Find a plan list test
	 */
	@Test
	public void findPLanListTest0() {

		Thread.currentThread().setName("findPlanListTest0");

		Map<String, String> parameters = new HashMap<String, String>();
		try {
			List<SubscriptionPlan> response = PayUPlans.findList(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response,
					"Empty subscription plan list response");
		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Find a plan list test
	 */
	@Test
	public void findPLanListTest1() {

		Thread.currentThread().setName("findPlanListTest1");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");

		try {
			List<SubscriptionPlan> response = PayUPlans.findList(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response,
					"Empty subscription plan list response");
		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Find a plan list test
	 */
	@Test
	public void findPLanListTest2() {

		Thread.currentThread().setName("findPlanListTest2");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.LIMIT, "2");
		parameters.put(PayU.PARAMETERS.OFFSET, "2");

		try {
			List<SubscriptionPlan> response = PayUPlans.findList(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response,
					"Empty subscription plan list response");
		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Find a subscription test
	 */
	@Test(dependsOnMethods = "createBasicSubscription")
	public void findSubscription() {

		Thread.currentThread().setName("findSubscription");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, subscriptionId);

		try {
			Subscription response = PayUSubscription.find(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty plan response");
			Assert.assertNotNull(response.getCreditCardToken(), "Empty credit card token response");
			Assert.assertEquals(response.getCreditCardToken(), tokenId);

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Update a plan test
	 */
	@Test(dependsOnMethods = "findPlan")
	public void updatePlan() {

		Thread.currentThread().setName("updatePlan");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.PLAN_DESCRIPTION, "New Basic Plan");
		parameters.put(PayU.PARAMETERS.PLAN_CODE, planCode);
		parameters.put(PayU.PARAMETERS.PLAN_CURRENCY, "COP");
		parameters.put(PayU.PARAMETERS.PLAN_VALUE, "100000");
		parameters.put(PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY, "3");
		parameters.put(PayU.PARAMETERS.PLAN_TAX, "10000");
		parameters.put(PayU.PARAMETERS.PLAN_TAX_RETURN_BASE, "40000");

		try {
			SubscriptionPlan response = PayUPlans.update(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty plan response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * find Subscription Test
	 */
	@Test(dependsOnMethods = "findSubscription")
	public void updateSubscription() {

		Thread.currentThread().setName("updateSubscription");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, subscriptionId);

		try {

			Subscription subscription = PayUSubscription.find(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, subscription);
			Assert.assertNotNull(subscription,
					"Empty Subscription card response");
			Assert.assertNotNull(subscription.getCreditCardToken());
			Assert.assertEquals(subscription.getCreditCardToken(), tokenId);

		} catch (ConnectionException e) {
			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());

		} catch (SDKException e) {
			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

		String newTokenId = "";
		Map<String, String> parametersCC = new HashMap<String, String>();
		parametersCC.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);

		// Credit card parameters
		parametersCC
				.put(PayU.PARAMETERS.CREDIT_CARD_NUMBER, "5511275364819572");
		parametersCC
				.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2020/12");
		parametersCC.put(PayU.PARAMETERS.PAYMENT_METHOD, "MASTERCARD");

		parametersCC.put(PayU.PARAMETERS.PAYER_NAME, "Manuel V");
		parametersCC.put(PayU.PARAMETERS.PAYER_STREET, "Calle 93B");
		parametersCC.put(PayU.PARAMETERS.PAYER_STREET_2, "17 25");
		parametersCC.put(PayU.PARAMETERS.PAYER_STREET_3, "Oficina 301");
		parametersCC.put(PayU.PARAMETERS.PAYER_CITY, "Bogotá");
		parametersCC.put(PayU.PARAMETERS.PAYER_STATE, "Bogotá D.C.");
		parametersCC.put(PayU.PARAMETERS.PAYER_COUNTRY,
				PaymentCountry.CO.name());
		parametersCC.put(PayU.PARAMETERS.PAYER_POSTAL_CODE, "00000");
		parametersCC.put(PayU.PARAMETERS.PAYER_PHONE, "300300300");

		try {
			PaymentPlanCreditCard response = PayUCreditCard
					.create(parametersCC);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response, "Empty credit card response");
			Assert.assertNotNull(response.getToken());
			newTokenId = response.getToken();

		} catch (ConnectionException e) {
			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());

		} catch (SDKException e) {
			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

		Map<String, String> parametersSubscription = new HashMap<String, String>();
		parametersSubscription.put(PayU.PARAMETERS.SUBSCRIPTION_ID,
				subscriptionId);
		parametersSubscription.put(PayU.PARAMETERS.TOKEN_ID, newTokenId);

		try {

			Subscription response = PayUSubscription
					.update(parametersSubscription);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response, "Empty plan response");

			Subscription subscription = PayUSubscription.find(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, subscription);
			Assert.assertNotNull(subscription,
					"Empty Subscription card response");
			Assert.assertNotNull(subscription.getCreditCardToken());
			Assert.assertEquals(subscription.getCreditCardToken(), newTokenId);

		} catch (ConnectionException e) {
			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());

		} catch (SDKException e) {
			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Delete a plan test
	 */
	@Test(dependsOnMethods = "updatePlan")
	public void deletePlan() {

		Thread.currentThread().setName("deletePlan");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.PLAN_CODE, planCode);

		try {
			boolean response = PayUPlans.delete(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertTrue(response, "Can't delete the plan");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Error deleting a plan test
	 */
	@Test
	public void invalidDeletePlan() {

		Thread.currentThread().setName("deletePlan");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.PLAN_CODE, "12399999999");

		try {
			PayUPlans.delete(parameters);

			Assert.fail("is valid?");

		} catch (ConnectionException e) {

			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {
			LoggerUtil.error(e.getMessage(), e);
		}

	}

	/**
	 * Create credit card test
	 */
	@Test(dependsOnMethods = "createCustomer")
	public void createCreditCard() {

		Thread.currentThread().setName("createCreditCard");

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);

		// Credit card parameters
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_NUMBER, "4005580000029205");
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2030/01");
		parameters.put(PayU.PARAMETERS.PAYMENT_METHOD, "VISA");

		parameters.put(PayU.PARAMETERS.PAYER_NAME, "Oscar R");
		parameters.put(PayU.PARAMETERS.PAYER_STREET, "Calle 93B");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_2, "17 25");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_3, "Oficina 301");
		parameters.put(PayU.PARAMETERS.PAYER_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.PAYER_STATE, "Bogotá D.C.");
		parameters.put(PayU.PARAMETERS.PAYER_COUNTRY, PaymentCountry.CO.name());
		parameters.put(PayU.PARAMETERS.PAYER_POSTAL_CODE, "00000");
		parameters.put(PayU.PARAMETERS.PAYER_PHONE, "300300300");
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_DOCUMENT, "123321123");

		try {
			PaymentPlanCreditCard response = PayUCreditCard.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty credit card response");

			tokenId = response.getToken();

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Find the created token by customer
	 *
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods = "createCreditCard")
	public void getCreditCardList() throws InterruptedException {

		Thread.currentThread().setName("getCreditCardList");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);

		try {
			List<PaymentPlanCreditCard> response = PayUCreditCard
					.findList(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Null response");
			Assert.assertFalse(response.isEmpty(), "Empty response");
			for (PaymentPlanCreditCard paymentPlanCreditCard : response) {
				Assert.assertNotNull(paymentPlanCreditCard.getToken(),
						"Null token");
				Assert.assertNotNull(paymentPlanCreditCard.getCustomerId(),
						"Null customer");
				Assert.assertNull(paymentPlanCreditCard.getExpMonth(),
						"Not null month");
				Assert.assertNotNull(paymentPlanCreditCard.getName(),
						"Null payer name");
				Assert.assertNotNull(paymentPlanCreditCard.getAddress(),
						"Null address");
				Assert.assertNotNull(paymentPlanCreditCard.getAddress()
						.getCountry(), "Null country");
			}
			Thread.currentThread().setName("updateCreditCard");
		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Get credit card test
	 */
	@Test(dependsOnMethods = "createCreditCard")
	public void getCreditCard() {

		Thread.currentThread().setName("getCreditCard");

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put(PayU.PARAMETERS.TOKEN_ID, tokenId);

		try {
			PaymentPlanCreditCard response = PayUCreditCard.find(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty credit card response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Update credit card test
	 */
	@Test(dependsOnMethods = "createCreditCard")
	public void updateCreditCard() {

		Thread.currentThread().setName("updateCreditCard");

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put(PayU.PARAMETERS.TOKEN_ID, tokenId);

		parameters.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2030/01");

		parameters.put(PayU.PARAMETERS.PAYER_NAME, "Santiago A");
		parameters.put(PayU.PARAMETERS.PAYER_STREET, "Calle 152");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_2, "58 50");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_3, "2 - 903");
		parameters.put(PayU.PARAMETERS.PAYER_CITY, "Cali");
		parameters.put(PayU.PARAMETERS.PAYER_STATE, "Valle");
		parameters.put(PayU.PARAMETERS.PAYER_COUNTRY, PaymentCountry.PA.name());
		parameters.put(PayU.PARAMETERS.PAYER_POSTAL_CODE, "11111");
		parameters.put(PayU.PARAMETERS.PAYER_PHONE, "500500500");
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_DOCUMENT, "010101010101");

		try {
			PaymentPlanCreditCard response = PayUCreditCard.update(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty credit card response");

			tokenId = response.getToken();

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Create Customer with a CreditCard test
	 */
	@Test
	public void createCustomerWithCreditCard() {

		Thread.currentThread().setName("createCustomerWithCreditCard");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL, "prueba@payulatam.com");

		// Credit card data
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_NUMBER, "4005580000029205");
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2025/01");
		parameters.put(PayU.PARAMETERS.PAYMENT_METHOD, "VISA");

		parameters.put(PayU.PARAMETERS.PAYER_NAME, "Luis Alejandro");
		parameters.put(PayU.PARAMETERS.PAYER_STREET, "Calle 93B");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_2, "17 25");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_3, "Oficina 301");
		parameters.put(PayU.PARAMETERS.PAYER_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.PAYER_STATE, "Bogotá D.C.");
		parameters.put(PayU.PARAMETERS.PAYER_COUNTRY, PaymentCountry.CO.name());
		parameters.put(PayU.PARAMETERS.PAYER_POSTAL_CODE, "00000");
		parameters.put(PayU.PARAMETERS.PAYER_PHONE, "300300300");

		try {
			Customer response = PayUCustomers
					.createCustomerWithCreditCard(parameters);

			customerId = response.getId();
			tokenId = response.getCreditCards().get(0).getToken();

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response,
					"Empty Customer with a CreditCard response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Delete a credit card test
	 */
	@Test(dependsOnMethods = { "updateCreditCard", "getRecurringBill" })
	public void deleteCreditCard() {

		Thread.currentThread().setName("deleteCreditCard");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.TOKEN_ID, tokenId);
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);

		try {
			boolean response = PayUCreditCard.delete(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertTrue(response, "Can't delete the credit card");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Error deleting a credit card
	 */
	@Test()
	public void invalidDeleteCreditCard() {

		Thread.currentThread().setName("invalidDeleteCreditCard");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.TOKEN_ID, "123");
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, "123");

		try {
			PayUCreditCard.delete(parameters);

			Assert.fail("is valid?");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
		}

	}

	/**
	 * Create basic subscription test
	 */
	@Test(dependsOnMethods = { "createCustomer", "createPlan",
			"createCreditCard" })
	public void createBasicSubscription() {

		Thread.currentThread().setName("createBasicSubscription");

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put(PayU.PARAMETERS.PLAN_CODE, planCode);
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);
		parameters.put(PayU.PARAMETERS.TOKEN_ID, tokenId);
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.NOTIFY_URL, "testUrl");
		parameters.put(PayU.PARAMETERS.SOURCE_REFERENCE, "testSourceReference");
		parameters.put(PayU.PARAMETERS.EXTRA1, "extra1");
		parameters.put(PayU.PARAMETERS.EXTRA2, "extra2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_1, "line1");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_2, "line2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_3, "line3");
		parameters.put(PayU.PARAMETERS.DELIVERY_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.DELIVERY_STATE, "Cundinamarca");
		parameters.put(PayU.PARAMETERS.DELIVERY_COUNTRY, "CO");
		parameters.put(PayU.PARAMETERS.DELIVERY_POSTAL_CODE, "101010");
		parameters.put(PayU.PARAMETERS.DELIVERY_PHONE, "777123123");

		try {
			Subscription response = PayUSubscription.create(parameters);
			subscriptionId = response.getId();
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty subscription response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Create subscription test with existing plan
	 */
	@Test(dependsOnMethods = "createPlan")
	public void createSubscriptionExistingPlan() {

		Thread.currentThread().setName("createSubscriptionExistingPlan");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.NOTIFY_URL, "testUrl");
		parameters.put(PayU.PARAMETERS.SOURCE_REFERENCE, "testSourceReference");
		parameters.put(PayU.PARAMETERS.EXTRA1, "extra1");
		parameters.put(PayU.PARAMETERS.EXTRA2, "extra2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_1, "line1");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_2, "line2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_3, "line3");
		parameters.put(PayU.PARAMETERS.DELIVERY_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.DELIVERY_STATE, "Cundinamarca");
		parameters.put(PayU.PARAMETERS.DELIVERY_COUNTRY, "CO");
		parameters.put(PayU.PARAMETERS.DELIVERY_POSTAL_CODE, "101010");
		parameters.put(PayU.PARAMETERS.DELIVERY_PHONE, "777123123");

		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Oscar");
		parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL, "prueba@payulatam.com");

		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_ID, planId);

		// Credit card parameters
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_NUMBER, "4005580000029205");
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2030/01");
		parameters.put(PayU.PARAMETERS.PAYMENT_METHOD, "VISA");

		parameters.put(PayU.PARAMETERS.PAYER_NAME, "Santiago A");
		parameters.put(PayU.PARAMETERS.PAYER_STREET, "Calle 93B");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_2, "17 25");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_3, "Oficina 301");
		parameters.put(PayU.PARAMETERS.PAYER_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.PAYER_STATE, "Bogotá D.C.");
		parameters.put(PayU.PARAMETERS.PAYER_COUNTRY, PaymentCountry.CO.name());
		parameters.put(PayU.PARAMETERS.PAYER_POSTAL_CODE, "00000");
		parameters.put(PayU.PARAMETERS.PAYER_PHONE, "300300300");

		try {
			Subscription response = PayUSubscription.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty subscription response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Create subscription test with existing customer and credit card
	 */
	@Test(dependsOnMethods = { "createCustomer", "createCreditCard" })
	public void createSubscriptionNewPlan() {

		Thread.currentThread().setName("createSubscriptionNewPlan");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.NOTIFY_URL, "testUrl");
		parameters.put(PayU.PARAMETERS.SOURCE_REFERENCE, "testSourceReference");
		parameters.put(PayU.PARAMETERS.EXTRA1, "extra1");
		parameters.put(PayU.PARAMETERS.EXTRA2, "extra2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_1, "line1");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_2, "line2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_3, "line3");
		parameters.put(PayU.PARAMETERS.DELIVERY_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.DELIVERY_STATE, "Cundinamarca");
		parameters.put(PayU.PARAMETERS.DELIVERY_COUNTRY, "CO");
		parameters.put(PayU.PARAMETERS.DELIVERY_POSTAL_CODE, "101010");
		parameters.put(PayU.PARAMETERS.DELIVERY_PHONE, "777123123");

		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);

		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_DESCRIPTION, "Basic Plan");
		parameters.put(PayU.PARAMETERS.PLAN_CODE,
				"ASd456" + System.currentTimeMillis());
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL, "MONTH");
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL_COUNT, "12");
		parameters.put(PayU.PARAMETERS.PLAN_CURRENCY, "COP");
		parameters.put(PayU.PARAMETERS.PLAN_VALUE, "50000");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "2");
		parameters.put(PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PAYMENTS, "2");

		// Credit card parameters
		parameters.put(PayU.PARAMETERS.TOKEN_ID, tokenId);

		try {
			Subscription response = PayUSubscription.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty subscription response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Create subscription test with existing customer
	 */
	@Test(dependsOnMethods = "createCustomer")
	public void createSubscriptionExistingCustomer() {

		Thread.currentThread().setName("createSubscriptionExistingCustomer");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.NOTIFY_URL, "testUrl");
		parameters.put(PayU.PARAMETERS.SOURCE_REFERENCE, "testSourceReference");
		parameters.put(PayU.PARAMETERS.EXTRA1, "extra1");
		parameters.put(PayU.PARAMETERS.EXTRA2, "extra2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_1, "line1");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_2, "line2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_3, "line3");
		parameters.put(PayU.PARAMETERS.DELIVERY_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.DELIVERY_STATE, "Cundinamarca");
		parameters.put(PayU.PARAMETERS.DELIVERY_COUNTRY, "CO");
		parameters.put(PayU.PARAMETERS.DELIVERY_POSTAL_CODE, "101010");
		parameters.put(PayU.PARAMETERS.DELIVERY_PHONE, "777123123");

		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);

		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_DESCRIPTION, "Basic Plan");
		parameters.put(PayU.PARAMETERS.PLAN_CODE,
				"ASd456" + System.currentTimeMillis());
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL, "MONTH");
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL_COUNT, "12");
		parameters.put(PayU.PARAMETERS.PLAN_CURRENCY, "COP");
		parameters.put(PayU.PARAMETERS.PLAN_VALUE, "50000");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "2");
		parameters.put(PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PAYMENTS, "2");

		// Credit card parameters
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_NUMBER, "4005580000029205");
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2030/01");
		parameters.put(PayU.PARAMETERS.PAYMENT_METHOD, "VISA");

		parameters.put(PayU.PARAMETERS.PAYER_NAME, "Santiago A");
		parameters.put(PayU.PARAMETERS.PAYER_STREET, "Calle 93B");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_2, "17 25");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_3, "Oficina 301");
		parameters.put(PayU.PARAMETERS.PAYER_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.PAYER_STATE, "Bogotá D.C.");
		parameters.put(PayU.PARAMETERS.PAYER_COUNTRY, PaymentCountry.CO.name());
		parameters.put(PayU.PARAMETERS.PAYER_POSTAL_CODE, "00000");
		parameters.put(PayU.PARAMETERS.PAYER_PHONE, "300300300");

		try {
			Subscription response = PayUSubscription.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty subscription response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Create empty subscription test
	 *
	 * @throws SDKException
	 */
	@Test(expectedExceptions = SDKException.class)
	public void createEmptySubscription() throws SDKException {
		Thread.currentThread().setName("createEmptySubscription");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.NOTIFY_URL, "testUrl");
		parameters.put(PayU.PARAMETERS.SOURCE_REFERENCE, "testSourceReference");
		parameters.put(PayU.PARAMETERS.EXTRA1, "extra1");
		parameters.put(PayU.PARAMETERS.EXTRA2, "extra2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_1, "line1");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_2, "line2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_3, "line3");
		parameters.put(PayU.PARAMETERS.DELIVERY_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.DELIVERY_STATE, "Cundinamarca");
		parameters.put(PayU.PARAMETERS.DELIVERY_COUNTRY, "CO");
		parameters.put(PayU.PARAMETERS.DELIVERY_POSTAL_CODE, "101010");
		parameters.put(PayU.PARAMETERS.DELIVERY_PHONE, "777123123");

		Subscription response = PayUSubscription.create(parameters);

		LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

		Assert.fail("No exception was thrown");

	}

	/**
	 * Create failed subscription test
	 *
	 * @throws SDKException
	 */
	@Test(expectedExceptions = SDKException.class)
	public void createFailedSubscription() throws SDKException {

		Thread.currentThread().setName("createFailedSubscription");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.NOTIFY_URL, "testUrl");
		parameters.put(PayU.PARAMETERS.SOURCE_REFERENCE, "testSourceReference");
		parameters.put(PayU.PARAMETERS.EXTRA1, "extra1");
		parameters.put(PayU.PARAMETERS.EXTRA2, "extra2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_1, "line1");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_2, "line2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_3, "line3");
		parameters.put(PayU.PARAMETERS.DELIVERY_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.DELIVERY_STATE, "Cundinamarca");
		parameters.put(PayU.PARAMETERS.DELIVERY_COUNTRY, "CO");
		parameters.put(PayU.PARAMETERS.DELIVERY_POSTAL_CODE, "101010");
		parameters.put(PayU.PARAMETERS.DELIVERY_PHONE, "777123123");

		// Customer parameters

		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_DESCRIPTION, "Basic Plan");

		// Credit card parameters
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2015/01");

		Subscription response = PayUSubscription.create(parameters);

		LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

		Assert.fail("No exception was thrown");

	}

	/**
	 * Create failed subscription test2
	 *
	 * @throws SDKException
	 */
	@Test(expectedExceptions = SDKException.class)
	public void createFailedSubscription2() throws SDKException {

		Thread.currentThread().setName("createFailedSubscription");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.NOTIFY_URL, "testUrl");
		parameters.put(PayU.PARAMETERS.SOURCE_REFERENCE, "testSourceReference");
		parameters.put(PayU.PARAMETERS.EXTRA1, "extra1");
		parameters.put(PayU.PARAMETERS.EXTRA2, "extra2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_1, "line1");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_2, "line2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_3, "line3");
		parameters.put(PayU.PARAMETERS.DELIVERY_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.DELIVERY_STATE, "Cundinamarca");
		parameters.put(PayU.PARAMETERS.DELIVERY_COUNTRY, "CO");
		parameters.put(PayU.PARAMETERS.DELIVERY_POSTAL_CODE, "101010");
		parameters.put(PayU.PARAMETERS.DELIVERY_PHONE, "777123123");

		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_CODE, planCode);

		// Credit card parameters
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2015/01");

		Subscription response = PayUSubscription.create(parameters);

		LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

		Assert.fail("No exception was thrown");

	}

	/**
	 * Create failed full subscription test
	 *
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = { "createCustomer", "createPlan",
			"createCreditCard" }, expectedExceptions = SDKException.class)
	public void createFailedFullSubscription() throws SDKException {

		Thread.currentThread().setName("createFailedFullSubscription");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.NOTIFY_URL, "testUrl");
		parameters.put(PayU.PARAMETERS.SOURCE_REFERENCE, "testSourceReference");
		parameters.put(PayU.PARAMETERS.EXTRA1, "extra1");
		parameters.put(PayU.PARAMETERS.EXTRA2, "extra2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_1, "line1");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_2, "line2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_3, "line3");
		parameters.put(PayU.PARAMETERS.DELIVERY_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.DELIVERY_STATE, "Cundinamarca");
		parameters.put(PayU.PARAMETERS.DELIVERY_COUNTRY, "CO");
		parameters.put(PayU.PARAMETERS.DELIVERY_POSTAL_CODE, "101010");
		parameters.put(PayU.PARAMETERS.DELIVERY_PHONE, "777123123");

		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Name");
		parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL, "prueba@payulatam.com");

		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_DESCRIPTION, "Basic Plan");
		parameters.put(PayU.PARAMETERS.PLAN_CODE,
				"ASd456" + System.currentTimeMillis());
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL, "MONTH");
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL_COUNT, "12");
		parameters.put(PayU.PARAMETERS.PLAN_CURRENCY, "COP");
		parameters.put(PayU.PARAMETERS.PLAN_VALUE, "50000");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "2");
		parameters.put(PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PAYMENTS, "2");

		// Credit card parameters
		parameters.put(PayU.PARAMETERS.TOKEN_ID, tokenId);
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_NUMBER, "4005580000029205");
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2015/01");
		parameters.put(PayU.PARAMETERS.PAYMENT_METHOD, "VISA");

		parameters.put(PayU.PARAMETERS.PAYER_NAME, "Santiago A");
		parameters.put(PayU.PARAMETERS.PAYER_STREET, "Calle 93B");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_2, "17 25");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_3, "Oficina 301");
		parameters.put(PayU.PARAMETERS.PAYER_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.PAYER_STATE, "Bogotá D.C.");
		parameters.put(PayU.PARAMETERS.PAYER_COUNTRY, PaymentCountry.CO.name());
		parameters.put(PayU.PARAMETERS.PAYER_POSTAL_CODE, "00000");
		parameters.put(PayU.PARAMETERS.PAYER_PHONE, "300300300");

		Subscription response;

		response = PayUSubscription.create(parameters);

		LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

		Assert.fail("No exception was thrown");

	}

	/**
	 * Create full subscription test
	 */
	@Test
	public void createFullSubscription() {

		Thread.currentThread().setName("createFullSubscription");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.NOTIFY_URL, "testUrl");
		parameters.put(PayU.PARAMETERS.SOURCE_REFERENCE, "testSourceReference");
		parameters.put(PayU.PARAMETERS.EXTRA1, "extra1");
		parameters.put(PayU.PARAMETERS.EXTRA2, "extra2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_1, "line1");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_2, "line2");
		parameters.put(PayU.PARAMETERS.DELIVERY_ADDRESS_3, "line3");
		parameters.put(PayU.PARAMETERS.DELIVERY_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.DELIVERY_STATE, "Cundinamarca");
		parameters.put(PayU.PARAMETERS.DELIVERY_COUNTRY, "CO");
		parameters.put(PayU.PARAMETERS.DELIVERY_POSTAL_CODE, "101010");
		parameters.put(PayU.PARAMETERS.DELIVERY_PHONE, "777123123");

		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Oscar");
		parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL, "prueba@payulatam.com");

		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_DESCRIPTION, "Basic Plan");
		parameters.put(PayU.PARAMETERS.PLAN_CODE,
				"ASd456" + System.currentTimeMillis());
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL, "MONTH");
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL_COUNT, "12");
		parameters.put(PayU.PARAMETERS.PLAN_CURRENCY, "COP");
		parameters.put(PayU.PARAMETERS.PLAN_VALUE, "50000");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "2");
		parameters.put(PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PAYMENTS, "2");

		// Credit card parameters
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_NUMBER, "4005580000029205");
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2030/01");
		parameters.put(PayU.PARAMETERS.PAYMENT_METHOD, "VISA");

		parameters.put(PayU.PARAMETERS.PAYER_NAME, "Santiago A");
		parameters.put(PayU.PARAMETERS.PAYER_STREET, "Calle 93B");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_2, "17 25");
		parameters.put(PayU.PARAMETERS.PAYER_STREET_3, "Oficina 301");
		parameters.put(PayU.PARAMETERS.PAYER_CITY, "Bogotá");
		parameters.put(PayU.PARAMETERS.PAYER_STATE, "Bogotá D.C.");
		parameters.put(PayU.PARAMETERS.PAYER_COUNTRY, PaymentCountry.CO.name());
		parameters.put(PayU.PARAMETERS.PAYER_POSTAL_CODE, "00000");
		parameters.put(PayU.PARAMETERS.PAYER_PHONE, "300300300");

		try {
			Subscription response = PayUSubscription.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty subscription response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
	}

	@Test(dependsOnMethods = { "createRecurringBillItem",
			"updateRecurringBillItem", "getRecurringBillItem",
			"getRecurringBillItemBySuscriptionIdAndDescription" })
	public void cancelRecurringBillItem() throws InterruptedException {
		Thread.currentThread().setName("cancelRecurringBillItem");
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.RECURRING_BILL_ITEM_ID,
				recurringBillItemId);
		try {
			boolean response = PayURecurringBillItem.delete(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertTrue(response, "Can't cancel the subscription");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {
			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Cancel subscription
	 *
	 * @throws InterruptedException
	 * @throws SDKException
	 */

	@Test(dependsOnMethods = { "updateSubscription", "cancelRecurringBillItem" })
	public void cancelSubscription() throws InterruptedException {
		Thread.currentThread().setName("cancelSubscription");
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, subscriptionId);
		try {
			boolean response = PayUSubscription.cancel(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertTrue(response, "Can't delete the customer");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {
			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Error canceling a subscription
	 */
	@Test
	public void invalidCancelSubscription() {

		Thread.currentThread().setName("invalidCancelSubscription");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, "123");

		try {
			PayUSubscription.cancel(parameters);

			Assert.fail("is valid?");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);

		}

	}

	/**
	 * Invalid connection
	 */
	@Test
	public void invalidFindCustomer() {

		Thread.currentThread().setName("invalidFindCustomer");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, "-1123");

		try {
			PayUCustomers.find(parameters);

			Assert.fail("No error response");

		} catch (PayUException e) {

			// Invalid parameters
			LoggerUtil.error(e.getMessage(), e);

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	// Recurring bill item

	/**
	 * Create Recurring bill item test
	 */
	@Test(dependsOnMethods = "createBasicSubscription")
	public void createRecurringBillItem() {

		Thread.currentThread().setName("createRecurringBillItem");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test Item SDK JAVA");
		parameters.put(PayU.PARAMETERS.ITEM_VALUE, "100.5");
		parameters.put(PayU.PARAMETERS.CURRENCY, "COP");
		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, subscriptionId);

		parameters.put(PayU.PARAMETERS.ITEM_TAX, "10");
		parameters.put(PayU.PARAMETERS.ITEM_TAX_RETURN_BASE, "90.5");

		try {
			RecurringBillItem response = PayURecurringBillItem
					.create(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response, "Empty recurring bill item response");
			recurringBillItemId = response.getId();
			recurringBillId = response.getRecurringBillId();

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Update Recurring bill item test
	 */
	@Test(dependsOnMethods = "createRecurringBillItem")
	public void updateRecurringBillItem() {

		Thread.currentThread().setName("updateRecurringBillItem");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.RECURRING_BILL_ITEM_ID,
				recurringBillItemId);
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test Item New");
		parameters.put(PayU.PARAMETERS.ITEM_VALUE, "200.5");
		parameters.put(PayU.PARAMETERS.CURRENCY, "COP");
		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, subscriptionId);

		parameters.put(PayU.PARAMETERS.ITEM_TAX, "15");
		parameters.put(PayU.PARAMETERS.ITEM_TAX_RETURN_BASE, "185.5");

		try {
			RecurringBillItem response = PayURecurringBillItem
					.update(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty recurring bill item response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * gets Recurring bill item list by description test
	 */
	@Test(dependsOnMethods = "updateRecurringBillItem")
	public void getRecurringBillItemByDescription() {

		Thread.currentThread().setName("getRecurringBillItemByDescription");

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test Item New");
		try {
			List<RecurringBillItem> response = PayURecurringBillItem
					.findList(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty recurring bill item response");

			Assert.assertFalse(response.isEmpty(),
					"Empty recurring bill item list response");

			for (RecurringBillItem recurringBillItem : response) {
				Assert.assertNotNull(recurringBillItem,
						"Null recurringBillItem");
				Assert.assertNotNull(recurringBillItem.getDescription(),
						"Null recurringBillItem");
				Assert.assertTrue(
						recurringBillItem.getDescription().indexOf(
								"Test Item New") > -1,
						"RecurringBillItem no equals");
				Assert.assertNotNull(recurringBillItem.getSubscriptionId(),
						"Null suscriptionId");
				Assert.assertNotNull(recurringBillItem.getId(),
						"Null recurring bill id");
				Assert.assertNotNull(recurringBillItem.getAdditionalValues(),
						"Null AdditionalValues");
				Assert.assertNotNull(recurringBillItem.getRecurringBillId(),
						"Null RecurringInvoiceId");
			}

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	@Test(dependsOnMethods = "updateRecurringBillItem", expectedExceptions = SDKException.class)
	public void getRecurringBillItemByDescriptionExpectedExceptions()
			throws SDKException {

		Thread.currentThread().setName("getRecurringBillItemByDescription");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, "1234131232");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test Item New1234131232");
		try {
			PayURecurringBillItem.findList(parameters);

			Assert.fail("do not throw SDKException");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {
			// SDK error
			LoggerUtil.info(e.getMessage(), e);
			throw new SDKException(ErrorCode.NO_RESULTS_FOUND);
		}

	}

	/**
	 * gets Recurring bill item list by description test
	 */
	@Test(dependsOnMethods = "updateRecurringBillItem")
	public void getRecurringBillItemBySuscriptionId() {

		Thread.currentThread().setName("getRecurringBillItemBySuscriptionId");

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, subscriptionId);
		try {
			List<RecurringBillItem> response = PayURecurringBillItem
					.findList(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty recurring bill item response");
			Assert.assertFalse(response.isEmpty(),
					"Empty recurring bill item list response");

			for (RecurringBillItem recurringBillItem : response) {
				Assert.assertNotNull(recurringBillItem,
						"Null recurringBillItem");
				Assert.assertNotNull(recurringBillItem.getSubscriptionId(),
						"suscriptionId Error");
				Assert.assertEquals(recurringBillItem.getSubscriptionId(),
						subscriptionId, "subscriptionId no equals");
				Assert.assertEquals(recurringBillItem.getSubscriptionId(),
						subscriptionId, "Null recurringBillItem");
				Assert.assertNotNull(recurringBillItem.getId(),
						"Null recurring bill id");
				Assert.assertNotNull(recurringBillItem.getAdditionalValues(),
						"Null AdditionalValues");
				Assert.assertNotNull(recurringBillItem.getRecurringBillId(),
						"Null RecurringInvoiceId");
			}
		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * gets Recurring bill item list by description test
	 */
	@Test(dependsOnMethods = "updateRecurringBillItem")
	public void getRecurringBillItemBySuscriptionIdAndDescription() {

		Thread.currentThread().setName(
				"getRecurringBillItemBySuscriptionIdAndDescription");

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, subscriptionId);
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test");
		try {
			List<RecurringBillItem> response = PayURecurringBillItem
					.findList(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty recurring bill item response");
			Assert.assertFalse(response.isEmpty(),
					"Empty recurring bill item list response");

			for (RecurringBillItem recurringBillItem : response) {
				Assert.assertNotNull(recurringBillItem,
						"Null recurringBillItem");
				Assert.assertNotNull(recurringBillItem.getSubscriptionId(),
						"suscriptionId Error");
				Assert.assertEquals(recurringBillItem.getSubscriptionId(),
						subscriptionId, "subscriptionId no equals");
				Assert.assertTrue(
						recurringBillItem.getDescription().indexOf("Test Item") > -1,
						"RecurringBillItem no equals");
				Assert.assertEquals(recurringBillItem.getSubscriptionId(),
						subscriptionId, "Null recurringBillItem");
				Assert.assertNotNull(recurringBillItem.getId(),
						"Null recurring bill id");
				Assert.assertNotNull(recurringBillItem.getAdditionalValues(),
						"Null AdditionalValues");
				Assert.assertNotNull(recurringBillItem.getRecurringBillId(),
						"Null RecurringInvoiceId");
			}

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Create a customer with a bank account test
	 */
	@Test
	public void createCustomerWithBankAccount() {

		Thread.currentThread().setName("createCustomerWithBankAccount");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.PAYER_NAME, "Test");
		parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL, "prueba@payulatam.com");
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Usuario de Prueba");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME, "Usuario de Prueba");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
				"1239687789");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CC");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "BANCOLOMBIA");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "SAVING");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "987699921");
		parameters.put(PayU.PARAMETERS.COUNTRY, "CO");

		Customer response = new Customer();
		try {
			response = PayUCustomers.createCustomerWithBankAccount(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty bank account response");
			customerIdWithBankAccount = response.getId();
			Assert.assertNotNull(customerIdWithBankAccount,
					"Empty bank account Identifier response");

		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
	}

	/**
	 * Create a bank account
	 */
	@Test(dependsOnMethods = "createCustomerWithBankAccount")
	public void createBankAccount() {

		Thread.currentThread().setName("createBankAccount");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerIdWithBankAccount);
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Usuario de Prueba");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME, "Usuario de Prueba");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
				"123456789");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CC");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "BANCOLOMBIA");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "SAVING");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "98769321");
		parameters.put(PayU.PARAMETERS.COUNTRY, "CO");

		BankAccount response = new BankAccount();
		try {
			response = PayUBankAccount.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty bank account response");

		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
	}

	/**
	 * Delete the bank accounts the one payer
	 */
	@Test(dependsOnMethods = { "createBankAccount", "findCustomerList" })
	public void deleteBankAccounts() {

		Thread.currentThread().setName("deleteBankAccounts");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerIdWithBankAccount);

		try {
			Customer customer = PayUCustomers.find(parameters);
			Assert.assertNotNull(customer);
			Assert.assertNotNull(customer.getBankAccounts());
			Assert.assertTrue(!customer.getBankAccounts().isEmpty());
			Assert.assertEquals(customer.getBankAccounts().size(), 1);
			for (BankAccount bankAccount : customer.getBankAccounts()) {
				parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ID,
						bankAccount.getId());
				boolean isELiminated = PayUBankAccount.delete(parameters);
				Assert.assertEquals(isELiminated, true);
			}

		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
	}

	/**
	 * Delete a customer with bank account test
	 */
	@Test(dependsOnMethods = { "createCustomerWithBankAccount",
			"deleteBankAccounts" })
	public void deleteCustomerWithBankAccount() {

		Thread.currentThread().setName("deleteCustomerWithBankAccount");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerIdWithBankAccount);

		try {
			boolean response = PayUCustomers.delete(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertTrue(response, "Can't delete the customer");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Create a customer with a bank from brazil account test
	 */
	@Test
	public void createCustomerWithBankAccountBrazil() {

		Thread.currentThread().setName("createCustomerWithBankAccountBrazil");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.PAYER_NAME, "Test");
		parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL, "prueba@payulatam.com");

		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME, "Usuario de Prueba");
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Usuario de Prueba");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "3");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
				"549646514");
		parameters
				.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CPF");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "SANTANDER");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "CURRENT");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "12345698");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_AGENCY_DIGIT, "4");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_AGENCY_NUMBER, "9871");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ACCOUNT_DIGIT, "1");
		parameters.put(PayU.PARAMETERS.COUNTRY, "BR");

		Customer response = new Customer();
		try {
			response = PayUCustomers.createCustomerWithBankAccount(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty bank account response");

			customerIdWithBanckAccountBrazil = response.getId();
			bankAccountIdBrazil = response.getBankAccounts().get(0).getId();
		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
	}

	/**
	 * Expected Exceptions to Create a customer with a bank from brazil account
	 * test
	 *
	 * @throws PayUException
	 */
	@Test(expectedExceptions = PayUException.class)
	public void createCustomerWithBankAccountBrazilExpectedExceptions()
			throws PayUException {

		Thread.currentThread().setName(
				"createCustomerWithBankAccountBrazilExpectedExceptions");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Test");
		parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL, "prueba@payulatam.com");
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Usuario de Prueba");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
				"549646514");
		parameters
				.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CPF");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "SANTANDER");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "CURRENT");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "12345698");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_AGENCY_NUMBER, "9871");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ACCOUNT_DIGIT, "1");

		Customer response = new Customer();
		try {
			response = PayUCustomers.createCustomerWithBankAccount(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty bank account response");

			customerIdWithBanckAccountBrazil = response.getId();
			bankAccountIdBrazil = response.getBankAccounts().get(0).getId();
		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			throw new PayUException(ErrorCode.API_ERROR, e);
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);
			LoggerUtil.info("{0}", "Error por tiempo de conexion" + e.getMessage());
			Assert.assertEquals(e.getClass(), ConnectionException.class);
		}
	}

	/**
	 * Delete a bank account test
	 */
	@Test(dependsOnMethods = { "createCustomerWithBankAccountBrazil" })
	public void deleteBankAccountBrazil() {

		Thread.currentThread().setName("deleteBankAccountBrazil");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID,
				customerIdWithBanckAccountBrazil);
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ID, bankAccountIdBrazil);

		try {
			boolean isELiminated = PayUBankAccount.delete(parameters);
			Assert.assertEquals(isELiminated, true);
		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
	}

	/**
	 * Delete a customer with bank account test
	 */
	@Test(dependsOnMethods = { "deleteBankAccountBrazil", "findCustomerList" })
	public void deleteCustomerWithBankAccountBrazil() {

		Thread.currentThread().setName("deleteCustomerWithBankAccountBrazil");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID,
				customerIdWithBanckAccountBrazil);

		try {
			boolean response = PayUCustomers.delete(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertTrue(response, "Can't delete the customer");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * find the customer list by limit and offset
	 */
	@Test(dependsOnMethods = "createBankAccount")
	public void findCustomerList() {

		Thread.currentThread().setName("findCustomerList");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.LIMIT, "2");
		parameters.put(PayU.PARAMETERS.OFFSET, "1");
		List<Customer> response = new ArrayList<Customer>();
		try {
			response = PayUCustomers.findList(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Null customer list response");
			Assert.assertTrue(!response.isEmpty(),
					"Empty customer list response");
			Assert.assertEquals(response.size(), 2);
			for (Customer customer : response) {
				Assert.assertNotNull(customer.getFullName(),
						"Null customer full name response");
				Assert.assertNotNull(customer.getId(),
						"Null customer id response");
				Assert.assertNotNull(customer.getEmail(),
						"Null customer email response");
			}

		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
	}

	/**
	 * find the customer list by identifier
	 */
	@Test(dependsOnMethods = { "createBankAccount" })
	public void findCustomer() {

		Thread.currentThread().setName("findCustomer");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerIdWithBankAccount);
		Customer response = new Customer();
		try {
			response = PayUCustomers.find(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Null customer list response");
			Assert.assertNotNull(response.getFullName(),
					"Null customer full name response");
			Assert.assertNotNull(response.getId(), "Null customer id response");
			Assert.assertNotNull(response.getEmail(),
					"Null customer email response");
			Assert.assertNotNull(response.getBankAccounts(),
					"Null customer Bank Accounts response");
			Assert.assertTrue(!response.getBankAccounts().isEmpty());
			Assert.assertEquals(response.getBankAccounts().size(), 2);
			for (BankAccount bankAccount : response.getBankAccounts()) {
				Assert.assertNotNull(bankAccount);
				Assert.assertNotNull(bankAccount.getId());
				Assert.assertNotNull(bankAccount.getAccountId());
				Assert.assertNotNull(bankAccount.getCustomerId());
				Assert.assertNotNull(bankAccount.getName());
				Assert.assertNotNull(bankAccount.getBank());
				Assert.assertNotNull(bankAccount.getAccountNumber());
				Assert.assertNotNull(bankAccount.getAccountId());
				Assert.assertNotNull(bankAccount.getDocumentNumberType());
				Assert.assertNotNull(bankAccount.getType());
				Assert.assertNotNull(bankAccount.getDocumentNumber());
				Assert.assertNotNull(bankAccount.getState());
				Assert.assertNotNull(bankAccount.getCountry());
			}

		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
	}

	/**
	 * find the customer list by plan Id
	 */
	@Test(dependsOnMethods = "createSubscriptionExistingPlan", priority = 4)
	public void findCustomerListByPlanId() {

		Thread.currentThread().setName("findCustomerList");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.PLAN_ID, planId);
		List<Customer> response = new ArrayList<Customer>();
		try {
			response = PayUCustomers.findList(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Null customer list response");
			Assert.assertTrue(!response.isEmpty(),
					"Empty customer list response");
			for (Customer customer : response) {
				Assert.assertNotNull(customer.getFullName(),
						"Null customer full name response");
				Assert.assertNotNull(customer.getId(),
						"Null customer id response");
				Assert.assertNotNull(customer.getEmail(),
						"Null customer email response");
			}

		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
	}

	/**
	 * find the customer list by plan Id
	 */
	@Test(dependsOnMethods = "createSubscriptionExistingPlan", priority = 5)
	public void findCustomerListByPlanCode() {

		Thread.currentThread().setName("findCustomerList");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.PLAN_CODE, planCode);
		List<Customer> response = new ArrayList<Customer>();
		try {
			response = PayUCustomers.findList(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Null customer list response");
			Assert.assertTrue(!response.isEmpty(),
					"Empty customer list response");
			for (Customer customer : response) {
				Assert.assertNotNull(customer.getFullName(),
						"Null customer full name response");
				Assert.assertNotNull(customer.getId(),
						"Null customer id response");
				Assert.assertNotNull(customer.getEmail(),
						"Null customer email response");
			}

		} catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		} catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
	}

	/**
	 * Invalid create Recurring bill item test
	 */
	@Test
	public void invalidCreateRecurringBillItem() {

		Thread.currentThread().setName("invalidCreateRecurringBillItem");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test Item");
		parameters.put(PayU.PARAMETERS.ITEM_VALUE, "100.5");
		parameters.put(PayU.PARAMETERS.CURRENCY, "COP");
		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, "123");

		parameters.put(PayU.PARAMETERS.ITEM_TAX, "10");
		parameters.put(PayU.PARAMETERS.ITEM_TAX_RETURN_BASE, "90.5");

		try {

			PayURecurringBillItem.create(parameters);

			Assert.fail("is valid subscription?");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);

		}
	}

	/**
	 * get recurring bill item test
	 */
	@Test(dependsOnMethods = "createRecurringBillItem")
	public void getRecurringBillItem() {

		Thread.currentThread().setName("getRecurringBillItem");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.RECURRING_BILL_ITEM_ID,
				recurringBillItemId);

		try {
			RecurringBillItem response = PayURecurringBillItem.find(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			recurringBillItemId = response.getId();

			Assert.assertNotNull(response, "Null customer response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * invalid get recurring bill item test
	 */
	@Test(expectedExceptions = SDKException.class)
	public void invalidGetRecurringBillItem() throws SDKException {

		Thread.currentThread().setName("getRecurringBillItem");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.RECURRING_BILL_ITEM_ID, "123");

		try {

			PayURecurringBillItem.find(parameters);
			Assert.fail("is valid?");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		}

	}

	/**
	 * get recurring bill test
	 */
	@Test(dependsOnMethods = "createRecurringBillItem")
	public void getRecurringBill() {

		Thread.currentThread().setName("getRecurringBill");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.RECURRING_BILL_ID, recurringBillId);

		try {
			RecurringBill response = PayURecurringBill.find(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Null recurring bill response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * invalid get recurring bill test
	 */
	@Test(expectedExceptions = SDKException.class)
	public void invalidGetRecurringBill() throws SDKException {

		Thread.currentThread().setName("getRecurringBill");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.RECURRING_BILL_ID, "123");

		try {

			PayURecurringBill.find(parameters);
			Assert.fail("is valid?");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);
		}
	}

	/**
	 * get recurring bill list test
	 */
	@Test(dependsOnMethods = "createRecurringBillItem")
	public void getRecurringBillList() {

		Thread.currentThread().setName("getRecurringBillList");

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				Constants.DEFAULT_DATE_WITHOUT_HOUR_FORMAT);

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);

		String startDate = dateFormat.format(new Date());
		String endDate = dateFormat.format(calendar.getTime());

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);
		parameters.put(PayU.PARAMETERS.RECURRING_BILL_DATE_BEGIN, startDate);
		parameters.put(PayU.PARAMETERS.RECURRING_BILL_DATE_FINAL, endDate);
		parameters.put(PayU.PARAMETERS.RECURRING_BILL_PAYMENT_METHOD_TYPE, PaymentMethodType.CREDIT_CARD.name());
		parameters.put(PayU.PARAMETERS.RECURRING_BILL_STATE, "PENDING");
		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, subscriptionId);
		parameters.put(PayU.PARAMETERS.LIMIT, "10");
		parameters.put(PayU.PARAMETERS.OFFSET, "0");

		try {
			List<RecurringBill> response = PayURecurringBill
					.findList(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Null recurring bill list response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * invalid get recurring bill list test
	 */
	@Test(expectedExceptions = SDKException.class)
	public void invalidGetRecurringBillList() throws SDKException {

		Thread.currentThread().setName("invalidGetRecurringBillList");

		try {
			PayURecurringBill.findList(new HashMap<String, String>());

			Assert.fail("is valid?");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);
		}
	}



}