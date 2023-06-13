package com.overc1ock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class RequestTransactionStatementDTO {
	private Integer po_code;
	private String person;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

}
