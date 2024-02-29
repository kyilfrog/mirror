package com.grgr.dto;

import java.util.Date;

import lombok.Data;
/*

CREATE TABLE FREE_COMMENT(
FREE_COMMENT_NO NUMBER PRIMARY KEY,
UNO NUMBER NOT NULL,
FREE_BNO NUMBER NOT NULL,  
FREE_COMMENT_REPORTNO NUMBER DEFAULT 0,
FREE_COMMENT_CONTENT VARCHAR2(1000),
FREE_COMMENT_GROUP NUMBER,
FREE_COMMENT_BLINDSTATE NUMBER DEFAULT 1 NOT NULL CHECK(FREE_COMMENT_BLINDSTATE BETWEEN 1 AND 3),
FREE_COMMENT_REGDATE DATE DEFAULT SYSDATE,
FREE_COMMENT_UPDATE DATE DEFAULT SYSDATE,
FREE_COMMENT_UPDATE_UNO NUMBER DEFAULT SYSDATE);

CREATE SEQUENCE FREE_COMMENT_SEQ; 

*/

@Data
public class FreeComment {
	int freeCommentNo;
	int uno;
	int freeBno;
	int freeCommentReportno;
	String freeCommentContent;
	int freeCommentGroup;
	int freeCommentBlindstate;
	Date freeCommentRegdate;
	Date freeCommentUpdate;
	int freeCommentUpdateUno;
	String nickname; 
}
	
	
	