package com.khie.model;

import java.util.List;


public interface MemberDAO {
	
	// 추상메서드
	List<MemberDTO> getMemberList();
	int insertMember(MemberDTO dto);
	MemberDTO getMember(int num);
	int updateMember(MemberDTO dto);
	int delteMember(int num);
	void updateSequence(int num);
	List<MemberDTO> searchMemberList(String field,String keyword);
}
