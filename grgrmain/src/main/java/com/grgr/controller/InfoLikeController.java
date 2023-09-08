package com.grgr.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grgr.dao.infoLikeDAOImpl;
import com.grgr.service.InfoLikeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/infolike")
@RequiredArgsConstructor
@Slf4j
public class InfoLikeController {
	private final InfoLikeService infoLikeService;
	
	// 현재 좋아요 상태 반환
	@GetMapping("/status/{infoBno}")
	public ResponseEntity<Map<String, Object>> getLikeStatus(@PathVariable int infoBno, HttpSession session){
		
		Integer loginUno = (Integer)session.getAttribute("loginUno");
		if(loginUno == null) {
			return new ResponseEntity<Map<String, Object>> (HttpStatus.UNAUTHORIZED);
		}
		Map<String, Object> data = infoLikeService.getMyLikeStatus(infoBno, loginUno);
		
		return new ResponseEntity<Map<String, Object>>(data, HttpStatus.OK);
	}
	
	// 좋아요 상태 전환 (좋아요 O->X / X->O)
	@PostMapping("/toggle/{infoBno}")
	public ResponseEntity<Map<String, Object>> toggleLike(@PathVariable int infoBno, HttpSession session){
		Integer loginUno = (Integer)session.getAttribute("loginUno");
		if(loginUno == null) {
			return new ResponseEntity<Map<String, Object>> (HttpStatus.UNAUTHORIZED);
		}
		//삽입or삭제 실행 후 resultMap -> isLiked 상태 + 좋아요 Cnt
		Map<String, Object> data = infoLikeService.likeToggle(infoBno, loginUno);
		return new ResponseEntity<Map<String, Object>> (data, HttpStatus.OK);
		
	}
	
	
}
