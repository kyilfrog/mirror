package com.grgr.mapper;

import java.util.Map;

import com.grgr.dto.ReportFreeBoard;

public interface ReportFreeBoardMapper {
	int insertReportFreeBoard(Map<String, Object> map);
	int increaseFreeBoardReportCnt(int freeBno);
	ReportFreeBoard selectReportFreeBoard(int reportFreeBoardNo);
	int checkDuplicateReport(Map<String, Object> map);
}
