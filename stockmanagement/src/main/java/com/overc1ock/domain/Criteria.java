package com.overc1ock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Criteria {
	private String startDate;
	private String endDate;
	private String category;
	private String word;
	private Integer num;

}
