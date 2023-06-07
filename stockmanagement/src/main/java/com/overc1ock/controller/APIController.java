package com.overc1ock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overc1ock.domain.ChartReportVO;
import com.overc1ock.domain.Criteria;
import com.overc1ock.service.ReportService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/stockmanagement/api/*")
@Log4j
@AllArgsConstructor
public class APIController {	
	
	ReportService service;
	
	@GetMapping("/chartdate")
	public ChartReportVO getchartdate(String month) {
		String startDate = month+"-01";
		log.info("전송된 월을 해당 월의 첫날로 바꿈 > "+startDate);
		Criteria cri = new Criteria();
		cri.setStartDate(startDate);
		
		return service.chartDate(cri);
	}
	

}
