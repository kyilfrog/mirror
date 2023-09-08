package com.grgr.dao;

import java.util.Map;

public interface InfoLikeDAO {
	int insertMyInfoLike(Map<String, Object> map);
	int deleteMyInfoLike(Map<String, Object> map);
	int getMyLikeStatus(Map<String, Object> map);
	int InfoLikeCnt(int infoBno);
}
