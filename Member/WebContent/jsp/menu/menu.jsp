<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>menu.jsp</title>
	<link href="/Member/css/menu.css" rel="stylesheet">
</head>

<body>
	<div align="center">
		<div>
			<br>
			<h1>행복한 금요일</h1>
			<br>
			<ul id="nav">
				<li><a href="/Member/index.jsp">HOME</a> <!-- href="../../index.jsp" -->
					<c:if test="${id eq null || auth eq null }">
						<!-- id, auth 는 세션에 있는 값 -->
				<li><a href="/Member/jsp/member/loginForm.jsp">로그인</a></li>
				</c:if>
				<li><a href="#">메인메뉴 1</a>
					<ul>
						<li><a href="#">1-1</a></li>
						<li><a href="#">1-2</a></li>
					</ul>
				</li>
				<li><a href="/Member/BorderList.do">자유게시판</a></li>
				<c:if test="${id eq null || auth eq null }">
					<li><a href="/Member/jsp/member/signUp.jsp">회원가입</a></li>
				</c:if>
				<c:if test="${auth eq 'admin' }">
					<li><a href="/Member/MemberList.do">관리자권한</a>
						<ul>
							<li><a href="/Member/MemberList.do">멤버관리</a></li>
							<li><a href="#">3-2</a></li>
							<li><a href="#">3-3</a></li>
							<li><a href="#">3-4</a></li>
							<li><a href="#">3-5</a></li>
							<li><a href="#">3-6</a></li>
						</ul>
					</li>
				</c:if>
				<c:if test="${id ne null && auth ne null}">
					<li><a href="/Member/Logout.do">로그아웃</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>

</html>