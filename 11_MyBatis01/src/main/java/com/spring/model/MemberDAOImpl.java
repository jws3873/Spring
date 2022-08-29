package com.spring.model;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// String sql = null; 
	
	@Override
	public List<MemberDTO> getMemberList() {
		//all mapper에 작성하는 고유한 이름
		return this.sqlSession.selectList("all");
	}

	@Override
	public int insertMember(MemberDTO dto) {
		return this.sqlSession.insert("add", dto);
	}

	@Override
	public MemberDTO getMember(int num) {
		return this.sqlSession.selectOne("content", num);
	}

	@Override
	public int updateMember(MemberDTO dto) {
		return this.sqlSession.update("modify", dto);
	}

	@Override
	public int deleteMember(int num) {
		return this.sqlSession.delete("del", num);
	}

	@Override
	public void updateSequence(int num) {
		this.sqlSession.update("squence", num);
		
	}

	@Override
	public List<MemberDTO> searchMemberList(String field, String keyword) {
		
			return this.sqlSession.selectList(field, keyword);
	}

}
