<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">

  <title>웹개발 시작하기</title>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>


</head>

<style>
	.header-bg{
		background-color: #0B261A;
	}
	.nav-bg{
		background-color: #000D06;
	}
	

</style>

<div class="p-5 text-white text-center header-bg">
  <h1>My First Bootstrap 5 Page</h1>
</div>

<nav class="navbar navbar-expand-sm navbar-dark nav-bg">
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">공지사항</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">게시판</a>
      </li>
      
      <c:choose>
	      <c:when test="${ empty loginMember }">
		      <li class="nav-item">
		        <a class="nav-link js-scroll-trigger" data-toggle="modal" data-target="#log-in">로그인</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="join">회원가입</a>
		      </li>
		  </c:when>
		  <c:otherwise>
		      <li class="nav-item">
		        <a class="nav-link" href="myPage">내 정보</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="logout" onclick="return confrim('로그아웃 하시겠습니까?')">로그아웃</a>
		      </li>
		  </c:otherwise>
	  </c:choose>
      
    </ul>
  </div>
</nav>

  <!-- 로그인 Modal-->
<div class="modal fade" id="log-in">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">
					로그인
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">

				<form action="/mhp/sign-in" name="sign-in" method="post" id="signInForm"
					style="margin-bottom: 0;">
					<table style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 100%">
						<tr>
							<td style="text-align: left">
								<p><strong>아이디</strong>&nbsp;&nbsp;&nbsp;<span id="idCheck"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="memberId" id="signInId"
								class="form-control tooltipstered" maxlength="10"
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="아이디를 입력해주세요."></td>
						</tr>
						<tr>
							<td style="text-align: left">
								<p><strong>비밀번호</strong>&nbsp;&nbsp;&nbsp;<span id="pwCheck"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="password" size="17" maxlength="20" id="signInPw"
								name="memberPw" class="form-control tooltipstered" required="required" aria-required="true"
								style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
								placeholder="비밀번호를 입력해주세요."></td>
						</tr>
						<tr>
							<td style="width: 100%; text-align: center; colspan: 2;"><input
								type="submit" value="로그인" class="btn form-control tooltipstered" id="signIn-btn"
								style="background-color: #0B261A; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>

</body>
</html>