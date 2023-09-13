package com.grgr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grgr.dto.ProductCartDTO;
import com.grgr.service.ProductCartService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
@Slf4j
public class ProductCartController {
	private final ProductCartService productCartService;

	@PostMapping("/add")
	@ResponseBody // JSON 응답을 반환하도록 설정
	public String addCartPost(@RequestParam("uno") int uno, @RequestParam("productId") int productId,
			@RequestParam("productCount") int productCount) throws Exception {
		ProductCartDTO cart = new ProductCartDTO();
		cart.setUno(uno);
		cart.setProductId(productId);
		cart.setProductCount(productCount);
		
			int result = productCartService.addCart(cart);
			
			return result+"";
	}
}