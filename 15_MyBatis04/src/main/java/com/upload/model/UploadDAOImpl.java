package com.upload.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UploadDAOImpl implements UploadDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<UploadDTO> getUploadList() {
		return this.sqlSession.selectList("all");
	}

	@Override
	public int insertUpload(UploadDTO dto) {
		return this.sqlSession.insert("upload", dto);
	}

	@Override
	public void uploadHit(int no) {
		this.sqlSession.update("hit", no);

	}

	@Override
	public UploadDTO getUploadContent(int no) {
		return this.sqlSession.selectOne("cont", no);
	}

	@Override
	public int updateUpload(UploadDTO dto) {
		return this.sqlSession.update("edit", dto);
	}
	
	@Override
	public void updateCount(int no) {
		this.sqlSession.update("count", no);
	}

	@Override
	public int deleteUpload(int no) {
		return this.sqlSession.delete("del", no);
	}

}
