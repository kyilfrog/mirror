package com.grgr.service;

import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgr.dao.ReportFreeBoardDAO;
import com.grgr.dto.ReportFreeBoard;
import com.grgr.exception.WriteNullException;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportFreeBoardServiceImpl implements ReportFreeBoardService {
	private final ReportFreeBoardDAO reportFreeBoardDAO;

	@Transactional
	@Override
	public String addReportFreeBoard(int freeBno, ReportFreeBoard reportFreeBoard)
			throws WriteNullException {
		log.info("ReportFreeBoardServiceImpl 클래스의 addReportFreeBoard 메서드");

		Map<String, Object> duplicateMap = new HashMap<String, Object>();
		duplicateMap.put("uno", reportFreeBoard.getUno());
		duplicateMap.put("freeBno", freeBno);
		reportFreeBoardDAO.checkDuplicateReport(duplicateMap);

		int duplicateResult = duplicateReport(duplicateMap);
		if (duplicateResult == 1) {
			return "duplicate";
		}

		Map<String, Object> addMap = new HashMap<String, Object>();
		addMap.put("reportFreeBoardNo", reportFreeBoard.getReportFreeBoardNo());
		addMap.put("uno", reportFreeBoard.getUno());
		addMap.put("freeBno", freeBno);
		addMap.put("reportReason", reportFreeBoard.getReportReason());

		reportFreeBoardDAO.insertReportFreeBoard(addMap);

		return "success";
	}

	
	@Override
	public int riseFreeBoardReportCnt(int freeBno) {
		return reportFreeBoardDAO.increaseFreeBoardReportCnt(freeBno);
	}

	@Override
	public ReportFreeBoard getReportFreeBoard(int reportFreeBoardNo) {
		ReportFreeBoard reportFreeBoard = reportFreeBoardDAO.selectReportFreeBoard(reportFreeBoardNo);

		if (reportFreeBoard != null) {
			String reportConentIncludeEnter = reportFreeBoard.getReportReason().replace("\r\n", "<br>");
			reportFreeBoard.setReportReason(reportConentIncludeEnter);
		}

		return reportFreeBoard;
	}

	@Override
	public int duplicateReport(Map<String, Object> map) {
		int result = reportFreeBoardDAO.checkDuplicateReport(map);

		if (result > 0) {
			return 1;// 중복
		} else {
			return 0;// 미중복
		}
	}

}