package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TickerInfo;
import com.example.demo.service.BlockchainService;

@RestController
@RequestMapping("api/v1/block")
public class BlockchainEndpoint {

	@Autowired
	BlockchainService blockchainService;

	@GetMapping
	public HashMap<String, TickerInfo> getBlockchain() {
		return blockchainService.getTickerData();
	}
}
