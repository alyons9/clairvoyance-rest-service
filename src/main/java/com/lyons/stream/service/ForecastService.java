package com.lyons.stream.service;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.esotericsoftware.minlog.Log;
import com.lyons.models.ForecastData;
import com.lyons.stream.ForecastStream;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ForecastService {

	private final ForecastStream forecastStream;
	
	public ForecastService(ForecastStream stream) {
		this.forecastStream  = stream;
	}
	
	public void sendForecast(final ForecastData data) {
		Log.info(">> sendForecast");
		MessageChannel messageChannel = forecastStream.sendForecastData();
		messageChannel.send(
				MessageBuilder
				.withPayload(data)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
		Log.info("<< sendForecast");
	}
}
