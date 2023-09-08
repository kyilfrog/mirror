package com.grgr.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductBoardVO {
	private int productId; // 상품 번호(PK)

	private String productTitle; // 상품 제목

	private int uno; // 판매자 회원 번호(FK)

	private int productUpdateUno; // 상품 수정 회원

	private Date productRegdate; // 상품 등록 날짜

	private Date productUpdate; // 상품 수정 날짜

	private int productPrice; // 상품 가격

	private String productContent; // 상품 설명

	private int productViewCnt; // 조회수

	private int productReportNo; // 신고수

	private int productBlindState; // 상품 상태

	private String productImage; // 이미지 파일 이름
	
	

}
