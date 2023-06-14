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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.ExistingStockVO;
import com.overc1ock.domain.InBoundVO;
import com.overc1ock.domain.OutBoundVO;
import com.overc1ock.domain.ProcurementPlanVO;
import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.domain.RequestTransactionStatementDTO;
import com.overc1ock.domain.TransactionInfoVO;
import com.overc1ock.domain.TransactionStatementVO;
import com.overc1ock.service.InboundService;
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
	
	//입고처리(마감)
	@GetMapping("/inboundmain")
	public void inboundmain(Model model,Criteria cri) {
		log.info("get 입고처리(마감) 메인페이지 controller");
		model.addAttribute("poList", ibService.getPurchaseOrderListAtInbound(cri));
	}
	
	@GetMapping("/inboundwork")
	public void inboundwork(Model model, Integer po_code) {
		log.info("get 입고처리(마감) 입고처리페이지 controller");
		List<ProcurementPlanVO> list=ibService.getOrderItemList(po_code);
		model.addAttribute("supplier", list.get(0).getSupplier());
		model.addAttribute("oiList", list);
		model.addAttribute("ppList", ibService.getProcurementPlanList(po_code));
		model.addAttribute("po_code", po_code);
	}
	
	@PostMapping("/insertinbound")
	public String insertinbound(InBoundVO inBoundVO) {
		
		log.info("post 입고처리(마감) 입고등록 요청 controller");
		log.info(inBoundVO.getInBoundVOList());
		for (InBoundVO vo : inBoundVO.getInBoundVOList()) {
			if (vo.getAmount() != null && vo.getDate() != null) {
				log.info(vo);
				ibService.insertInbound(vo);
			}
		}
		List<InBoundVO> list = inBoundVO.getInBoundVOList();
		
		return "redirect:/stockmanagement/inboundwork?po_code="+list.get(0).getPo_code();
		
		
	}
	
	//거래명세서 발행
	@GetMapping("/transactionstatementmain")
	public void transactionstatementmain(Model model, Criteria cri) {
		log.info("get 거래명세서 메인페이지 요청 controller");
		model.addAttribute("poList", tsService.getPurchaseOrderListAtTransactionStatement(cri));
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
	public String inputtransactionstatement(RequestTransactionStatementDTO dto) {
		log.info("post 거래명세서 등록요청 controller");
		log.info(dto);
		tsService.insertTransactionStatement(dto);
		return "redirect:/stockmanagement/transactionstatement?po_code="+dto.getPo_code();
	}
	
	@PostMapping("/deletetransactionstatement")
	public String transactionstatement(Integer po_code) {
		log.info("post 거래명세서 삭제요청 controller");
		tsService.deleteTransactionStatement(po_code);
		return "redirect:/stockmanagement/transactionstatementmain";
	}
	
	//출고처리
	@GetMapping("/outbound")
	public void outbound(Model model,Criteria cri) {
		log.info("get 출고처리 요청 controller");
//		model.addAttribute("obList", observice.getOutboundList());
		log.info(cri);
		model.addAttribute("obList", obService.getOutboundListWithCriteria(cri));
		model.addAttribute("pnList", obService.getProductNameList());
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
		model.addAttribute("icList", scService.getItemCodeList());
	}
	
	@PostMapping("/stockcalculation")
	public String inputStock(ExistingStockVO vo, RedirectAttributes rttr) {
		log.info("get 재고산출 기존재고등록 요청 controller");
		scService.insertExistingStock(vo);
		rttr.addFlashAttribute("svo", vo);
		return "redirect:/stockmanagement/stockcalculation";
	}
	
	//재고금액현황관리리포트
	@GetMapping("/report")
	public void report() {
		log.info("get 재고금액현황관리리포트 controller");
		
	}
	

}
