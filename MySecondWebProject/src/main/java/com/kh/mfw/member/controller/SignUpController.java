package com.kh.mfw.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mfw.member.model.dto.MemberDTO;
import com.kh.mfw.member.model.service.MemberService;

@WebServlet("/sign-up")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩설정 > POST방식이라서 해야함
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("memberId");
		String memberPW = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String email = request.getParameter("email");
		
		MemberDTO member = new MemberDTO(memberId, memberPW, memberName, email, null);
		
		// Controller : 요청 처리 -> 사용자가 입력한 값들을 저 멀리있는 DB서버의 KH_MEMBER 테이블에 한 행 INSERT
		// MemberDTO 타입의 주소값
		int result = new MemberService().signUp(member);
		
		// 중복되는 부분 변수로 빼기 (자료형 살펴보기)
		String path = request.getContextPath();
		/*
			if(result != 0) {
				// 실패했을 경우 => 회원가입페이지로 이동
				// 유지보수가 용이해짐 => 왜? => 고쳐야할 부분이 늘어남
				// request.getRequestDispatcher("/WEB-INF/views/member/enroll_page.jsp").forward(request, response);
				// response.sendRedirect(request.getContextPath() + "/join");
				path = request.getContextPath() + "/join";
			}else {
				// 성공했을 경우 => 웰컴페이지로 이동
				// response.sendRedirect(request.getContextPath());
				path = request.getContextPath();
			}
		*/
		// "중복된 아이디가 존재합니다. 다른 아이디를 입력해주세요."
		// 이거 못씀 : request.setAttribute("message", "중복된 아이디가 존재합니다. 다른 아이디를 입력해주세요.");
		if(result == 0) {
			request.getSession().setAttribute("message", "중복된 아이디가 존재합니다. 다른 아이디를 입력해주세요.");
		}
		
		response.sendRedirect(result != 0 ? path + "/join" : path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
