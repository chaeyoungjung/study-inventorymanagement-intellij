package com.overc1ock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class InOutBoundVO {
	Integer inOutBoundAmount;
	Date inOutBoundDate;

}
