package com.grgr.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.grgr.dto.ReportFreeBoard;
import com.grgr.mapper.ReportFreeBoardMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReportFreeBoardDAOImpl implements ReportFreeBoardDAO {
	private final SqlSession sqlSession;

	@Override
	public int insertReportFreeBoard(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ReportFreeBoardMapper.class).insertReportFreeBoard(map);
	}

	@Override
	public int increaseFreeBoardReportCnt(int freeBno) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ReportFreeBoardMapper.class).increaseFreeBoardReportCnt(freeBno);
	}

	@Override
	public ReportFreeBoard selectReportFreeBoard(int reportFreeBoardNo) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ReportFreeBoardMapper.class).selectReportFreeBoard(reportFreeBoardNo);
	}

	@Override
	public int checkDuplicateReport(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ReportFreeBoardMapper.class).checkDuplicateReport(map);
	}
}
