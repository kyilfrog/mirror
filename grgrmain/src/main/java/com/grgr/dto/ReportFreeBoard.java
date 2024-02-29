package com.grgr.dto;

import java.util.Date;

import lombok.Data;

/*


CREATE TABLE REPORT_FREEBOARD(
    REPORT_FREEBOARD_NO NUMBER PRIMARY KEY,		
    UNO NUMBER,									
    CONSTRAINT REPORT_FREEBOARD_UNO_FK FOREIGN KEY(UNO) references USERINFO(UNO),
    FREE_BNO NUMBER,								
    CONSTRAINT REPORT_FREEBOARD_BNO_FK FOREIGN KEY(FREE_BNO) references FREE_BOARD(FREE_BNO),
    REPORT_REASON VARCHAR2(500),								
    REPORT_REGDATE DATE DEFAULT SYSDATE);	
    
    CREATE SEQUENCE REPORT_FREEBOARD_SEQ;	
 */

@Data

public class ReportFreeBoard {
	private int reportFreeBoardNo;
	private int uno;
	private int freeBno;
	private String reportReason;
	private Date reportRegdate;
	
}
