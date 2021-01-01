<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="/jsp/menu/head.jsp" />

<head>
	<meta charset="UTF-8">
	<title>loginResult.jsp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
	<div align="center">
		<p>&nbsp;
			<p />
			<p>&nbsp;
				<p />
				<p>&nbsp;
					<p />
					<p>&nbsp;
						<p />
	</div>
	<div align="center">
		<c:if test="${auth ne null }">
			<h3>${vo.memberName }님 환영합니다.</h3>
		</c:if>
		<c:if test="${auth eq null }">
			<h3>${vo.memberId}님의 아이디가 존재하지 않거나 패스워드가 일치하지 않습니다.</h3>
		</c:if>
	</div>
	<div align="center">
		<p>&nbsp;
			<p />
			<p>&nbsp;
				<p />
				<p>&nbsp;
					<p />
					<p>&nbsp;
						<p />
	</div>
</body>
<jsp:include page="/jsp/menu/footer.jsp" />

</html>