package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TickerInfo {

	@JsonProperty("15m")
	private double fifteenMinutesPrice;
	private double last;
	private double buy;
	private double sell;
	private String symbol;

}
