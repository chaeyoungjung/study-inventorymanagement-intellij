package com.overc1ock.mapper;

import java.util.List;

import com.overc1ock.domain.OutBoundVO;
import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.domain.ReportVO;
import com.overc1ock.domain.Criteria;

public interface StockManagementMapper {
	
	public List<ProductionPlanVO>getOutboundList();
	public List<ProductionPlanVO>getOutboundListWithCriteria(Criteria cri);
	public List<ProductionPlanVO>getProductNameList();
	public Integer insertOutbound(List<OutBoundVO> list);
	public ReportVO chartItemName();
	public ReportVO chartItemCode();
	public ReportVO chartDate();
}
