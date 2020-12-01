<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fail.jsp</title>
<script type="text/javascript">
	function formClose() {
		opener.frm.checked.value="";
		opener.frm.password.focus();
		window.close();
	}
</script>
</head>
<body>
	<div align="center">
		${id }는 사용할 수 없는 ID입니다.
		<br><button type="button" onclick="formClose()">확인</button>
	</div>
</body>
</html>