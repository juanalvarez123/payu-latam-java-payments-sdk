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
package com.payu.sdk.utils.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.w3c.dom.Element;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.model.Order;
import com.payu.sdk.model.TransactionResponse;
import com.payu.sdk.reporting.model.ReportingResultOrderList;
import com.payu.sdk.utils.JaxbUtil;

/**
 * Utility to convert Payload Object to corresponding type of {@link Element}
 * and vice versa.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public class PayloadAdapter extends XmlAdapter<Element, Object> {

	/** The payload transaction class */
	private static final String TRANSACTION_CLASS = "transactionResponse";
	/** The payload order class */
	private static final String ORDER_CLASS = "order";
	/** The payload list class */
	private static final String ORDER_LIST_CLASS = "list";

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public Element marshal(Object v) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public Object unmarshal(Element v) throws PayUException {

		Object payload = null;

		String clazz = v.getAttribute("class");

		if (clazz == null) {
			return null;
		}

		if (TRANSACTION_CLASS.equals(clazz)) {

			v.getOwnerDocument().renameNode(v, null, TRANSACTION_CLASS);
			payload = JaxbUtil.convertXmlToJava(TransactionResponse.class,
					XmlFormatter.nodeToString(v));

		} else if (ORDER_CLASS.equals(clazz)) {

			v.getOwnerDocument().renameNode(v, null, ORDER_CLASS);
			payload = JaxbUtil.convertXmlToJava(Order.class,
					XmlFormatter.nodeToString(v));

		} else if (ORDER_LIST_CLASS.equals(clazz)) {

			v.getOwnerDocument().renameNode(v, null, ORDER_LIST_CLASS);
			payload = JaxbUtil.convertXmlToJava(ReportingResultOrderList.class,
					XmlFormatter.nodeToString(v)).getPayload();
		}

		return payload;
	}
}
