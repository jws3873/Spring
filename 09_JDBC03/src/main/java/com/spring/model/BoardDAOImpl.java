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
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	String sql = null;

	@Override
	public int getBoardCount() {
		sql = "select count(*) from board";
		
		return this.template.queryForInt(sql);
	}

	@Override
	public List<BoardDTO> getBoardList(int page, int rowsize) {
		List<BoardDTO> list = null;
		
		final int startNo = (page*rowsize) - (rowsize-1);
		
		// 해당 페이지에서 끝 번호 
		final int endNo = (page*rowsize);
		sql  = "select *from "
				+ "(select row_number() over(order by board_no desc) rnum, b. *from board b)"
				+ " where rnum >= ? and rnum <=?";
		return list = this.template.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, startNo);
				ps.setInt(2, endNo);
			}
		}, new RowMapper<BoardDTO>() {

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_date(rs.getString("board_date"));
				dto.setBoard_update(rs.getString("board_update"));
				return dto;
			}
		});
	}

	@Override
	public int insertBoard(final BoardDTO dto) {
		
		sql = "select max(board_no) from board";
		final int count = this.template.queryForInt(sql);
		
		sql = "insert into board values(?,?,?,?,?,default,sysdate,'')";
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, count+1);
				ps.setString(2, dto.getBoard_writer());
				ps.setString(3, dto.getBoard_title());
				ps.setString(4, dto.getBoard_cont());
				ps.setString(5, dto.getBoard_pwd());
			}
		});
	}

	@Override
	public void boardHit(final int no) {
		sql = "update board set board_hit = board_hit+1 where board_no = ?";
		/*
		 * this.template.update(sql, new PreparedStatementSetter() {
		 * 
		 * @Override public void setValues(PreparedStatement ps) throws SQLException {
		 * ps.setInt(1, no); } });
		 */
		this.template.update(sql, no);
	}

	@Override
	public BoardDTO getBoardCont(int no) {

		sql = "select *from board where board_no = ?";
		return this.template.queryForObject(sql, new RowMapper<BoardDTO>() {

			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_date(rs.getString("board_date"));
				dto.setBoard_update(rs.getString("board_update"));
				return dto;
			}
		}, no);
	}

	@Override
	public int boardUpdate(final BoardDTO dto) {

		sql = "update board set board_title = ?, board_cont = ?,"
				+ "board_update = sysdate where board_no = ?";
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getBoard_title());
				ps.setString(2, dto.getBoard_cont());
				ps.setInt(3, dto.getBoard_no());
			}
		});
	}

	@Override
	public int deleteBoard(final int no) {
		sql = "delete from board where board_no = ?";
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, no);
				
			}
		});
	}

	@Override
	public int searchListCount(String field, String keyword) {
		int result=0;
		if(field.equals("title")) {
			sql = "select count(*) from board where board_title like ?";
			result = this.template.queryForInt(sql, "%"+keyword+"%");
		}else if(field.equals("content")){
			sql = "select count(*) from board where board_content like ?";
			result = this.template.queryForInt(sql, "%"+keyword+"%");
		}else {
			sql = "select count(*)from board where board_title like ? or board_cont like ?";
			result = this.template.queryForInt(sql, "%"+keyword+"%","%"+keyword+"%");
		}
		return result;
	}

	@Override
	public List<BoardDTO> searchBoardList(String field, final String keyword, int page, int rowsize) {
		List<BoardDTO> list = null;
		
		// 해당 페이지에서 시작번호
		final int startNo = (page*rowsize)-(rowsize-1);
		final int endNo = (page*rowsize);
		
		if(field.equals("title")) {
			sql = "select *from "
					+ "(select row_number()"
					+ "over(order by board_no desc) rnum,"
					+ "b.*from board b where board_title like ?)"
					+ "where rnum >= ? and rnum <= ?";
			list = this.template.query(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, "%"+keyword+"%");
					ps.setInt(2, startNo);
					ps.setInt(3, endNo);
				}
			}, new RowMapper<BoardDTO>() {

				@Override
				public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					BoardDTO dto = new BoardDTO();
					dto.setBoard_no(rs.getInt("board_no"));
					dto.setBoard_writer(rs.getString("board_writer"));
					dto.setBoard_title(rs.getString("board_title"));
					dto.setBoard_cont(rs.getString("board_cont"));
					dto.setBoard_pwd(rs.getString("board_pwd"));
					dto.setBoard_hit(rs.getInt("board_hit"));
					dto.setBoard_date(rs.getString("board_date"));
					dto.setBoard_update(rs.getString("board_update"));
					return dto;
				}
			});
		}else if(field.equals("content")){
			sql = "select *from "
					+ "(select row_number()"
					+ "over(order by board_no desc) rnum,"
					+ "b.*from board b where board_content like ?)"
					+ "where rnum >= ? and rnum <= ?";
			list = this.template.query(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, "%"+keyword+"%");
					ps.setInt(2, startNo);
					ps.setInt(3, endNo);
				}
			}, new RowMapper<BoardDTO>() {

				@Override
				public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					BoardDTO dto = new BoardDTO();
					dto.setBoard_no(rs.getInt("board_no"));
					dto.setBoard_writer(rs.getString("board_writer"));
					dto.setBoard_title(rs.getString("board_title"));
					dto.setBoard_cont(rs.getString("board_cont"));
					dto.setBoard_pwd(rs.getString("board_pwd"));
					dto.setBoard_hit(rs.getInt("board_hit"));
					dto.setBoard_date(rs.getString("board_date"));
					dto.setBoard_update(rs.getString("board_update"));
					return dto;
				}
			});
			
		}else {
			sql = "select *from "
					+ "(select row_number()"
					+ "over(order by board_no desc) rnum,"
					+ "b.*from board b where board_title like ? or board_cont like ?) "
					+ "where rnum >= ? and rnum <= ?";
			list = this.template.query(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, "%"+keyword+"%");
					ps.setString(2, "%"+keyword+"%");
					ps.setInt(3, startNo);
					ps.setInt(4, endNo);
				}
			}, new RowMapper<BoardDTO>() {

				@Override
				public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					BoardDTO dto = new BoardDTO();
					dto.setBoard_no(rs.getInt("board_no"));
					dto.setBoard_writer(rs.getString("board_writer"));
					dto.setBoard_title(rs.getString("board_title"));
					dto.setBoard_cont(rs.getString("board_cont"));
					dto.setBoard_pwd(rs.getString("board_pwd"));
					dto.setBoard_hit(rs.getInt("board_hit"));
					dto.setBoard_date(rs.getString("board_date"));
					dto.setBoard_update(rs.getString("board_update"));
					return dto;
				}
			});
		}
		return list;
	}

	@Override
	public void boardSequence(final int no) {
		sql = "update board set board_no = board_no -1 where board_no > ?";
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, no);
				
			}
		});
	}

}
