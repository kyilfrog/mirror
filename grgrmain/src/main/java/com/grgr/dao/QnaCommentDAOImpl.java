package com.grgr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.grgr.dto.QnaComment;
import com.grgr.mapper.QnaCommentMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QnaCommentDAOImpl implements QnaCommentDAO{
	private final SqlSession sqlSession;

	@Override
	public int qnaCommentCount(int qnaBno) {
		return sqlSession.getMapper(QnaCommentMapper.class).qnaCommentCount(qnaBno);
	}

	@Override
	public List<QnaComment> selectQnaCommentList(Map<String, Object> map) {
		return sqlSession.getMapper(QnaCommentMapper.class).selectQnaCommentList(map);
	}

	@Override
	public int insertQnaComment(QnaComment qnaComment) {
		return sqlSession.getMapper(QnaCommentMapper.class).insertQnaComment(qnaComment);
	}

	@Override
	public int updateQnaComment(QnaComment qnaComment) {
		return sqlSession.getMapper(QnaCommentMapper.class).updateQnaComment(qnaComment);
	}

	@Override
	public int deleteQnaComment(Map<String, Object> map) {
		return sqlSession.getMapper(QnaCommentMapper.class).deleteQnaComment(map);
	}

	@Override
	public int blindQnaComment(Map<String, Object> map) {
		return sqlSession.getMapper(QnaCommentMapper.class).blindQnaComment(map);
	}
}