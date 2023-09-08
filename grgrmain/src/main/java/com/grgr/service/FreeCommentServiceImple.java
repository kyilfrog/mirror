package com.grgr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.grgr.dao.FreeCommentDAO;
import com.grgr.dto.FreeComment;
import com.grgr.exception.CommentBlindException;
import com.grgr.exception.CommentInsertException;
import com.grgr.exception.CommentModifyException;
import com.grgr.exception.CommentRemoveException;
import com.grgr.util.CommentPager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FreeCommentServiceImple implements FreeCommentService {
	private final FreeCommentDAO freeCommentDAO;

	@Override
	public void getFreeCommentCount(int freeBno) {
		freeCommentDAO.freeCommentCount(freeBno);
	}

	@Override
	public Map<String, Object> getFreeCommentList(int freeBno, int pageNum) {
		int totalComment = freeCommentDAO.freeCommentCount(freeBno);
		CommentPager commentPager = new CommentPager(pageNum, totalComment);
		Map<String, Object> map = new HashMap<>();
		map.put("freeBno", freeBno);
		map.put("startRow", commentPager.getStartRow());
		map.put("endRow", commentPager.getEndRow());
		List<FreeComment> freeCommentList = freeCommentDAO.selectFreeCommentList(map);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("freeCommentList", freeCommentList);
		resultMap.put("commentPager", commentPager);
		return resultMap;
	}

	@Override
	public void addFreeComment(FreeComment freeComment) throws CommentInsertException {
		// TODO Auto-generated method stub
		int result = freeCommentDAO.insertFreeComment(freeComment);
		if (result != 1) {
			throw new CommentInsertException("��� ��Ͽ� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public void modifyFreeComment(FreeComment freeComment) throws CommentModifyException {
		// TODO Auto-generated method stub
		int result = freeCommentDAO.updateFreeComment(freeComment);
		if (result != 1) {
			throw new CommentModifyException("��� ������ �����Ͽ����ϴ�.");
		}
	}

	@Override
	public void removeFreeComment(int freeCommentNo, int loginUno) throws CommentRemoveException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("freeCommentNo", freeCommentNo);
		map.put("uno", loginUno);
		int result = freeCommentDAO.deleteFreeComment(map);
		if (result != 1) {
			throw new CommentRemoveException("��� ������ �����Ͽ����ϴ�.");
		}
	}

	@Override
	public void hideFreeComment(int uno, int freeCommentNo, int userStatus) throws CommentBlindException {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("freeCommentNo", freeCommentNo);
		map.put("uno", uno);
		map.put("userStatus", userStatus);
		int result = freeCommentDAO.blindFreeComment(map);
		if (result != 1) {
			throw new CommentBlindException("��� ���迡 �����ϼ̽��ϴ�.");
		}
	}

	@Override
	public int freeCommentReportNo(int freeBno) {
		// TODO Auto-generated method stub
		return freeCommentDAO.increaseFreeCommentReportNo(freeBno);
	}
}
