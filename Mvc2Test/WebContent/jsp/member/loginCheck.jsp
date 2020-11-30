<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/loginCheck</title>
</head>
<body>
	<div align="center">
		<h6>${param.id }</h2>
		<h6>${param.password }</h2>
		<h2>${msg }</h3>
	</div>
</body>
</html>
<jsp:include page="../common/tail.jsp" />