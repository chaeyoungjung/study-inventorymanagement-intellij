package com.overc1ock.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.stereotype.Service;

import com.overc1ock.domain.ChartReportVO;
import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.ReportVO;
import com.overc1ock.mapper.StockManagementMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class ReportServiceImpl implements ReportService {
	
	StockManagementMapper mapper;

	@Override
	public ChartReportVO chartDate(Criteria cri) {
		log.info("날짜별 재고금액리포트 서비스");
		
		List<ReportVO> list = mapper.chartDate(cri);
		log.info(list);
		
		ChartReportVO vo = new ChartReportVO();
		String[] labelsarr = new String[list.size()];
		Integer[] valuesarr = new Integer[list.size()];
		
		int i = 0;
		
		for (ReportVO rvo : list) {
			labelsarr[i] = rvo.getMylabel();
			valuesarr[i] = rvo.getMyvalue();
			log.info("i값 : "+i);
			log.info("결과확인 라벨 :  "+labelsarr[i]+" 결과확인 값 : "+valuesarr[i]);
			i++;
		}
		vo.setLabelsarr(labelsarr);
		vo.setValuesarr(valuesarr);	
		
		return vo;
	}

	@Override
	public ChartReportVO chartItemCode(Criteria cri) {
		log.info("품목별 재고금액리포트 서비스 **품목코드 기준");
		
		List<ReportVO> list = mapper.chartItemCode(cri);
		log.info(list);
		
		ChartReportVO vo = new ChartReportVO();
		String[] labelsarr = new String[list.size()];
		Integer[] valuesarr = new Integer[list.size()];
		
		int i = 0;
		
		for (ReportVO rvo : list) {
			labelsarr[i] = rvo.getMylabel();
			valuesarr[i] = rvo.getMyvalue();
			log.info("i값 : "+i);
			log.info("결과확인 라벨 :  "+labelsarr[i]+" 결과확인 값 : "+valuesarr[i]);
			i++;
		}
		vo.setLabelsarr(labelsarr);
		vo.setValuesarr(valuesarr);	
		
		return vo;
	}

	@Override
	public ChartReportVO chartItemCategory(Criteria cri) {
		log.info("품목별 재고금액리포트 서비스 **품목군기준");
		
		List<ReportVO> list = mapper.chartItemCategory(cri);
		log.info(list);
		
		ChartReportVO vo = new ChartReportVO();
		String[] labelsarr = new String[list.size()];
		Integer[] valuesarr = new Integer[list.size()];
		
		int i = 0;
		
		for (ReportVO rvo : list) {
			labelsarr[i] = rvo.getMylabel();
			valuesarr[i] = rvo.getMyvalue();
			log.info("i값 : "+i);
			log.info("결과확인 라벨 :  "+labelsarr[i]+" 결과확인 값 : "+valuesarr[i]);
			i++;
		}
		vo.setLabelsarr(labelsarr);
		vo.setValuesarr(valuesarr);	
		
		return vo;
	}
	
	

}
