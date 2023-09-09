package com.grgr.dto;

import java.util.Date;

import lombok.Data;

/*
안소연_0908

CREATE TABLE REPORT_QNA(
    REPORT_QNABOARD_NO NUMBER PRIMARY KEY,		신고글번호
    UNO NUMBER,									유저번호
    CONSTRAINT REPORT_UNO_FK FOREIGN KEY(UNO) references USERINFO(UNO),
    QNA_BNO NUMBER,								문의게시글 번호
    CONSTRAINT REPORT_QNA_BNO_FK FOREIGN KEY(QNA_BNO) references QNA_BOARD(QNA_BNO),
    REPORT_CNT NUMBER,							신고 카운트
    REPORT_REASON VARCHAR2(500),				신고 사유				
    REPORT_REGDATE DATE DEFAULT SYSDATE,		신고 일자
    REPORT_UPDATE DATE DEFAULT SYSDATE,			신고수정 일자
    REPORT_UPDATE_UNO NUMBER,					신고 수정자(관리자가 되겠지)
    CONSTRAINT REPORT_QNA_UPDATE_UNO_FK FOREIGN KEY(REPORT_UPDATE_UNO) references USERINFO(UNO),
    REPORT_STATUS NUMBER DEFAULT 1 NOT NULL CHECK(REPORT_STATUS BETWEEN 1 AND 2),	게시글 처리상태
-- REPORT_STATUS - 1: 미처리, 2: 처리완료
 */

@Data
public class ReportQnaBoard {
	private int reportQnaBoardNo;
	private int uno;
	private int qnaBno;
	private int reportCnt;
	private String reportReason;
	private Date reportRegdate;
	private Date reportUpdate;
	private int reportUpdateUno;
	private int reportStatus;
}