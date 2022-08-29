package com.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upload.dao.UploadDAO;
import com.upload.domain.UploadDTO;

@Service
public class UploadServiceImpl implements UploadService {
	
	@Autowired
	UploadDAO uploadDao;
	
	@Override
	public List<UploadDTO> selectUploadList(){
		
		return uploadDao.selectUploadList();
		
	}
	
	@Override
	public int insertUpload(UploadDTO dto) {
		return uploadDao.insertUpload(dto);
	}
	
	@Override
	public void updateHit(int no) {
		uploadDao.updateHit(no);
	}
	
	@Override
	public UploadDTO selectUpload(int no) {
		return uploadDao.selectUpload(no);
	}
	
	@Override
	public int updateUpload(UploadDTO dto) {
		return uploadDao.updateUpload(dto);
	}
	
	@Override
	public int deleteUpload(int no) {
		return uploadDao.deleteUpload(no);
	}
	
	@Override
	public void updateSequence(int no) {
		uploadDao.updateSequence(no);
	}

}
