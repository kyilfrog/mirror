package com.grgr.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.grgr.dao.FreeBoardDAO;
import com.grgr.dto.FreeBoard;
import com.grgr.dto.FreeFile;
import com.grgr.exception.FileUploadFailException;
import com.grgr.exception.WriteNullException;
import com.grgr.util.Pager;
import com.grgr.util.SearchCondition;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FreeBoardServiceImpl implements FreeBoardService {
	private final FreeBoardDAO freeBoardDAO;
	private final WebApplicationContext context;

	@Override
	public int getFreeCount(SearchCondition searchCondition) {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		if (searchCondition != null) {
			if (searchCondition.getSearchType() != null && !searchCondition.getSearchType().isEmpty()) {
				searchMap.put("searchType", searchCondition.getSearchType());
			}
			if (searchCondition.getSearchKeyword() != null && !searchCondition.getSearchKeyword().isEmpty()) {
				searchMap.put("searchKeyword", searchCondition.getSearchKeyword());
			}
		}
		
		if (searchCondition.getKeyword() != null && !searchCondition.getKeyword().trim().isEmpty()) {
		    searchMap.put("freeKeyword", searchCondition.getKeyword().trim());
		}
		searchMap.put("freeLoc", "������");
		return freeBoardDAO.freeBoardCount(searchMap);
	}

	@Override
	@Transactional
	public int addFreeBoard(FreeBoard freeBoard, List<MultipartFile> files) throws WriteNullException, FileUploadFailException, IOException{
		
		if (freeBoard.getFreeTitle() == null || freeBoard.getFreeContent() == null) {
	        throw new WriteNullException("���� �Ǵ� ������ ����ֽ��ϴ�.");
	    }
		freeBoardDAO.insertFreeBoard(freeBoard);

		String uploadDirectory=context.getServletContext().getRealPath("/resources/upload");
	
		//������ �ϳ��� ���ε����� �ʾƵ� �ǹǷ� null�� �ƴҽÿ��� ���ε� �۾�
		if(files != null && !files.isEmpty()) {
			for(MultipartFile multipartfile : files) {
				 if(multipartfile.isEmpty()) {
			            continue; // ������ ��� ������ ���� ���Ϸ� �Ѿ
			        }

			        if(!multipartfile.getContentType().startsWith("image/")) {
			            throw new FileUploadFailException("������ �ƴ� �����Դϴ�.");
			        }
				
				String uploadFileName = UUID.randomUUID().toString()+"_"+multipartfile.getOriginalFilename();
				System.out.println(uploadFileName);
				File file = new File(uploadDirectory, uploadFileName);
				System.out.println(file);
				

				multipartfile.transferTo(file);
					
			
				
				// ���� ���� ��ü ����
				FreeFile freeFile = new FreeFile();
				freeFile.setFreeBno(freeBoard.getFreeBno());
				freeFile.setFreeFileOrigin(multipartfile.getOriginalFilename());
				freeFile.setFreeFileUpload(uploadFileName);
		        
				freeBoardDAO.insertFreeFile(freeFile);

			}
		}
		return freeBoard.getFreeBno();
	}

	@Override
	public void modifyFreeBoard(FreeBoard freeBoard) {
		// TODO Auto-generated method stub
		freeBoardDAO.updateFreeBoard(freeBoard);

	}

	@Override
	public void removeFreeBoard(int freeBno, int uno) {
		// TODO Auto-generated method stub
		freeBoardDAO.deleteFreeBoard(freeBno, uno);

	}

	@Override
	public void hideFreeBoard(int freeBno) {
		// TODO Auto-generated method stub
		freeBoardDAO.blindFreeBoard(freeBno);
	}

	@Override
	public Map<String, Object> getFreeBoard(int freeBno) {
		Map<String, Object> readMap = new HashMap<String, Object>();
		// TODO Auto-generated method stub
		readMap.put("freeBoard", freeBoardDAO.selectFreeBoard(freeBno));
		readMap.put("freeFiles", freeBoardDAO.selectFreeFile(freeBno));
		
		return readMap;
	}

	@Override
	public Map<String, Object> getFreeBoardList(SearchCondition searchCondition) {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		if (searchCondition != null) {
			if (searchCondition.getSearchType() != null && !searchCondition.getSearchType().isEmpty()) {
				searchMap.put("searchType", searchCondition.getSearchType());
			}
			if (searchCondition.getSearchKeyword() != null && !searchCondition.getSearchKeyword().isEmpty()) {
				searchMap.put("searchKeyword", searchCondition.getSearchKeyword());
			}
		}
		
		if (searchCondition.getKeyword() != null && !searchCondition.getKeyword().trim().isEmpty()) {
		    searchMap.put("infoKeyword", searchCondition.getKeyword().trim());
		}
		searchMap.put("freeLoc", "강남구");

		int totalBoard = freeBoardDAO.freeBoardCount(searchMap);
		//
		Pager pager = new Pager(totalBoard, searchCondition);
		// ����¡ ���
		searchMap.put("startRow", pager.getStartRow());
		searchMap.put("endRow", pager.getEndRow());

		List<FreeBoard> freeBoardList = freeBoardDAO.selectFreeBoardList(searchMap);
		
		List<String> fileList=new ArrayList<String>();
		for (FreeBoard freeBoard : freeBoardList) {
	        List<FreeFile> freeFiles = freeBoardDAO.selectFreeFile(freeBoard.getFreeBno());
	        if (!freeFiles.isEmpty()) {
	        	fileList.add(freeFiles.get(0).getFreeFileUpload());
	        } else {
	        	fileList.add("placeholder-square.jpg");
	        }
	    }

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("freeBoardList", freeBoardList);
		resultMap.put("pager", pager); // pager ��ü�� ��ȯ
		//resultMap.put("searchMap", searchMap);
		resultMap.put("fileList", fileList);

		return resultMap;
	}

	@Override
	public Integer prevFreeBno(SearchCondition searchCondition, int freeBno) {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		if (searchCondition != null) {
			if (searchCondition.getSearchType() != null && !searchCondition.getSearchType().isEmpty()) {
				searchMap.put("searchType", searchCondition.getSearchType());
			}
			if (searchCondition.getSearchKeyword() != null && !searchCondition.getSearchKeyword().isEmpty()) {
				searchMap.put("searchKeyword", searchCondition.getSearchKeyword());
			}
		}
		searchMap.put("freeLoc", "������");
		searchMap.put("freeBno", freeBno);
		
		return freeBoardDAO.selectPrevFreeBno(searchMap);
	}

	@Override
	public Integer nextFreeBno(SearchCondition searchCondition, int freeBno) {
		Map<String, Object> searchMap = new HashMap<String, Object>();
		if (searchCondition != null) {
			if (searchCondition.getSearchType() != null && !searchCondition.getSearchType().isEmpty()) {
				searchMap.put("searchType", searchCondition.getSearchType());
			}
			if (searchCondition.getSearchKeyword() != null && !searchCondition.getSearchKeyword().isEmpty()) {
				searchMap.put("searchKeyword", searchCondition.getSearchKeyword());
			}
		}
		searchMap.put("freeLoc", "������");
		searchMap.put("freeBno", freeBno);
		
		
		

		return freeBoardDAO.selectNextFreeBno(searchMap);
	}

}
