package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.ExistingStockVO;
import com.overc1ock.domain.StockCalculationVO;

public interface StockCalculationService {
	
	List<StockCalculationVO> getStockCalculationList(Criteria cri);
	Integer insertExistingStock(ExistingStockVO vo);
	List<Integer> getItemCodeList();
	String getItemName(Integer item_code);

}
