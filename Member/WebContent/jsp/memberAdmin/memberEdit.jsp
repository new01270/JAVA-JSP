<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>memberEdit.jsp</title>
</head>

<body>
	<div align="center"><br>
		<h2>수정하기</h2>
	</div>
	<div align="center">
		<form action="/Member/MemberEdit.do" id="frm" name="frm" method="post">
			<table border="1" style="border-collapse: collapse">
				<tr>
					<th width="120" height="40">아이디</th>
					<td width="400">&nbsp;${vo.memberId }</td>
				</tr>
				<tr>
					<th width="120" height="40">이름</th>
					<td width="400">&nbsp;${vo.memberName }</td>
				</tr>
				<tr>
					<th width="120" height="40">권한</th>
					<td width="400"><input type="text" size="50" id="auth" name="auth">&nbsp;${vo.memberAuth }</td>
				</tr>
				<tr>
					<th width="120" height="40">포인트</th>
					<td width="400"><input type="text" size="50" id="point" name="point">&nbsp;${vo.memberPoint }</td>
				</tr>
			</table><br>
			<input type="hidden" id="id" name="id" value="${vo.memberId }">
			<button type="submit">저 장</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='/Member/Memberlist.do'">목록</button>
		</form>
	</div>
</body>

</html>