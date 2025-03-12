package com.kh.mfw.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mfw.member.model.dto.MemberDTO;
import com.kh.mfw.member.model.service.MemberService;

@WebServlet("/sign-in")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 절차
		// 1) GET? / POST? => 요청 전송방식이 POST라면 인코딩 작업
		// setter란? 필드값을 변경하기 위한 메서드
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청값이 있나? 없나? => 있다면 값을 뽑아서 가공
		// request.getParameter("input요소의 name속성");
		//						ㄴ이게 100% 무조건 input요소의 name속성값을 적는 것은 아님
		// memberId, memberPw
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		// System.out.printf("입력한 아이디값 : %s / 입력한 비밀번호값 : %s", userId, userPw);
		// 입력한 아이디값 : admin / 입력한 비밀번호값 : 1234
		
		// 3) 값이 두 개 이상일 경우 어딘가에 예쁘게 담기
		MemberDTO member = new MemberDTO();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		// MemberDTO의 주소값 => 메모리에 올라가 있어야 데이터를 넘길 수 있음 
		// => 서비스를 메모리에 올리려면 객체생성!
		// 객체간의 상호작용 == 메서드호출
		MemberDTO loginMember = new MemberService().login(member);
		// MemberDTO처럼 생긴 무언가가 돌아옴
		// case 1. 아이디와 비밀번호값이 일치했다면
		// 		   필드값에 회원정보가 담겨있는 MemberDTO객체의 주소값
		// case 2. 유효성 검증에 통과하지 못했거나, 아이디 또는 비밀번호가 일치하지 않았다면
		// 		   null 반환
		// System.out.println(loginMember);
		
		// 4) 응답화면 만들기
		// 조건식에 쓸 값부터 담아서 넘겨주기
		// request.setAttribute("loginMember", loginMember);
		
		/*
		 * 로그인에 성공했다면,
		 * 로그인 한 회원의 정보를
		 * 로그아웃 요청이 들어오거나, 브라우저를 종료하기 전까지는
		 * 계속 사용할 수 있어야 하기 때문에,
		 * Session이라는 저장소에 값을 담아둘 것.
		 */
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
		
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
