package com.grgr.dto;

import lombok.Data;

/*
CREATE TABLE FREE_FILE( 
FREE_FILE_NO NUMBER PRIMARY KEY,
FREE_BNO NUMBER NOT NULL,
FREE_FILE_ORIGIN VARCHAR2(50),
FREE_FILE_UPLOAD VARCHAR2(50),
FREE_FILE_REGDATE DATE DEFAULT SYSDATE,
FREE_FILE_UPDATE DATE DEFAULT SYSDATE,
FREE_FILE_UPDATE_UNO NUMBER);

CREATE SEQUENCE FREE_FILE_SEQ;
  
  
 
 
 */

@Data
public class FreeFile {
	private int freeFileNo;
	private int freeBno;
	private String freeFileOrigin;
	private String freeFileUpload;
	private String freeFileRegdate;
	private String freeFileUpdate;
	private int freeFileUpdateUno;
}
