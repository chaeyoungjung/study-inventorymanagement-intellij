package com.overc1ock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProcurementPlanVO {
	private Integer item_code;
	private String item_name;
	private String process;
	private Date production_date;
	private Integer amount;
	private Date procurement_date;
	private Integer pp_status; //완료여부, 미완료 0, 완료 1
	private String supplier;

}
