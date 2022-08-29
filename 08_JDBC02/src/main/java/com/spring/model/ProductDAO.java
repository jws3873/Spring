package com.spring.model;

import java.util.List;
import java.util.Locale.Category;

public interface ProductDAO {
	List<productDTO> getProductList();
	int insertProduct(productDTO dto);
	productDTO getProductContr(int pnum);
	int updateProduct(productDTO dto);
	int deleteProduct(int pnum);
	void updateSeq(int pnum);
	List<productDTO> searchProductList(String field,String keyword);
	List<CategoryDTO> categoryList();
}
