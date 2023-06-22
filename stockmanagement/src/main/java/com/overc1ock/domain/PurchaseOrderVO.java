package com.overc1ock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PurchaseOrderVO {
	private Integer po_code;
	private String item_code;
	private String item_name;
	private String supplier;
	private Date po_date;
	private Integer save;

}
