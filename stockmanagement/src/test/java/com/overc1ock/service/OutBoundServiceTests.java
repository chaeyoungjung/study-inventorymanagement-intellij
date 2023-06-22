package com.overc1ock.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.overc1ock.domain.Criteria;
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
	public void testGetOutboundListWithCriteria() {
		Criteria cri = new Criteria();
		cri.setStartDate("2023-06-01");
		cri.setEndDate("2023-06-11");
		cri.setWord("test제품2");
		List<ProductionPlanVO> list = service.getOutboundListWithCriteria(cri);
		for (ProductionPlanVO vo : list) {
			log.info("*****************************"+vo);
		}
	}

}
