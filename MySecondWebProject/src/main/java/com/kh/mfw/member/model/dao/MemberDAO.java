package com.kh.mfw.member.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.kh.mfw.member.model.dto.MemberDTO;
public class MemberDAO {
	
	// SqlSession > Connection, PreparedStatement 역할을 함
	public MemberDTO login(SqlSession sqlSession, MemberDTO member) {
		
		// SqlSession이 제공하는 메서드를 통해 SQL문을 찾아서 실행하고 결과를 받을 수 있음
		// sqlSession.sql문 종류에 맞는 메서드("mapper파일의 namespace.sql문의 id속성값");
		//MemberDTO loginMember = sqlSession.selectOne("memberMapper.login", member);
		//System.out.println(loginMember.toString());
		
		return sqlSession.selectOne("memberMapper.login", member);
	}
	
	
	// 아이디 중복 체크
	public boolean checkId(SqlSession sqlSession, String memberId) {
		/*
		 * int result = sqlSession.selectOne("memberMapper.checkId", memberId);
		 * 
		 * if(result > 0) { return true; } else { return false; }
		 */
		return (Integer)sqlSession.selectOne("memberMapper.checkId", memberId) > 0 ? true : false;
		
	}
	
	
	// 아이디 중복 없으면 INSERT
	public int signUp(MemberDTO member) {
		
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
