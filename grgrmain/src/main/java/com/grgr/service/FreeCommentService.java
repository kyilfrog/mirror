package com.grgr.service;

import java.util.Map;

import com.grgr.dto.FreeComment;
import com.grgr.exception.CommentBlindException;
import com.grgr.exception.CommentInsertException;
import com.grgr.exception.CommentModifyException;
import com.grgr.exception.CommentRemoveException;

public interface FreeCommentService {
	
	//�Խñ� �� ��ü ��ۼ�(����¡) 
	public void getFreeCommentCount(int freeBno) ;
	//��� ���(����Ʈ)
	public Map<String, Object> getFreeCommentList(int freeBno, int pageNum) ;
	
	//��� �Է�
	public void addFreeComment(FreeComment freeComment) throws CommentInsertException;
	
	//��� ����
	public void modifyFreeComment(FreeComment freeComment) throws CommentModifyException;
	
	//��� ����
	public void removeFreeComment(int freeCommentNo, int uno) throws CommentRemoveException;
	
	//��� ����(������)
	public void hideFreeComment(int uno, int freeCommentNo, int userStatus) throws CommentBlindException;
	
	//�Ű�� ����
	public int freeCommentReportNo(int freeBno);
}