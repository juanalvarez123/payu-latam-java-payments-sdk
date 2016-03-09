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

/**
 * Enum representing a batch file token state in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public enum BatchFileTokenState {

	/**
	 * State used to indicate that the batch file is being created and
	 * validated.
	 */
	CREATING,

	/**
	 * State used to indicate that the batch file is pending.
	 */
	PENDING,

	/**
	 * State used to indicate that the batch file is being processed.
	 */
	PROCESSING,

	/**
	 * State used to indicate that the batch file is is not valid for
	 * processing.
	 */
	ERROR,

	/**
	 * State used to indicate that the batch file was processed.
	 */
	PROCESSED;

	/**
	 * Return a ApiBatchFileTokenState Object from the String.
	 *
	 * @param batchFileTokenState
	 *            The batch file token state to search
	 * @return The batch file token state found, or null if none is found.
	 */
	public static BatchFileTokenState fromString(String batchFileTokenState) {
		if (batchFileTokenState != null) {
			for (BatchFileTokenState bfts : BatchFileTokenState.values()) {
				if (batchFileTokenState.equalsIgnoreCase(bfts.toString())) {
					return bfts;
				}
			}
		}
		return null;
	}

}
