package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.InBoundVO;
import com.overc1ock.domain.ProcurementPlanVO;
import com.overc1ock.domain.PurchaseOrderVO;

public interface InboundService {
	
	List<PurchaseOrderVO> getPurchaseOrderListAtInbound(Criteria cri);
	List<ProcurementPlanVO> getProcurementPlanList(Integer po_code);
	List<ProcurementPlanVO> getOrderItemList(Integer po_code);
	Integer insertInbound(InBoundVO vo);

}
