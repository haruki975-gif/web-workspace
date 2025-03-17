package com.kh.mhp.member.model.service;

import org.apache.ibatis.session.SqlSession;
import static com.kh.mhp.common.Template.getSqlSession;

import com.kh.mhp.member.model.dao.MemberDAO;
import com.kh.mhp.member.model.dto.MemberDTO;

public class MemberService {
	
	// 로그인
	public MemberDTO login(MemberDTO member) {
		
		SqlSession sqlSession = getSqlSession();
		
		MemberDTO loginMember = new MemberDAO().login(sqlSession, member);
		
		sqlSession.close();
		return loginMember;
	}
	
	
	// 회원가입
	public int signUp(MemberDTO member) {
		SqlSession sqlSession = getSqlSession();
		
		if(new MemberDAO().checkId(sqlSession, member.getMemberId())) {
			sqlSession.close();
			return 0;
		}
		int result = new MemberDAO().signUp(sqlSession, member);
		
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
}
