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
<style>
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
</head>

<body>
	<div align="center">
		<br>
		<h2>게 시 판</h2>
		<br>
		<table border="1" style="border-collapse: collapse">
			<tr height="50" style="background: papayawhip;">
				<th width="100">번 호</th>
				<th width="100">제 목</th>
				<th width="100">작성자</th>
				<th width="100">작성일</th>
				<th width="100">조회수</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr class="row"
					onclick="location.href='/Member/BorderRead.do?id=${vo.borderId}'">
					<td width="100" height="30" align="center">${vo.borderId }</td>
					<td width="300" align="center">${vo.borderTitle }</td>
					<td width="150" align="center">${vo.borderWrite }</td>
					<td width="150" align="center">${vo.borderDate }</td>
					<td width="100" align="center">${vo.borderHit }</td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<button type="button"
			onclick="location.href='jsp/border/borderInput.jsp'">글쓰기</button>
		<br> <br>
		<div align="center">
			<form id="frm" name="frm" action="BorderKeyword.do" method="get">
				<select id="opt" name="opt">
					<option value="bordertitle">제목</option>
					<option value="borderwriter">작성자</option>
					<option value=bordercontent>내용</option>
				</select> <input type="text" size="30" id="condition" name="condition"
					placeholder="특수문자는 사용할수 없습니다.">&nbsp; <input type="submit"
					value="검색"><br> <br>
			</form>
		</div>
		<div>${params}</div>
		<div class="pagination">
			<a href="javascript:goPage(${params.firstPageNo})" class="first">처음
				페이지</a> <a href="javascript:goPage(${params.prevPageNo})" class="prev">이전
				페이지</a> <span> <c:forEach var="i" begin="${params.startPageNo}"
					end="${params.endPageNo}" step="1">
					<c:choose>
						<c:when test="${i eq params.pageNo}">
							<a href="javascript:goPage(${i})" class="active">${i}</a>
						</c:when>
						<c:otherwise>
							<a href="javascript:goPage(${i})">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</span> <a href="javascript:goPage(${params.nextPageNo})" class="next">다음
				페이지</a> <a href="javascript:goPage(${params.finalPageNo})" class="last">마지막
				페이지</a>
		</div>

	</div>
	<script>
		function goPage(page) {
			location.href = "/Member/BorderList.do?pageNum=" + page;
		}
	</script>
</body>

</html>