package com.overc1ock.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.mapper.StockManagementMapperTests;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class OutBoundServiceTests {
	
	@Autowired
	OutBoundService service;
	
	@Test
	public void testGetOutboundList() {
		List<ProductionPlanVO> list = service.getOutboundList();
		for (ProductionPlanVO vo : list) {
			log.info("*************service test****************"+vo);
		}
	}

}
