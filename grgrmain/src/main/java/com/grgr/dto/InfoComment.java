package com.grgr.dto;

import java.util.Date;

import lombok.Data;
/*
-- UNO 나중에 FK 줄것
CREATE TABLE INFO_COMMENT(
INFO_COMMENT_NO NUMBER PRIMARY KEY,
UNO NUMBER NOT NULL,
INFO_BNO NUMBER NOT NULL, 
CONSTRAINT INFO_COM_BNO_FK FOREIGN KEY(INFO_BNO) REFERENCES INFO_BOARD(INFO_BNO), 
INFO_COMMENT_REPORTNO NUMBER DEFAULT 0,
INFO_COMMENT_CONTENT VARCHAR2(1000),
INFO_COMMENT_GROUP NUMBER,
INFO_COMMENT_BLINDSTATE NUMBER DEFAULT 1 NOT NULL CHECK(INFO_COMMENT_BLINDSTATE BETWEEN 1 AND 3),
INFO_COMMENT_REGDATE DATE DEFAULT SYSDATE,
INFO_COMMENT_UPDATE DATE DEFAULT SYSDATE,
INFO_COMMENT_UPDATE_UNO DATE DEFAULT SYSDATE);

CREATE SEQUENCE INFO_COMMENT_SEQ; 
  
이름                      널?       유형             
----------------------- -------- -------------- 
INFO_COMMENT_NO         NOT NULL NUMBER         
UNO                              NUMBER         
INFO_BNO                         NUMBER         
INFO_COMMENT_REPORTNO            NUMBER         
INFO_COMMENT_CONTENT             VARCHAR2(1000) 
INFO_COMMENT_GROUP               NUMBER      - 모댓글이 같은 댓글들은 같은 그룹번호를 가짐   
INFO_COMMENT_BLINDSTATE NOT NULL NUMBER      - 1. 공개, 2.비공개, 3.삭제
INFO_COMMENT_REGDATE             DATE           
INFO_COMMENT_UPDATE              DATE           
INFO_COMMENT_UPDATE_UNO          DATE  

*/

@Data
public class InfoComment {
	int infoCommentNo;
	int uno;
	int infoBno;
	int infoCommentReportno;
	String infoCommentContent;
	int infoCommentGroup;
	int infoCommentBlindstate;
	String infoCommentRegdate;
	String infoCommentUpdate;
	int infoCommnetUpdateUno;
	
	String nickname; //조회시에만 사용할 닉네임 변수
	
}
