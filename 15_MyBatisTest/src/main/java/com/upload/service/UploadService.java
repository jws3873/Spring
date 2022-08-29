package com.upload.service;

import java.util.List;

import com.upload.domain.UploadDTO;

public interface UploadService {

	List<UploadDTO> selectUploadList();

	int insertUpload(UploadDTO dto);

	void updateHit(int no);

	UploadDTO selectUpload(int no);

	int updateUpload(UploadDTO dto);

	int deleteUpload(int no);

	void updateSequence(int no);

}