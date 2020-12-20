<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>noticeList.jsp</title>
	<style>
		tr.row:hover {
			background: pink;
		}
	</style>
</head>

<body>
	<div align="center">
		<div>
			<br>
			<h2>공지사항 목록</h2>
			<br>
			<bl>
		</div>
		<div align="center">
			<table border="1" style="border-collapse: collapse">
				<tr>
					<th width="100" height="40">순번</th>
					<th width="250" height="40">제목</th>
					<th width="150" height="40">작성일자</th>
					<th width="150" height="40">작성자</th>
					<th width="100" height="40">조회수</th>
					<th width="150" height="40">첨부파일</th>
				</tr>
				<c:forEach var="vo" items="${list}">
					<tr class="row" onclick="location.href='/Member/NoticeRead.do?id=${vo.noticeid}'">
						<td height="30" align='center'>${vo.noticeid}</td>
						<td height="30" align='center'>${vo.noticetitle}</td>
						<td height="30" align='center'>${vo.noticedate}</td>
						<td height="30" align='center'>${vo.noticewriter}</td>
						<td height="30" align='center'>${vo.noticehit}</td>
						<c:if test="${vo.noticeattach ne null }">
							<td align="center">😍</td>
						</c:if>
						<c:if test="${vo.noticeattach eq null }">
							<td align="center">🤢</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
			<br>
			<div>
				<form action="#" id="frm" name="frm" method="POST">
					<input type="hidden" id="no" name="no">
					<c:if test="${auth eq 'admin'}">
						<button type="button" onclick="location.href='jsp/notice/noticeForm.jsp'">글쓰기</button><br><br>
					</c:if>
				</form>
			</div>
			<div align="center">
				<form id="frm" name="frm" action="NoticeKeyword.do" method="get">
					<select id="opt" name="opt">
						<option value="noticetitle">제목</option>
						<option value="noticecontent">내용</option>
					</select>
					<input type="text" size="30" id="condition" name="condition" placeholder="특수문자는 사용할수 없습니다.">&nbsp;
					<input type="submit" value="검색"><br><br><br>
					<hr><br><br><br>
				</form>
			</div>
		</div>
	</div>
</body>

</html>