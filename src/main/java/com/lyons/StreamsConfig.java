package com.lyons;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.lyons.stream.ForecastStream;

@EnableBinding(ForecastStream.class)
public class StreamsConfig {

}
