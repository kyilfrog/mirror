package com.grgr.mapper;

import java.util.List;
import java.util.Map;

import com.grgr.dto.ReportQnaBoard;

public interface ReportQnaBoardMapper {
	int insertReportQnaBoard(Map<String, Object> map);
	int increaseReportQnaBoard(int reportQnaBoardNo);
	int deleteReportQnaBoard(Map<String, Object> map);
	ReportQnaBoard selectReportQnaBoard(int reportQnaBoardNo);
	Integer selectPrevReportQnaBoard(Map<String, Object> map);
	Integer selectNextReportQnaBoard(Map<String, Object> map);
	List<ReportQnaBoard> selectReportQnaBoardList(Map<String, Object> map);
}
