package com.overc1ock.mapper;

import java.util.List;

import com.overc1ock.domain.OutBoundVO;
import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.domain.ReportVO;
import com.overc1ock.domain.StockCalculationVO;
import com.overc1ock.domain.Criteria;

public interface StockManagementMapper {
	
	List<ProductionPlanVO>getOutboundList();
	List<ProductionPlanVO>getOutboundListWithCriteria(Criteria cri);
	List<ProductionPlanVO>getProductNameList();
	Integer insertOutbound(List<OutBoundVO> list);
	List<ReportVO> chartItemCategory(Criteria cri);
	List<ReportVO> chartItemCode(Criteria cri);
	List<ReportVO> chartDate(Criteria cri);
	List<StockCalculationVO> getStockCalculationList();
}
