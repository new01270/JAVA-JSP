<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<jsp:include page="/jsp/menu/head.jsp" />

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="dns-prefetch" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/style.css">
<link rel="icon" href="Favicon.png">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>signUp.jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	let duplicationChecked = false;
	let passwordChecked = false;

	function idDuplicationCheck() {
		var form = document.frm;
		var id = document.getElementById("mid").value;

		$.ajax({
			type : 'post',
			url : '/MiniProject/IdDuplication.do',
			data : {
				id : id
			},
			success : function(result) {
				if (!id) {
					alert("아이디를 입력하세요.");
				} else if (result == 1) {
					alert("사용할 수 있는 아이디입니다.");
				} else {
					alert("사용할 수 없는 아이디입니다.");
				}
			},
			error : function(reject) {
				console.log(reject);
			}
		})
		duplicationChecked = true;
	}

	function passwordCheck() {
		var form = document.frm;
		var password = document.getElementById("password").value;
		var password2 = document.getElementById("password2").value;

		if (password != password2) {
			alert("패스워드가 일치하지 않습니다.");
		} else {
			passwordChecked = true;
		}
	}

	function valueCheck() {
		let form = document.frm;
		var id = document.getElementById("mid").value;
		var name = document.getElementById("name").value;
		var password = document.getElementById("password").value;
		var password2 = document.getElementById("password2").value;

		if (!id) {
			alert("아이디를 입력하세요.")
			return false;
		}

		if (duplicationChecked != true) {
			alert("아이디 중복체크를 해주세요.");
			return false;
		}

		if (!name) {
			alert("이름를 입력하세요.")
			return false;
		}

		if (!password) {
			alert("비밀번호를 입력하세요.")
			return false;
		}

		if (!password2) {
			alert("비밀번호를 한번 더 입력하세요.")
			return false;
		}

		if (passwordCheck()) {
			form.password2.focus();
			return false;
		}

		if (passwordChecked != true) {
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<div align="center">
		<p>&nbsp;
		<p />
		<p>&nbsp;
		<p />
		<p>&nbsp;
		<p />
	</div>
	<main class="login-form">
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-6">
					<div class="card">
						<div class="card-header">회원가입 해주세요.</div>
						<form id="frm" name="frm" action="/MiniProject/SignUp.do"
							onsubmit="return valueCheck()" method="post">
							<div class="card-body">
								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">ID </label>
									<div class="col-md-6">
										<input type="text" class="form-control" placeholder="아이디 입력"
											id="mid" name="mid" required autofocus> <input
											type="button" value="중복확인" onclick="idDuplicationCheck()">
									</div>
								</div>

								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">NAME </label>
									<div class="col-md-6">
										<input type="text" class="form-control" placeholder="이름 입력"
											id="name" name="name" required autofocus>
									</div>
								</div>

								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Password</label>
									<div class="col-md-6">
										<input type="password" class="form-control"
											placeholder="비밀번호 입력" id="password" name="password" required>
									</div>
								</div>


								<div class="form-group row">
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">Password
										Confirm </label>
									<div class="col-md-6">
										<input type="password" class="form-control"
											placeholder="비밀번호 재입력" id="password2" name="password2"
											required autofocus>
									</div>
								</div>
								<div class="col-md-6 offset-md-4">
									<input type="submit" class="btn btn-primary" value="SING UP">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</main>
	<div align="center">
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