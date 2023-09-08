package com.grgr.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.grgr.mapper.InfoLikeMapper;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class infoLikeDAOImpl implements InfoLikeDAO{
	private final SqlSession session;
	@Override
	public int insertMyInfoLike(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.getMapper(InfoLikeMapper.class).insertMyInfoLike(map);
	}

	@Override
	public int deleteMyInfoLike(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.getMapper(InfoLikeMapper.class).deleteMyInfoLike(map);
	}

	@Override
	public int getMyLikeStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.getMapper(InfoLikeMapper.class).getMyLikeStatus(map);
	}

	@Override
	public int InfoLikeCnt(int infoBno) {
		// TODO Auto-generated method stub
		return session.getMapper(InfoLikeMapper.class).InfoLikeCnt(infoBno);
	}
	
}
