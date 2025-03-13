package com.kh.mfw.member.model.service;

import com.kh.mfw.member.model.dao.MemberDAO;
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {

	// 사용자가 입력한 아이디/비밀번호 값을 담은 MemberDTO의 주소값 필요
	// 어떤 데이터가 넘어올지는 모르지만 자료형은 알고있음
	public MemberDTO login(MemberDTO member) {
		
		/*
		 * 로그인: 
		 * * DB에 가서 SELECT절에 사용자가 입력한 아이디값과 비밀번호값을 
		 *   조건절에 사용해서 조회를 하는 절차
		 * ID가 틀리거나 PW가 틀려서 로그인에 실패할 수 있는 가능성이 있음
		 * 
		 * member.getMemberId().length() > 10
		 * 
		 * 						!.matches("/^[A-Za-z0-1)/")
		 * member.getMemberId().equals("")
		 * 
		 * DB에 갈 필요가 없는 거 아님?
		 * 서비스단에서 유효성검사하기(Validation)
		 * 
		 * 하나의 DAO 메서드는 하나의 SQL문을 수행함
		 */
		MemberDTO loginMember = new MemberDAO().login(member);
		return loginMember;
	}
	
	
	// INSERT 된 회원의 정보를 담아서 돌아가는게 좋음
	// int(SQLException, 성공실패여부 알려줌)/void 두 타입
	// DB에서 처리된 1행 또는 0행이 돌아옴
	// 유효성 검사 + 검증하기 후 > 무조건 성공! (반환할 값이 없음!)
	public int signUp(MemberDTO member) {
		
		// id 중복 검사 > DAO > 메모리에 올라가 있어야 함 > 객체 생성 후 메서드 호출
		int result = new MemberDAO().checkId(member.getMemberId());
		
		// 중복되면 1이라는 정수값이 돌아감 / 아니면 0이라는 정수값이 돌아감
		// 0이 돌아갔다면 성공, 1이면 실패
		if(result > 0) {
			return result;
		}
		
		new MemberDAO().signUp(member);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
