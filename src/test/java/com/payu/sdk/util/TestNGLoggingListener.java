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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Logging listener for all automation test classes.
 *
 * @author <a href="mailto:jeanpaul.manjarres@payulatam.com">Jean Paul Manjarres Correal</a><br/>
 *         21/03/2014
 *
 */
public class TestNGLoggingListener extends TestListenerAdapter {

	/** Class logger */
	private static final Logger LOGGER = LoggerFactory.getLogger("Log");

	/*
	 * (non-Javadoc)
	 * @see org.testng.TestListenerAdapter#onTestStart(org.testng.ITestResult)
	 */
	@Override
	public void onTestStart(ITestResult result) {
		super.onTestStart(result);
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.TestListenerAdapter#onTestSuccess(org.testng.ITestResult)
	 */
	@Override
	public void onTestSuccess(ITestResult tr) {

		super.onTestSuccess(tr);

		LOGGER.info("Test [{}.{}] Finished Successfully. Duration [{}] seconds", tr.getTestClass().getRealClass().getSimpleName(),tr.getName(),
				this.calculateDurationInSeconds(tr.getEndMillis(), tr.getStartMillis()));
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.TestListenerAdapter#onTestSkipped(org.testng.ITestResult)
	 */
	@Override
	public void onTestSkipped(ITestResult tr) {

		super.onTestSkipped(tr);
		LOGGER.info("Test [{}.{}] Skipped. ", tr.getTestClass().getRealClass().getSimpleName(),tr.getName());
	}

	/*
	 * (non-Javadoc)
	 * @see org.testng.TestListenerAdapter#onTestFailure(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailure(ITestResult tr) {

		super.onTestFailure(tr);
		LOGGER.info("Test [{}.{}] Failure. Duration [{}] seconds. ", tr.getTestClass().getRealClass().getSimpleName(),tr.getName(),
				this.calculateDurationInSeconds(tr.getEndMillis(), tr.getStartMillis()));

	}

	/**
	 * Calculates the duration of an interval in seconds.
	 *
	 * @param end
	 * @param start
	 * @return
	 */
	private long calculateDurationInSeconds(long endMillis, long startMillis) {

		return (endMillis - startMillis) / 1000;
	}

}
