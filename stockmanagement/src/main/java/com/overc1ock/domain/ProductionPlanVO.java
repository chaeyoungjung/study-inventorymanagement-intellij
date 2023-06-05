package com.overc1ock.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProductionPlanVO {
	private String product_name;
	Integer item_code;
	private String item_name;
	private Integer consumption;
	private Date production_date;
	private Integer stock_amount;
	private Integer total_amount;
	Integer iup_code;
	
	
}
