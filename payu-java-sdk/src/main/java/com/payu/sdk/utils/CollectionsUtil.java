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
