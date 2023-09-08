package com.grgr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.grgr.dto.FreeComment;
import com.grgr.mapper.FreeCommentMapper;

import lombok.RequiredArgsConstructor;
@Repository
@RequiredArgsConstructor
public class FreeCommentDAOImpl implements FreeCommentDAO {

		private final SqlSession sqlSession;

		@Override
		public int freeCommentCount(int freeBno) {
			// TODO Auto-generated method stub
			return sqlSession.getMapper(FreeCommentMapper.class).freeCommentCount(freeBno);
		}

		@Override
		public List<FreeComment> selectFreeCommentList(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return sqlSession.getMapper(FreeCommentMapper.class).selectFreeCommentList(map);
		}

		@Override
		public int insertFreeComment(FreeComment freeComment) {
			// TODO Auto-generated method stub
			return sqlSession.getMapper(FreeCommentMapper.class).insertFreeComment(freeComment);
		}

		@Override
		public int updateFreeComment(FreeComment freeComment) {
			// TODO Auto-generated method stub
			return sqlSession.getMapper(FreeCommentMapper.class).updateFreeComment(freeComment);
		}

		@Override
		public int deleteFreeComment(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return sqlSession.getMapper(FreeCommentMapper.class).deleteFreeComment(map);
		}

		@Override
		public int blindFreeComment(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return sqlSession.getMapper(FreeCommentMapper.class).blindFreeComment(map);
		}

		@Override
		public int increaseFreeCommentReportNo(int freeBno) {
			// TODO Auto-generated method stub
			return sqlSession.getMapper(FreeCommentMapper.class).increaseFreeCommentReportNo(freeBno);
		}
}
