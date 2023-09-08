package com.grgr.service;

import java.util.Map;

import com.grgr.dto.QnaComment;
import com.grgr.exception.CommentBlindException;
import com.grgr.exception.CommentInsertException;
import com.grgr.exception.CommentModifyException;
import com.grgr.exception.CommentRemoveException;

public interface QnaCommentService {
	//게시글 내 전체 댓글수(페이징) 
	public void getQnaCommentCount(int qnaBno);
	
	//댓글 출력(리스트)
	public Map<String, Object> getQnaCommentList(int qnaBno, int pageNum);
	
	//댓글 입력
	public void addQnaComment(QnaComment qnaComment) throws CommentInsertException;
	
	//댓글 수정
	public void modifyQnaComment(QnaComment qnaComment) throws CommentModifyException;
	
	//댓글 삭제
	public void removeQnaComment(int qnaCommentNo, int uno) throws CommentRemoveException;
	
	//댓글 숨김(관리자)
	public void hideQnaComment(int uno, int qnaCommentNo, int userStatus) throws CommentBlindException;
	
}
