<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSTL이란...?</h1>

	<p>
		JSP(자바_서버_페이지) Standard(표준) Tag Library의 약어 <br>
		JSP에서 사용할 수 있는 커스텀 액션 태그 <br>
		공통적으로 사용해야하는 코드들을 보다 쉽게 사용할 수 있도록 태그화해서 표준으로 제공하는 라이브러리
	</p>
	
	<hr>
	
	<p>
		JSTL을 사용하기 위해선 먼저 라이브러리를 추가해준 후<br/>
		JSTL을 사용하고자 하는 JSP페이지 상단에 선언을 해 주어야함!! <br/>
	</p>
	
	
	<% if(false) { %>
		ABCDE
	<% } %>
	
	
	<h2>Core 라이브러리 실전압축 핵심요약 빠르게 배우고 넘어가기</h2>
	
	<p>
		if라는 태그를 작성하여 조건문을 만들어낼 수 있음!<br/>
		- Java에서의 단일 if문과 똑같은 역할을 할 수 있는 태그 <br/>
		- 조건식(true, false => 비교연산)은 test라는 속성의 값으로 작성 <br/>
		- 조건식을 만들 때 반드시 EL구문으로 작성.........
	</p>
	
	<c:if test="${ 1 lt 2 }">
		<strong>1이 2보다 작습니다.</strong>
	</c:if>
	
	
	
	
	
	
	
	
	





</body>
</html>