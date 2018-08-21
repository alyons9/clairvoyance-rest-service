package com.lyons.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lyons.models.ForecastData;
import com.lyons.stream.service.ForecastService;

@RestController
public class ForecastController {

	@Autowired
	ForecastService forecastService;
	
	@PostMapping("/forecast")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void forecast() {
		ForecastData data = ForecastData.builder()
		.startDate(new Date())
		.build();
		
		forecastService.sendForecast(data);
	}
}
