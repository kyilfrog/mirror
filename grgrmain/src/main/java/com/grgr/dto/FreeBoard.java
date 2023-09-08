package com.grgr.dto;

import java.util.Date;

import lombok.Data;

/*
CREATE TABLE FREE_BOARD (FREE_BNO NUMBER PRIMARY KEY,
UNO NUMBER NOT NULL, ),
FREE_KEYWORD NUMBER,
FREE_TITLE VARCHAR2(100) NOT NULL,
FREE_CONTENT VARCHAR2(2000) NOT NULL,
FREE_LOC VARCHAR2(50),
FREE_VIEW_CNT NUMBER DEFAULT 0,
FREE_REPORT_NO NUMBER DEFAULT 0,
FREE_BLINDSTATE NUMBER DEFAULT 1 NOT NULL CHECK(FREE_BLINDSTATE BETWEEN 1 AND 3),
FREE_REGDATE DATE DEFAULT SYSDATE,
FREE_UPDATE DATE DEFAULT SYSDATE,
FREE_UPDATE_UNO NUMBER);

CREATE SEQUENCE FREE_SEQ;
 */
@Data
public class FreeBoard {
	private String freeTitle;
	private String freeContent;
	private String freeLoc;
	private int freeBno;
	private int uno;
	private String freeKeyword;
	private int freeViewCnt;
	private int freeReportNo;
	private int freeBlindstate;
	private int freeUpdateUno;
	private Date freeRegdate;
	private Date freeUpdate;
	private String nickname;
	private String thumbnail;
}	
	/*
	 * 
	freeTitle: ���� �Խù��� �����Դϴ�.
	freeContent: ���� �Խù��� �����Դϴ�.
	freeLoc: ���� �Խù��� ��ġ �����Դϴ�.
	freeBno: ���� �Խù��� ��ȣ�Դϴ�. �ַ� ������ �ĺ��ڷ� ���˴ϴ�.
	uno: �Խù��� �ۼ��� ������� ��ȣ(�ĺ���)�Դϴ�.
	freeKeyword: ���� �Խù��� Ű���� �Ǵ� �±��Դϴ�.
	freeViewCnt: ���� �Խù��� ��ȸ�� Ƚ���Դϴ�.
	freeReportNo: ���� �Խù��� ���� �Ű� Ƚ���Դϴ�.
	freeBlindstate: ���� �Խù��� ����ε� ���¸� ��Ÿ���ϴ�.
	�� 1: �Ϲ� ����
	�� 2: ����ε� ���� (�����ڿ� ���� ���� ó����)
	�� 3: ���� ���� (����ڿ� ���� ���� ó����)
	freeUpdateUno: ���� �Խù��� ������Ʈ�� ������� ��ȣ(�ĺ���)�Դϴ�.
	freeRegdate: ���� �Խù��� ��������Դϴ�.
	freeUpdate: ���� �Խù��� ���������� ������Ʈ�� �����Դϴ�.
	thumbnail: ���� �Խù��� ÷�ε� ����� �̹��� ������ ��γ� �����Դϴ�.
	 * */

