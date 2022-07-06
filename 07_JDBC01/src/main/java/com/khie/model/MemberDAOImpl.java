package com.khie.model;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
// 스프링에서 일반적으로 DAO 클래스에 적용되는 애노테이션 
//외부I/O 처리 : @Repository (퍼시스턴스 레이어, DB나 파일같은 외부 I/O 작업을 처리함)
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired 
	// 자동으로 의존관계를 설정해 주는 에노테이션
	// 무조건 객체에 대한 의존을 주입해 주는 에노테이션.
	private JdbcTemplate template; //root xml 참조변수와 같은 이름을 사용해 준다.
	
	String sql = null; 
	
	@Override
	// MEMBER10 테이블에서 전체 회원 목록을 조회하는 메서드.
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> list = null;
		
		sql = "select *from member10 order by num desc";
		
		return list = this.template.query(sql, new RowMapper<MemberDTO>() {

			@Override
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MemberDTO dto = new MemberDTO();
				dto.setNum(rs.getInt("num"));
				dto.setMemid(rs.getString("memid"));
				dto.setMemname(rs.getString("memname"));
				dto.setPwd(rs.getString("pwd"));
				dto.setAge(rs.getInt("age"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setJob(rs.getString("job"));
				dto.setAddr(rs.getString("addr"));
				dto.setRegdate(rs.getString("regdate"));
				return dto;
			}
		});
	}

	@Override
	// MEMBER10 테이블에 회원을 등록하는 메서드.
	public int insertMember(final MemberDTO dto) {
		
		sql = "select max(num) from member10";
		
		final int count =  this.template.queryForInt(sql);
		
		sql = "insert into member10 values(?,?,?,?,?,?,?,?,sysdate)";
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				//이너클래스가 바깥쪽에 있는 정보를 변경할 수 있기 때문에 final타입이 필요
				ps.setInt(1, count+1);
				ps.setString(2, dto.getMemid());
				ps.setString(3, dto.getMemname());
				ps.setString(4, dto.getPwd());
				ps.setInt(5, dto.getAge());
				ps.setInt(6, dto.getMileage());
				ps.setString(7, dto.getJob());
				ps.setString(8, dto.getAddr());
				
			}
		});
	
		
		
	}

	@Override
	public MemberDTO getMember(int num) {
		
		sql ="select *from member10 where num = ?";
		
		return this.template.queryForObject(sql, new RowMapper<MemberDTO>() {

			@Override
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDTO dto = new MemberDTO();
				dto.setNum(rs.getInt("num"));
				dto.setMemid(rs.getString("memid"));
				dto.setMemname(rs.getString("memname"));
				dto.setPwd(rs.getString("pwd"));
				dto.setAge(rs.getInt("age"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setJob(rs.getString("job"));
				dto.setAddr(rs.getString("addr"));
				dto.setRegdate(rs.getString("regdate"));
				return dto;
			}
		}, num);
	}

	@Override
	public int updateMember(final MemberDTO dto) {
		
		sql = "update member10 set age = ?, mileage = ?, "
				+ "job = ?, addr = ? where num = ?";
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, dto.getAge());
				ps.setInt(2,dto.getMileage());
				ps.setString(3, dto.getJob());
				ps.setString(4, dto.getAddr());
				ps.setInt(5, dto.getNum());
			}
		});
	}

	@Override
	public int delteMember(final int num) {
		
		sql = "delete from member10 where num = ?";
		return this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, num);
			}
		});
	}

	@Override
	public void updateSequence(final int num) {
		sql = "update member10 set num = num - 1 where num > ?";
		
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, num);
			}
		});
	}

	@Override
	public List<MemberDTO> searchMemberList(String field, final String keyword) {
		List<MemberDTO> searchList = null;
		
		if(field.equals("id")) {
			sql = "select *from member10 where memid like ? order by num desc";
			searchList = this.template.query(sql, new RowMapper<MemberDTO>() {

				@Override
				public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MemberDTO dto = new MemberDTO();
					dto.setNum(rs.getInt("num"));
					dto.setMemid(rs.getString("memid"));
					dto.setMemname(rs.getString("memname"));
					dto.setPwd(rs.getString("pwd"));
					dto.setAge(rs.getInt("age"));
					dto.setMileage(rs.getInt("mileage"));
					dto.setJob(rs.getString("job"));
					dto.setAddr(rs.getString("addr"));
					dto.setRegdate(rs.getString("regdate"));
					return dto;
				}
			}, "%"+keyword+"%");
		}else if(field.equals("name")) {
			sql = "select *from member10 where memname like ? order by num desc";
			searchList = this.template.query(sql, new RowMapper<MemberDTO>() {

				@Override
				public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MemberDTO dto = new MemberDTO();
					dto.setNum(rs.getInt("num"));
					dto.setMemid(rs.getString("memid"));
					dto.setMemname(rs.getString("memname"));
					dto.setPwd(rs.getString("pwd"));
					dto.setAge(rs.getInt("age"));
					dto.setMileage(rs.getInt("mileage"));
					dto.setJob(rs.getString("job"));
					dto.setAddr(rs.getString("addr"));
					dto.setRegdate(rs.getString("regdate"));
					return dto;
				}
			}, "%"+keyword+"%");
		}else if(field.equals("job")){
			sql = "select *from member10 where job like ? order by num desc";
			searchList = this.template.query(sql, new RowMapper<MemberDTO>() {

				@Override
				public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MemberDTO dto = new MemberDTO();
					dto.setNum(rs.getInt("num"));
					dto.setMemid(rs.getString("memid"));
					dto.setMemname(rs.getString("memname"));
					dto.setPwd(rs.getString("pwd"));
					dto.setAge(rs.getInt("age"));
					dto.setMileage(rs.getInt("mileage"));
					dto.setJob(rs.getString("job"));
					dto.setAddr(rs.getString("addr"));
					dto.setRegdate(rs.getString("regdate"));
					return dto;
				}
			}, "%"+keyword+"%");
		}else {
			sql = "select *from member10 where memid like ? or memname like ? order by num desc";
			searchList = this.template.query(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, "%"+keyword+"%");
					ps.setString(2, "%"+keyword+"%");
					
				}
			}, new RowMapper<MemberDTO>() {

				@Override
				public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MemberDTO dto = new MemberDTO();
					dto.setNum(rs.getInt("num"));
					dto.setMemid(rs.getString("memid"));
					dto.setMemname(rs.getString("memname"));
					dto.setPwd(rs.getString("pwd"));
					dto.setAge(rs.getInt("age"));
					dto.setMileage(rs.getInt("mileage"));
					dto.setJob(rs.getString("job"));
					dto.setAddr(rs.getString("addr"));
					dto.setRegdate(rs.getString("regdate"));
					return dto;
				}
			});
		}
		
		return searchList;
		
	}

}
