package com.grgr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.grgr.dao.QnaCommentDAO;
import com.grgr.dto.QnaComment;
import com.grgr.exception.CommentBlindException;
import com.grgr.exception.CommentInsertException;
import com.grgr.exception.CommentModifyException;
import com.grgr.exception.CommentRemoveException;
import com.grgr.util.CommentPager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnaCommentServiceImpl implements QnaCommentService {
	private final QnaCommentDAO qnaCommentDAO;

	@Override
	public void getQnaCommentCount(int qnaBno) {
		qnaCommentDAO.qnaCommentCount(qnaBno);
	}

	@Override
	public Map<String, Object> getQnaCommentList(int qnaBno, int pageNum) {
		int totalComment = qnaCommentDAO.qnaCommentCount(qnaBno);
		CommentPager commentPager = new CommentPager(pageNum, totalComment);
		Map<String, Object> map = new HashMap<>();
		map.put("qnaBno", qnaBno);
		map.put("startRow", commentPager.getStartRow());
		map.put("endRow", commentPager.getEndRow());
		List<QnaComment> qnaCommentList = qnaCommentDAO.selectQnaCommentList(map);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("qnaCommentList", qnaCommentList);
		resultMap.put("commentPager", commentPager);
		return resultMap;
	}

	@Override
	public void addQnaComment(QnaComment qnaComment) throws CommentInsertException {
		int result = qnaCommentDAO.insertQnaComment(qnaComment);
		if(result != 1) {
			throw new CommentInsertException("댓글 등록에 실패하였습니다.");
		}
	}

	@Override
	public void modifyQnaComment(QnaComment qnaComment) throws CommentModifyException {
		int result = qnaCommentDAO.updateQnaComment(qnaComment);
		if(result != 1) {
			throw new CommentModifyException("댓글 수정에 실패하였습니다.");
		}
	}

	@Override
	public void removeQnaComment(int qnaCommentNo, int loginUno) throws CommentRemoveException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qnaCommentNo", qnaCommentNo);
		map.put("uno", loginUno);
		int result = qnaCommentDAO.deleteQnaComment(map);
		if(result != 1) {
			throw new CommentRemoveException("댓글 삭제에 실패하였습니다.");
		}
	}

	@Override
	public void hideQnaComment(int uno, int qnaCommentNo, int userStatus) throws CommentBlindException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qnaCommentNo", qnaCommentNo);
		map.put("uno", uno);
		map.put("userStatus", userStatus);
		int result = qnaCommentDAO.blindQnaComment(map);
		if(result!=1) {
			throw new CommentBlindException("댓글 숨김에 실패하셨습니다.");
		}
	}
	
	/*
	@Override
	public int qnaCommentReportNo(int qnaBno) {
		// TODO Auto-generated method stub
		return qnaCommentDAO.increaseqnaCommentReportNo(qnaBno);
	}
	*/


}