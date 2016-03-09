package com.payu.sdk.utils.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.payu.sdk.constants.Constants;

/**
 * Utility to convert a {@link Date} into a {@link String} and vice versa.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public class DateAdapter extends XmlAdapter<String, Date> {

	/** The date format to be used */
	private SimpleDateFormat dateFormat = new SimpleDateFormat(
			Constants.DEFAULT_DATE_FORMAT);

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public String marshal(Date v) {
		return dateFormat.format(v);
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public Date unmarshal(String v) throws ParseException {
		return dateFormat.parse(v);
	}

}
