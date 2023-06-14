package com.overc1ock.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.ExistingStockVO;
import com.overc1ock.domain.StockCalculationVO;
import com.overc1ock.mapper.StockManagementMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class StockCalculationServiceImpl implements StockCalculationService {
	
	StockManagementMapper mapper;

	@Override
	public List<StockCalculationVO> getStockCalculationList(Criteria cri) {
		log.info("재고산출 리스트 서비스");
		return mapper.getStockCalculationList(cri);
	}

	@Override
	public Integer insertExistingStock(ExistingStockVO vo) {
		log.info("기존재고등록 서비스");
		return mapper.insertExistingStock(vo);
	}

	@Override
	public List<Integer> getItemCodeList() {
		log.info("기존재고가 없는 품목코드 목록 서비스");
		return mapper.getItemCodeList();
	}

	@Override
	public String getItemName(Integer item_code) {
		log.info("품목코드에 해당하는 품목명 보여주기 서비스");
		return mapper.getItemName(item_code);
	}

}
