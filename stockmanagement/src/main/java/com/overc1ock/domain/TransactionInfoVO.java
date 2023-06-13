package com.overc1ock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class TransactionInfoVO {
	
	private String subcontractor_name;
	private String subcontractor_address;
	private String subcontractor_tel;
	private String subcontractor_person;
	private String subcontractor_email;
	private String acceptor;
	private Date deal_date;
}
