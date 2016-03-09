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
