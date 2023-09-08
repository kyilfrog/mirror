package com.grgr.util;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

//페이징 처리 관련 값을 필드에 저장하기 위한 클래스
@Data
public class Pager {
	//생성자를 이용하여 초기값을 전달받아 필드에 저장
//	private int pageNum;//요청 페이지의 번호
//	private int pageSize;//하나의 페이지에 출력될 게시글의 갯수
//	private int blockSize;//하나의 블럭에 출력될 페이지 번호의 갯수
//  keyword, searchType, keyword
	private SearchCondition searchCondition;

	private int totalBoard;//전체 게시글의 갯수
	private int totalPage;//전체 페이지의 갯수
	private int startRow;//요청 페이지에 출력될 게시글의 시작 행번호
	private int endRow;//요청 페이지에 출력될 게시글의 종료 행번호
	private int startPage;//현재 블럭에 출력될 시작 페이지 번호
	private int endPage;//현재 블럭에 출력될 종료 페이지 번호
	private int prevPage;//이전 블럭에 출력될 시작 페이지 번호
	private int nextPage;//다음 블럭에 출력될 시작 페이지 번호
	
	
	
	
	public Pager(int totalBoard, SearchCondition searchCondition) {
		super();
		this.totalBoard = totalBoard;
		this.searchCondition = searchCondition;
		
		calcPage(totalBoard, searchCondition);
	}
	


	
	//계산된 결과값을 필드에 저장하는 메소드 - 생성자에서 호출하여 사용
	private void calcPage(int totalBoard, SearchCondition searchCondition) {
		
		totalPage=(int)Math.ceil((double)totalBoard/searchCondition.getPageSize());
		if(searchCondition.getPageNum()<=0 ||searchCondition.getPageNum()>totalPage) {
			searchCondition.setPageNum(1);
		}
		
		startRow=(searchCondition.getPageNum()-1)*searchCondition.getPageSize()+1;
 		endRow=searchCondition.getPageNum()*searchCondition.getPageSize();
		if(endRow>totalBoard) {
			endRow=totalBoard;
		}
		
		startPage=(searchCondition.getPageNum()-1)/searchCondition.getBlockSize()*searchCondition.getBlockSize()+1;
		endPage=startPage+searchCondition.getBlockSize()-1;
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		prevPage=startPage-searchCondition.getBlockSize();
		nextPage=startPage+searchCondition.getBlockSize();
	}



}