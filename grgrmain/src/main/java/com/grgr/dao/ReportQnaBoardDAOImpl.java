package com.grgr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.grgr.dto.ReportQnaBoard;
import com.grgr.mapper.ReportQnaBoardMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReportQnaBoardDAOImpl implements ReportQnaBoardDAO {
	private final SqlSession sqlSession;
	
	@Override
	public int insertReportQnaBoard(Map<String, Object> map) {
		return sqlSession.getMapper(ReportQnaBoardMapper.class).insertReportQnaBoard(map);
	}
	
	@Override
	public int reportQnaBoardCount(Map<String, Object> map) {
		return sqlSession.getMapper(ReportQnaBoardMapper.class).reportQnaBoardCount(map);
	}
	@Override
	public int increaseReportQnaBoard(int reportQnaBoardNo) {
		return sqlSession.getMapper(ReportQnaBoardMapper.class).increaseReportQnaBoard(reportQnaBoardNo);
	}

	@Override
	public int deleteReportQnaBoard(Map<String, Object> map) {
		return sqlSession.getMapper(ReportQnaBoardMapper.class).deleteReportQnaBoard(map);
	}

	@Override
	public ReportQnaBoard selectReportQnaBoard(int reportQnaBoardNo) {
		return sqlSession.getMapper(ReportQnaBoardMapper.class).selectReportQnaBoard(reportQnaBoardNo);
	}

	@Override
	public Integer selectPrevReportQnaBoard(Map<String, Object> map) {
		return sqlSession.getMapper(ReportQnaBoardMapper.class).selectPrevReportQnaBoard(map);
	}

	@Override
	public Integer selectNextReportQnaBoard(Map<String, Object> map) {
		return sqlSession.getMapper(ReportQnaBoardMapper.class).selectNextReportQnaBoard(map);
	}

	@Override
	public List<ReportQnaBoard> selectReportQnaBoardList(Map<String, Object> map) {
		return sqlSession.getMapper(ReportQnaBoardMapper.class).selectReportQnaBoardList(map);
	}
}
