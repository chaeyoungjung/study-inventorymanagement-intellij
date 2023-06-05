package com.overc1ock.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class OutBoundVO extends ProductionPlanVO{
	private Integer amount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") //input date 를 받을때 패턴 지정해줘야 400에러 안남
	private Date date;
	private ArrayList<OutBoundVO> outBoundVOList;
	
	@Override
	public String toString() {
		return "OutBoundVO [amount=" + amount + ", date=" + date + ", outBoundVOList=" + outBoundVOList + ", item_code="
				+ item_code + ", iup_code=" + iup_code + "]";
	}
	
	

}
