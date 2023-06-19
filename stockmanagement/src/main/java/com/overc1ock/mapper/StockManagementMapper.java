package com.overc1ock.mapper;

import java.util.List;

import com.overc1ock.domain.OutBoundVO;
import com.overc1ock.domain.ProcurementPlanVO;
import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.domain.PurchaseOrderVO;
import com.overc1ock.domain.ReportVO;
import com.overc1ock.domain.StockCalculationVO;
import com.overc1ock.domain.TransactionStatementVO;
import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.InBoundVO;

public interface StockManagementMapper {
	
	//입고처리(마감)
	List<ProcurementPlanVO> getOrderItemList(Criteria cri);
	List<Integer> checkOrderList();
	List<ProcurementPlanVO> getProcurementPlanList(Integer po_code);
	Integer insertInbound(InBoundVO vo);
	Integer updateProcurementPlanStatus(InBoundVO vo);
	List<ProcurementPlanVO> getPurchaseOrderAtInbound(Integer po_code);
	
	//거래명세서 발행
	List<PurchaseOrderVO> getPurchaseOrderListAtTransactionStatement(Criteria cri);
	List<TransactionStatementVO> getTransactionStatement(Integer po_code);
	Integer insertTransactionStatement(Integer po_code);
	
	//출고처리
	List<ProductionPlanVO>getOutboundListWithCriteria(Criteria cri);
	List<ProductionPlanVO>getProductNameList();
	Integer insertOutbound(List<OutBoundVO> list);
	
	//재고산출
	List<StockCalculationVO> getStockCalculationList(Criteria cri);
	
	//재고금액현황관리리포트
	List<ReportVO> chartItemCategory(Criteria cri);
	List<ReportVO> chartDate(Criteria cri);
	

	

	
	
	
}
