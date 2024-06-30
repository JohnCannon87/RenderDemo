package com.example.demo.service;

import java.util.HashMap;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.TickerInfo;

@Service
public class BlockchainService {

	private final RestTemplate restTemplate;

	public BlockchainService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public HashMap<String, TickerInfo> getTickerData() {
		String url = "https://blockchain.info/ticker";

		ParameterizedTypeReference<HashMap<String, TickerInfo>> typeReference = new ParameterizedTypeReference<HashMap<String, TickerInfo>>() {
		};

		ResponseEntity<HashMap<String, TickerInfo>> result = restTemplate.exchange(url, HttpMethod.GET, null,
				typeReference);
		return result.getBody();
	}
}
