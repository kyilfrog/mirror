package com.grgr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grgr.dto.ReportFreeBoard;
import com.grgr.service.ReportFreeBoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
@Slf4j
public class ReportFreeBoardController {
	@Autowired
	private ReportFreeBoardService reportFreeBoardService;

	@PostMapping("/board-add/{freeBno}")
	public ResponseEntity<String> addReportFreeBoard(@PathVariable int freeBno,
			@RequestBody ReportFreeBoard reportFreeBoard, HttpSession session) {
		log.info("ReportFreeBoardController 클래스의 addReportFreeBoard 메서드");

		// 조회수 증가 처리
		reportFreeBoardService.riseFreeBoardReportCnt(freeBno);

		Integer loginUno = (Integer) session.getAttribute("loginUno");

		//로그인 사용자가 아닌 경우
		if (loginUno == null) {
			return new ResponseEntity<>("unauthorized_error", HttpStatus.UNAUTHORIZED);
		}

		reportFreeBoard.setUno(loginUno);

		String result = reportFreeBoardService.addReportFreeBoard(freeBno, reportFreeBoard);

		//신고 중복 확인 
		if ("duplicate".equals(result)) {
			return new ResponseEntity<>("duplicate", HttpStatus.OK);
		}

		return new ResponseEntity<>("success", HttpStatus.OK);
	}
}