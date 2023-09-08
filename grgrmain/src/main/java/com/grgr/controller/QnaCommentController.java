package com.grgr.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.grgr.dto.QnaComment;
import com.grgr.exception.CommentBlindException;
import com.grgr.exception.CommentInsertException;
import com.grgr.exception.CommentModifyException;
import com.grgr.exception.CommentRemoveException;
import com.grgr.service.QnaCommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/qnacomment")
@RequiredArgsConstructor
@Slf4j
public class QnaCommentController {
	private final QnaCommentService qnaCommentService;
	
	//댓글 조회 (GET 사용)
	@GetMapping("/list/{qnaBno}")
	public Map<String, Object> commentList(
	    @PathVariable int qnaBno,
	    @RequestParam(defaultValue = "1") int pageNum,
	    HttpSession session
	)  {
		log.info("QnaCommentController() 클래스의 commentList() 메소드 호출");
	    
	    Integer loginUno = (Integer) session.getAttribute("loginUno");
		Integer loginUserStatus = (Integer)session.getAttribute("loginUserStatus"); 

	    
	    Map<String, Object> resultMap = qnaCommentService.getQnaCommentList(qnaBno, pageNum);
	    resultMap.put("loginUno", loginUno); // 로그인한 사용자의 uno 값을 결과 맵에 포함
	    resultMap.put("loginUserStatus", loginUserStatus);
	    
	    return resultMap;
	}
	
	//댓글 삽입(POST 사용)
	@PostMapping("/write/{qnaBno}")
	public ResponseEntity<String> qnaCommentAdd(@RequestBody QnaComment qnaComment, @PathVariable int qnaBno, HttpSession session) throws CommentInsertException {
		log.info("QnaCommentController() 클래스의 qnaCommentAdd() 메소드 호출");
		Integer loginUno = (Integer)session.getAttribute("loginUno"); 
		qnaComment.setUno(loginUno);
		qnaComment.setQnaBno(qnaBno);
		qnaCommentService.addQnaComment(qnaComment);
		
		return new ResponseEntity<String>("WRT_OK",HttpStatus.OK);
	}

	//댓글 수정(PUT 사용)
	@PatchMapping("/modify/{qnaCommentNo}")
	public ResponseEntity<String> qnaCommentModify(@PathVariable int qnaCommentNo, @RequestBody QnaComment qnaComment, HttpSession session) 
			throws CommentModifyException  {
		log.info("QnaCommentController() 클래스의 qnaCommentModify() 메소드 호출");
		Integer loginUno = (Integer)session.getAttribute("loginUno"); 
		qnaComment.setUno(loginUno);
		qnaComment.setQnaCommentContent(HtmlUtils.htmlEscape(qnaComment.getQnaCommentContent()));
		qnaCommentService.modifyQnaComment(qnaComment);
		
		return new ResponseEntity<String>("MOD_OK",HttpStatus.OK);
	}
	
	//댓글 삭제(본인)
	@PutMapping("/remove/{qnaCommentNo}")
	public ResponseEntity<String> qnaCommentRemove(@PathVariable int qnaCommentNo, HttpSession session ) throws CommentRemoveException {
		Integer loginUno = (Integer)session.getAttribute("loginUno"); 
		log.info("QnaCommentController() 클래스의 qnaCommentRemove() 메소드 호출");
		qnaCommentService.removeQnaComment(qnaCommentNo, loginUno);
		
		return new ResponseEntity<String>("DEL_OK",HttpStatus.OK);
		
	}
	
	//댓글 숨김
	@PutMapping("/hide/{qnaCommentNo}")
	public ResponseEntity<String> qnaCommentBlind(@PathVariable int qnaCommentNo, HttpSession session ) throws CommentBlindException {
		log.info("QnaCommentController() 클래스의 qnaCommentBlind() 메소드 호출");
		Integer loginUno = (Integer)session.getAttribute("loginUno"); 
		Integer loginUserStatus = (Integer)session.getAttribute("loginUserStatus"); 
		qnaCommentService.hideQnaComment(loginUno,qnaCommentNo, loginUserStatus);
		
		return new ResponseEntity<String>("DEL_OK",HttpStatus.OK);
	}
	
}