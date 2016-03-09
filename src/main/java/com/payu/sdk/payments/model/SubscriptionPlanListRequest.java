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
package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.model.request.Request;

/**
 * Subscription plan representation List
 *
 * @author PayU Latam
 * @since 1.1.1
 * @version 1.1.1, 06/06/2014
 */
@XmlRootElement(name = "planListResponse")
@XmlType(propOrder = {"planList"})
public class SubscriptionPlanListRequest extends Request {

	/** The generated serial version Id */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.payu.sdk.model.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants#RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl, RequestMethod requestMethod) {

		return String.format(Resources.ENTITY_API_URL_PATTERN,
				baseUrl, Resources.PAYMENT_PLAN_VERSION,
				Resources.URI_PLANS + this.getQueryString());
	}

}
