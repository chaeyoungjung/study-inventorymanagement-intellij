package com.overc1ock.mapper;

import java.util.List;

import com.overc1ock.domain.OutBoundVO;
import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.domain.ReportVO;
import com.overc1ock.domain.StockCalculationVO;
import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.ExistingStockVO;

public interface StockManagementMapper {
	
	//출고처리
	List<ProductionPlanVO>getOutboundList();
	List<ProductionPlanVO>getOutboundListWithCriteria(Criteria cri);
	List<ProductionPlanVO>getProductNameList();
	Integer insertOutbound(List<OutBoundVO> list);
	
	//재고금액현황관리리포트
	List<ReportVO> chartItemCategory(Criteria cri);
	List<ReportVO> chartItemCode(Criteria cri);
	List<ReportVO> chartDate(Criteria cri);
	
	//재고산출
	List<StockCalculationVO> getStockCalculationList(Criteria cri);
	Integer insertExistingStock(ExistingStockVO vo);
	
}
