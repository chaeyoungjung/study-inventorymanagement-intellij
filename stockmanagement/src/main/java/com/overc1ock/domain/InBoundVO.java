package com.overc1ock.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class InBoundVO {
	private Integer item_code;
	private Integer amount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") //input date 를 받을때 패턴 지정해줘야 400에러 안남
	private Date date;
	private Integer po_code;
	private ArrayList<InBoundVO> inBoundVOList;
	
	

}
