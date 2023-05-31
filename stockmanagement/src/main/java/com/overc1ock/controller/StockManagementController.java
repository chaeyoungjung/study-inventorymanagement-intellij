package com.overc1ock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class StockManagementController {
	
	@GetMapping("/outbound")
	public void outbound() {
		
	}
	

}
