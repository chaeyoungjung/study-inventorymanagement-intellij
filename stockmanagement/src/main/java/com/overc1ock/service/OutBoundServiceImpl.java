package com.overc1ock.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.stereotype.Service;

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
	public List<ProductionPlanVO> getOutboundList() {
		log.info("*******************outbound list service**********************");
		return mapper.getOutboundList();
	}

	@Override
	public List<ProductionPlanVO> getProductNameList() {
		log.info("*******************product name list service**********************");
		return mapper.getProductNameList();
	}

	@Override
	public Integer insertOutbound(List<OutBoundVO> list) {
		log.info("*******************product name list service**********************");
		return mapper.insertOutbound(list);
	}

}
