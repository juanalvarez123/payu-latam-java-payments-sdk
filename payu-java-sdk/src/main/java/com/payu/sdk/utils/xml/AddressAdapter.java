package com.payu.sdk.utils.xml;

import java.text.ParseException;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.payu.sdk.model.Address;
import com.payu.sdk.model.AddressV4;

/**
 * Utility to convert old API address to new address version and vice versa.
 * 
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 06/09/2013
 */
public class AddressAdapter extends XmlAdapter<AddressV4, Address> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	@Override
	public AddressV4 marshal(Address v) {

		if (v != null) {
			AddressV4 address = new AddressV4();

			address.setCity(v.getCity());
			address.setCountry(v.getCountry());
			address.setPhone(v.getPhone());
			address.setPostalCode(v.getPostalCode());
			address.setState(v.getState());
			address.setStreet1(v.getLine1());
			address.setStreet2(v.getLine2());
			address.setStreet3(v.getLine3());

			return address;

		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	@Override
	public Address unmarshal(AddressV4 v) throws ParseException {

		if (v != null) {
			Address address = new Address();

			address.setCity(v.getCity());
			address.setCountry(v.getCountry());
			address.setPhone(v.getPhone());
			address.setPostalCode(v.getPostalCode());
			address.setState(v.getState());
			address.setLine1(v.getStreet1());
			address.setLine2(v.getStreet2());
			address.setLine3(v.getStreet3());

			return address;

		} else {

			return null;
		}
	}

}
