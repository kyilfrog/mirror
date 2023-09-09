package com.grgr.dao;

import java.util.List;
import java.util.Map;

import com.grgr.dto.ReportQnaBoard;

public interface ReportQnaBoardDAO {
	int insertReportQnaBoard(Map<String, Object> map);//신고게시글 삽입
	int reportQnaBoardCount(Map<String, Object> map);//총 신고게시글 수
	int increaseReportQnaBoard(int reportQnaBoardNo);//신고게시글 카운트
	int deleteReportQnaBoard(Map<String, Object> map);//신고게시글 삭제
	ReportQnaBoard selectReportQnaBoard(int reportQnaBoardNo);//신고게시글 조회
	Integer selectPrevReportQnaBoard(Map<String, Object> map);//이전페이지
	Integer selectNextReportQnaBoard(Map<String, Object> map);//다음페이지
	List<ReportQnaBoard> selectReportQnaBoardList(Map<String, Object> map);//신고게시글 리스트
}
