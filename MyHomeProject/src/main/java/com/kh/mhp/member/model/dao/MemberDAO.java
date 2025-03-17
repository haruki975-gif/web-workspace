package com.kh.mhp.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mhp.member.model.dto.MemberDTO;

public class MemberDAO {
	
	// 로그인
	public MemberDTO login(SqlSession sqlSession, MemberDTO member) {
		return sqlSession.selectOne("memberMapper.login", member);
	}
	
	// 아이디 체크
	public boolean checkId(SqlSession sqlSession, String memberId) {
		return (Integer)sqlSession.selectOne("memberMapper.checkId", memberId) > 0 ? true : false;
	}
	
	// 회원가입
	public int signUp(SqlSession sqlSession, MemberDTO member) {
		return sqlSession.insert("memberMapper.signUp", member);
	}
	
}
