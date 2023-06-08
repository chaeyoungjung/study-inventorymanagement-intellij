package com.overc1ock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import com.overc1ock.service.StockCalculationService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/stockmanagement/*")
@AllArgsConstructor
public class StockManagementController {
	
	OutBoundService obService;
	StockCalculationService scService;
	
	@GetMapping("/outbound")
	public void outbound(Model model,Criteria cri) {
		log.info("*******************get 출고처리 controller**********************");
//		model.addAttribute("obList", observice.getOutboundList());
		log.info(cri);
		model.addAttribute("obList", obService.getOutboundListWithCriteria(cri));
		model.addAttribute("pnList", obService.getProductNameList());
	}
	
	@PostMapping("/outbound")
	public String outbound(OutBoundVO outBoundVO, Criteria cri) {
		log.info("*******************post 출고처리 controller**********************");
		List<OutBoundVO> list = new ArrayList<OutBoundVO>();
		for (OutBoundVO vo : outBoundVO.getOutBoundVOList()) {
			if (vo.getAmount() != null && vo.getDate() != null) {
				list.add(vo);
			}
		}
		log.info(list);
		if (list != null && !list.isEmpty()) {
			log.info("출고량 입력 수행되나");
			obService.insertOutbound(list);
		}
//		return "redirect:/stockmanagement/outbound?startDate="+cri.getStartDate()+"&endDate="+cri.getEndDate()+"&word="+cri.getWord();
		return "redirect:/stockmanagement/outbound";
	}
	
	@GetMapping("/report")
	public void report() {
		log.info("*******************get 재고금액현황관리리포트 controller**********************");
		
	}
	
	@GetMapping("/stockcalculation")
	public void stockcalculation(Model model, Criteria cri) {
		log.info("*******************get 재고산출 controller**********************");
		log.info(cri);
		if (cri.getStartDate() == null || cri.getStartDate().isEmpty()) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			cri.setStartDate(format.format(new Date())+"");
		}
		model.addAttribute("scList", scService.getStockCalculationList(cri));
	}
	
	

}
