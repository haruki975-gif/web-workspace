package com.kh.mhp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mhp.member.model.dto.MemberDTO;
import com.kh.mhp.member.model.service.MemberService;

@WebServlet("/sign-up")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("email");
		
		MemberDTO member = new MemberDTO(memberId, memberPw, memberName, memberEmail, null);
		
		int result = new MemberService().signUp(member);
		String path = request.getContextPath();
		
		if(result == 0) {
			request.getSession().setAttribute("message", "중복된 아이디입니다. 다른 아이디를 입력해주세요.");
		}
		response.sendRedirect(result != 0 ? path + "/join" : path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
