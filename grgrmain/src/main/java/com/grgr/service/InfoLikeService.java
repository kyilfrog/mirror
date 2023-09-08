package com.grgr.service;

import java.util.Map;

public interface InfoLikeService {
	Map<String, Object> getMyLikeStatus(int infoBno, int loginUno);
	Map<String, Object> likeToggle(int infoBno, int loginUno);
	
}
