package com.lyons.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ForecastStream {
	String INPUT = "forecastResults-in";
	String OUTPUT = "forecastData-out";
	
	@Input(INPUT)
	SubscribableChannel retrieveForecastResults();
	
	@Input(OUTPUT)
	MessageChannel sendForecastData();
}
