package com.overc1ock.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.InBoundVO;
import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.mapper.StockManagementMapperTests;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class InBoundServiceTests {
	
	@Autowired
	InboundService service;
	
	@Test
	public void testInsertInbound() {
		InBoundVO vo = new InBoundVO();
		vo.setDate(new Date());
		vo.setPo_code(3);
		vo.setAmount(2000);
		vo.setItem_code(4);
		service.insertInbound(vo);
	}
	

}
