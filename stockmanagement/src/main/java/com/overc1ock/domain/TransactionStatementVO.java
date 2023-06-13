package com.overc1ock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TransactionStatementVO {
	
	private String item_name;
	private Integer amount;
	private Integer price;
	private String subcontractor_name;
	private String subcontractor_address;
	private String subcontractor_tel;
	private String subcontractor_person;
	private String subcontractor_email;
	private String acceptor;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deal_date;
	
	

}
