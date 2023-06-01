package com.overc1ock.mapper;

import java.util.List;

import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.domain.RequestDTO;

public interface StockManagementMapper {
	
	public List<ProductionPlanVO>getOutboundList(RequestDTO rdto);
}
