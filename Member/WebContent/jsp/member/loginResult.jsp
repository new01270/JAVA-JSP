<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>loginResult.jsp</title>
	<script type="text/javascript">

	</script>
</head>

<body>
	<div align="center">
		<br>
		<c:if test="${auth ne null }">
			<h3>${vo.memberName} 님 환영합니다.</h3>
			<!-- 공지사항 목록 -->
			<div id="notice"></div>
		</c:if>
		<c:if test="${auth eq null }">
			<h3>${vo.memberId}님의아이디가 존재하지 않거나 패스워드가 일치하지 않습니다.</h3>
		</c:if>
	</div>
</body>

</html>