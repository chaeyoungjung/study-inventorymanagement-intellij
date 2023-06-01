package com.overc1ock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.overc1ock.domain.InOutBoundVO;
import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.domain.RequestDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class StockManagementMapperTests {
	
	@Autowired
	StockManagementMapper mapper;
	
	@Test
	public void testGetOutboundList() {
		RequestDTO rdto = new RequestDTO();
		List<ProductionPlanVO> list = mapper.getOutboundList(rdto);
		for (ProductionPlanVO vo : list) {
			log.info("*****************************"+vo);
		}
	}

}
