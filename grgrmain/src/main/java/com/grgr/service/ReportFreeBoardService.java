package com.grgr.service;

import java.util.Map;

import com.grgr.dto.ReportFreeBoard;
import com.grgr.exception.WriteNullException;

public interface ReportFreeBoardService {
	String addReportFreeBoard(int freeBno, ReportFreeBoard reportFreeBoard) throws WriteNullException;//신고게시글 삽입
	int riseFreeBoardReportCnt(int freeBno);//신고게시글 카운트
	ReportFreeBoard getReportFreeBoard(int reportFreeBoardNo);//신고게시글 조회
	int duplicateReport(Map<String, Object> map);//신고 중복 여부
	
}
