<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/loginCheck</title>
</head>
<%!
	//변수선언
	String id; 
	String msg;
%>

<%-- 아이디값을 비교하는 부분 --%>
<%
	//자바코드
	id = request.getParameter("id");
	if (id.equals("hong")) {
		msg = "홍길동 님 환영합니다.";
	} else {
		msg = "아이디가 존재하지 않습니다.";
	}
%>
<body>
	<div align="center">
		<h1>
		<%= //출력
		msg %>
		</h1>
	</div>
</body>
</html>
<%@ include file="../common/tail.jsp" %>