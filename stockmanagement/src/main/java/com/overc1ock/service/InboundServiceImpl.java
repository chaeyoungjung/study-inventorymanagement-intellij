package com.overc1ock.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<ProcurementPlanVO> getOrderItemList(Criteria cri) {
		log.info("입고처리(마감) 발주품목 목록 요청 서비스"); 
		return mapper.getOrderItemList(cri);
	}

	@Override
	@Transactional
	public Integer insertInbound(InBoundVO vo) {
		log.info("입고처리(마감) 입고등록 요청 서비스"); 
		mapper.insertInbound(vo);
		mapper.updateProcurementPlanStatus(vo);
		return null;
	}

	@Override
	public List<Integer> checkOrderList() {
		log.info("완료된 구매발주서 있는지 확인");
		return mapper.checkOrderList();
	}

}
