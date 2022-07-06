package com.upload.model;

import java.util.List;

public interface UploadDAO {
	List<UploadDTO> getUploadList();
	int insertUpload(UploadDTO dto);
	void uploadHit(int no);
	UploadDTO getUploadContent(int no);
	int updateUpload(UploadDTO dto);
	void updateCount(int no);
	int deleteUpload(int no);
	
}
