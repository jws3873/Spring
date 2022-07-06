package com.spring.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	String sql = null;
	
	@Override
	public List<productDTO> getProductList() {
		List<productDTO> list = null;
		
		sql = "select *from products order by pnum desc";
		
		return list = this.template.query(sql, new RowMapper<productDTO>() {

			@Override
			public productDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				productDTO dto = new productDTO();
				
				dto.setPnum(rs.getInt("pnum"));
				dto.setCategory_fk(rs.getString("category_fk"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setEp_code_fk(rs.getString("ep_code_fk"));
				dto.setInput_price(rs.getInt("input_price"));
				dto.setOutput_price(rs.getInt("output_price"));
				dto.setTrans_cost(rs.getInt("trans_cost"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setCompany(rs.getString("company"));
				return dto;
			}
		});
	}

	@Override
	public int insertProduct(final productDTO dto) {
		
		sql = "select max(pnum) from products";
		final int count = this.template.queryForInt(sql);
		
		sql = "insert into products values(?,?,?,?,?,?,?,?,?)";
		return this.template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, count+1);
				ps.setString(2, dto.getCategory_fk());
				ps.setString(3, dto.getProduct_name());
				ps.setString(4, dto.getEp_code_fk());
				ps.setInt(5, dto.getInput_price());
				ps.setInt(6, dto.getOutput_price());
				ps.setInt(7, dto.getTrans_cost());
				ps.setInt(8, dto.getMileage());
				ps.setString(9, dto.getCompany());
			}
		});
	}

	@Override
	public productDTO getProductContr(int pnum) {
		
		sql="select *from products where pnum = ? ";
		return this.template.queryForObject(sql, new RowMapper<productDTO>() {

			@Override
			public productDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				productDTO dto = new productDTO();
				
				dto.setPnum(rs.getInt("pnum"));
				dto.setCategory_fk(rs.getString("category_fk"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setEp_code_fk(rs.getString("ep_code_fk"));
				dto.setInput_price(rs.getInt("input_price"));
				dto.setOutput_price(rs.getInt("output_price"));
				dto.setTrans_cost(rs.getInt("trans_cost"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setCompany(rs.getString("company"));
				return dto;
			}
		}, pnum);
	}

	@Override
	public int updateProduct(final productDTO dto) {
		
		sql = "update products set input_price = ?, output_price = ?, "
				+ "trans_cost = ?, mileage = ? where pnum = ?";
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, dto.getInput_price());
				ps.setInt(2, dto.getOutput_price());
				ps.setInt(3, dto.getTrans_cost());
				ps.setInt(4, dto.getMileage());
				ps.setInt(5, dto.getPnum());
			}
		});
		
	}

	@Override
	public int deleteProduct(final int pnum) {

		sql = "delete from products where pnum = ?";
		
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, pnum);
			}
		});
	
	}

	@Override
	public void updateSeq(final int pnum) {
		
		sql = "update products set pnum = pnum -1 where pnum > ?";
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, pnum);
			}
		});

	}

	@Override
	public List<productDTO> searchProductList(String field, String keyword) {
		List<productDTO> searchList = null;
		
		if(field.equals("product_name")) {
			
			sql = "select *from products where product_name like ? order by pnum desc";
			searchList = this.template.query(sql, new RowMapper<productDTO>() {

				@Override
				public productDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					productDTO dto = new productDTO();
					dto.setPnum(rs.getInt("pnum"));
					dto.setCategory_fk(rs.getString("category_fk"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setEp_code_fk(rs.getString("ep_code_fk"));
					dto.setInput_price(rs.getInt("input_price"));
					dto.setOutput_price(rs.getInt("output_price"));
					dto.setTrans_cost(rs.getInt("trans_cost"));
					dto.setMileage(rs.getInt("mileage"));
					dto.setCompany(rs.getString("company"));
					return dto;
				}
			}, "%"+keyword+"%");
		}else {
			sql = "select *from products where company like ? order by pnum desc";
			searchList = this.template.query(sql, new RowMapper<productDTO>() {

				@Override
				public productDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					productDTO dto = new productDTO();
					dto.setPnum(rs.getInt("pnum"));
					dto.setCategory_fk(rs.getString("category_fk"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setEp_code_fk(rs.getString("ep_code_fk"));
					dto.setInput_price(rs.getInt("input_price"));
					dto.setOutput_price(rs.getInt("output_price"));
					dto.setTrans_cost(rs.getInt("trans_cost"));
					dto.setMileage(rs.getInt("mileage"));
					dto.setCompany(rs.getString("company"));
					return dto;
				}
			}, "%"+keyword+"%");
		}
		
		return searchList;
	}

	@Override
	public List<CategoryDTO> categoryList() {
		List<CategoryDTO> list = null;
		
		sql = "select *from category order by cnum desc";
		
		return list = this.template.query(sql, new RowMapper<CategoryDTO>() {

			@Override
			public CategoryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				CategoryDTO dto = new CategoryDTO();
				dto.setCnum(rs.getInt("cnum"));
				dto.setCategory_code(rs.getString("category_code"));
				dto.setCategory_name(rs.getString("category_name"));
				return dto;
			}
		});
	}

}
