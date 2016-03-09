package com.payu.sdk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.payu.sdk.constants.Constants;

/**
 * Utility for logs in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public final class LoggerUtil {

	/**
	 * Private Constructor
	 */
	private LoggerUtil() {
	}

	/**
	 * The payU default logger
	 */
	private static final Logger LOGGER = Logger.getAnonymousLogger();

	/**
	 * The logger date format
	 */
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	// Configure the formatter and handler
	static {

		LOGGER.setUseParentHandlers(false);

		for (Handler handler : LOGGER.getHandlers()) {
			LOGGER.removeHandler(handler);
		}

		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(new PayUFormatter());
		LOGGER.addHandler(consoleHandler);

		LOGGER.setLevel(Level.INFO);

	}

	/**
	 * logs info messages
	 * 
	 * @param message
	 *            The info message to log
	 * @param parameters
	 *            The parameters to the log
	 */
	public static void info(String message, Object... parameters) {
		LOGGER.log(Level.INFO, message, parameters);
	}

	/**
	 * logs debug messages
	 * 
	 * @param message
	 *            The debug message to log
	 * @param parameters
	 *            The parameters to the log
	 */
	public static void debug(String message, Object... parameters) {
		LOGGER.log(Level.FINER, message, parameters);
	}

	/**
	 * logs error messages
	 * 
	 * @param message
	 *            The error message to log
	 * @param parameters
	 *            The parameters to the log
	 */
	public static void error(String message, Throwable exception) {
		LOGGER.log(Level.SEVERE, message, exception);
	}

	/**
	 * logs warning messages
	 * 
	 * @param message
	 *            The warning message to log
	 * @param parameters
	 *            The parameters to the log
	 */
	public static void warning(String message, Object... parameters) {
		LOGGER.log(Level.WARNING, message, parameters);
	}

	/**
	 * The default payU log formatter
	 * 
	 * @author PayU Latam
	 * @since 1.0.0
	 * @version 1.0.0, 21/08/2013
	 */
	private static class PayUFormatter extends Formatter {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
		 */
		@Override
		public String format(LogRecord record) {

			return new StringBuilder(
					new SimpleDateFormat(DATE_FORMAT).format(new Date(record
							.getMillis()))).append(Constants.SPACE_STRING)
					.append(Thread.currentThread().getName())
					.append(Constants.LINE_BREAK)
					.append(formatMessage(record))
					.append(Constants.LINE_SEPARATOR).toString();
		}
	}

	/**
	 * Updates the log level
	 * 
	 * @param level
	 *            the new log level
	 */
	public static void setLogLevel(Level level) {

		for (Handler handler : LOGGER.getHandlers()) {
			LOGGER.removeHandler(handler);
		}

		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(level);
		consoleHandler.setFormatter(new PayUFormatter());
		LOGGER.addHandler(consoleHandler);

		LOGGER.setLevel(level);
	}

	/**
	 * Adds a custom logger handler
	 * 
	 * @param handler
	 */
	public static void addHandler(Handler handler) {
		LOGGER.addHandler(handler);
	}
}
