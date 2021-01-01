<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>borderInput.jsp</title>
</head>

<body>
	<div align="center">
		<br>
		<h2>글쓰기</h2>
	</div>
	<div align="center">
		<form action="/Member/BorderInput.do" id="frm" name="frm"
			method="post">
			<table border="1" style="border-collapse: collapse">
				<tr>
					<th width="200" height="40">작성자</th>
					<td width="700">&nbsp; <input type="text" size="50" id="write"
						name="write" style="border: none"></td>
				</tr>
				<tr>
					<th width="200" height="40">작성일</th>
					<td width="700">&nbsp; <input type="date" size="50" id="wdate"
						name="wdate" style="border: none"></td>
				</tr>
				<tr>
					<th width="200" height="40">제목</th>
					<td width="700">&nbsp; <input type="text" size="50" id="title"
						name="title" style="border: none"></td>
				</tr>
				<tr>
					<th width="200" height="150">내용</th>
					<td width="700">&nbsp; <textarea cols="100" rows="5"
							id="content" name="content" style="border: none"></textarea></td>
				</tr>
			</table>
			<br />
			<button type="submit">등 록</button>
			&nbsp;&nbsp;&nbsp;
			<button type="reset">다시쓰기</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='/Member/BorderList.do'">목
				록</button>
			&nbsp;&nbsp;&nbsp;
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script>
		var date = new Date();
		var yyyy = date.getFullYear();
		var mm = date.getMonth() + 1 > 10 ? date.getMonth() + 1 : '0'
				+ (date.getMonth() + 1);
		var dd = date.getDate() > 10 ? date.getDate() : '0' + date.getDate();

		$("input[type=date]").val(yyyy + "-" + mm + "-" + dd);
	</script>
</body>

</html>