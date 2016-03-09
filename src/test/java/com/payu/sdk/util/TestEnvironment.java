package com.payu.sdk.util;

/**
 * The available environments for payments-api test.
 * 
 * @author <a href="juan.roman@payulatam.com">Juan Roman</a>
 * 
 */
public enum TestEnvironment {

	CUSTOM("", ""),

	QA("https://qa.api.payulatam.com/payments-api/", "https://qa.api.payulatam.com/reports-api/"),
	
	QALT("https://load.api.payulatam.com/payments-api/", "https://load.api.payulatam.com/reports-api/"),

	STG("https://stg.api.payulatam.com/payments-api/", "https://stg.api.payulatam.com/reports-api/"),
	
	LOCAL("http://localhost:8080/ppp-web-payments-api/", "http://localhost:8080/ppp-web-reports-api/"),

	PRD("https://api.payulatam.com/payments-api/", "https://api.payulatam.com/reports-api/");
	
	private String paymentsApiUrl;

	private String reportsApiUrl;

	private TestEnvironment(String paymentsApiUrl, String reportsApiUrl) {

		this.paymentsApiUrl = paymentsApiUrl;
		this.reportsApiUrl = reportsApiUrl;
	}

	/**
	 * Create a {@link TestEnvironment} given a custom URLs.
	 * 
	 * @param paymentsApiUrl
	 *            the payments api url.
	 * @return
	 */
	public static TestEnvironment createCustom(String paymentsApiUrl, String reportsApiUrl) {

		TestEnvironment environment = TestEnvironment.CUSTOM;
		environment.paymentsApiUrl = paymentsApiUrl;
		environment.reportsApiUrl = reportsApiUrl;

		return environment;
	}

	/**
	 * @return the payments api url.
	 */
	public String getPaymentsApiUrl() {

		return paymentsApiUrl;
	}

	/**
	 * @return the reportsApiUrl
	 */
	public String getReportsApiUrl() {

		return reportsApiUrl;
	}

}
