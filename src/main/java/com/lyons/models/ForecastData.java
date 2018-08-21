package com.lyons.models;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ForecastData {
	Date startDate;
}
