package com.overc1ock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.InBoundVO;
import com.overc1ock.domain.OutBoundVO;
import com.overc1ock.domain.TransactionInfoVO;
import com.overc1ock.domain.TransactionStatementVO;
import com.overc1ock.service.InboundService;
import com.overc1ock.service.MailService;
import com.overc1ock.service.OutBoundService;
import com.overc1ock.service.StockCalculationService;
import com.overc1ock.service.TransactionStatementService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/stockmanagement/*")
@AllArgsConstructor
public class StockManagementController {
	
	OutBoundService obService;
	StockCalculationService scService;
	TransactionStatementService tsService;
	InboundService ibService;
	MailService mailservice;
	
	//입고처리(마감)
	@GetMapping("/inbound")
	public void inboundmain(Model model,Criteria cri) {
		log.info("get 입고처리(마감) 메인페이지 controller");
		model.addAttribute("poList", ibService.getOrderItemList(cri));
		model.addAttribute("cri",cri);
	}
	
	@PostMapping("/insertinbound")
	public String insertinbound(InBoundVO inBoundVO) {
		
		log.info("post 입고처리(마감) 입고등록 요청 controller");
		log.info(inBoundVO.getInBoundVOList());
		List<Integer> pocodeList = new ArrayList<Integer>();
		for (InBoundVO vo : inBoundVO.getInBoundVOList()) {
			if (vo.getAmount() != null && vo.getDate() != null) {
				log.info(vo);
				ibService.insertInbound(vo);
				if (ibService.checkOrderList().contains(vo.getPo_code())) {
					pocodeList.add(vo.getPo_code());
				};
			}
		}
		Collections.sort(pocodeList);
		log.info("모든 조달계획 완료된 구매발주서 : "+pocodeList);
		if (pocodeList.size() > 0) {
			mailservice.mailSender(pocodeList);
		}
		List<InBoundVO> list = inBoundVO.getInBoundVOList();
		
		return "redirect:/stockmanagement/inbound";
	}
	
	//거래명세서 발행
	@GetMapping("/transactionstatementmain")
	public void transactionstatementmain(Model model, Criteria cri) {
		log.info("get 거래명세서 메인페이지 요청 controller");
		model.addAttribute("poList", tsService.getPurchaseOrderListAtTransactionStatement(cri));
		model.addAttribute("cri", cri);
	}
	
	@GetMapping("/transactionstatement")
	public void transactionstatement(Model model, Integer po_code) {
		log.info("get 거래명세서 발행페이지 요청 controller");
		
		List<TransactionStatementVO> list = tsService.getTransactionStatement(po_code);
		
		TransactionInfoVO vo = new TransactionInfoVO();
		vo.setSubcontractor_person(list.get(0).getSubcontractor_person());
		vo.setSubcontractor_name(list.get(0).getSubcontractor_name());
		vo.setSubcontractor_address(list.get(0).getSubcontractor_address());
		vo.setSubcontractor_email(list.get(0).getSubcontractor_email());
		vo.setSubcontractor_tel(list.get(0).getSubcontractor_tel());
		vo.setAcceptor(list.get(0).getAcceptor());
		vo.setDeal_date(list.get(0).getDeal_date());
		log.info(vo);
		
		model.addAttribute("tsList", list);
		model.addAttribute("tsVO", vo);
		model.addAttribute("po_code",po_code);
	}
	
	@PostMapping("/inputtransactionstatement")
	public String inputtransactionstatement(Integer po_code) {
		log.info("post 거래명세서 발행요청 controller");
		log.info(po_code);
		tsService.insertTransactionStatement(po_code);
		return "redirect:/stockmanagement/transactionstatement?po_code="+po_code;
	}
	
	//출고처리
	@GetMapping("/outbound")
	public void outbound(Model model,Criteria cri) {
		log.info("get 출고처리 요청 controller");
//		model.addAttribute("obList", observice.getOutboundList());
		log.info(cri);
		model.addAttribute("obList", obService.getOutboundListWithCriteria(cri));
		model.addAttribute("pnList", obService.getProductNameList());
		model.addAttribute("cri",cri);
	}
	
	@PostMapping("/outbound")
	public String outbound(OutBoundVO outBoundVO, Criteria cri) {
		log.info("post 출고처리 출고등록 요청 controller");
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
	
	//재고산출
	@GetMapping("/stockcalculation")
	public void stockcalculation(Model model, Criteria cri) {
		log.info("get 재고산출 요청 controller");
		log.info(cri);
		if (cri.getStartDate() == null || cri.getStartDate().isEmpty()) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			cri.setStartDate(format.format(new Date())+"");
		}
		model.addAttribute("scList", scService.getStockCalculationList(cri));
	}
	
	
	//재고금액현황관리리포트
	@GetMapping("/report")
	public void report() {
		log.info("get 재고금액현황관리리포트 controller");
		
	}
	

}
