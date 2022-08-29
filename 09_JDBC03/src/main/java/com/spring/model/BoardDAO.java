package com.spring.model;

import java.util.List;

public interface BoardDAO {
	int getBoardCount();
	List<BoardDTO> getBoardList(int page,int rowsize);
	int insertBoard(BoardDTO dto);
	void boardHit(int no);
	BoardDTO getBoardCont(int no);
	int boardUpdate(BoardDTO dto);
	int deleteBoard(int no);
	int searchListCount(String field,String keyword);
	List<BoardDTO> searchBoardList(String field,String keyword,int page,int rowsize);
	void boardSequence(int no);
	
}
