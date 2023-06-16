package com.overc1ock.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class StockCalculationVO {
	
	private String item_code;
	private String item_name;
	private String standard;
	private String material;
	private String subcontractor_name;
	private Integer inbound_amount;
	private Integer outbound_amount;
	private Integer stock_amount;
	private Integer supply_price;
}
