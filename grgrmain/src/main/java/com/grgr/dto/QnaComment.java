package com.grgr.dto;

import lombok.Data;

/*
CREATE TABLE QNA_COMMENT(
    QNA_COMMENT_NO NUMBER PRIMARY KEY
    , UNO NUMBER NOT NULL
    , QNA_BNO NUMBER NOT NULL
    , CONSTRAINT QNA_COM_BNO_FK FOREIGN KEY(QNA_BNO) REFERENCES QNA_BOARD(QNA_BNO)
    , QNA_COMMENT_CONTENT VARCHAR2(1000)
    , QNA_COMMENT_GROUP NUMBER
    , QNA_COMMENT_BLINDSTATE NUMBER DEFAULT 1 NOT NULL CHECK(QNA_COMMENT_BLINDSTATE BETWEEN 1 AND 3)
    , QNA_COMMENT_REGDATE DATE DEFAULT SYSDATE
    , QNA_COMMENT_UPDATE DATE DEFAULT SYSDATE
    , QNA_COMMENT_UPDATE_UNO NUMBER);
    
     
이름                     널?       유형             
---------------------- -------- -------------- 
QNA_COMMENT_NO         NOT NULL NUMBER         
UNO                    NOT NULL NUMBER         
QNA_BNO                NOT NULL NUMBER         
QNA_COMMENT_CONTENT             VARCHAR2(1000) 
QNA_COMMENT_GROUP               NUMBER     		- 모댓글이 같은 댓글들은 같은 그룹번호를 가짐       
QNA_COMMENT_BLINDSTATE NOT NULL NUMBER  		- 1. 공개, 2.비공개, 3.삭제       
QNA_COMMENT_REGDATE             DATE           
QNA_COMMENT_UPDATE              DATE           
QNA_COMMENT_UPDATE_UNO          NUMBER         

 */

@Data
public class QnaComment {
	private int qnaCommentNo;
	private int uno;
	private int qnaBno;
	private String qnaCommentContent;
	private int qnaCommentGroup;
	private int qnaCommentBlindstate;
	private String qnaCommentRegdate;
	private String qnaCommentUpdate;
	private int qnaCommentUpdateUno;
	
	String nickname; //조회시에만 사용할 닉네임 변수
}
