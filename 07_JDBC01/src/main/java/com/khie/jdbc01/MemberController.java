package com.khie.jdbc01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khie.model.MemberDAO;
import com.khie.model.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired
	//필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다.
	private MemberDAO dao;
	
	@RequestMapping("/member_select.do")
	public String list(Model model) {
		
		List<MemberDTO> list =  this.dao.getMemberList();
		
		model.addAttribute("memList", list);
		
		return "member_list";
		
	}
	@RequestMapping("member_insert.do")
	public String insert() {
		return "member_insert";
	}
	
	@RequestMapping("member_insert_ok.do")
	public void insertOk(MemberDTO dto, HttpServletResponse response) throws IOException {
		
		int check =  this.dao.insertMember(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check>0) {
			out.println("<script>");
			out.println("alert('회원등록 성공!!!')");
			out.println("location.href='member_select.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원등록 성공실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	@RequestMapping("member_content.do")
	public String content(@RequestParam("num") int num,Model model) {
		
		// 회원의 상세 정보를 조회하는 메서드 호출
		MemberDTO dto = this.dao.getMember(num);
		
		model.addAttribute("Cont", dto);
		
		return "member_content";
	}
	
	@RequestMapping("member_modify.do")
	public String modify(@RequestParam("num") int num,Model model) {
		
		// 회원의 상세 정보를 조회하는 메서드 호출
		MemberDTO dto = this.dao.getMember(num);
				
		model.addAttribute("Modify", dto);
		
		return "member_modify";
	}
	
	@RequestMapping("member_modify_ok.do")
	public void modifyOk(MemberDTO dto,HttpServletResponse response) throws IOException {
		
		int check = this.dao.updateMember(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check>0) {
			out.println("<script>");
			out.println("alert('회원정보 수정 성공!!')");
			out.println("location.href='member_content.do?num="+dto.getNum()+"'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원정보 수정 실패!!')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("member_delete.do")
	public void delete(@RequestParam("num") int num,HttpServletResponse response) throws IOException {
		
		int check = this.dao.delteMember(num);
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(check>0) {
			this.dao.updateSequence(num);
			out.println("<script>");
			out.println("alert('삭제 성공!!')");
			out.println("location.href='member_select.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('삭제 실패~~')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("member_search.do")
	public String search(@RequestParam("search_field") String field,
			@RequestParam("search_keyword") String keyword, Model model) {
		List<MemberDTO> list =  this.dao.searchMemberList(field, keyword);
		
		model.addAttribute("searchList", list);
		
		return "member_searchList";
	}
}
