<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
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
	
	<c:if test="${ 1 gt 2 }">
		<strong>1이 2보다 큽니다.</strong>
	</c:if>
	
	<c:if test="${ '안녕하세요' ne '반갑습니다' }">
		<mark>안녕하세요와 반갑습니다는 같지 않습니다.</mark>
	</c:if>
	
	<hr>
	
	<h3>2) choose, when, otherwise</h3>
	<!-- 
		point라는 키값으로 Value가 넘어옴
		
		포인트 사용량이 100이하라면 일반회원이라고 출력해주고 싶음
		포인트 사용량이 300이하라면 우수회원이라고 출력해주고 싶음
		요 앞에 두 케이스에 걸리지 않을 시 최우수회원이라고 출력해주고 싶음
	 -->
	<c:choose>
		<c:when test="${ point le 100 }">
			일반회원<br/>
		</c:when>
		<c:when test="${ point le 300 }">
			<label style="color:gold">우수회원</label><br/>
		</c:when>
		<c:otherwise>
			<mark style="color:white; background:blue">최우수회원</mark><br/>
		</c:otherwise>
	</c:choose>
	
	<hr>
	
	<h3>3) 반복문 - forEach </h3>
	
	<pre>
		<!-- 
			for(let i=0; i<10; i++){
			
			} 
		
		
			for(let i in list){
			
			}
			
			머시기.map(e => {
			
			});
			
			반복문 돌리면서 조건검사
			머시기.filter(e => {
			
			});
		-->
		
		[ 표현법 ]
		for loop문
		&lt;c:forEach var="속성명" begin="초기값" end="끝값" step="증가시킬값(생략가능)" &gt;
			반복적으로 실행할 내용
		&lt;c:/forEach&gt;
		
		&lt;c:forEach var="속성명" items="순차적으로 접근할 배열 또는 컬렉션" &gt;
			반복적으로 실행할 내용
		&lt;c:/forEach&gt;
	</pre>
	
	<c:forEach var="i" begin="0" end="9">
		${ i }
	</c:forEach>
	
	<br/>

	<c:forEach var="i" begin="1" end="6">
		<h${i}>이런것도가능</h>
	</c:forEach>
	
	<hr>
	
	<!-- 
	for(String color : colors){
		System.out.println(color);
	}
	 -->
	 
	 <ul>
		 <c:forEach var="c" items="${ colors }">
		 	<li style="color:${c}">${ c }</li>
		 </c:forEach>
	</ul>
	
	<hr>
	
	<h3>회원 목록</h3>
	
	<!-- 
		caption : 표 제목 
		thead(컬럼명), tbody(본문), tfoot(통계) : 표 구조
		tr(행)
		th(컬럼명...), td(데이터)
	 -->
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>가입일</th>
			</tr>
		</thead>
		
		<tbody>
		
			<!-- 조회결과가 있는가 없는가 -->
			<!-- 
				조건식 만들 때 필요한 것
				최소 1개 이상의 "값" -> 이거 뭔값임?
			 -->
			<c:choose>
				<%-- <c:when test="${ requestScope.users.size() != 0 }"> --%>
				<c:when test="${ empty requestScope.users }">
					<tr>
						<td colspan="4">조회 결과가 존재하지 않습니다.</td>
					</tr>
				</c:when>
				
				<c:otherwise>
					<c:forEach items="${ requestScope.users }" var="user">
						<tr>
							<td>${ user.userNo }</td>
							<td>${ user.userName }</td>
							<td>${ user.userId }</td>
							<td>${ user.enrollDate }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	
	
	<button type="button" class="btn">Basic</button>
	<button type="button" class="btn btn-primary">Primary</button>
	<button type="button" class="btn btn-secondary">Secondary</button>
	<button type="button" class="btn btn-success">Success</button>
	<button type="button" class="btn btn-info">Info</button>
	<button type="button" class="btn btn-warning">Warning</button>
	<button type="button" class="btn btn-danger">Danger</button>
	<button type="button" class="btn btn-dark">Dark</button>
	<button type="button" class="btn btn-light">Light</button>
	<button type="button" class="btn btn-link">Link</button>
	
	
	
	
	
	




</body>
</html>