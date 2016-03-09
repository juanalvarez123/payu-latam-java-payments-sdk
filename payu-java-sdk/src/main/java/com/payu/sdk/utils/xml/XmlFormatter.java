package com.payu.sdk.utils.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Node;

import com.payu.sdk.constants.Constants;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.utils.LoggerUtil;

/**
 * Utility to format response into String.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public final class XmlFormatter {

	/**
	 * Private constructor
	 */
	private XmlFormatter() {
	}

	/**
	 * Pretty format an input XML stream
	 * 
	 * @param input string to be transformed
	 * @param indent size of indentation
	 * @return pretty formatted string
	 * @throws PayUException
	 */
	public static String prettyFormat(String input, int indent)
			throws PayUException {
		try {
			Source xmlInput = new StreamSource(new StringReader(input));
			StringWriter stringWriter = new StringWriter();
			StreamResult xmlOutput = new StreamResult(stringWriter);
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount",
					Constants.EMPTY_STRING + indent);
			transformer.transform(xmlInput, xmlOutput);
			return xmlOutput.getWriter().toString();
		} catch (Exception e) {
			throw new PayUException(
					PayUException.ErrorCode.XML_DESERIALIZATION_ERROR,
					e.getMessage(), e);
		}
	}

	/**
	 * Pretty format a input xml
	 * @param input xml string to be transformed
	 * @return pretty formatted string
	 * @throws PayUException
	 */
	public static String prettyFormat(String input) throws PayUException {
		return prettyFormat(input, 2);
	}

	/**
	 * Converts DOM node to xml string
	 * 
	 * @param node The DOM node to convert
	 * @return The converted DOM node to string
	 */
	public static String nodeToString(Node node) {
		StringWriter sw = new StringWriter();
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.transform(new DOMSource(node), new StreamResult(sw));
		} catch (TransformerException te) {
			LoggerUtil.info("{0}", te.getMessage());
		}
		return sw.toString();
	}

}
