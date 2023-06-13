package com.overc1ock.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.overc1ock.domain.OutBoundVO;
import com.overc1ock.domain.ProcurementPlanVO;
import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.domain.PurchaseOrderVO;
import com.overc1ock.domain.ReportVO;
import com.overc1ock.domain.RequestTransactionStatementDTO;
import com.overc1ock.domain.StockCalculationVO;
import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.ExistingStockVO;
import com.overc1ock.domain.InBoundVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class StockManagementMapperTests {
	
	@Autowired
	StockManagementMapper mapper;
	
	//출고처리
	@Test
	public void testGetOutboundList() {
		List<ProductionPlanVO> list = mapper.getOutboundList();
		for (ProductionPlanVO vo : list) {
			log.info("*****************************"+vo);
		}
	}
	
	@Test
	public void testGetOutboundListWithCriteria() {
		Criteria cri = new Criteria();
		cri.setStartDate("2023-06-01");
		cri.setEndDate("2023-06-11");
		cri.setWord("1");
		List<ProductionPlanVO> list = mapper.getOutboundListWithCriteria(cri);
		for (ProductionPlanVO vo : list) {
			log.info("*****************************"+vo);
		}
	}
	
	@Test
	public void testGetProductNameList() {
		List<ProductionPlanVO> list = mapper.getProductNameList();
		for (ProductionPlanVO vo : list) {
			log.info("*****************************"+vo);
		}
	}
	
	@Test
	public void testInsertOutbound() {
		List<OutBoundVO> list = new ArrayList<OutBoundVO>();
		OutBoundVO vo1 = new OutBoundVO();
		vo1.setItem_code(1);
		vo1.setIup_code(1);
		vo1.setAmount(20);
		vo1.setDate(new Date());
		list.add(vo1);
		OutBoundVO vo2 = new OutBoundVO();
		vo2.setItem_code(2);
		vo2.setIup_code(2);
		vo2.setAmount(40);
		vo2.setDate(new Date());
		list.add(vo2);
		log.info("insert outbound 수행결과 "+mapper.insertOutbound(list));
	}
	
	//재고금액현황관리리스트
	@Test
	public void testChartDate() {
		Criteria cri = new Criteria();
		cri.setStartDate("2023-05-01");
		List<ReportVO> list = mapper.chartDate(cri);
		log.info(list);
	}
	
	@Test
	public void testChartItemCode() {
		Criteria cri = new Criteria();
		cri.setStartDate("2023-06-08");
//		cri.setNum(200000);
		List<ReportVO> list = mapper.chartItemCode(cri);
		list.forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testChartItemCategory() {
		Criteria cri = new Criteria();
		cri.setStartDate("2023-06-08");
		cri.setCategory("S");
//		cri.setNum(200000);
		List<ReportVO> list = mapper.chartItemCategory(cri);
		list.forEach(vo -> log.info(vo));
	}
	
	//재고산출
	@Test
	public void testInsertExistingStock() {
		ExistingStockVO vo = new ExistingStockVO();
		vo.setAmount(20);
		vo.setItem_code(3);
		mapper.insertExistingStock(vo);
	}
	
	@Test
	public void testGetStockCalculationList() {
		Criteria cri = new Criteria();
		cri.setStartDate("2023-06-08");
		cri.setCategory("name");
		cri.setWord("test");
		mapper.getStockCalculationList(cri).forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetItemCodeList() {
		mapper.getItemCodeList().forEach(vo -> log.info(vo));
	}
	
	//입고처리
	@Test
	public void testGetPurchaseOrderListAtInbound() {
		Criteria cri = new Criteria();
		cri.setStartDate("2023-06-01");
		cri.setEndDate("2023-06-03");
		mapper.getPurchaseOrderListAtInbound(cri).forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetProcurementPlanList() {
		mapper.getProcurementPlanList(3).forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetOrderItemList() {
		mapper.getOrderItemList(1).forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testInsertInbound() {
		List<InBoundVO> list = new ArrayList<InBoundVO>();
		InBoundVO vo1 = new InBoundVO();
		vo1.setItem_code(1);
		vo1.setPo_code(1);
		vo1.setAmount(500);
		vo1.setDate(new Date());
		list.add(vo1);
		InBoundVO vo2 = new InBoundVO();
		vo2.setItem_code(2);
		vo2.setPo_code(1);
		vo2.setAmount(500);
		vo2.setDate(new Date());
		list.add(vo2);
		log.info("insert inbound 수행결과 "+mapper.insertInbound(list));
	}
	
	@Test
	public void testUpdateProcurementPlanStatus() {
		log.info(mapper.updateProcurementPlanStatus());
	}
	
	//거래명세서 발행
	@Test
	public void testGetPurchaseOrderListAtTransactionStatement() {
		Criteria cri = new Criteria();
		cri.setStartDate("2023-06-01");
		cri.setEndDate("2023-06-03");
		mapper.getPurchaseOrderListAtTransactionStatement(cri).forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetTransactionStatement() {
		mapper.getTransactionStatement(3).forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testInsertTransactionStatement() {
		RequestTransactionStatementDTO dto = new RequestTransactionStatementDTO();
		dto.setPerson("인수한 사람");
		dto.setDate(new Date());
		dto.setPo_code(3);
		log.info(mapper.insertTransactionStatement(dto));
	}
	
	@Test
	public void testDeleteTransactionStatement() {
		log.info(mapper.deleteTransactionStatement(3));
	}
}
