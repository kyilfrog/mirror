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

import com.grgr.dto.ProductComment;
import com.grgr.exception.CommentBlindException;
import com.grgr.exception.CommentInsertException;
import com.grgr.exception.CommentModifyException;
import com.grgr.exception.CommentRemoveException;
import com.grgr.service.ProductCommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/productcomment")
@RequiredArgsConstructor
@Slf4j
public class ProductCommentController {
	private final ProductCommentService productCommentService;

	// 댓글 조회
	@GetMapping("/list/{productId}")
	public Map<String, Object> commentList(@PathVariable int productId, @RequestParam(defaultValue = "1") int pageNum,
			HttpSession session) {
		Integer loginUno = (Integer) session.getAttribute("loginUno");
		Map<String, Object> resultMap = productCommentService.getProductCommentList(productId, pageNum);

		return resultMap;

	}

	// 댓글 삽입
	@PostMapping("/write/{productId}")
	public ResponseEntity<String> productCommentAdd(@RequestBody ProductComment productComment,
			@PathVariable int productId, HttpSession session) throws CommentInsertException {
		int loginUno = (int) session.getAttribute("loginUno");
		productComment.setUno(loginUno);
		productComment.setProductId(productId);
		productCommentService.addProductComment(productComment);

		return new ResponseEntity<String>("WRT_OK", HttpStatus.OK);
	}

	// 댓글 수정
	@PatchMapping("/modify/{productId}")
	public ResponseEntity<String> productCommentModify(@PathVariable int productCommentNo,
			@RequestBody ProductComment productComment, HttpSession session) throws CommentModifyException {
		int loginUno = (int) session.getAttribute("loginUno");
		productComment.setUno(loginUno);
		productComment.setProductCommentContent(HtmlUtils.htmlEscape(productComment.getProductCommentContent()));
		productCommentService.modifyProductComment(productComment);
		return new ResponseEntity<String>("MOD_OK", HttpStatus.OK);
	}

	// 댓글 삭제
	@PutMapping("/remove/{productId}")
	public ResponseEntity<String> productCommentRemove(@PathVariable int productCommentNo, HttpSession session)
			throws CommentRemoveException {
		int loginUno = (int) session.getAttribute("loginUno");
		productCommentService.removeProductComment(productCommentNo, loginUno);

		return new ResponseEntity<String>("DEL_OK", HttpStatus.OK);

	}

	// 댓글 숨김
	@PutMapping("/hide/{productId}")
	public ResponseEntity<String> productCommentHide(@PathVariable int productCommentNo, HttpSession session)
			throws CommentBlindException {
		int loginUno = (int) session.getAttribute("loginUno");
		int loginUserStatus = (int) session.getAttribute("loginUserStatus");
		log.info("hide 메서드");
		productCommentService.hideProductComment(loginUno, productCommentNo, loginUserStatus);

		return new ResponseEntity<String>("HIDE_OK", HttpStatus.OK);
	}

}
