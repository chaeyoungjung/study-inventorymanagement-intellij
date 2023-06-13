package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.InBoundVO;
import com.overc1ock.domain.ProcurementPlanVO;
import com.overc1ock.domain.PurchaseOrderVO;

public class InboundServiceImpl implements InboundService {

	@Override
	public List<PurchaseOrderVO> getPurchaseOrderListAtInbound(Criteria cri) {
		return null;
	}

	@Override
	public List<ProcurementPlanVO> getProcurementPlanList(Integer po_code) {
		return null;
	}

	@Override
	public List<ProcurementPlanVO> getOrderItemList(Integer po_code) {
		return null;
	}

	@Override
	public Integer insertInbound(List<InBoundVO> list) {
		return null;
	}

}
