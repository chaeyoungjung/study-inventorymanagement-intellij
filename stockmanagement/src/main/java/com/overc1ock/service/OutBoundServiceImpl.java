package com.overc1ock.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.stereotype.Service;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.OutBoundVO;
import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.mapper.StockManagementMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class OutBoundServiceImpl implements OutBoundService {
	
	StockManagementMapper mapper;

	@Override
	public List<ProductionPlanVO> getOutboundListWithCriteria(Criteria cri) {
		log.info("*******************조건 포함 출고목록 서비스**********************");
		return mapper.getOutboundListWithCriteria(cri);
	}
	
	@Override
	public List<ProductionPlanVO> getProductNameList() {
		log.info("*******************제품명 목록 서비스**********************");
		return mapper.getProductNameList();
	}

	@Override
	public Integer insertOutbound(List<OutBoundVO> list) {
		log.info("*******************출고등록 서비스**********************");
		return mapper.insertOutbound(list);
	}


}
