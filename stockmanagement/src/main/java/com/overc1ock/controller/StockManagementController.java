package com.overc1ock.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.OutBoundVO;
import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.service.OutBoundService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/stockmanagement/*")
@AllArgsConstructor
public class StockManagementController {
	
	OutBoundService observice;
	
	@GetMapping("/outbound")
	public void outbound(Model model,Criteria cri) {
		log.info("*******************get outbound controller**********************");
//		model.addAttribute("obList", observice.getOutboundList());
		log.info(cri);
		model.addAttribute("obList", observice.getOutboundListWithCriteria(cri));
		model.addAttribute("pnList", observice.getProductNameList());
	}
	
	@PostMapping("/outbound")
	public String outbound(OutBoundVO outBoundVO, Criteria cri) {
		log.info("*******************post outbound controller**********************");
		List<OutBoundVO> list = new ArrayList<OutBoundVO>();
		for (OutBoundVO vo : outBoundVO.getOutBoundVOList()) {
			if (vo.getAmount() != null && vo.getDate() != null) {
				list.add(vo);
			}
		}
		log.info(list);
		if (list != null && !list.isEmpty()) {
			log.info("출고량 입력 수행되나");
			observice.insertOutbound(list);
		}
//		return "redirect:/stockmanagement/outbound?startDate="+cri.getStartDate()+"&endDate="+cri.getEndDate()+"&word="+cri.getWord();
		return "redirect:/stockmanagement/outbound";
	}
	
	@GetMapping("/report")
	public void report() {
		
	}
	

}
