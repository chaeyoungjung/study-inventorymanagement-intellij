package com.overc1ock.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ReportVO {
	private String[] labelsarr;
	private Integer[] valuesarr;
	
}
