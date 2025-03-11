<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//String brand = (String)request.getAttribute("brand");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이게 굉장히 중요함</title>
</head>
<body>

	<%-- <%= brand %> --%><br/>
	<!-- EL구문 -->
	${ brand } <br/>
	${ bestSeller }
	
	<ul>
	<!-- 
		.brand, .name, .price처럼 실제로 필드에 직접 접근하는 게 아니라 
		getter() 메서드를 호출한 반환값을 화면상에 출력하는 것
		항상 getter() 메서드가 있어야 함
		EL구문에서 getter() 찾는 양식 > getName()
	-->
		<li>브랜드 : ${ bestSeller.brand }</li>
		<li>버거 : ${ bestSeller.name }</li>
		<li>가격 : ${ bestSeller.price }원</li>
	</ul>
	
	
	두 개 이상의 Scope에 같은 키값으로 값을 담은 경우<br/>
	<!-- 
		page => request => session => application 순으로 키값을 검색
	 -->
	 Scope에 직접 접근하는 방법! <br/>
	 
	 requestScope : ${ requestScope.brand } <br/>
	 sessionScope : ${ sessionScope.brand } <br/><br/>
	
	만약에 없는 키값 el구문으로 출력하려고 하면 어떻게 될까? <br/><br/>
	
	없는 값 : ${ sesiionScope.abc } <!-- 빈 문자열 출력 -->
	
	<hr/>
	
	연산은 어디서 하는 게 제일 좋음?<br/>
	1. SQL문 DB단<br/>
	2. Java => Service단(validation/transaction)<br/>
	3. View(최후의 수단, 연산 최대한 자제)
	
	<hr/>
	
	<h3>1. 산술연산</h3>
	<p>
		* EL 구문을 이용한 산술연산<br/>
		big + small = ${ big + small } <br/>
		big - small = ${ big - small } <br/>
		big x small = ${ big * small } <br/>
		big / small = ${ big / small } 또는 ${ big div small }<br/>
		big % small = ${ big % small } 또는 ${ big mod small }<br/>
	</p>
	
	<h3>2. 논리연산(웬만하면 후자로 적기, 선호)</h3>
	<p>
		AND : ${ true && true } 또는 ${ true and true } <br/>
		OR  : ${ true || true } 또는 ${ true or true } <br/>
	</p>
	
	비교연산 == 조건문의 조건식으로 많이 사용됨<br/>
	
	<h3>숫자끼리 비교해볼까?</h3>
	<p>
		big이 small보다 작니? : ${ big < small } 또는 ${ big lt small }<br/>
		big이 small보다 크니? : ${ big gt small } <br/>
		big이 small보다 작거나 같니? : ${ big le small } <br/>
		big이 small보다 크거나 같니? : ${ big ge small } <br/>
	</p>
	
	<h4>동등비교도 해볼까?</h3>
	<p>
		big이 small과 같습니까? : ${ big == small } 또는 ${ big eq small } <br/>
		big이 10과 같습니까? : ${ big eq 10 } <br/>
		str과 조아하는문구가 일치합니까? : ${ str == "조아하는문구" } 또는 ${ str eq '조아하는문구' }<br/>
		<!-- == -> equals("")로 보는구나 -->
		big이 10과 일치하지 않습니까? ${ big ne 10 } <br/>
		<!-- ne ==> not equals -->
	</p>
	
	<h4>비어있는지 체크</h4>
	<p>
		bestSeller가 null과 일치합니까?<br/>
		${ bestSeller == null } 또는 ${ bestSeller eq null } 또는 ${ empty bestSeller }<br/>
		<!-- empty => list에도 사용할 수 있음! -->
		list가 비어있지 않습니까?<br/>
		${ !empty list }
	</p>
	
	
	
	
	

</body>
</html>