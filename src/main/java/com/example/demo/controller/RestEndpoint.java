package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Country;

@RestController
@RequestMapping("api/v1/countries")
public class RestEndpoint extends abstractEndpoint {

	private static final String ENDPOINT_TYPE = "Countries";

	private static final List<Country> COUNTRIES = List.of(
			new Country("United States of America", "Washington D.C.", 339_996_563),
			new Country("China", "Beijing", 1_411_750_000),
			new Country("India", "New Delhi", 1_428_627_663));

	@GetMapping
	public List<Country> getCountries() {
		updateStats(ENDPOINT_TYPE);
		return COUNTRIES;
	}

	@Override
	protected String endpointType() {
		return ENDPOINT_TYPE;
	}
}
