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
package com.payu.sdk.model.request;

import javax.xml.bind.annotation.XmlElement;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.model.Language;
import com.payu.sdk.model.Merchant;

/**
 * Represents a command request in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public abstract class CommandRequest extends Request {

	/** The generated serial version Id */
	private static final long serialVersionUID = 404737321362981389L;
	/** The language to be sent in the request */
	@XmlElement
	private Language language;
	/** The command that the request will try to do */
	@XmlElement
	private Command command;
	/** The merchant that made the request */
	@XmlElement
	private Merchant merchant;

	/**
	 * Returns the language
	 *
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * Returns the command
	 *
	 * @return the command
	 */
	public Command getCommand() {
		return command;
	}

	/**
	 * Returns the merchant
	 *
	 * @return the merchant
	 */
	public Merchant getMerchant() {
		return merchant;
	}

	/**
	 * Sets the language
	 *
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * Sets the command
	 *
	 * @param command
	 *            the command to set
	 */
	public void setCommand(Command command) {
		this.command = command;
	}

	/**
	 * Sets the merchant
	 *
	 * @param merchant
	 *            the merchant to set
	 */
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.payu.sdk.model.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants#RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl,
			RequestMethod requestMethod) {

		return String.format("%s%s", baseUrl, Resources.DEFAULT_API_URL);
	}
}
