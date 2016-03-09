package com.payu.sdk.utils.xml;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Utility to adapt Object into {@link MapDetailsElement} and vice
 * versa.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public class MapDetailsAdapter extends
		XmlAdapter<MapDetailsElement, Map<String, Object>> {

	/**
	 * The document builder singleton
	 */
	private DocumentBuilder documentBuilder;
	/**
	 * The Jaxb context singleton
	 */
	private JAXBContext jaxbContext;

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public MapDetailsElement marshal(Map<String, Object> v) throws JAXBException, ParserConfigurationException {

		if (v == null || v.isEmpty()) {
			return null;
		}

		MapDetailsElement map = new MapDetailsElement();

		for (String key : v.keySet()) {
			Element value = marshalObject(v.get(key));
			map.addEntry(key, value);
		}

		return map;
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public Map<String, Object> unmarshal(MapDetailsElement v) {
		if (v == null) {
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>(v.getEntries().size());

		for (MapDetailsEntry entry : v.getEntries()) {
			map.put(entry.getKey(), entry.getObject());
		}

		return map;
	}

	/**
	 * Marshals a given object
	 * 
	 * @param obj
	 *            The object
	 * @return The marshalled object
	 * @throws JAXBException 
	 * @throws ParserConfigurationException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Element marshalObject(Object obj) throws JAXBException,
			ParserConfigurationException {
	QName rootElement = new QName(obj.getClass().getName());
		Class<?> type = obj.getClass();
		JAXBElement jaxbElement = new JAXBElement(rootElement, type, obj);

		// 2. Marshal the JAXBElement to a DOM element.
		Document document = getDocumentBuilder().newDocument();
		Marshaller marshaller = getJAXBContext(type).createMarshaller();
		marshaller.marshal(jaxbElement, document);
		Element element = document.getDocumentElement();

		// 3. Set the type attribute based on the value's type.
		element.setAttribute("class", type.getName());
		return element;
	}

	/**
	 * Returns the document builder
	 * 
	 * @return The document builder
	 * @throws ParserConfigurationException 
	 */
	private DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
		// Lazy load the DocumentBuilder as it is not used for unmarshalling.
		if (null == documentBuilder) {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			documentBuilder = dbf.newDocumentBuilder();
		}
		return documentBuilder;
	}

	/**
	 * Returns the singleton JAXB context
	 * 
	 * @param type
	 *            The type for the context to be built
	 * @return The built context
	 * @throws JAXBException 
	 */
	private JAXBContext getJAXBContext(Class<?> type) throws JAXBException {
		if (jaxbContext == null) {
			jaxbContext = JAXBContext.newInstance(type);
		}
		return jaxbContext;
	}
}
