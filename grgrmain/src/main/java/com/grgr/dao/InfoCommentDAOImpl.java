package com.grgr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.grgr.dto.InfoComment;
import com.grgr.mapper.InfoCommentMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class InfoCommentDAOImpl implements InfoCommentDAO{
	private final SqlSession sqlSession;

	@Override
	public int infoCommentCount(int infoBno) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(InfoCommentMapper.class).infoCommentCount(infoBno);
	}

	@Override
	public List<InfoComment> selectInfoCommentList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(InfoCommentMapper.class).selectInfoCommentList(map);
	}

	@Override
	public int insertInfoComment(InfoComment infoComment) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(InfoCommentMapper.class).insertInfoComment(infoComment);
	}

	@Override
	public int updateInfoComment(InfoComment infoComment) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(InfoCommentMapper.class).updateInfoComment(infoComment);
	}

	@Override
	public int deleteInfoComment(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(InfoCommentMapper.class).deleteInfoComment(map);
	}

	@Override
	public int blindInfoComment(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(InfoCommentMapper.class).blindInfoComment(map);
	}

	@Override
	public int increaseInfoCommentReportNo(int infoBno) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(InfoCommentMapper.class).increaseInfoCommentReportNo(infoBno);
	}

}
