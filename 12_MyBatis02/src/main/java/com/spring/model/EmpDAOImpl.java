package com.spring.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImpl implements EmpDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<EmpDTO> getEmpList() {
		return this.sqlSession.selectList("all");
	}

	@Override
	public List<String> getJobList() {
		return this.sqlSession.selectList("joblist");
	}

	@Override
	public List<EmpDTO> getMgrList() {
		return this.sqlSession.selectList("mgrlist");
	}

	@Override
	public List<DeptDTO> getDeptList() {
		return this.sqlSession.selectList("deptlist");
	}

	@Override
	public int insertEmp(EmpDTO dto) {
		return this.sqlSession.insert("hire", dto);
	}

	@Override
	public EmpDTO getContent(int num) {
		return this.sqlSession.selectOne("cont", num);
	}

	@Override
	public int updateEmp(EmpDTO dto) {
		return this.sqlSession.update("modify", dto);
	}

	@Override
	public int deleteEmp(int no) {
		return this.sqlSession.delete("del", no);
	}

	@Override
	public List<EmpDTO> getSearchList(String field, String keyword) {
		return this.sqlSession.selectList(field, keyword);
	}
}
