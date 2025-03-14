package com.kh.mhp.member.model.service;

import com.kh.mhp.member.model.dao.MemberDAO;
import com.kh.mhp.member.model.dto.MemberDTO;

public class MemberService {
	
	public MemberDTO loginMember(MemberDTO member) {
		
		MemberDTO loginMember = new MemberDAO().loginMember(member);
		return loginMember;
	}
}
