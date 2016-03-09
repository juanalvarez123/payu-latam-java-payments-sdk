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
