package com.grgr.service;

import java.util.Map;

import com.grgr.dto.InfoComment;
import com.grgr.exception.CommentBlindException;
import com.grgr.exception.CommentInsertException;
import com.grgr.exception.CommentModifyException;
import com.grgr.exception.CommentRemoveException;

public interface InfoCommentService {
	
	//게시글 내 전체 댓글수(페이징) 
	public void getInfoCommentCount(int infoBno);
	//댓글 출력(리스트)
	public Map<String, Object> getInfoCommentList(int infoBno, int pageNum);
	
	//댓글 입력
	public void addInfoComment(InfoComment infoComment) throws CommentInsertException;
	
	//댓글 수정
	public void modifyInfoComment(InfoComment infoComment) throws CommentModifyException;
	
	//댓글 삭제
	public void removeInfoComment(int infoCommentNo, int uno) throws CommentRemoveException;
	
	//댓글 숨김(관리자)
	public void hideInfoComment(int uno, int infoCommentNo, int userStatus) throws CommentBlindException;
	
	//신고수 증가
	public int infoCommentReportNo(int infoBno);
}
