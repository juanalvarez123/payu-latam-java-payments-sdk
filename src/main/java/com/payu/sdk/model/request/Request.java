package com.payu.sdk.model.request;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.PayU;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.exceptions.SDKException.ErrorCode;
import com.payu.sdk.model.Language;
import com.payu.sdk.reporting.model.ReportingRequest;
import com.payu.sdk.utils.JaxbUtil;
import com.payu.sdk.utils.RequestUtil;

/**
 * Represents a request in the PayU SDK.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Request implements Serializable {
	
	private String apiLogin = null;
	
	private String apiKey = null;
	
	private Language language = null;
	
	private String merchantId = null;
	
	private boolean isTest = false;
	
	private String queryString=null;
	
	private static final String INTERROGATION_SIGNE="?";

	/**
	 * The URL separator string
	 */
	private static final String PATH_SEPARATOR = "/";

	/** The generated serial version Id */
	private static final long serialVersionUID = 404737321362981389L;
	
	
	/**
	 * @return the queryString
	 */
	protected String getQueryString() {
		if(queryString==null || queryString.equals("")){
			return "";	
		}
		String result=INTERROGATION_SIGNE+queryString;
		return result;
	}
	
	/**
	 * @return the apiLogin
	 */
	public String getApiLogin() {
	
		return apiLogin;
	}

	
	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
	
		return apiKey;
	}

	
	/**
	 * @return the language
	 */
	public Language getLanguage() {
	
		return language;
	}

	
	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
	
		return merchantId;
	}

	
	/**
	 * @return the isTest
	 */
	public boolean isTest() {
	
		return isTest;
	}

	
	
	/**
	 * @param apiLogin the apiLogin to set
	 */
	public void setApiLogin(String apiLogin) {
	
		this.apiLogin = apiLogin;
	}

	
	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
	
		this.apiKey = apiKey;
	}

	
	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
	
		this.language = language;
	}

	/**
	 * @param queryString the queryString(Params) to set
	 * @throws PayUException 
	 */
	public void setMap(Map<String, String> map) throws PayUException {
		this.queryString = RequestUtil.mapToString(map);
	}

	
	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
	
		this.merchantId = merchantId;
	}

	
	/**
	 * @param isTest the isTest to set
	 */
	public void setTest(boolean isTest) {
	
		this.isTest = isTest;
	}

	/**
	 * Returns the request URL based on the request method
	 * 
	 * @param requestMethod
	 *            The request method to be sent to the server
	 * @return the request base url
	 */
	public String getRequestUrl(RequestMethod requestMethod) {

		String url;
		Environment environment = Environment.API_URL;

		if (this instanceof ReportingRequest) {

			url = PayU.reportsUrl != null ? PayU.reportsUrl : environment
					.getReportsUrl();
		} else {

			url = PayU.paymentsUrl != null ? PayU.paymentsUrl : environment
					.getPaymentsUrl();

		}

		if (!url.endsWith(PATH_SEPARATOR)) {
			url += PATH_SEPARATOR;
		}

		return getBaseRequestUrl(url, requestMethod);
	}

	/**
	 * Abstract method to get the request URL
	 * 
	 * @param baseUrl
	 *            The API base URL
	 * @param requestMethod
	 *            The request method to be sent to the server
	 * @return the request base url
	 */
	abstract protected String getBaseRequestUrl(String baseUrl,
			RequestMethod requestMethod);

	/**
	 * Maps this object into a XML format
	 * 
	 * @return The XML format of the object
	 * @throws PayUException
	 */
	public String toXml() throws PayUException {

		try {
			return JaxbUtil.convertJavaToXml(this, true);
		} catch (Exception e) {
			throw new PayUException(ErrorCode.XML_SERIALIZATION_ERROR, e);
		}

	}

}
