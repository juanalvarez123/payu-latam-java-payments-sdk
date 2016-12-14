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
package com.payu.sdk.utils;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.payu.sdk.PayU;
import com.payu.sdk.reporting.model.ReportingRequest;

/**
 * @author raphael.batista
 * @since 1.1.19
 * @date 14/12/2016
 * @version 1.0
 */
public class RequestUtilTest {

	/**
	 * Reset the static variables for each test
	 */
	@BeforeMethod
	public void before() {
		PayU.apiKey = null;
		PayU.apiLogin = null;
	}
	
	/**
	 * Test if the method {@link RequestUtil#buildOrderReportingDetails()} return authentication 
	 * from static variables.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testBuildOrderReportingDetails_returnAuthenticationFromStaticVars() throws Exception {
		String expectedApiKey = "apikey";
		String expectedApiLogin = "apilogin";
		
		PayU.apiKey = expectedApiKey;
		PayU.apiLogin = expectedApiLogin;
		
		Map<String, String> parameters = new HashMap<String, String>();
		ReportingRequest reportingRequest = RequestUtil.buildOrderReportingDetails(parameters);
		
		Assert.assertEquals(reportingRequest.getMerchant().getApiKey(), expectedApiKey);
		Assert.assertEquals(reportingRequest.getMerchant().getApiLogin(), expectedApiLogin);
	}
	
	/**
	 * Test if the method {@link RequestUtil#buildOrderReportingDetails()} return authentication
	 * from parameters.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testBuildOrderReportingDetails_returnAuthenticationFromParameters() throws Exception {
		String expectedApiKey = "apikeyParam";
		String expectedApiLogin = "apiloginParam";
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.API_KEY, expectedApiKey);
		parameters.put(PayU.PARAMETERS.API_LOGIN, expectedApiLogin);
		
		ReportingRequest reportingRequest = RequestUtil.buildOrderReportingDetails(parameters);
		
		Assert.assertEquals(reportingRequest.getMerchant().getApiKey(), expectedApiKey);
		Assert.assertEquals(reportingRequest.getMerchant().getApiLogin(), expectedApiLogin);
	}
	
	/**
	 * Test if the method {@link RequestUtil#buildOrderReportingDetails()} return authentication 
	 * from static variables over parameters.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testBuildOrderReportingDetails_returnAuthenticationFromStaticVarsOverParams() throws Exception {
		String expectedApiKey = "apikey";
		String expectedApiLogin = "apilogin";
		
		PayU.apiKey = expectedApiKey;
		PayU.apiLogin = expectedApiLogin;
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(PayU.PARAMETERS.API_KEY, expectedApiKey + "Params");
		parameters.put(PayU.PARAMETERS.API_LOGIN, expectedApiLogin + "Params");
		
		ReportingRequest reportingRequest = RequestUtil.buildOrderReportingDetails(parameters);
		
		Assert.assertEquals(reportingRequest.getMerchant().getApiKey(), expectedApiKey);
		Assert.assertEquals(reportingRequest.getMerchant().getApiLogin(), expectedApiLogin);
	}

}
