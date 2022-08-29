package com.upload.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.upload.domain.Upload;
import com.upload.domain.UploadDTO;
import com.upload.service.UploadService;

@Controller
public class UploadController {
	
	@Autowired
	UploadService uploadService;
	
	@Autowired 
	Upload upload;
	
	@RequestMapping(value = "/upload_list.do",method = RequestMethod.GET)
	public String uploadList(Model model) {
		
		List<UploadDTO> uploadList = uploadService.selectUploadList();
		
		model.addAttribute("uploadList", uploadList);
		
		return "upload_list";
	}
	
	@RequestMapping(value = "/upload_write.do",method = RequestMethod.GET)
	public String uploadWrite() {
		
		return "upload_write";
	}
	
	@RequestMapping(value = "/upload_write_ok.do",method = RequestMethod.POST)
	public void uploadWriteOk(MultipartHttpServletRequest mrequest,MultipartFile file1,
			UploadDTO dto, HttpServletResponse response) throws IOException {
		
		String fileDBName= "";
		
		//List<MultipartFile> fileList = mrequest.getFiles("file1");
		
		if(!file1.isEmpty()) {
			fileDBName = upload.fileUpload(mrequest);
		}
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		dto.setUpload_file(fileDBName);
		int check = uploadService.insertUpload(dto);
		
		if(check >0) {
			out.println("<script>");
			out.println("alert('게시물 등록 성공')");
			out.println("location.href='upload_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('게시물 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}

	
	@RequestMapping(value = "/upload_detail.do", method=RequestMethod.GET)
	public String uploadDetail(@RequestParam("no") int no, Model model) {
		
		uploadService.updateHit(no);
		
		UploadDTO dto = uploadService.selectUpload(no);
		
		model.addAttribute("dto", dto);
		
		return "upload_detail";
		
	}
	
	@RequestMapping(value = "/upload_modify.do", method=RequestMethod.GET)
	public String uploadmodify(@RequestParam("no") int no, Model model) {
		
		UploadDTO dto = uploadService.selectUpload(no);
		
		model.addAttribute("modifyDto", dto);
		
		return "upload_modify";
		
	}
	
	@RequestMapping(value = "/upload_modify_ok.do", method=RequestMethod.POST)
	public void uploadModifyOk(UploadDTO dto,@RequestParam("check_pwd") String check_pwd,
							   MultipartHttpServletRequest mrequest,MultipartFile file1,
							   HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(check_pwd.equals(dto.getUpload_pwd())) {
			
			String fileDBName= "";
			
			if(!file1.isEmpty()) {
				fileDBName = upload.fileUpload(mrequest);
			}
			
			dto.setUpload_file(fileDBName);
			
			int check = uploadService.updateUpload(dto);
			
			if(check>0) {
				out.println("<script>");
				out.println("alert('게시글 수정 성공!!.')");
				out.println("location.href='upload_detail.do?no="+dto.getUpload_no()+"'");
				out.println("</script>");
			}else {
				out.println("<script>");
				out.println("alert('게시글 수정 실패!!.')");
				out.println("history.back()");
				out.println("</script>");
			}
			
		}else {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}// uploadModifyOk end
	
	@RequestMapping(value = "/upload_delete.do", method=RequestMethod.GET)
	public void uploadDelete(@RequestParam("no") int no, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		int check = uploadService.deleteUpload(no);
		
		if(check>0) {
			uploadService.updateSequence(no);
			out.println("<script>");
			out.println("alert('삭제 성공')");
			out.println("location.href='upload_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}// uploadDelete end
	
}
