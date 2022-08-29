package com.upload.dao;

import java.util.List;

import com.upload.domain.UploadDTO;

public interface UploadDAO {

	List<UploadDTO> selectUploadList();

	int insertUpload(UploadDTO dto);

	void updateHit(int no);

	UploadDTO selectUpload(int no);

	int updateUpload(UploadDTO dto);

	int deleteUpload(int no);

	void updateSequence(int no);

}