package com.kh.mfw.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberDAO {
	
	// DB와의 직접적인 상호작용 == 영속성 작업
	
	static {
		// FullClassName (패키지네임부터 클래스네임까지)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public MemberDTO login(MemberDTO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = """
				SELECT
					  MEMBER_ID
					, MEMBER_PW
					, MEMBER_NAME
					, EMAIL
					, ENROLL_DATE
				FROM 
					  KH_MEMBER
				WHERE 
					  MEMBER_ID = ?
				  AND 
					  MEMBER_PW = ?
				""";
		
		MemberDTO loginMember = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@112.221.156.34:12345:XE", "KH17_LEB", "KH1234");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			
			rset = pstmt.executeQuery();
			
			// 사용자가 입력한 조회 결과가 1행으로 존재한다
			// {} > block scope로 표현
			if(rset.next()) {
				loginMember = new MemberDTO(
						rset.getString("MEMBER_ID"),
						rset.getString("MEMBER_PW"),
						rset.getString("MEMBER_NAME"),
						rset.getString("EMAIL"),
						rset.getDate("ENROLL_DATE")
						);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) rset.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return loginMember;
		
	}
}
