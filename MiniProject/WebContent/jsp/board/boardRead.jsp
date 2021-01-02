<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="/jsp/menu/head.jsp" />
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<style>
	textarea {
		border: 1px solid #999999;
		width: 100%;
		margin: 5px 0;
		padding: 3px;
	}

	.container {
		margin-left: 20%;
		margin-right: 20%;
	}

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

<head>
	<meta charset="UTF-8">
	<title>boardRead.jsp</title>
</head>

<body>
	<div align="center">
		<p>&nbsp;
			<p />
			<p>&nbsp;
				<p />
				<h1 style="font-size: 30px; font-weight: bold">
					QnA<span style="color: red; font-size: 30px;">?</span>
				</h1>
				<p>&nbsp;
					<p />
					<p>&nbsp;
						<p />
	</div>
	<div style="margin: 0px 9% 0px 9%">
		<div align="right">
			<button type="button" class="btn btn-sm btn-primary btn-create"
				onclick="location.href='/MiniProject/BoardList.do'">LIST</button>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="row mb-3">
					<div class="col-md-12">
						<div class="">
							<div class="card-body">
								<div class="row">
									<div class="col-md-12" align="center">
										<P align="left" style="font-size: 30px; font-weight: bold">
											${vo.boardtitle }</P>
										<hr>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-md-12" align="center">
										<div class="card">
											<div class="card-body">
												<P style="font-size: 20px; font-weight: bold" align="left">작성자
													<span>${vo.memberid } </span>
													<span>${vo.boarddate }</span>
												</p>
												<br>
												<h4 align="left">${vo.boardcontent }</h4>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12" align="center"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${c_list ne null}">
			<c:forEach var="c_list" items="${c_list }">
				<div class="col-md-10 col-md-offset-1" style="margin: 0">
				<div class="panel panel-default panel-table">
				&nbsp;&nbsp;
				<h4 style="font-size: 20px; font-weight: bold; padding: 10px 15px 10px 15px" align="left">
					${c_list.memberid }&nbsp;<span style="color: lightgray; font-size: 15px;">${c_list.boarddate}
						댓글작성날짜</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>
						<c:if test="${id ne null }">
						<button type="button" class="btn btn-default" onclick="location.href='#'">
							<em class="fa fa-pencil">&nbsp;Edit</em>
						</button>
						<button type="button" class="btn btn-danger" onclick="location.href='#'">
							<em class="fa fa-trash"> &nbsp;Del</em>
						</button>
						</c:if>
					</span>
				</h4>
				<h6 align="left">${c_list.commentcontent }</h6>
			</div>
		</div>
		</c:forEach>
		</c:if>
		<c:if test="${id ne null }">
		<div class="col-md-10 col-md-offset-1" style="margin: 0">
			<div class="panel panel-default panel-table">
				<div class="panel-heading">
					<form id="frm" name="frm" action="#">
						<input type="hidden" name="comment_board" value="${vo.boardnumber }">
						<input type="hidden" name="comment_id" value="${id }">
						<h4 style="font-size: 20px; font-weight: bold">${id }&nbsp;
							<span style="color: lightgray; font-size: 15px;">${vo.boarddate}댓글작성현재날짜수정
							</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span>
								<button type="submit" class="btn btn-default" onclick="reply()" id="reply" name="reply">
									<em class="fa fa-pencil">&nbsp;Reply&nbsp;</em>
								</button></span>
						</h4>
					</form>
				</div>
				<textarea rows="3" cols=100% style="border: none" id="comment_content" name="comment_content"
					placeholder="  답변을 해주세요 :)"></textarea>
			</div>
		</div>
		</c:if>
	</div>
	<div align="center">
		<p>&nbsp;
			<p />
			<p>&nbsp;
				<p />
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script>
	
		
		function reply() {
			var form = document.getElementById("frm");
			var board = form.comment_board.value
			var id = form.comment_id.value
			var content = form.comment_content.value;

			if (!content) {
				alert("내용을 입력하세요.");
				return false;
			} else {
				var param = "comment_board=" + board + "&comment_id=" + id + "&comment_content=" + content;

				httpRequest = getXMLHttpRequest();
				httpRequest.onreadystatechange = checkFunc;
				httpRequest.open("POST", "CommentWrite.do", true);
				httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
				httpRequest.send(param);
			}

			function checkFunc() {
				if (httpRequest.readyState == 4) {
					// 결과값을 가져온다.
					var resultText = httpRequest.responseText;
					if (resultText == 1) {
						document.location.reload(); // 상세보기 창 새로고침
					}
				}
			}



		}
	</script>
</body>


<jsp:include page="/jsp/menu/footer.jsp" />

</html>