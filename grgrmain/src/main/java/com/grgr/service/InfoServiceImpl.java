package com.grgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grgr.dto.Matzib;
import com.grgr.dto.MatzibResponse;

import lombok.RequiredArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class InfoServiceImpl implements InfoService {

	
	@Override
    public List<Matzib> getMatzibList(String query) {
        RestTemplate restTemplate = new RestTemplate();

        // query를 Base64로 인코딩
        String encode = Base64.getEncoder().encodeToString(query.getBytes(StandardCharsets.UTF_8));

        // 네이버 API 호출 URI 생성
        URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com/v1/search/local.json")
                .queryParam("query", query)
                .queryParam("display", 30)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode()
                .build()
                .toUri();

        // 네이버 API 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", "0PhhgMX_KR1xHRl1q6k7");
        headers.set("X-Naver-Client-Secret", "fq1gTWshB0");
        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);

     // 네이버 API 호출
        ResponseEntity<MatzibResponse> responseEntity = restTemplate.exchange(requestEntity, MatzibResponse.class);
        MatzibResponse matzibResponse = responseEntity.getBody();
        
        if (matzibResponse != null) {
            return matzibResponse.getItems();
        } else {
            return Collections.emptyList();
        }
    }
}