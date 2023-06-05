package com.overc1ock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class RequestDTO {
	private Date startDate;
	private Date endDate;
	private String category;
	private String word;

}
