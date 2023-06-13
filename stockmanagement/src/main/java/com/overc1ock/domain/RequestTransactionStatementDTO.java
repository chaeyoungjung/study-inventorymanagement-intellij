package com.overc1ock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class RequestTransactionStatementDTO {
	private Integer po_code;
	private Date date;
	private String person;

}
