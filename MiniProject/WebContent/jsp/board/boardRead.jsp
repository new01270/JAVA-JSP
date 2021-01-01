<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="/jsp/menu/head.jsp" />
<style>
div.padding {
	padding-left: 5%;
}

h4.refont {
	font-size: 25px;
}

div.input-group>.form-control {
	position: relative;
	-ms-flex: 1 1 auto;
	flex: 1 1 auto;
	width: 92%;
	margin-bottom: 0;
}
</style>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<style>
textarea {
	border: 1px solid #999999;
	width: 100%;
	margin: 5px 0;
	padding: 3px;
}
</style>
<head>
<meta charset="UTF-8">
<title>boardRead.jsp</title>

</head>

<body>
	<div class="padding">
		<div align="left">
			<p>&nbsp;
			<p />
			<p>&nbsp;
			<p />
			<h1 style="font-size: 30px; font-weight: bold">
				<span style="color: red; font-size: 30px;">?</span>QnA<span
					style="color: red; font-size: 30px;">!</span>
			</h1>
		</div>
	</div>
	<p>&nbsp;
	<p />
	<p>&nbsp;
	<p />
	<div>

		<div class="col-md-10 col-md-offset-1">
			<div class="panel panel-default panel-table">
				<div class="panel-heading">
					<h4 style="font-size: 20px; font-weight: bold">TITLE :
						${vo.boardtitle }</h4>
				</div>
				<div class="panel-body">
					<h4 style="font-size: 20px; font-weight: bold">CONTENT :</h4>
					<h4 class="refont">${vo.boardcontent }</h4>
				</div>
				<div class="panel-footer">
					<h4 style="font-size: 20px; font-weight: bold">WRITER
						&nbsp;&nbsp;${vo.memberid }</h4>
					<h4 style="font-size: 20px; font-weight: bold">DATE
						&nbsp;&nbsp;${vo.boarddate }</h4>
				</div>
			</div>

		</div>
	</div>
	<p>
		<br>
	<div class="col-md-10 col-md-offset-1" align="left">
		<div class="panel panel-default panel-table">
			<div class="panel-heading">
				<h4 style="font-size: 20px; font-weight: bold">COMMENT</h4>
			</div>
			<textarea rows="3" cols=100% style="border: none" id="rContent"
				name="rContent"></textarea>
			<div class="panel-footer">
				<h4>
					아이디: &nbsp;<input type="text" id="rId" name="rId">&nbsp;비밀번호:
					&nbsp;<input type="password" id="password" name="password">
				</h4>
				<div align="right">
					<button type="submit" class="btn btn-default" onclick="#">
						<em class="fa fa-pencil">&nbsp;Reple&nbsp;</em>
					</button>
				</div>
			</div>
			<input type="hidden" id="Id" name="Id" value="${vo.boardnumber }">
		</div>
		<div align="center">
			<br> <br>
			<button type="button" class="btn btn-sm btn-primary btn-create"
				onclick="location.href='/MiniProject/BoardList.do'"> LIST </button>
		</div>
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
	</div>
</body>


<jsp:include page="/jsp/menu/footer.jsp" />

</html>