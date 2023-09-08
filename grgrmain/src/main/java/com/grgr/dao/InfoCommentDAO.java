package com.grgr.dao;

import java.util.List;
import java.util.Map;

import com.grgr.dto.InfoComment;

public interface InfoCommentDAO {
	int infoCommentCount(int infoBno);
	List<InfoComment> selectInfoCommentList(Map<String, Object> map);
	int insertInfoComment(InfoComment infoComment);
	int updateInfoComment(InfoComment infoComment);
	int deleteInfoComment(Map<String, Object> map); // infoBno, uno(세션) 필요
	int blindInfoComment(Map<String, Object> map); //uno(세션), infoBno 필요
	int increaseInfoCommentReportNo(int infoBno);

}
