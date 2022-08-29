package com.upload.mybatis04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.upload.model.Upload;
import com.upload.model.UploadDAO;
import com.upload.model.UploadDTO;

@Controller
public class UploadController {
	
	@Autowired
	private Upload upload;
	
	@Autowired
	private UploadDAO dao;
	
	@RequestMapping("upload_list.do")
	public String list(Model model) {
		
		List<UploadDTO> list =  this.dao.getUploadList();
		
		model.addAttribute("List", list);
		
		return "upload_list";
	}
	
	@RequestMapping("upload_write.do")
	public String write() {
		return "upload_write";
	}
	
	@RequestMapping("upload_write_ok.do")
	public void writeOk(MultipartHttpServletRequest mrequest,UploadDTO dto,
			HttpServletResponse response) throws IOException {
		
		String fileDBName = upload.fileUpload(mrequest);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(fileDBName != null) {
			dto.setUpload_file(fileDBName);
			int check = this.dao.insertUpload(dto);
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
		}else {
			out.println("<script>");
			out.println("alert('파일 업로드 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("upload_content.do")
	public String content(@RequestParam("no") int no,Model model) {
		this.dao.uploadHit(no);
		
		UploadDTO dto = this.dao.getUploadContent(no);
		
		model.addAttribute("Cont", dto);
		
		return "upload_content";
	}
	
	@RequestMapping("upload_update.do")
	public String update(@RequestParam("no") int no, Model model) {
		
		UploadDTO dto = this.dao.getUploadContent(no);
		
		model.addAttribute("Modify", dto);
		
		return "upload_modify";
		
	}
	
	@RequestMapping("upload_modify_ok.do")
	public void modifyOk(MultipartHttpServletRequest mrequest, @RequestParam("pwd") String pwd,
			UploadDTO dto,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(pwd.equals(dto.getUpload_pwd())) {
			String fileDBName = upload.fileUpload(mrequest);
			
			if(fileDBName != null) {
				dto.setUpload_file(fileDBName);
				int check = this.dao.updateUpload(dto);
				if(check >0) {
					out.println("<script>");
					out.println("alert('게시물 수정 성공')");
					out.println("location.href='upload_content.do?no="+dto.getUpload_no()+"'");
					out.println("</script>");
				}else {
					out.println("<script>");
					out.println("alert('게시물 수정 실패.')");
					out.println("history.back()");
					out.println("</script>");
				}
			}else {
				out.println("<script>");
				out.println("alert('파일 업로드중 문제 발생')");
				out.println("history.back()");
				out.println("</script>");
			}
			
		}else {
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 안습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("upload_delete.do")
	public void delete(@RequestParam("no") int no,HttpServletResponse response) throws IOException {
		
		int check = this.dao.deleteUpload(no);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(check>0) {
			this.dao.updateCount(no);
			out.println("<script>");
			out.println("alert('게시물 삭제 성공')");
			out.println("location.href='upload_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('게시물 삭제 실패.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
	
	
	
	
}
