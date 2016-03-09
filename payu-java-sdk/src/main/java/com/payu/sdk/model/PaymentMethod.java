package com.payu.sdk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum representing a payment method in the PayU SDK.
 * 
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 * @deprecated use {@link #com.payu.sdk.model.PaymentMethodApi} instead.  
 */
@Deprecated
public enum PaymentMethod {

	VISA(PaymentMethodType.CREDIT_CARD),

	AMEX(PaymentMethodType.CREDIT_CARD),

	DINERS(PaymentMethodType.CREDIT_CARD),

	MASTERCARD(PaymentMethodType.CREDIT_CARD),

	DISCOVER(PaymentMethodType.CREDIT_CARD),

	ELO(PaymentMethodType.CREDIT_CARD),

	SHOPPING(PaymentMethodType.CREDIT_CARD),

	NARANJA(PaymentMethodType.CREDIT_CARD),

	CABAL(PaymentMethodType.CREDIT_CARD),

	ARGENCARD(PaymentMethodType.CREDIT_CARD),

	PRESTO(PaymentMethodType.CREDIT_CARD),

	RIPLEY(PaymentMethodType.CREDIT_CARD),

	PSE(PaymentMethodType.PSE),

	BALOTO(PaymentMethodType.CASH),

	EFECTY(PaymentMethodType.CASH),

	BCP(PaymentMethodType.REFERENCED),

	SEVEN_ELEVEN(PaymentMethodType.CASH),

	OXXO(PaymentMethodType.CASH),

	BOLETO_BANCARIO(PaymentMethodType.CASH),

	RAPIPAGO(PaymentMethodType.CASH),

	PAGOFACIL(PaymentMethodType.CASH),

	BAPRO(PaymentMethodType.CASH),

	COBRO_EXPRESS(PaymentMethodType.CASH),

	SERVIPAG(PaymentMethodType.CASH),

	SENCILLITO(PaymentMethodType.CASH),

	BAJIO(PaymentMethodType.REFERENCED),

	BANAMEX(PaymentMethodType.REFERENCED),

	BANCOMER(PaymentMethodType.REFERENCED),

	HSBC(PaymentMethodType.REFERENCED),

	IXE(PaymentMethodType.REFERENCED),

	SANTANDER(PaymentMethodType.REFERENCED),

	SCOTIABANK(PaymentMethodType.REFERENCED);

	/**
	 * Default constructor
	 * 
	 * @param type
	 *            the payment method type
	 */
	private PaymentMethod(PaymentMethodType type) {
		this.type = type;
	}

	/**
	 * The type of the payment method.
	 */
	private PaymentMethodType type;

	/**
	 * <p>
	 * Return a PaymentMethodMain Object from the String.<br>
	 * Ex. PaymentMethodMain.fromString("visa") return PaymentMethodMain.VISA
	 * Ex. PaymentMethodMain.fromString("VISA") return PaymentMethodMain.VISA
	 * Ex. PaymentMethodMain.fromString("XX") return null
	 * </p>
	 * 
	 * @param paymentMethodMain
	 * @return
	 */
	public static PaymentMethod fromString(String paymentMethod) {
		if (paymentMethod != null) {
			for (PaymentMethod pmm : PaymentMethod.values()) {
				if (paymentMethod.equalsIgnoreCase(pmm.toString())) {
					return pmm;
				}
			}
		}
		return null;
	}

	/**
	 * Filters the payments methods list by type.
	 * 
	 * @param type
	 *            , the filter type.
	 * @return the list of the payments method given type.
	 */
	public static List<PaymentMethod> getPaymentMethods(PaymentMethodType type) {
		List<PaymentMethod> paymentsMethod = new ArrayList<PaymentMethod>();
		PaymentMethod[] values = PaymentMethod.values();
		for (int i = 0; i < values.length; i++) {
			if (values[i].getType() == type) {
				paymentsMethod.add(values[i]);
			}
		}
		return paymentsMethod;
	}

	/**
	 * Returns the type of the payment method.
	 * 
	 * @return the type of the payment method.
	 */
	public PaymentMethodType getType() {
		return type;
	}

}
