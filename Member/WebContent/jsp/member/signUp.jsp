<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>signUp.jsp</title>
	<script type="text/javascript">
		//회원가입 화면 입력값 검사.
		function checkValue() {
			var form = document.frm;

			if (!form.id.value) {
				alert("아이디를 입력하세요.")
				return false;
			}

			if (form.idDuplication.value != "idCheck") {
				alert("아이디 중복체크를 해주세요.")
				return false;
			}

			if (!form.password.value) {
				alert("비밀번호를 입력하세요.")
				return false;
			}

			if (form.password.value != form.passwordcheck.value) {
				alert("비밀번호가 동일하지 않습니다.")
				return false;
			}

			if (!form.name.value) {
				alert("이름을 입력하세요.")
				return false;
			}
			form.submit();
		}

		// 중복확인 창
		function openIdcheck() {
			window.name = "parentForm";
			window.open("member/idCheckForm.jsp", "아이디 중복체크",
				"width=500, height=300, resizable=no, scrollbars=no")
		}

		// 아이디 입력->hidden에 idUncheck 세팅->중복체크후 다시 입력하명 다시 체크.
		function inputIdChk() {
			document.form.idDuplication.value = "idUncheck";
		}
	</script>
</head>

<body>
	<div align="center">
		<br>
		<div>
			<h2>회 원 가 입</h2>
			<br>
		</div>
		<div>
			<form action="/Member/MemberSignUp.do" id="frm" name="frm" method="post" onsubmit="return checkValue()">
				<table border="1" style="border-collapse: collapse">
					<tr>
						<th width="200" height="30">아 이 디</th>
						<td>&nbsp;<input type="text" id="id" name="id" style="border: none" size="30"
								onkeydown="inputIdChk()">&nbsp;
							<input type="button" value="중복확인" onclick="openIdChk()">&nbsp;
							<input type="hidden" id="idDuplication" name="idDuplication" value="idUncheck">
						</td>
					</tr>
					<tr>
						<th width="200" height="30">이 름</th>
						<td>&nbsp;<input type="text" id="name" name="name" style="border: none" size="30"></td>
					</tr>
					<tr>
						<th width="200" height="30">패스워드</th>
						<td>&nbsp;<input type="password" id="password" name="password" style="border: none" size="30">
						</td>
					</tr>
					<tr>
						<th width="200" height="30">패스워드 확인</th>
						<td>&nbsp;<input type="password" id="passwordcheck" name="passwordcheck" style="border: none"
								size="30">
						</td>
					</tr>
				</table>
				<br> <br> <input type="button" value="가입하기" onclick="checkValue()">&nbsp;&nbsp;&nbsp;
				<input type="button" value="취 소" onclick="location.href='/Member/jsp/menu/menu.jsp'">
			</form>
		</div>
	</div>
</body>

</html>