package com.grgr.dto;

import java.util.Date;

import lombok.Data;

/*
CREATE TABLE NOTICE_BOARD (NOTICE_BNO NUMBER PRIMARY KEY,
UNO NUMBER NOT NULL, CONSTRAINT NOTICE_BOARD_FK FOREIGN KEY(UNO) references USERINFO (UNO),
NOTICE_TITLE VARCHAR2(100) NOT NULL,
NOTICE_CONTENT VARCHAR2(2000) NOT NULL,
NOTICE_VIEW_CNT NUMBER DEFAULT 0,
NOTICE_BLINDSTATE NUMBER DEFAULT 1 NOT NULL,
NOTICE_REGDATE DATE DEFAULT SYSDATE,
NOTICE_UPDATE DATE DEFAULT SYSDATE,
NOTICE_UPDATE_UNO NUMBER);

CREATE SEQUENCE NOTICE_SEQ; 
*/

@Data
public class NoticeBoard {
	
	private String noticeTitle;
	private String noticeContent;
	private int noticeBno;
	private int uno;
	private int noticeViewCnt;
	private int noticeBlindstate;
	private int noticeUpdateUno;
	private Date noticeRegdate;
	private Date noticeUpdate;

}
