package com.overc1ock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class RequestDTO {
	Date fromDate;
	Date toDate;
	String category;
	String word;

}
