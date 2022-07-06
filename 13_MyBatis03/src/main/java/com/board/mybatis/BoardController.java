package com.board.mybatis;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;
import com.board.model.PageDTO;

@Controller
public class BoardController {
	
	 @Autowired
	 private BoardDAO dao;
	 
	 private final int rowsize = 3;
	 private int totalRecord = 0; // DB상의 전체 게시물 수
	
	//@Inject
	//private BoardDAO dao;
	
	@RequestMapping("board_list.do")
	// 페이징 처리 작업
	public String list(Model model, HttpServletRequest request) {
		
		int page = 0;	// 현재 페이지 편수
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page").trim()); 
		}else { 
			page =1; // 처음으로 전체 게시물 목록 a태그를 선택한 경우
		}
		
		//DB상의 전체 게시물 수를 확인하는 메서드 호출
		totalRecord = this.dao.getBoardListCount();
		
		PageDTO dto = new PageDTO(page, rowsize, totalRecord);
		
		// 페이지에 해당하는 게시물을 가져오는 메서드 호출
		List<BoardDTO> pageList =  this.dao.getBoardList(dto);
		
		model.addAttribute("List", pageList);
		model.addAttribute("Paging", dto);
		
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
		
		if(check > 0) {
			out.println("<script>");
			out.println("alert('게시물 등록 성공!!!')");
			out.println("location.href='board_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('게시물 등록 실패~~')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("board_content.do")
	public String content(@RequestParam("no") int no,@RequestParam("page") int page, Model model) { 
		
		this.dao.boardHit(no);
		
		BoardDTO dto =  this.dao.getBoardCont(no);
		
		model.addAttribute("Cont", dto);
		model.addAttribute("Page", page);
		
		return "board_content";
	}
	
	@RequestMapping("board_modify.do")
	public String modify(@RequestParam("no") int no,@RequestParam("page") int page, Model model) {
		
		BoardDTO dto =  this.dao.getBoardCont(no);
		
		model.addAttribute("Modify", dto);
		model.addAttribute("Page", page);
		
		return "board_modify";
	}
	
	@RequestMapping("board_modify_ok.do")
	public void modifyOk(BoardDTO dto,@RequestParam("page") int page,@RequestParam("pwd") String pwd,
			HttpServletResponse response ) throws IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		if(pwd.equals(dto.getBoard_pwd())) {
			
			int check = this.dao.updateBoard(dto);
			
			if(check > 0) {
				out.println("<script>");
				out.println("alert('게시물 수정 성공!!!')");
				out.println("location.href='board_content.do?no="+dto.getBoard_no()+"&page="+page+"'");
				out.println("</script>");
			}else {
				out.println("<script>");
				out.println("alert('게시물 수정 실패~~')");
				out.println("history.back()");
				out.println("</script>");
			}
			
		}else {
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다. ~~')");
			out.println("history.back()");
			out.println("</script>");
		}
		}
	
		@RequestMapping("board_delete.do")
		public String delete(@RequestParam("page") int page,@RequestParam("no") int no, Model model) {
			
			BoardDTO dto =  this.dao.getBoardCont(no);
			
			model.addAttribute("dCont", dto);
			model.addAttribute("Page", page);
			
			return "board_delete";
		}
		
		@RequestMapping("board_delete_ok.do")
		public void deleteOk(BoardDTO dto, HttpServletResponse response,
				@RequestParam("page") int page,@RequestParam("pwd") String pwd) throws IOException {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			if(pwd.equals(dto.getBoard_pwd())) {
				int check = this.dao.deleteBoard(dto.getBoard_no());
				
				if(check > 0) {
					dao.updateSequence(dto.getBoard_no());
					out.println("<script>");
					out.println("alert('게시물 삭제 성공!!!')");
					out.println("location.href='board_list.do?page="+page+"'");
					out.println("</script>");
				}else {
					out.println("<script>");
					out.println("alert('게시물 삭제 실패~~')");
					out.println("history.back()");
					out.println("</script>");
				}
				
			}else {
				out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다. ~~')");
				out.println("history.back()");
				out.println("</script>");
			}
		}
		
		@RequestMapping("board_search.do")
		public String searchList(@RequestParam("field") String field,@RequestParam("keyword") String keyword,
				@RequestParam("page") int nowPage, Model model) {
			
			//DB상의 전체 게시물 수를 확인하는 메서드 호출
			totalRecord = this.dao.seatchListCount(field,keyword);
			
			PageDTO pdto = new PageDTO(nowPage, rowsize, totalRecord, field, keyword);
			
			System.out.println("검색 게시물 수 >>> "+pdto.getTotalRecord());
			
			System.out.println("검색 전체 페이지 수 >>> "+ pdto.getAllPage());
			
			// 검색 시 한페이지당 보여질 게시물 수만큼 검색한 게시물을 List로 가져오는 메서드.
			List<BoardDTO> list =  this.dao.searchBoardList(pdto);
			
			model.addAttribute("searchPageList", list);
			model.addAttribute("Paging", pdto);

			return "board_searchList";
		}
		


	
	
	
}
