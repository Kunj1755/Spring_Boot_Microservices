package com.in28minutes.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// To read the application.properties values starting with limits-service
@Component // To ask Spring to create bean for this class
@ConfigurationProperties(prefix = "limits-service")
public class Configuration {

	/*
	 * Here we need to define the properties that we want to read from
	 * application.properties
	 */

	private int minimum;
	private int maximum;

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}
}