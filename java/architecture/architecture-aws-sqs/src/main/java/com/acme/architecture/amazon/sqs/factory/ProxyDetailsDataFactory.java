package com.acme.architecture.amazon.sqs.factory;
import com.acme.architecture.amazon.sqs.entity.ProxyDetails;

public final class ProxyDetailsDataFactory {

	public static ProxyDetails create(final String host, int port) {
		final ProxyDetails proxyDetails = new ProxyDetails();
		proxyDetails.setHost(host);
		proxyDetails.setPort(port);
		return proxyDetails;
	}
	
}
