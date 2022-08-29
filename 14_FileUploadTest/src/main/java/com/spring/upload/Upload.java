package com.spring.upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class Upload {
	
	public boolean fileUpload(MultipartHttpServletRequest mrequest) {
		boolean isUpload = false;
		
		String uploadPath = "C:\\NCS\\workspace(spring)\\14_FileUploadTest\\src\\main\\webapp\\resources\\upload\\";
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
				
		List<MultipartFile> fileList = mrequest.getFiles("file");
		
		for(MultipartFile mf : fileList) {
			
			String uploadFileName = mf.getName();
			
			String originalFileName = mf.getOriginalFilename();
			
			long fileSize = mf.getSize(); // 파일 사이즈
			
			System.out.println("uploadFileName = "+uploadFileName);
			System.out.println("originalFileName = "+originalFileName);
			System.out.println("fileSize = "+fileSize);
			
			String homedir = uploadPath + year + "-" + month + "-" + day;
			
			File path1 = new File(homedir);
			
			if(!path1.exists()) {
				path1.mkdir();
			}
			
            String safeFile = System.currentTimeMillis() + "_" + originalFileName;
			
			 try {
				mf.transferTo(new File(homedir+"\\"+safeFile));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		return isUpload;
		
	}
	
}
