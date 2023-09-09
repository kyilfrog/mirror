package com.grgr.service;

import java.util.Map;

import com.grgr.dto.ReportQnaBoard;
import com.grgr.exception.WriteNullException;
import com.grgr.util.SearchCondition;

public interface ReportQnaBoardService {
	int addReportQnaBoard(SearchCondition searchCondition);//신고게시글 삽입
	int getQnaBoardCount(ReportQnaBoard reportQnaBoard) throws WriteNullException;//총 신고게시글 수
	int riseReportQnaBoard(int reportQnaBoardNo);//신고게시글 카운트
	int removeReportQnaBoard(Map<String, Object> map);//신고게시글 삭제
	ReportQnaBoard selectReportQnaBoard(int reportQnaBoardNo);//신고게시글 조회
	Integer prevReportQnaBoard(SearchCondition searchCondition, int reportQnaBoard);//이전페이지
	Integer nextReportQnaBoard(SearchCondition searchCondition, int reportQnaBoard);//다음페이지
	Map<String, Object> getReportQnaBoardList(SearchCondition searchCondition);//신고게시글 리스트
}
