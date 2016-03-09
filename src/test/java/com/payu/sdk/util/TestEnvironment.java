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
