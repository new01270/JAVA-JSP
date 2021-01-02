<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="/jsp/menu/head.jsp" />

<head>
	<meta charset="UTF-8">
	<title>boardNew.jsp</title>
	<style>
		textarea,
		input {
			border: solid 1px lightgray;
			border-radius: 5px;
		}

		p {
			font-size: 30px
		}

		p.textarea {
			font-size: 15px
		}
	</style>

</head>

<body>
	<div align="center">
		<p>&nbsp;
			<p />
			<p>&nbsp;
				<p />
	</div>
	<form id="frm" name="frm" action="/MiniProject/BoardNew.do" method="post">
		<section class="main-content  py-4 mb-5">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="row mb-3">
							<div class="col-md-12">
								<div class="">
									<div class="card-body">
										<div class="row">
											<div class="col-md-12" align="center">
												<P>TITLE</P>
												<input type="text" size="100" id="title" name="title">
												<br>
												<hr>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12" align="center">
												<P>CONTENT</p>
												<textarea cols=150 rows="15" id="content" name="content"></textarea>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-12" align="center">
								<div class="card">
									<div class="card-body">
										<P>WRITER</p>
										<h4>${id }</h4>
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-12" align="center">
								<div class="card">
									<div class="card-body">
										<P>DATE</p>
										<input type="date" id="wdate" name="wdate" style="border: none">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<div align="center">
			<button type="submit" class="btn btn-sm btn-primary btn-create"
				onclick="location.href='/MiniProject/jsp/board/boardNew.jsp'">
				Question</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-sm btn-primary btn-create"
				onclick="location.href='/MiniProject/BoardList.do'">List</button>
		</div>
	</form>
	<div align="center">
		<p>&nbsp;
			<p />
			<p>&nbsp;
				<p />
				<p>&nbsp;
					<p />
					<p>&nbsp;
						<p />
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script>
		var date = new Date();
		var yyyy = date.getFullYear();
		var mm = date.getMonth() + 1 > 10 ? date.getMonth() + 1 : '0' +
			(date.getMonth() + 1);
		var dd = date.getDate() > 10 ? date.getDate() : '0' + date.getDate();

		$("input[type=date]").val(yyyy + "-" + mm + "-" + dd);
	</script>
</body>
<jsp:include page="/jsp/menu/footer.jsp" />

</html>