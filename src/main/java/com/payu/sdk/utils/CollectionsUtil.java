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
package com.payu.sdk.utils;

import java.util.Set;
/*
 * Utility class for managing collections
 * @author PayU Latam
 * @since 1.1.1
 * @version 1.1.1, 11/07/2014
 */
public class CollectionsUtil {


	/*
	 * Takes an array and a Set, determines whether any Set key is within the array
	 *
	 * @param Set<String> keySet
	 * 							the Set with the keys
	 * @param String[] array
	 * 							the array parameters
	 * return if some value is intercepted
	 */
	public static boolean interceptMaps(Set<String> keySet, String[] array) {

		for (String key : array) {
			if(keySet.contains(key)){
				return true;
			}
		}
		return false;
	}

}
