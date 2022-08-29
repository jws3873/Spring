package com.spring.jdbc02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.CategoryDTO;
import com.spring.model.ProductDAO;
import com.spring.model.productDTO;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO dao;
	
	@RequestMapping("product_list.do")
	public String list(Model model) {
		
		List<productDTO> list =  this.dao.getProductList();
		
		model.addAttribute("ProductList", list);
		
		return "product_list";
	}
	
	@RequestMapping("product_insert.do")
	public String insert(Model model) {
		List<CategoryDTO> list = this.dao.categoryList();
		model.addAttribute("CartList", list);
		return "product_insert";
	}
	
	@RequestMapping("product_insert_ok.do")
	public void insert(productDTO dto,HttpServletResponse response) throws IOException {
		
		int check = this.dao.insertProduct(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check >0) {
			out.println("<script>");
			out.println("alert('제품 등록 성공!')");
			out.println("location.href='product_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('제품 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("product_content.do")
	public String content(@RequestParam("pnum") int pnum,Model model) {
		productDTO dto = this.dao.getProductContr(pnum);
		
		model.addAttribute("Cont", dto);
		
		return "product_content";
		
	}
	
	@RequestMapping("product_modify.do")
	public String modify(@RequestParam("pnum") int pnum,Model model) {
		
		productDTO dto = this.dao.getProductContr(pnum);
		List<CategoryDTO> list = this.dao.categoryList();
		
		model.addAttribute("CartList", list);
		model.addAttribute("Modify", dto);
		
		return "product_modify";
	}
	
	@RequestMapping("product_modify_ok.do")
	public void modifyOk(productDTO dto,HttpServletResponse response) throws IOException {
		
		int check = this.dao.updateProduct(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check>0) {
			out.println("<script>");
			out.println("alert('제품수정 성공!!')");
			out.println("location.href='product_content.do?pnum="+dto.getPnum()+"'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('제품수정 실패~~')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("product_delete.do")
	public void delete(@RequestParam("pnum") int pnum,HttpServletResponse response) throws IOException {
		
		int check = this.dao.deleteProduct(pnum);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check>0) {
			this.dao.updateSeq(pnum);
			out.println("<script>");
			out.println("alert('제품삭제 성공!!')");
			out.println("location.href='product_list.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('제품삭제 실패~~')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("product_search.do")
	public String search(@RequestParam("field") String field,@RequestParam("keyword") String keyword, Model model) {
		
		List<productDTO> list =  this.dao.searchProductList(field, keyword);
		
		model.addAttribute("searchList", list);
		
		return "product_searchList";
		
	}

}
