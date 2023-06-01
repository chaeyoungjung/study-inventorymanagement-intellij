package com.overc1ock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProductionPlanVO {
	String product_name;
	Integer item_code;
	String item_name;
	Integer consumption;
	Date production_date;
	Integer stock_amount;
	Integer total_amount;
}
