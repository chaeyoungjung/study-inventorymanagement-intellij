package com.overc1ock.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.InBoundVO;
import com.overc1ock.domain.ProcurementPlanVO;
import com.overc1ock.domain.PurchaseOrderVO;
import com.overc1ock.mapper.StockManagementMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class InboundServiceImpl implements InboundService {
	
	StockManagementMapper mapper;

	@Override
	public List<PurchaseOrderVO> getPurchaseOrderListAtInbound(Criteria cri) {
		log.info("입고처리(마감) 구매발주서 목록 요청 서비스"); 
		return mapper.getPurchaseOrderListAtInbound(cri);
	}

	@Override
	public List<ProcurementPlanVO> getProcurementPlanList(Integer po_code) {
		log.info("입고처리(마감) 조달계획 목록 요청 서비스"); 
		return mapper.getProcurementPlanList(po_code);
	}

	@Override
	public List<ProcurementPlanVO> getOrderItemList(Integer po_code) {
		log.info("입고처리(마감) 발주품목 목록 요청 서비스"); 
		return mapper.getOrderItemList(po_code);
	}

	@Override
	public Integer insertInbound(List<InBoundVO> list) {
		return null;
	}

}
