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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.payu.sdk.PayU;
import com.payu.sdk.PayUBankAccount;
import com.payu.sdk.PayUCreditCard;
import com.payu.sdk.PayUCustomers;
import com.payu.sdk.PayUPlans;
import com.payu.sdk.PayUSubscription;
import com.payu.sdk.exceptions.ConnectionException;
import com.payu.sdk.exceptions.InvalidParametersException;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.exceptions.SDKException;
import com.payu.sdk.model.Language;
import com.payu.sdk.model.PaymentCountry;
import com.payu.sdk.paymentplan.model.BankAccount;
import com.payu.sdk.paymentplan.model.Customer;
import com.payu.sdk.paymentplan.model.PaymentPlanCreditCard;
import com.payu.sdk.paymentplan.model.Subscription;
import com.payu.sdk.paymentplan.model.SubscriptionPlan;
import com.payu.sdk.util.TestEnvironment;
import com.payu.sdk.util.TestNGLoggingListener;
import com.payu.sdk.utils.LoggerUtil;

/**
 * @author PayULatam
 * @since 1.1.1
 * @date 13/06/2014
 * @version 1.1.1
 */
@Listeners(TestNGLoggingListener.class)
public class BankAccountApiIntegrationTest {

	/**
	 * Default response log message
	 */
	private static final String RESPONSE_LOG_MESSAGE = "{0}";
	/**
	 * The bank account id
	 */
	private static String bankAccountId;
	/**
	 * The customer id
	 */
	private static Customer customer;
	/*
	 * the plan Identifier
	 */
	private String planId;
	/*
	 * the plan code
	 */
	private String planCode;
	/*
	 * the subscription identifiers list
	 */
	private List<String> subscriptionIds=new ArrayList<String>();

	/*
	 * the plan codes list
	 */
	private List<String> planCodes=new ArrayList<String>();

	/*
	 * the token identifier
	 */
	private String tokenId;
	/*
	 * the customer identifiers list
	 */
	private List<String> customerIds=new ArrayList<String>();

	/*
	 * the identifier of subscription to change
	 */
	private String subscriptionToChange;

	/**
	 * The bank account identifier
	 */
	private String bankAccountBrazilId;
	
	/**
	 * The subscriptions created
	 */
	private List<Subscription> subscriptionsCreated = new ArrayList<Subscription>();

	@BeforeClass
	private void init() {


		PayU.apiLogin = "012345678901";
		PayU.apiKey = "012345678901";
		PayU.merchantId = "1";
		PayU.language = Language.en;
		PayU.isTest = false;

		TestEnvironment enviroment = TestEnvironment.SANDBOX;
		PayU.paymentsUrl = enviroment.getPaymentsApiUrl();

		LoggerUtil.setLogLevel(Level.ALL);
	}

	@Test
	public void createCustomer() {

		Thread.currentThread().setName("createCustomer");

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Usuario de Prueba");
        parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL, "pruebas@payulatam.com");

