package com.board.model;

import java.util.List;

public interface BoardDAO {
	int getBoardListCount();
	List<BoardDTO> getBoardList(PageDTO dto);
	int insertBoard(BoardDTO dto);
	void boardHit(int no);
	BoardDTO getBoardCont(int no);
	int updateBoard(BoardDTO dto);
	int deleteBoard(int no);
	void updateSequence(int no);
	int seatchListCount(String field,String keyword);
	List<BoardDTO> searchBoardList(PageDTO dto);
}
