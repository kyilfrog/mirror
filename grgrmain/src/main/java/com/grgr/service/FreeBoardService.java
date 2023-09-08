package com.grgr.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
 
import org.springframework.web.multipart.MultipartFile;

import com.grgr.dto.FreeBoard;
import com.grgr.exception.FileUploadFailException;
import com.grgr.exception.WriteNullException;
import com.grgr.util.SearchCondition;

public interface FreeBoardService {
	//게시글 수 조회
	int getFreeCount(SearchCondition searchCondition);
	//게시글 추가
	int addFreeBoard(FreeBoard freeBoard, List<MultipartFile> files)throws WriteNullException, FileUploadFailException, IOException;
	//게시글 수정
	void modifyFreeBoard(FreeBoard freeBoard);
	//게시글 삭제
	void removeFreeBoard(int freeBno, int uno);
	//게시글 숨김 처리
	void hideFreeBoard(int freeBno);
//	int increaseFreeViewCnt(int freeBno);
//	int increaseFreeReportNo(int freeBno);
	//게시글 상세 조회
	Map<String, Object> getFreeBoard(int freeBno);
	//이전 게시글 번호 조회
	Integer prevFreeBno(SearchCondition searchCondition, int freeBno);
	//다음 게시글 번호 조회
	Integer nextFreeBno(SearchCondition searchCondition, int freeBno);
	//게시글 목록 조회
	Map<String, Object> getFreeBoardList(SearchCondition searchCondition);
}
