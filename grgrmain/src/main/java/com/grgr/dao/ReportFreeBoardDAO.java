package com.grgr.dao;

import java.util.Map;

import com.grgr.dto.ReportFreeBoard;

public interface ReportFreeBoardDAO {
	//신고 게시글 삽입
	int insertReportFreeBoard(Map<String, Object> map);
	//신고 게시글 카운트
	int increaseFreeBoardReportCnt(int freeBno);
	//신고게시글 조회
	ReportFreeBoard selectReportFreeBoard(int reportFreeBoardNo);
	//게시글 신고 중복여부 체크
	int checkDuplicateReport(Map<String, Object> map);
	
}
