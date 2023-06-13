package com.overc1ock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.overc1ock.domain.Criteria;
import com.overc1ock.mapper.StockManagementMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TransactionStatementServiceTests {
	
	@Autowired
	TransactionStatementService service;
	
	@Test
	public void testGetPurchaseOrderListAtTransactionStatement() {
		Criteria cri = new Criteria();
		cri.setStartDate("2023-06-01");
		cri.setEndDate("2023-06-03");
		cri.setWord("유");
		service.getPurchaseOrderListAtTransactionStatement(cri).forEach(vo -> log.info(vo));
	}

}
