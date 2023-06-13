package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.PurchaseOrderVO;
import com.overc1ock.domain.RequestTransactionStatementDTO;
import com.overc1ock.domain.TransactionStatementVO;

public interface TransactionStatementService {
	
	List<PurchaseOrderVO> getPurchaseOrderListAtTransactionStatement(Criteria cri);
	List<TransactionStatementVO> getTransactionStatement(Integer po_code);
	Integer insertTransactionStatement(RequestTransactionStatementDTO dto);
	Integer deleteTransactionStatement(Integer po_code);

}
