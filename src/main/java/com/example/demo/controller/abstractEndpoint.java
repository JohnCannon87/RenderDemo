package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.datastore.StatsDAO;
import com.example.demo.model.Stats;

public abstract class abstractEndpoint {

	@Autowired
	protected StatsDAO statsDAO;

	protected abstract String endpointType();

	protected void updateStats(String endpointType) {
		Stats endpointStats = statsDAO.findByEndpointType(endpointType);
		if (endpointStats == null) {
			endpointStats = Stats.builder().endpointType(endpointType).build();
		}
		endpointStats.incrementCount();
		statsDAO.save(endpointStats);
	}

}
