package com.grgr.mapper;

import java.util.Map;

public interface InfoLikeMapper {
	int insertMyInfoLike(Map<String, Object> map);
	int deleteMyInfoLike(Map<String, Object> map);
	int getMyLikeStatus(Map<String, Object> map);
	int InfoLikeCnt(int infoBno);

}
