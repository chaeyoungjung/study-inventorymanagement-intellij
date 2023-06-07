package com.overc1ock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.overc1ock.domain.ChartReportVO;
import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.OutBoundVO;
import com.overc1ock.domain.ProductionPlanVO;

public interface OutBoundService {
	
	List<ProductionPlanVO> getOutboundList();
	List<ProductionPlanVO> getOutboundListWithCriteria(Criteria cri);
	List<ProductionPlanVO> getProductNameList();
	Integer insertOutbound(List<OutBoundVO> list);
}
