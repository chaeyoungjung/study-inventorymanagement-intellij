package com.overc1ock.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ExistingStockVO {
	private Integer item_code;
	private Integer amount;

}
