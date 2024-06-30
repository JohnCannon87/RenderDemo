package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stats {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String endpointType;
	private long visitCount;

	public void incrementCount() {
		visitCount++;
	}

}
