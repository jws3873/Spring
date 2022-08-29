package com.upload.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upload.domain.UploadDTO;

@Repository
public class UploadDAOImpl implements UploadDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	final String namespace = "com.spring.dao.uploadMapper.";
	
	@Override
	public List<UploadDTO> selectUploadList(){
		
		return sqlSession.selectList(namespace+"AllList");
		
	}
	
	@Override
	public int insertUpload(UploadDTO dto) {
		return sqlSession.insert("InsertUpload", dto);
	}
	
	@Override
	public void updateHit(int no) {
		sqlSession.update("updateHit", no);
	}
	
	@Override
	public UploadDTO selectUpload(int no) {
		return sqlSession.selectOne("SelectUpload", no);
	}
	
	@Override
	public int updateUpload(UploadDTO dto) {
		return sqlSession.update("UpdateUpload", dto);
	}
	
	@Override
	public int deleteUpload(int no) {
		return sqlSession.delete("DeleteUpload", no);
	}
	
	@Override
	public void updateSequence(int no) {
		sqlSession.update("UpdateSequence", no);
	}

}
