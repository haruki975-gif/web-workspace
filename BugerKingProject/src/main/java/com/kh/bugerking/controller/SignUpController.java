package com.kh.bugerking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.bugerking.model.dto.UserDTO;

@WebServlet("/sign-up.do")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post에서 나를 부름");
		
		/*
		 * 컨트롤러
		 * 
		 * 1. request 객체로부터 값을 뽑아서 DTO로 가공
		 * 2. 요청 처리(Service) -> 패스
		 * 3. View 처리
		 */
		// POST방식일 경우 인코딩 설정 ISO-8859-1방식으로 바뀌기 때문에~~
		// 값을 뽑기 전에 UTF-8방식으로 변경해주어야함~~~!!!!
		request.setCharacterEncoding("UTF-8");
		
		// 값 뽑기
		// request.getParameter("input 요소의 name 속성값");
		String userId = request.getParameter("userId");
		System.out.println(userId);
		String userPw = request.getParameter("userPw");
		System.out.println(userPw);
		String userName = request.getParameter("userName");
		System.out.println(userName);
		
		UserDTO user = new UserDTO(userId, userPw, userName);
		
		// service.inserMember(user); 잘가~~
		// 잘 다녀왔다고 가정
		// Service -> DAO -> DB
		// : int return 받음
		
		// View 처리
		// 프레젠테이션 로직과 비즈니스로직 분리
		
		// JSP를 이용해서 응답데이터 만들기
		
		// JSP : Java 기반의 서버 사이드 스크립트 언어
		// ASP, PHP
		// * Java 코드와 HTML을 분리하기 위한 기술
		
		// 응답페이지를 JSP에게 위임(배정)
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("호출됨?");
		
		doGet(request, response);
	}

}
