package com.grgr.mapper;

import java.util.List;
import java.util.Map;

import com.grgr.dto.QnaComment;

public interface QnaCommentMapper {
	int qnaCommentCount(int qnaBno);
	List<QnaComment> selectQnaCommentList(Map<String, Object> map);
	int insertQnaComment(QnaComment qnaComment);
	int updateQnaComment(QnaComment qnaComment);
	int deleteQnaComment(Map<String, Object> map); // qnaBno, uno(세션) 필요
	int blindQnaComment(Map<String, Object> map); //uno(세션), qnaBno 필요
}
