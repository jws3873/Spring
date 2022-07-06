package com.spring.upload;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service // 스프링에서 비지니스 로직을 수행할 때 붙이는 애노테이션
		 // 해당  Upload 라는 클래스는 비지니스 로직을 수행하는 클래스
public class Upload {
	
	public boolean fileUpload(MultipartHttpServletRequest mrequest) {
		
		boolean isUpload = false;
		
		String uploadPath = "C:\\NCS\\workspace(spring)\\14_FileUpload\\src\\main\\webapp\\resources\\upload\\";
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		// 업로드된 파일들의 이름 목록을 제공하는 메서드
		Iterator<String> iterator =  mrequest.getFileNames();
		
		while(iterator.hasNext()) {
			String uploadFileName = iterator.next();
			MultipartFile mfile =  mrequest.getFile(uploadFileName);
			
			//업로드한 파일의 이름을 구하느 메서드
			String originalFileName = mfile.getOriginalFilename();
			
			//실제 폴더를 만들어 보자.
			// .......\\resources\\upload\\2022-05-30
			String homedir = uploadPath + year + "-" + month + "-" + day;
			
			File path1 = new File(homedir);
			
			if(!path1.exists()) {
				path1.mkdir();
			}
			
			//실제 파일을 만들어 보자.
			String savefileName = originalFileName;
			
			if(savefileName != null) {
				savefileName = 
				System.currentTimeMillis() + "_" + savefileName;
				// .......\\resources\\upload\\2022-05-30\\ 실페 파일
				File origin = new File(homedir+"/"+savefileName);
				
				try {
					
					// transferTo() : 파일 데이터를 지정한 폴더로 실제 저장시키는 메서드
					mfile.transferTo(origin);
					
					isUpload = true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}// while문 end
		
		return isUpload;
		
	}// fileUpload() 메서드 end
}
