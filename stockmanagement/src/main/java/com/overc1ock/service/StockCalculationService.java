package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.StockCalculationVO;

public interface StockCalculationService {
	
	List<StockCalculationVO> getStockCalculationList(Criteria cri);

}
