<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/loginForm.jsp</title>
</head>
<body>
	<div align="center">
	<div><h1>로 그 인</h1></div>
	<div>
		<form action="loginCheck.jsp" id="frm" name="frm" metho="post">
			<table border="1">
				<tr>
					<th>아 이 디</th>
					<td><input type="text" id="id" name="id" size="20"></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" id="password" name="password" size="20"></td>
				</tr>
			</table>
			<br/>
			<input type="submit" value="로그인"> &nbsp;&nbsp;&nbsp;
			<input type="reset" value="취 소">
		</form>
	</div>
	</div>
</body>
</html>
<%@ include file="../common/tail.jsp" %>