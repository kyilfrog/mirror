package com.grgr.dao;

import java.util.List;
import java.util.Map;

import com.grgr.dto.FreeComment;

public interface FreeCommentDAO {
	int freeCommentCount(int freeBno);
	List<FreeComment> selectFreeCommentList(Map<String, Object> map);
	int insertFreeComment(FreeComment freeComment);
	int updateFreeComment(FreeComment freeComment);
	int deleteFreeComment(Map<String, Object> map); // infoBno, uno(技记) 鞘夸
	int blindFreeComment(Map<String, Object> map); //uno(技记), infoBno 鞘夸
	int increaseFreeCommentReportNo(int freeBno);
}
