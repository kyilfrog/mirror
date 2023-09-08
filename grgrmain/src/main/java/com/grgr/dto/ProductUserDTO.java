package com.grgr.dto;

import lombok.Data;

// 조인해서 사용할 데이터 DTO
@Data
public class ProductUserDTO {
	private String productId;
	private String productTitle; // 상품 제목
	private int uno; // 판매자 회원 번호(FK)
	private int productPrice; // 상품 가격
	private String productContent; // 상품 설명
	private String nickName;
	private String email;
	private String phone;
	private String productRegdate;
	
}
