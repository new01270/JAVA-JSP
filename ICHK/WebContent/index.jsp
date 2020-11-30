<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idex.jsp</title>
<script type="text/javascript">
	function valiDate() {
		if (document.frm.checked.value == "N") {
			alert("아이디 중복체크 확인하세요.")
			return false;
		} 
		return true;
	}
	
	//아이디 중복체크 창
	function idChk() {
		var f = document.frm;
		window.open("", "아이디 중복 체크", "width=100, height=100, resizable=no, scrollbars=no" );
		
	}
</script>
</head>
<body>
	<div align="center"><br>
		<form id="frm" name="frm" action="#" onsubmit="return valiDate()" method="post">
			아이디 : <input type="text" id="mid" name="mid">&nbsp;&nbsp;
			<input type="hidden" id="checked" name="checked" value="N">
			<button type="button" onclick="idChk()">중복확인</button>
			<input type="submit" value="가입하기">
		</form>
	</div>
</body>
</html>