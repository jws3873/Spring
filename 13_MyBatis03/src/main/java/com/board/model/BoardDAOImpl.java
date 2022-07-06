package com.board.model;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getBoardListCount() {
		return this.sqlSession.selectOne("count");
	}

	@Override
	public List<BoardDTO> getBoardList(PageDTO dto) {
		return this.sqlSession.selectList("list", dto);
	}

	@Override
	public int insertBoard(BoardDTO dto) {
		return this.sqlSession.insert("write", dto);
	}

	@Override
	public void boardHit(int no) {
		this.sqlSession.update("hit", no);

	}

	@Override
	public BoardDTO getBoardCont(int no) {
		return this.sqlSession.selectOne("cont", no);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		return this.sqlSession.update("edit", dto);
	}

	@Override
	public int deleteBoard(int no) {
		return this.sqlSession.delete("del", no);
	}
	
	@Override
	public void updateSequence(int no) {
		this.sqlSession.update("seq", no);
		
	}

	@Override
	public int seatchListCount(String field,String keyword) {
		return this.sqlSession.selectOne(field+"Count", keyword);
	}

	@Override
	public List<BoardDTO> searchBoardList(PageDTO dto) {

		return this.sqlSession.selectList(dto.getField()+"List", dto);
	}

}
