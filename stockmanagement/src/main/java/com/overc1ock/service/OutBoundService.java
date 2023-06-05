package com.overc1ock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.OutBoundVO;
import com.overc1ock.domain.ProductionPlanVO;

public interface OutBoundService {
	
	public List<ProductionPlanVO>getOutboundList();
	public List<ProductionPlanVO>getOutboundListWithCriteria(Criteria cri);
	public List<ProductionPlanVO>getProductNameList();
	public Integer insertOutbound(List<OutBoundVO> list);
}
