package com.payu.sdk.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.payu.sdk.utils.xml.DateAdapter;

/**
 * <p>
 * Represents a token batch file in the PayU SDK.<br>
 * The token bath file are:
 * <li>Batch file Credit Card token.
 * <li>Batch file Transaction token.
 * </p>
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
@XmlRootElement(name = "creditCardBatchTokensFile")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCardBatchTokensFile {

	/** The batch Id */
	@XmlElement(required = false)
	private String id;
	/** The batch creation Date */
	@XmlElement(required = false)
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date creationDate;
	/** The batch processing date */
	@XmlElement(required = false)
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date processingDate;
	/** The batch merchant id */
	@XmlElement(required = false)
	private Integer merchantId;
	/** The batch file record number */
	@XmlElement(required = false)
	private Integer recordNumber;
	/** The batch file successful record number */
	@XmlElement(required = false)
	private Integer successfulRecordNumber;
	/** the batch state */
	@XmlElement(required = false)
	private BatchFileTokenState state;
	/** The batch error description */
	@XmlElement(required = false)
	private String errorDescription;

	/**
	 * Returns the Id
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the batch file creation date.
	 * 
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Returns the batch file processing date.
	 * 
	 * @return the processing
	 */
	public Date getProcessingDate() {
		return processingDate;
	}

	/**
	 * Returns the batch file merchant id.
	 * 
	 * @return the merchant id.
	 */
	public Integer getMerchantId() {
		return merchantId;
	}

	/**
	 * Returns the batch file record number.
	 * 
	 * @return the recordNumber
	 */
	public Integer getRecordNumber() {
		return recordNumber;
	}

	/**
	 * Returns the batch file successful record number.
	 * 
	 * @return the successfulRecordNumber
	 */
	public Integer getSuccessfulRecordNumber() {
		return successfulRecordNumber;
	}

	/**
	 * Returns the batch file state.
	 * 
	 * @return the state
	 */
	public BatchFileTokenState getState() {
		return state;
	}

	/**
	 * Returns the batch file error.
	 * 
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * Sets the batch id
	 * 
	 * @param id The batch id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the batch file creation date.
	 * 
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Sets the batch file processing date.
	 * 
	 * @param processingDate
	 *            the processing date to set
	 */
	public void setProcessingDate(Date processingDate) {
		this.processingDate = processingDate;
	}

	/**
	 * Sets the batch file merchant id.
	 * 
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * Sets the batch file record number.
	 * 
	 * @param recordNumber
	 *            the recordNumber to set
	 */
	public void setRecordNumber(Integer recordNumber) {
		this.recordNumber = recordNumber;
	}

	/**
	 * Sets the batch file successful record number.
	 * 
	 * @param successfulRecordNumber
	 *            the successfulRecordNumber to set
	 */
	public void setSuccessfulRecordNumber(Integer successfulRecordNumber) {
		this.successfulRecordNumber = successfulRecordNumber;
	}

	/**
	 * Sets the batch file creation state.
	 * 
	 * @param state
	 *            the state to set
	 */
	public void setState(BatchFileTokenState state) {
		this.state = state;
	}

	/**
	 * Sets the batch file error description.
	 * 
	 * @param errorDescription
	 *            the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription != null
				&& !errorDescription.trim().isEmpty() ? errorDescription.trim()
				: null;
	}

}
