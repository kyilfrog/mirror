package com.grgr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.grgr.dao.InfoCommentDAO;
import com.grgr.dto.InfoComment;
import com.grgr.exception.CommentBlindException;
import com.grgr.exception.CommentInsertException;
import com.grgr.exception.CommentModifyException;
import com.grgr.exception.CommentRemoveException;
import com.grgr.util.CommentPager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InfoCommentServiceImpl implements InfoCommentService {
	private final InfoCommentDAO infoCommentDAO;

	@Override
	public void getInfoCommentCount(int infoBno) {
		// TODO Auto-generated method stub
		infoCommentDAO.infoCommentCount(infoBno);
	}

	@Override
	public Map<String, Object> getInfoCommentList(int infoBno, int pageNum){
		int totalComment = infoCommentDAO.infoCommentCount(infoBno);
		CommentPager commentPager = new CommentPager(pageNum, totalComment);
		Map<String, Object> map = new HashMap<>();
		map.put("infoBno", infoBno);
		map.put("startRow", commentPager.getStartRow());
		map.put("endRow", commentPager.getEndRow());
		List<InfoComment> infoCommentList = infoCommentDAO.selectInfoCommentList(map);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("infoCommentList", infoCommentList);
		resultMap.put("commentPager", commentPager);
		return resultMap;
	}

	@Override
	public void addInfoComment(InfoComment infoComment) throws CommentInsertException {
		// TODO Auto-generated method stub
		int result = infoCommentDAO.insertInfoComment(infoComment);
		if(result != 1) {
			throw new CommentInsertException("댓글 등록에 실패하였습니다.");
		}
	}

	@Override
	public void modifyInfoComment(InfoComment infoComment) throws CommentModifyException {
		// TODO Auto-generated method stub
		int result = infoCommentDAO.updateInfoComment(infoComment);
		if(result != 1) {
			throw new CommentModifyException("댓글 수정에 실패하였습니다.");
		}
	}

	@Override
	public void removeInfoComment(int infoCommentNo, int loginUno) throws CommentRemoveException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("infoCommentNo", infoCommentNo);
		map.put("uno", loginUno);
		int result = infoCommentDAO.deleteInfoComment(map);
		if(result != 1) {
			throw new CommentRemoveException("댓글 삭제에 실패하였습니다.");
		}
	}

	@Override
	public void hideInfoComment(int uno, int infoCommentNo, int userStatus) throws CommentBlindException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("infoCommentNo", infoCommentNo);
		map.put("uno", uno);
		map.put("userStatus", userStatus);
		int result = infoCommentDAO.blindInfoComment(map);
		if(result!=1) {
			throw new CommentBlindException("댓글 숨김에 실패하셨습니다.");
		}
		
	}

	@Override
	public int infoCommentReportNo(int infoBno) {
		// TODO Auto-generated method stub
		return infoCommentDAO.increaseInfoCommentReportNo(infoBno);
	}


}
