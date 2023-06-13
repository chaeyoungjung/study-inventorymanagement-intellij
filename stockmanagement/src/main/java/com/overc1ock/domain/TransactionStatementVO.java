package com.overc1ock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class TransactionStatementVO extends TransactionInfoVO {
	
	private String item_name;
	private Integer amount;
	private Integer price;
	
	

}
