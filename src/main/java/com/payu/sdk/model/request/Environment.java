package com.payu.sdk.model.request;

/**
 * Represents the environment in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public enum Environment {

	/**
	 * Default url for payments and reports requests
	 */
	API_URL("https://api.payulatam.com/payments-api/",
			"https://api.payulatam.com/reports-api/");

	/** Payments request's url */
	private String paymentsUrl;
	/** Reports request's url */
	private String reportsUrl;

	/**
	 * Private constructor
	 * 
	 * @param paymentsUrl
	 *            the payments url to use
	 * @param reportsUrl
	 *            the reports url to use
	 */
	private Environment(String paymentsUrl, String reportsUrl) {
		this.paymentsUrl = paymentsUrl;
		this.reportsUrl = reportsUrl;
	}

	/**
	 * Creates an environment with the given urls
	 * 
	 * @param paymentsUrl
	 *            the payments url to use
	 * @param reportsUrl
	 *            the reports url to use
	 * @return The created environment
	 */
	public static Environment createEnvironment(String paymentsUrl,
			String reportsUrl) {
		Environment environment = Environment.API_URL;
		environment.paymentsUrl = paymentsUrl;
		environment.reportsUrl = reportsUrl;

		return environment;
	}

	/**
	 * Returns the payments url
	 * 
	 * @return the payments url
	 */
	public String getPaymentsUrl() {
		return paymentsUrl;
	}

	/**
	 * Returns the reports url
	 * 
	 * @return the reports Url
	 */
	public String getReportsUrl() {
		return reportsUrl;
	}
}
