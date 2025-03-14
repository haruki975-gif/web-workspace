package com.kh.mfw.member.model.service;

import org.apache.ibatis.session.SqlSession;

// 앞에 static 붙여주고 뒤에 .클래스명 적어줌
import static com.kh.mfw.common.Template.getSqlSession;

import com.kh.mfw.member.model.dao.MemberDAO;
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {
	
	public MemberDTO login(MemberDTO member) {
		
		// JDBCUtil 클래스로부터
		// static Method로 구현해놓은
		// getConnection 메서드를 호출하여
		// Connection 객체를 반환받음
		SqlSession sqlSession = getSqlSession(); // static은 참조연산자로(=직접접근 연산자)
		
		// DAO의 메서드 호출 = DAO객체와의 상호작용
		// 유효성 검증 => 패스(원래 해야됨)
		new MemberDAO().login(sqlSession, member);
		
		
		return null;
	}
	
}
