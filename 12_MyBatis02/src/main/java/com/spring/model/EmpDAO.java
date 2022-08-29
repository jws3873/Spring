package com.spring.model;

import java.util.List;

public interface EmpDAO {
	List<EmpDTO> getEmpList();
	List<String> getJobList();
	List<EmpDTO> getMgrList();
	List<DeptDTO> getDeptList();
	int insertEmp(EmpDTO dto);
	EmpDTO getContent(int num);
	int updateEmp(EmpDTO dto);
	int deleteEmp(int no);
	List<EmpDTO> getSearchList(String field,String keyword);
}
