package com.grgr.dao;

import java.util.List;
import java.util.Map;



import com.grgr.dto.FreeBoard;
import com.grgr.dto.FreeFile;

public interface FreeBoardDAO {
	int freeBoardCount(Map<String, Object> map);
	int insertFreeBoard(FreeBoard freeBoard);
	int updateFreeBoard(FreeBoard freeBoard);
	int deleteFreeBoard(int freeBno, int uno);
	int blindFreeBoard(int freeBno);
	int increaseFreeViewCnt(int freeBno);
	int increaseFreeReportNo(int freeBno);
	FreeBoard selectFreeBoard(int freeBno);
	Integer selectPrevFreeBno(Map<String, Object> map);
	Integer selectNextFreeBno(Map<String, Object> map);
	List<FreeBoard> selectFreeBoardList(Map<String, Object> map);
	
	int insertFreeFile(FreeFile freeFile);
	List<FreeFile> selectFreeFile(int freeBno);
}
