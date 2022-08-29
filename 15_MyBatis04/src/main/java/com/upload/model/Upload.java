package com.upload.model;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class Upload {
	
	public String fileUpload(MultipartHttpServletRequest mrequest) {
		
		String fileDBName = null;
		
		String uploadPath = "C:\\NCS\\workspace(spring)\\15_MyBatis04\\src\\main\\webapp\\resources\\upload\\";
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		Iterator<String> iterator = mrequest.getFileNames();
		
		while(iterator.hasNext()) {
			String uploadFileName = iterator.next();
			MultipartFile mfile = mrequest.getFile(uploadFileName);
			
			String originalFileName = mfile.getOriginalFilename();
			
			String homedir = uploadPath + year + "-" + month + "-" +day;
			
			File path1 = new File(homedir);
			
			if(!path1.exists()) {
				path1.mkdir();
			}
			
			String savefileName = originalFileName;
			
			if(savefileName != null) {
				savefileName = System.currentTimeMillis() + "_" + savefileName;
				
				File origin = new File(homedir+"/"+savefileName);
				
				try {
					mfile.transferTo(origin);
					
					fileDBName = "upload/"+year + "-" + month + "-" +day+"/"+savefileName;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
					
		}
		
		return fileDBName;
		
	}
}
