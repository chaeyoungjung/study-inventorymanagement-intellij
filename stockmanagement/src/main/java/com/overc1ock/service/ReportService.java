package com.overc1ock.service;

import com.overc1ock.domain.ChartReportVO;
import com.overc1ock.domain.Criteria;

public interface ReportService {
	ChartReportVO chartDate(Criteria cri);
}
