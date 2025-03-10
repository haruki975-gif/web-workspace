package com.kh.mcdonald.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sc")
public class SettingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SettingController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("잘 나옴?");
		
		// Servlet에서 응답데이터가 있는데?
		// JSP에게 보내줘야함! --> request에 담아서
		// Servlet 내장 객체 / Scope 객체
		
		// Application / Session / Request / Page => 저장소(=값을 담음)
		
		/*
		 * 1. ServletContext (Application Scope)
		 * 하나의 애플리케이션(응용프로그램) 당, 딱 한 개 존재하는 객체
		 * 
		 * 
		 * 2. HttpSession (Session Scope)
		 * 
		 * 
		 * 3. HttpServletRequest (Request Scope) > 요청을 받았을 때 만들어짐
		 * 요청 시 매번 생성되는 객체
		 * 이 영역에 데이터를 담으면 해당 request 객체를 포워딩 받는 응답 JSP에서만 사용가능(1회용)
		 */
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
