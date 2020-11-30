<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<title>Bootstrap 4 Website Example</title>
	<meta charset="utf-8">
	<style>
		tr.row:hover {
			background: pink;
		}
	</style>
</head>

<body>
	<div align="center"><br>
		<h2>게 시 판</h2><br>
		<table border="1" style="border-collapse: collapse">
			<tr height="50" style="background: papayawhip;">
				<th width="100">번 호</th>
				<th width="100">제 목</th>
				<th width="100">작성자</th>
				<th width="100">작성일</th>
				<th width="100">조회수</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr class="row" onclick="location.href='/Member/BorderRead.do?id=${vo.borderId}'">
					<td width="100" height="30" align="center">${vo.borderId }</td>
					<td width="300" align="center">${vo.borderTitle }</td>
					<td width="150" align="center">${vo.borderWrite }</td>
					<td width="150" align="center">${vo.borderDate }</td>
					<td width="100" align="center">${vo.borderHit }</td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<button type="button" onclick="location.href='jsp/border/borderInput.jsp'">글쓰기</button>
	</div>
</body>

</html>