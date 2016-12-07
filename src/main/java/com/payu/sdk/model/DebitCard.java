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
package com.payu.sdk.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a debit card in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.1.18
 * @version 1.1.18, 07/12/2016
 */
@XmlRootElement(name="debitCard")
@XmlAccessorType(XmlAccessType.FIELD)
public class DebitCard extends AbstractCardData implements Serializable {

	/** The generated serial version Id */
	private static final long serialVersionUID = 3297523835462425085L;

	/**
	 * Account type of the debit card.
	 */
	@XmlElement(required = false)
	private DebitCardAccountType debitAccountType;
	
	/* (non-Javadoc)
	 * @see com.payu.sdk.model.AbstractCardData#getCardType()
	 */
	@Override
	public CardType getCardType() {
		return CardType.DEBIT;
	}
	
	/**
	 * Gets the debit account type.
	 *
	 * @return the debit account type
	 */
	public DebitCardAccountType getDebitAccountType() {
		return debitAccountType;
	}

	/**
	 * Sets the debit account type.
	 *
	 * @param debitAccountType the new debit account type
	 */
	public void setDebitAccountType(DebitCardAccountType debitAccountType) {
		this.debitAccountType = debitAccountType;
	}

}
