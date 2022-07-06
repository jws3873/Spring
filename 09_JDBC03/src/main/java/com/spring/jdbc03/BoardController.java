package com.spring.jdbc03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.BoardDAO;
import com.spring.model.BoardDTO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("board_list.do")
	public String list(HttpServletRequest request, Model model) {
		
		int rowsize = 3;
		int block = 3;
		int totalRecord = 0;
		int allPage = 0;
		
		int page = 0;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page").trim());
		}else {
			page = 1;
		}
		
		int startNo = (page * rowsize) - (rowsize -1);
		int endNo = (page * rowsize);
		
		int startBlock = (((page-1)/block)*block)+1;
		int endBlock = (((page-1)/block)*block)+block;
		
		totalRecord = this.dao.getBoardCount();
		
		allPage = (int)Math.ceil(totalRecord/(double)rowsize);
		
		if(endBlock > allPage) {
			endBlock = allPage;
		}
		
		List<BoardDTO> list = this.dao.getBoardList(page, rowsize);
		
		model.addAttribute("rowsize", rowsize);
		model.addAttribute("block", block);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("allPage", allPage);
		model.addAttribute("page", page);
		model.addAttribute("startNo", startNo);
		model.addAttribute("endNo", endNo);
		model.addAttribute("startBlock", startBlock);
		model.addAttribute("endBlock", endBlock);
		model.addAttribute("List", list);
		
		return "board_list";
	}
	
	@RequestMapping("board_write.do")
	public String write() {
		return "board_write";
	}
	
	@RequestMapping("board_write_ok.do")
	public void writeOk(BoardDTO dto, HttpServletResponse response) throws IOException {
		int check = this.dao.insertBoard(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		//String res = null;
		if(check >0) {
			out.println("<script>");
			out.println("alert('글 등록 성공!')");
			out.println("location.href='board_list.do'");
			out.println("</script>");
			//res = "redirect:board_list.do";
		}else {
			out.println("<script>");
			out.println("alert('글 등록 실패~~')");
			out.println("history.back()");
			out.println("</script>");
			//res = "reditect:write.do";
		}
		//return  res;
	}
	
	@RequestMapping("board_content.do")
	public String content(@RequestParam("no") int no, Model model) {
		
		this.dao.boardHit(no);
		
		BoardDTO dto = this.dao.getBoardCont(no);
		
		model.addAttribute("Cont", dto);
		
		return "board_content";
	}
	
	@RequestMapping("board_modify.do")
	public String modify(@RequestParam("no") int no, Model model) {
		
		BoardDTO dto = this.dao.getBoardCont(no);
		
		model.addAttribute("Modify", dto);
		
		return "board_modify";
	}
	
	@RequestMapping("board_modify_ok.do")
	public void modifyOk(BoardDTO dto, @RequestParam("pwd") String pwd,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(dto.getBoard_pwd().equals(pwd)) {
			int check = this.dao.boardUpdate(dto);
			if(check >0) {
				out.println("<script>");
				out.println("alert('글 수정 성공!')");
				out.println("location.href='board_content.do?no="+dto.getBoard_no()+"'");
				out.println("</script>");
			}else {
				out.println("<script>");
				out.println("alert('글 수정 실패~~')");
				out.println("history.back()");
				out.println("</script>");
			}
		}else {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("board_delete.do")
	public void delete(@RequestParam("no") int no, HttpServletResponse response) throws IOException {
		
		int check = this.dao.deleteBoard(no);
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		if(check > 0) {
			this.dao.boardSequence(no);
			out.println("<script>");
			out.println("alert('글 삭제 성공!')");
			out.println("location.href='board_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('글삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("board_search.do")
	public String search(@RequestParam("field") String field, 
			@RequestParam("keyword") String keyword,
			HttpServletRequest request, Model model) {
		
		int rowsize = 3;
		int block = 3;
		int totalRecord = 0;
		int allPage = 0;
		
		int page = 0;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page").trim());
		}else {
			page = 1;
		}
		
		int startNo = (page * rowsize) - (rowsize -1);
		int endNo = (page * rowsize);
		
		int startBlock = (((page-1)/block)*block)+1;
		int endBlock = (((page-1)/block)*block)+block;
		
		totalRecord = this.dao.searchListCount(field, keyword);
		

		
		allPage = (int)Math.ceil(totalRecord/(double)rowsize);
		
		if(endBlock > allPage) {
			endBlock = allPage;
		}
		
		List<BoardDTO> list = this.dao.searchBoardList(field, keyword, page, rowsize);
		
		model.addAttribute("rowsize", rowsize);
		model.addAttribute("block", block);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("allPage", allPage);
		model.addAttribute("page", page);
		model.addAttribute("startNo", startNo);
		model.addAttribute("endNo", endNo);
		model.addAttribute("startBlock", startBlock);
		model.addAttribute("endBlock", endBlock);
		model.addAttribute("field", field);
		model.addAttribute("keyword", keyword);
		model.addAttribute("searchList", list);
		return "board_search";
	}
}
