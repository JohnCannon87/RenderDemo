package com.example.demo.datastore;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Stats;

public interface StatsDAO extends CrudRepository<Stats, Long> {

	Stats findById(long id);

	Stats findByEndpointType(String endpointType);

}
