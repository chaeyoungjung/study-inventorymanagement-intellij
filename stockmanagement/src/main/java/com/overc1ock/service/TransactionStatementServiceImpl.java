package com.overc1ock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.PurchaseOrderVO;
import com.overc1ock.domain.RequestTransactionStatementDTO;
import com.overc1ock.domain.TransactionStatementVO;
import com.overc1ock.mapper.StockManagementMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class TransactionStatementServiceImpl implements TransactionStatementService {
	
	StockManagementMapper mapper;

	@Override
	public List<PurchaseOrderVO> getPurchaseOrderListAtTransactionStatement(Criteria cri) {
		log.info("거래명세서 발행화면 구매발주서 목록 보여주기 서비스");
		return mapper.getPurchaseOrderListAtTransactionStatement(cri);
	}

	@Override
	public List<TransactionStatementVO> getTransactionStatement(Integer po_code) {
		log.info("거래명세서 발행화면 보여주기 서비스");
		return mapper.getTransactionStatement(po_code);
	}

	@Override
	public Integer insertTransactionStatement(Integer po_code) {
		log.info("거래명세서 등록 서비스");
		return mapper.insertTransactionStatement(po_code);
	}

}
