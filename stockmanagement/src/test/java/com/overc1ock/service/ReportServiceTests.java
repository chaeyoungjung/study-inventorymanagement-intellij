package com.overc1ock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.overc1ock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReportServiceTests {
	
	@Autowired
	ReportService service;
	
	@Test
	public void testChartDate() {
		Criteria cri = new Criteria();
		cri.setStartDate("2023-05-01");
		cri.setEndDate("2023-05-01");
		
		log.info(service.chartDate(cri));
	}

}