        try {
        	customer = PayUCustomers.create(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, customer);
			Assert.assertNotNull(customer, "Empty customer response");
			customerIds.add(customer.getId());
		}
		catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
		catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
		}
		catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
	}

	@Test(dependsOnMethods = "createCustomer")
    public void createBankAccount() {

		Thread.currentThread().setName("createBankAccount");

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME, "Usuario de Prueba");
        parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER, "123456789");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CC");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "BANCOLOMBIA");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "SAVING");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "987654321");
        parameters.put(PayU.PARAMETERS.COUNTRY, "CO");

        BankAccount response = new BankAccount();
        try {
			response = PayUBankAccount.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty bank account response");

			bankAccountId = response.getId();
		}
		catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
		catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
		catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
    }

	@Test(dependsOnMethods = "createCustomer")
    public void createBrazilBankAccount() {

		Thread.currentThread().setName("createBrazilBankAccount");

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME, "Usuario de Prueba");
        parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "3");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER, "78965874");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CNPJ");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "SANTANDER");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "CURRENT");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "96325871");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ACCOUNT_DIGIT, "2");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_AGENCY_DIGIT, "3");
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_AGENCY_NUMBER, "4568");
        parameters.put(PayU.PARAMETERS.COUNTRY, "BR");

        BankAccount response = new BankAccount();
        try {
			response = PayUBankAccount.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty bank account response");

			bankAccountBrazilId= response.getId();

		}
		catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
		catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
		catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
    }

	@Test(dependsOnMethods = "createBankAccount")
    public void findBankAccount() {

		Thread.currentThread().setName("findBankAccount");

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ID, bankAccountId);

        BankAccount response = new BankAccount();
        try {
        	response = PayUBankAccount.find(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
        	Assert.assertEquals(bankAccountId, response.getId());
		}
		catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
		catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
		catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
    }

	@Test(dependsOnMethods = { "findBankAccount" })
    public void findBankAccountList() {

		Thread.currentThread().setName("findBankAccountList");

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());

        try {
        	List<BankAccount> response = PayUBankAccount.findList(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
        	Assert.assertNotNull(response, "Empty bank account response");
		}
		catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
		catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
		catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);

		}
    }

	/**
	 * Update bank account test.
	 */
	@Test(dependsOnMethods = { "createBrazilBankAccount" })
	public void updateBankAccount() {

		Thread.currentThread().setName("updateBankAccount");

		String newName = "newName";
		String newDocumentType = "CPF";

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ID, bankAccountBrazilId);
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME, newName);
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, newDocumentType);

		try {
			BankAccount response = PayUBankAccount.update(parameters);
            bankAccountBrazilId=response.getId();
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty bank account response");

			Assert.assertEquals(response.getName(), newName);
			Assert.assertEquals(response.getDocumentNumberType(), newDocumentType);

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
	 * Invalid data to update bank account test.
	 */
	@Test(expectedExceptions=SDKException.class, dependsOnMethods = { "findBankAccount" })
	public void invalidDataUpdateBankAccount() throws SDKException {

		Thread.currentThread().setName("invalidDataUpdateBankAccount");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ID, bankAccountId);
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, "newCustomerId");

		try {
			PayUBankAccount.update(parameters);

			Assert.fail("is valid?");

		} catch (ConnectionException e) {
			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);
		}
	}

	/**
	 * Invalid update bank account test.
	 */
	@Test(expectedExceptions=SDKException.class)
	public void invalidUpdateBankAccount() throws SDKException {

		Thread.currentThread().setName("invalidUpdateBankAccount");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ID, "123");

		try {
			PayUBankAccount.update(parameters);

			Assert.fail("is valid?");

		} catch (ConnectionException e) {
			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);
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
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PAYMENTS, "2");

		parameters.put(PayU.PARAMETERS.PLAN_MAX_PAYMENT_ATTEMPTS, "0");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PENDING_PAYMENTS, "2");

		try {
			SubscriptionPlan response = PayUPlans.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty plan response");

			planId = response.getId();
			planCode = response.getPlanCode();
			planCodes.add(planCode);

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
	 * Create subscription test with existing plan and bank account
	 */
	@Test(dependsOnMethods = { "createPlan", "updateBankAccount" })
	public void createSubscriptionExistingPlanAndBankAccountExisting() {

		Thread.currentThread().setName(
				"createSubscriptionExistingPlanAndBankAccountExisting");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.TERMS_AND_CONDITIONS_ACEPTED, "true");
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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");

		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());

		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_ID, planId);

		// Bank account parameters
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ID, bankAccountId);

		try {
			Subscription response = PayUSubscription.create(parameters);
			subscriptionsCreated.add(response);
			subscriptionIds.add(response.getId());
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
	 * Create subscription test with existing plan and bank account new
	 */
	@Test(dependsOnMethods = { "createPlan", "updateBankAccount" })
	public void createSubscriptionExistingPlanAndNewBankAccount() {

		Thread.currentThread().setName(
				"createSubscriptionExistingPlanAndNewBankAccount");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.TERMS_AND_CONDITIONS_ACEPTED, "true");
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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");
		
		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "David");
		parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL, "prueba@payulatam.com");

		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_ID, planId);

		// Bank account parameters
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME,
				"Usuario de Prueba");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
				"1223456789");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CC");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "BANCOLOMBIA");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "SAVING");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "9287654321");
		parameters.put(PayU.PARAMETERS.COUNTRY, "CO");

		try {
			Subscription response = PayUSubscription.create(parameters);
			subscriptionIds.add(response.getId());
			customerIds.add(response.getCustomer().getId());
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
	 * Create subscription test with existing plan and bank account new
	 *
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = { "createPlan", "updateBankAccount" }, expectedExceptions = SDKException.class)
	public void createSubscriptionWithPlanNewAndBankAccountNewAndCreditCardNew()
			throws SDKException {

		Thread.currentThread().setName(
				"createSubscriptionExistingPlanAndNewBankAccount");

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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");

		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());

		// Bank account parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "Usuario de Prueba");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
				"1223456789");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CC");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "BANCOLOMBIA");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "SAVING");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "9287654321");
		parameters.put(PayU.PARAMETERS.COUNTRY, "CO");

		// plan parameters
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

		// Credit card parameters
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

		try {
			Subscription response = PayUSubscription.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.fail("is valid?");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			throw e;
		}

	}

	/**
	 * Create credit card test
	 */
	@Test(dependsOnMethods = "createCustomer")
	public void createCreditCard() {

		Thread.currentThread().setName("createCreditCard");

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());

		// Credit card parameters
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_NUMBER, "4005580000029205");
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, "2025/01");
		parameters.put(PayU.PARAMETERS.CREDIT_CARD_DOCUMENT, "123456789");
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
	 * Create subscription test with existing plan and bank account
	 *
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = { "createPlan", "updateBankAccount",
			"createCreditCard" }, expectedExceptions = SDKException.class)
	public void createSubscriptionExistingPlanAndBankAccountExistingAndCreditCardExisting()
			throws SDKException {

		Thread.currentThread()
				.setName(
						"createSubscriptionExistingPlanAndBankAccountExistingAndCreditCardExisting");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.TERMS_AND_CONDITIONS_ACEPTED, "true");
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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");

		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());

		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_ID, planId);

		// Bank account parameters
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ID, bankAccountId);

		// bank account parameters
		parameters.put(PayU.PARAMETERS.TOKEN_ID, tokenId);

		try {
			Subscription response = PayUSubscription.create(parameters);
			subscriptionIds.add(response.getId());
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.assertNotNull(response, "Empty subscription response");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			throw e;
		}

	}

	/**
	 * Create subscription test with existing plan and bank account new
	 */
	@Test(dependsOnMethods = { "createPlan", "updateBankAccount",
			"createCreditCard" })
	public void createSubscriptionWithPlanNewAndBankAccountNew() {

		Thread.currentThread().setName(
				"createSubscriptionExistingPlanAndNewBankAccount");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.TERMS_AND_CONDITIONS_ACEPTED, "true");
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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");

		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "David");
		parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL, "prueba@payulatam.com");

		// Bank account parameters
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME,
				"Usuario de Prueba");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
				"1223456789");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CC");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "BANCOLOMBIA");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "SAVING");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "9287654321");
		parameters.put(PayU.PARAMETERS.COUNTRY, "CO");

		// plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_DESCRIPTION, "Basic Plan");
		parameters.put(PayU.PARAMETERS.PLAN_CODE,
				"ASd456" + System.currentTimeMillis());
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL, "MONTH");
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL_COUNT, "12");
		parameters.put(PayU.PARAMETERS.PLAN_CURRENCY, "COP");
		parameters.put(PayU.PARAMETERS.PLAN_VALUE, "50000");
		parameters.put(PayU.PARAMETERS.PLAN_TAX, "10000");
		parameters.put(PayU.PARAMETERS.PLAN_TAX_RETURN_BASE, "40000");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PAYMENTS, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PENDING_PAYMENTS, "2");

		try {
			Subscription response = PayUSubscription.create(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response);
			subscriptionIds.add(response.getId());
			customerIds.add(response.getCustomer().getId());
			planCodes.add(response.getPlan().getPlanCode());

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
	 * Create subscription test with existing plan and bank account new and
	 * credit card new
	 *
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = "createPlan", expectedExceptions = PayUException.class, priority = 3)
	public void createSubscriptionWithoutPaymentMethod() throws SDKException {

		Thread.currentThread()
				.setName("createSubscriptionWithoutPaymentMethod");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.TERMS_AND_CONDITIONS_ACEPTED, "true");
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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");

		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "David");
		parameters.put(PayU.PARAMETERS.CUSTOMER_EMAIL, "prueba@payulatam.com");

		// plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_CODE, planCode);

		try {
			Subscription response = PayUSubscription.create(parameters);
			subscriptionsCreated.add(response);
			
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			throw e;
		}

	}

	/**
	 * Create subscription test with new plan and existing bank account
	 *
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = "updateBankAccount")
	public void createSubscriptionNewPlanAndExistingBankAccount()
			throws SDKException {

		Thread.currentThread().setName(
				"createSubscriptionNewPlanAndExistingBankAccount");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.TERMS_AND_CONDITIONS_ACEPTED, "true");
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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");

		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());

		// plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_DESCRIPTION, "Basic Plan");
		parameters.put(PayU.PARAMETERS.PLAN_CODE,
				"ASd456" + System.currentTimeMillis());
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL, "MONTH");
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL_COUNT, "12");
		parameters.put(PayU.PARAMETERS.PLAN_CURRENCY, "COP");
		parameters.put(PayU.PARAMETERS.PLAN_VALUE, "50000");
		parameters.put(PayU.PARAMETERS.PLAN_TAX, "10000");
		parameters.put(PayU.PARAMETERS.PLAN_TAX_RETURN_BASE, "40000");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PAYMENTS, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PENDING_PAYMENTS, "2");

		// Bank account parameters
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ID, bankAccountId);

		try {
			Subscription response = PayUSubscription.create(parameters);
			subscriptionIds.add(response.getId());
			planCodes.add(response.getPlan().getPlanCode());
			subscriptionsCreated.add(response);
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
	 * Create subscription test with existing plan and bank account new
	 */
	@Test(dependsOnMethods = { "createPlan", "createCustomer" })
	public void createSubscriptionExistingPlanAndNewBankAccountAndExistingCustomer() {

		Thread.currentThread()
				.setName(
						"createSubscriptionExistingPlanAndNewBankAccountAndExistingCustomer");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.TERMS_AND_CONDITIONS_ACEPTED, "true");
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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");
		
		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());
		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_ID, planId);

		// Bank account parameters
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME, "David");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
				"1223456789");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CC");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "BANCOLOMBIA");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "SAVING");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "9287654321");
		parameters.put(PayU.PARAMETERS.COUNTRY, "CO");

		try {
			Subscription response = PayUSubscription.create(parameters);
			subscriptionIds.add(response.getId());
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
	 * Create subscription test with existing plan and bank account new
	 *
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = { "createPlan", "createCustomer" }, priority = 2, expectedExceptions = SDKException.class)
	public void createSubscriptionWithoutCustomer() throws SDKException {

		Thread.currentThread().setName("createSubscriptionWithoutCustomer");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.TERMS_AND_CONDITIONS_ACEPTED, "true");
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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");

		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_ID, planId);

		// Bank account parameters
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME, "David");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
				"1223456789");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CC");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "BANCOLOMBIA");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "SAVING");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "9287654321");
		parameters.put(PayU.PARAMETERS.COUNTRY, "CO");

		try {
			Subscription response = PayUSubscription.create(parameters);
			subscriptionsCreated.add(response);
			
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.fail("is valid?");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			throw e;
		}

	}

	/**
	 * Create subscription test with existing plan and bank account new
	 *
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = { "createPlan", "createCustomer" }, priority = 2)
	public void createSubscriptionWithoutCustomer2()  {

		Thread.currentThread().setName("createSubscriptionWithoutCustomer2");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.TERMS_AND_CONDITIONS_ACEPTED, "true");
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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");

		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_ID, planId);

		// customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_NAME, "david");

		// Bank account parameters
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME, "David");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
				"1223456789");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CC");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "BANCOLOMBIA");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "SAVING");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "9287654321");
		parameters.put(PayU.PARAMETERS.COUNTRY, "CO");

		try {
			Subscription response = PayUSubscription.create(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response,"Null subscription response");
			Assert.assertNotNull(response.getCustomer(),"Null customer response");
			Assert.assertNotNull(response.getCustomer().getId(),"Null customer identifier response");
			customerIds.add(response.getCustomer().getId());
			subscriptionsCreated.add(response);
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
	 * Create subscription test with existing plan and bank account new
	 *
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = { "createPlan", "createCustomer" }, priority = 2,
			expectedExceptions = SDKException.class)
	public void createSubscriptionWithoutPlanCode() throws SDKException {

		Thread.currentThread().setName("createSubscriptionWithoutPlanCode");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.TERMS_AND_CONDITIONS_ACEPTED, "true");
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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");

		// plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_DESCRIPTION, "Basic Plan");
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL, "MONTH");
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL_COUNT, "12");
		parameters.put(PayU.PARAMETERS.PLAN_CURRENCY, "COP");
		parameters.put(PayU.PARAMETERS.PLAN_VALUE, "50000");
		parameters.put(PayU.PARAMETERS.PLAN_TAX, "10000");
		parameters.put(PayU.PARAMETERS.PLAN_TAX_RETURN_BASE, "40000");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PAYMENTS, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PENDING_PAYMENTS, "2");

		// Customers parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());

		// Bank account parameters
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME, "David");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "1");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER,
				"1223456789");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE, "CC");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "BANCOLOMBIA");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "SAVING");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "9287654321");
		parameters.put(PayU.PARAMETERS.COUNTRY, "CO");

		try {
			Subscription response = PayUSubscription.create(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.fail("is valid?");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(" Service Unavailable");
		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			throw e;
		}

	}
	/**
	 * Create subscription test with existing plan and bank account new
	 */
	@Test(dependsOnMethods = { "createCustomer" })
	public void createSubscriptionNewPlanAndNewBankAccountAndExistingCustomer() {

		Thread.currentThread()
				.setName(
						"createSubscriptionNewPlanAndNewBankAccountAndExistingCustomer");

		Map<String, String> parameters = new HashMap<String, String>();

		// Subscription parameters
		parameters.put(PayU.PARAMETERS.QUANTITY, "5");
		parameters.put(PayU.PARAMETERS.IMMEDIATE_PAYMENT, "true");
		parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "2");
		parameters.put(PayU.PARAMETERS.TRIAL_DAYS, "2");
		parameters.put(PayU.PARAMETERS.TERMS_AND_CONDITIONS_ACEPTED, "true");
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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");
		
		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());
		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_DESCRIPTION, "Basic Plan");
		parameters.put(PayU.PARAMETERS.PLAN_CODE,
				"ASd456" + System.currentTimeMillis());
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL, "MONTH");
		parameters.put(PayU.PARAMETERS.PLAN_INTERVAL_COUNT, "12");
		parameters.put(PayU.PARAMETERS.PLAN_CURRENCY, "BRL");
		parameters.put(PayU.PARAMETERS.PLAN_VALUE, "200");
		parameters.put(PayU.PARAMETERS.PLAN_TAX, "10");
		parameters.put(PayU.PARAMETERS.PLAN_TAX_RETURN_BASE, "30");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "3");
		parameters.put(PayU.PARAMETERS.PLAN_ATTEMPTS_DELAY, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PAYMENTS, "2");
		parameters.put(PayU.PARAMETERS.PLAN_MAX_PENDING_PAYMENTS, "2");

		// Bank account parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_CUSTOMER_NAME,
				"Usuario de Prueba");
		parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "3");
		parameters
				.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER, "78964874");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_DOCUMENT_NUMBER_TYPE,
				"CNPJ");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_BANK_NAME, "SANTANDER");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_TYPE, "CURRENT");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_NUMBER, "96325891");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ACCOUNT_DIGIT, "2");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_AGENCY_DIGIT, "3");
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_AGENCY_NUMBER, "4518");
		parameters.put(PayU.PARAMETERS.COUNTRY, "BR");

		try {
			Subscription response = PayUSubscription.create(parameters);
			subscriptionIds.add(response.getId());
			subscriptionToChange = response.getId();
			planCodes.add(response.getPlan().getPlanCode());
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
	 * Update subscription's bank account
	 *
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = {
			"createSubscriptionNewPlanAndNewBankAccountAndExistingCustomer",
			"findBankAccount" })
	public void updateSubscription() throws SDKException {

		Thread.currentThread().setName("updateSubscription");

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, subscriptionToChange);
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ID, bankAccountBrazilId);

		try {
			Subscription response = PayUSubscription.update(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getBankAccountId());
			Assert.assertEquals(response.getBankAccountId(),
					bankAccountBrazilId);

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
	 * finds subscription by id, validate bank account
	 *
	 */
	@Test(dependsOnMethods = { "updateSubscription" })
	public void findSubscriptionWithBankAccount() {

		Thread.currentThread().setName("findSubscriptionWithBankAccount");

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, subscriptionToChange);

		try {
			Subscription response = PayUSubscription.find(parameters);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getCustomer());
			Assert.assertNotNull(response.getBankAccountId());
			Assert.assertEquals(response.getBankAccountId(),
					bankAccountBrazilId);

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
	 * Create subscription test without terms and conditions
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = { "createCustomer", "createPlan",
			"createBankAccount" },expectedExceptions=SDKException.class, priority=2)
	public void createSubscriptionWithoutTermAndConditions() throws SDKException {

		Thread.currentThread().setName("createSubscriptionWithoutTermAndConditions");

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
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "12345");
		parameters.put(PayU.PARAMETERS.DESCRIPTION, "Test description");
		parameters.put(PayU.PARAMETERS.SOURCE_BUYER_IP, "123.321.123.321");
		parameters.put(PayU.PARAMETERS.SOURCE_NUMBER_OF_PAYMENTS, "6");
		parameters.put(PayU.PARAMETERS.SOURCE_NEXT_PAYMENT_NUMBER, "7");
		parameters.put(PayU.PARAMETERS.CREATION_SOURCE, "POL_RECURRING_PAYMENT");
		
		// Customer parameters
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());
		// Plan parameters
		parameters.put(PayU.PARAMETERS.PLAN_ID, planId);
		// Bank account parameters
		parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ID, bankAccountId);

		try {
			Subscription response = PayUSubscription.create(parameters);
			subscriptionsCreated.add(response);

			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);

			Assert.fail("is valid?");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			throw e;
		}

	}

	/**
	 * finds subscription list by customer
	 *
	 * @throws InterruptedException
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = {
			"createSubscriptionNewPlanAndExistingBankAccount",
			"createSubscriptionExistingPlanAndBankAccountExisting",
			"createSubscriptionWithPlanNewAndBankAccountNewAndCreditCardNew",
			"createSubscriptionExistingPlanAndBankAccountExistingAndCreditCardExisting",
			"createSubscriptionWithPlanNewAndBankAccountNew",
			"createSubscriptionNewPlanAndNewBankAccountAndExistingCustomer",
			"updateSubscription" })
	public void findSubscriptionListByCustomer() throws InterruptedException {
		Thread.currentThread().setName("findSubscriptionListByCustomer");
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());
		try {
			List<Subscription> response;
			response = PayUSubscription.findList(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response, "Empty subscription list");
			Assert.assertTrue(!response.isEmpty());
			for (Subscription subscription : response) {
				Assert.assertNotNull(subscription, "NUll subscription");
				Assert.assertNotNull(subscription.getCustomer(),
						"NUll customer");
				Assert.assertNotNull(subscription.getCustomer().getId(),
						"NUll customer identifier");
				Assert.assertEquals(subscription.getCustomer().getId(),
						customer.getId());
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
	 * finds subscription list by plan code
	 *
	 * @throws InterruptedException
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = "findSubscriptionListByCustomer")
	public void findSubscriptionListByPlanCode() throws InterruptedException {
		Thread.currentThread().setName("findSubscriptionListByPlanCode");
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.PLAN_CODE, planCode);
		try {
			List<Subscription> response;
			response = PayUSubscription.findList(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response, "Empty subscription list");
			Assert.assertTrue(!response.isEmpty());
			for (Subscription subscription : response) {
				Assert.assertNotNull(subscription, "NUll subscription");
				Assert.assertNotNull(subscription.getCustomer(),
						"NUll customer");
				Assert.assertNotNull(subscription.getPlan(), "NUll plan");
				Assert.assertNotNull(subscription.getPlan().getPlanCode(),
						"NUll plan code");
				Assert.assertEquals(subscription.getPlan().getPlanCode(),
						planCode);
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
	 * finds subscription list by plan identifier, using limit
	 *
	 * @throws InterruptedException
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = "findSubscriptionListByPlanCode")
	public void findSubscriptionListByPlanId() throws InterruptedException {
		Thread.currentThread().setName("findSubscriptionListByPlanId");
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.PLAN_ID, planId);
		parameters.put(PayU.PARAMETERS.LIMIT, "2");
		try {
			List<Subscription> response;
			response = PayUSubscription.findList(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertNotNull(response, "Empty subscription list");
			Assert.assertTrue(!response.isEmpty());
			Assert.assertEquals(response.size(), 2);
			for (Subscription subscription : response) {
				Assert.assertNotNull(subscription, "NUll subscription");
				Assert.assertNotNull(subscription.getCustomer(),
						"NUll customer");
				Assert.assertNotNull(subscription.getPlan(), "NUll plan");
				Assert.assertNotNull(subscription.getPlan().getId(),
						"NUll plan id");
				Assert.assertEquals(subscription.getPlan().getId(), planId);
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
	 * finds subscription list by customer identifier using offset
	 *
	 * @throws SDKException
	 */
	@Test(dependsOnMethods = "findSubscriptionListByPlanCode", expectedExceptions = SDKException.class)
	public void findSubscriptionByCustomerWithOffset() throws SDKException {
		Thread.currentThread().setName("findSubscriptionListByPlanCode");
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());
		parameters.put(PayU.PARAMETERS.OFFSET, "50");
		try {
			List<Subscription> response;
			response = PayUSubscription.findList(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.fail("is valid?");

		} catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);

		} catch (SDKException e) {
			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			throw e;
		}

	}

	/**
	 * finds subscription list by status
	 *
	 */
	@Test(dependsOnMethods = "findSubscriptionByCustomerWithOffset")
	public void findSubscriptionByState() {
		Thread.currentThread().setName("findSubscriptionByState");
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.STATE, "ACTIVE");
		try {
			List<Subscription> response;
			response = PayUSubscription.findList(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
			Assert.assertTrue(!response.isEmpty());

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
	@Test(dependsOnMethods = { "findSubscriptionByState" })
	public void cancelSubscriptions() throws InterruptedException {
		Thread.currentThread().setName("cancelSubscriptions");
		Map<String, String> parameters = new HashMap<String, String>();

		try {
			boolean response;
			for (String subscriptionId : subscriptionIds) {
				parameters.put(PayU.PARAMETERS.SUBSCRIPTION_ID, subscriptionId);
				response = PayUSubscription.cancel(parameters);
				LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
				Assert.assertTrue(response, "Can't cancel the subscription");
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
	 * Delete the plans test
	 */
	@Test(dependsOnMethods = "cancelSubscriptions")
	public void deletePlans() {

		Thread.currentThread().setName("deletePlans");

		Map<String, String> parameters = new HashMap<String, String>();

		try {
			boolean response;
			for (String planCode : planCodes) {
				parameters.put(PayU.PARAMETERS.PLAN_CODE, planCode);
				response = PayUPlans.delete(parameters);
				LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
				Assert.assertTrue(response, "Can't delete the plan");
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
	 * Delete the credit cards and bank accounts
	 */
	@Test(dependsOnMethods = "deletePlans")
	public void deleteCustomers() {

		Thread.currentThread().setName("deleteCreditCards");

		Map<String, String> parameters = new HashMap<String, String>();
		boolean response;
		try {
			for (String customerId : customerIds) {

				parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customerId);
				customer = PayUCustomers.find(parameters);

				// delete the bank Accounts
				if (customer.getBankAccounts() != null) {
					for (BankAccount bankAccount : customer.getBankAccounts()) {
						parameters.put(PayU.PARAMETERS.BANK_ACCOUNT_ID,
								bankAccount.getId());
						response = PayUBankAccount.delete(parameters);
						LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
						Assert.assertTrue(response,
								"Can't delete the bank account");
					}
				}

				// delete the credit cards
				if (customer.getCreditCards() != null) {
					for (PaymentPlanCreditCard creditCard : customer
							.getCreditCards()) {
						parameters.put(PayU.PARAMETERS.TOKEN_ID,
								creditCard.getToken());
						response = PayUCreditCard.delete(parameters);
						LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
						Assert.assertTrue(response,
								"Can't delete the credit card");
					}
				}
				response = PayUCustomers.delete(parameters);
				LoggerUtil.info(RESPONSE_LOG_MESSAGE, response);
				Assert.assertTrue(response, "Can't delete the customer");

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
	
	@Test(dependsOnMethods = { 
			"createSubscriptionExistingPlanAndBankAccountExisting", 
			"createSubscriptionWithoutPaymentMethod",
			"createSubscriptionNewPlanAndExistingBankAccount", 
			"createSubscriptionWithoutCustomer",
			"createSubscriptionWithoutCustomer2", 
			"createSubscriptionWithoutTermAndConditions" })
	public void findSubscriptionsBySourceId() {

		Thread.currentThread().setName("findSubscriptionsBySourceId");

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.SOURCE_ID, subscriptionsCreated.get(0).getSourceId().toString());

		try {
			List<Subscription> subscriptions = PayUSubscription.findList(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, subscriptions);

			Assert.assertNotNull(subscriptions);
			for (Subscription sus : subscriptions) {
				Assert.assertNotNull(sus);
			}
			
			Assert.assertTrue(subscriptionsCreated.size() == subscriptions.size());
		}
		catch (ConnectionException e) {

			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);
		}
		catch (SDKException e) {

			// SDK error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(expectedExceptions = PayUException.class)
	public void findSubscriptionsBySourceIdReturnsNothing() throws Exception {
		
		Thread.currentThread().setName("findSubscriptionsBySourceId");
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.SOURCE_ID, "300777999");
		
		try {
			List<Subscription> subscriptions = PayUSubscription.findList(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, subscriptions);
			
			Assert.fail("Has results");
		}
		catch (ConnectionException e) {
			
			// Service Unavailable
			LoggerUtil.error(e.getMessage(), e);
		}
		catch (InvalidParametersException e) {
			
			// Different error
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
	}
	
	@AfterTest
	public void deleteCustomer() {

		Thread.currentThread().setName("deleteCustomer");

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(PayU.PARAMETERS.CUSTOMER_ID, customer.getId());

        try {
        	PayUCustomers.delete(parameters);
			LoggerUtil.info(RESPONSE_LOG_MESSAGE, customer);
		}
		catch (PayUException e) {
			LoggerUtil.error(e.getMessage(), e);
		}
		catch (InvalidParametersException e) {
			LoggerUtil.error(e.getMessage(), e);
		}
		catch (ConnectionException e) {
			LoggerUtil.error(e.getMessage(), e);
			Assert.fail(e.getMessage());
		}
	}
	
}
