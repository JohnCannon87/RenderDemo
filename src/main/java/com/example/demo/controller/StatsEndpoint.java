package com.example.demo.controller;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Stats;

@RestController
@RequestMapping("api/v1/stats")
public class StatsEndpoint extends abstractEndpoint {

	private static final String ENDPOINT_TYPE = "Stats";

	@GetMapping
	public List<Stats> getCountries() {
		updateStats(ENDPOINT_TYPE);
		return StreamSupport.stream(statsDAO.findAll().spliterator(), false).toList();
	}

	@Override
	protected String endpointType() {
		return ENDPOINT_TYPE;
	}
}
