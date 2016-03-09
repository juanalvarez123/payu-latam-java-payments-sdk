package com.payu.sdk.helper;

/* Java SSL Client */

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;

import com.payu.sdk.constants.Constants;
import com.payu.sdk.exceptions.ConnectionException;

/**
 * The PayU SDK wrapper of a WebClient petition
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
public final class WebClientDevWrapper {

	/**
	 * Private Constructor
	 */
	private WebClientDevWrapper() {
	}

	/**
	 * Wraps a default and secure httpClient
	 * 
	 * @param base the original httpClient
	 * @return the hhtpClient wrapped
	 * @throws ConnectionException
	 */
	public static HttpClient wrapClient(HttpClient base)
			throws ConnectionException {
		try {
			SSLContext ctx = SSLContext.getInstance(Constants.SSL_PROVIDER);

			X509TrustManager tm = new X509TrustManager() {

				public void checkClientTrusted(
						java.security.cert.X509Certificate[] chain,
						String authType)
						throws java.security.cert.CertificateException {
				}
				public void checkServerTrusted(
						java.security.cert.X509Certificate[] chain,
						String authType)
						throws java.security.cert.CertificateException {
				}

				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

			};

			ctx.init(null, new TrustManager[] { tm }, null);

			SSLSocketFactory ssf = new SSLSocketFactory(ctx,
					SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			ClientConnectionManager ccm = base.getConnectionManager();
			SchemeRegistry sr = ccm.getSchemeRegistry();

			sr.register(new Scheme("https", Constants.HTTPS_PORT, ssf));
			return new DefaultHttpClient(ccm, base.getParams());
		} catch (Exception ex) {
			throw new ConnectionException("Invalid SSL connection", ex);
		}
	}
}