package com.payu.sdk.utils;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.payu.sdk.constants.Constants;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.exceptions.SDKException;

/**
 * Java Architecture for XML Binding (JAXB) utility to map Java Classes to XML
 * representation and XML representation to Java Classes.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public final class JaxbUtil {

	/**
	 * Default Constructor
	 */
	private JaxbUtil() {
	}

	/**
	 * Convert a XML Representation String to the specified Java Class
	 * 
	 * @param clasz
	 *            The class that represent the XML representation
	 * @param xmlData
	 *            A string with the XML Representation data
	 * 
	 * @return An object of type <code>clasz</code>
	 * @throws PayUException
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T convertXmlToJava(Class<T> clasz,
			String xmlData) throws PayUException {

		if (xmlData == null || xmlData.isEmpty()) {
			return null;
		}

		T javaObject = null;

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(clasz);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			javaObject = (T) jaxbUnmarshaller.unmarshal(new StringReader(
					xmlData));
		} catch (JAXBException e) {
			throw new PayUException(
					SDKException.ErrorCode.XML_DESERIALIZATION_ERROR,
					"The input XML is not a valid [" + clasz.getName() + "] "
							+ "class representation. XML Data: [" + xmlData
							+ "]", e);
		}

		return (T) javaObject;
	}

	/**
	 * Convert a Java Object to its XML representation
	 * 
	 * @param javaObject
	 *            The Java object to serialize with XML
	 * @param formattedOutput
	 *            Specify whether or not the marshalled XML data is formatted
	 *            with linefeeds and indentation.
	 * 
	 * @return A string that contains the XML Representation
	 */
	public static <T extends Serializable> String convertJavaToXml(
			T javaObject, boolean formattedOutput) {

		String xmlData = null;

		try {
			if (javaObject != null) {
				JAXBContext jaxbContext = JAXBContext.newInstance(javaObject
						.getClass());
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						formattedOutput);
				jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING,
						Constants.DEFAULT_ENCODING);

				StringWriter stringWriter = new StringWriter();
				jaxbMarshaller.marshal(javaObject, stringWriter);

				xmlData = stringWriter.toString();
			}

		} catch (JAXBException e) {
			throw new IllegalArgumentException("The input XML is not a valid ["
					+ javaObject.getClass().getName() + "] "
					+ "class representation. XML Data: [" + xmlData + "]", e);
		}

		return xmlData;
	}

}
