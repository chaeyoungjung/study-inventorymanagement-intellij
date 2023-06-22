package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.InBoundVO;
import com.overc1ock.domain.ProcurementPlanVO;
import com.overc1ock.domain.PurchaseOrderVO;

public interface InboundService {
	
	List<Integer> checkOrderList();
	List<ProcurementPlanVO> getOrderItemList(Criteria cri);
	Integer insertInbound(InBoundVO vo);

}
