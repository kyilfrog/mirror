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

import com.grgr.dto.FreeComment;
import com.grgr.exception.CommentBlindException;
import com.grgr.exception.CommentInsertException;
import com.grgr.exception.CommentModifyException;
import com.grgr.exception.CommentRemoveException;
import com.grgr.service.FreeCommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/freecomment")
@RequiredArgsConstructor
public class FreeCommentController {
	private final FreeCommentService freeCommentService;
	
	
	//��� ��ȸ (GET ���)
	@GetMapping("/list/{freeBno}")
	public Map<String, Object> commentList(
	    @PathVariable int freeBno,
	    @RequestParam(defaultValue = "1") int pageNum,
	    Integer loginUno, Integer loginUserStatus /*HttpSession session*/
	)  {
	    
	    //int loginUno = (int) session.getAttribute("uno");
		//int loginUserStatus = (int)session.getAttribute("loginUserStatus"); 
	    loginUno = 2;
	    loginUserStatus=1;
	    
	    Map<String, Object> resultMap = freeCommentService.getFreeCommentList(freeBno, pageNum);
	    resultMap.put("loginUno", loginUno); // �α����� ������� uno ���� ��� �ʿ� ����
	    resultMap.put("loginUserStatus", loginUserStatus);
	    
	    return resultMap;
	}
	
	//��� ����(POST ���)
	@PostMapping("/write/{freeBno}")
	public ResponseEntity<String> freeCommentAdd(@RequestBody FreeComment freeComment, @PathVariable int freeBno, Integer loginUno, HttpSession session) throws CommentInsertException {
		//int loginUno = (int)session.getAttribute("uno"); 
		loginUno = 2; //�α��� ����� ���� �ּ����� ����
		freeComment.setUno(loginUno);
		freeComment.setFreeBno(freeBno);
		freeCommentService.addFreeComment(freeComment);
		
		return new ResponseEntity<String>("WRT_OK",HttpStatus.OK);
	}

	//��� ����(PUT ���)
	@PatchMapping("/modify/{freeCommentNo}")
	public ResponseEntity<String> freeCommentModify(@PathVariable int freeCommentNo, @RequestBody FreeComment freeComment, int uno, HttpSession session) 
			throws CommentModifyException  {
		//int uno = (int)session.getAttribute("uno"); 
		uno = 2; //�α��� ����� ���� �ּ����� ����
		freeComment.setUno(uno);
		freeComment.setFreeCommentContent(HtmlUtils.htmlEscape(freeComment.getFreeCommentContent()));
		freeCommentService.modifyFreeComment(freeComment);
		
		return new ResponseEntity<String>("MOD_OK",HttpStatus.OK);
	}
	
	//��� ����(����)
	@PutMapping("/remove/{freeCommentNo}")
	public ResponseEntity<String> freeCommentRemove(@PathVariable int freeCommentNo, Integer loginUno, HttpSession session ) throws CommentRemoveException {
		//int loginUno = (int)session.getAttribute("uno"); 
		loginUno = 2; //�α��� ����� ���� �ּ����� ����
		freeCommentService.removeFreeComment(freeCommentNo, loginUno);
		
		return new ResponseEntity<String>("DEL_OK",HttpStatus.OK);
		
	}
	
	//��� ����
	@PutMapping("/hide/{freeCommentNo}")
	public ResponseEntity<String> freeCommentBlind(@PathVariable int freeCommentNo, Integer loginUno, Integer loginUserStatus, HttpSession session ) throws CommentBlindException {
		//int loginUno = (int)session.getAttribute("loginUserStatus"); 
		//int loginUserStatus = (int)session.getAttribute("loginUserStatus"); 
		loginUno = 1;
		loginUserStatus = 1; //�α��� ����� ���� �ּ����� ����
		freeCommentService.hideFreeComment(loginUno,freeCommentNo, loginUserStatus);
		
		return new ResponseEntity<String>("DEL_OK",HttpStatus.OK);
	}
	
	//�Ű�
	
	
	
}