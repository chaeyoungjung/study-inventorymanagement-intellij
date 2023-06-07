package com.overc1ock.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ChartReportVO {
	private String[] labelsarr;
	private Integer[] valuesarr;
	
}
