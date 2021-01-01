<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="/jsp/menu/head.jsp" />

<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
</head>
<style>
div.input-group>.custom-file, .input-group>.custom-select, .input-group>.form-control {
    position: relative;
    -ms-flex: 1 1 auto;
    flex: 1 1 auto;
    width: 90%;
    margin-bottom: 0;
}
div.padding{
padding-left: 5%;
}
.select, .search, .submit {
	border-radius: 5px
}

.table tbody tr:hover td, .table tbody tr:hover th {
    background-color: #eeeeea;
}

</style>
<body>
	<div class="padding">
		<div align="left">
			<p>&nbsp;
			<p />
			<p>&nbsp;
			<p />
			<h1 style="font-size: 30px; font-weight: bold">
				<span style="color: red; font-size: 30px;">?</span>QnA<span style="color: red; font-size: 30px;">!</span>
			</h1>
			<p>&nbsp;
			<p />
		</div>
	</div>
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<form id="frm" name="frm" action="BoardList.do" method="post">
				<select id="opt" name="opt" class="opt">
					<c:choose>
						<c:when test="${opt eq 'memberid'}">
							<option value="memberid" selected>ID</option>
						</c:when>
						<c:otherwise>
							<option value="memberid">ID</option>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${opt eq 'boardtitle'}">
							<option value="boardtitle" selected>TITLE</option>
						</c:when>
						<c:otherwise>
							<option value="boardtitle">TITLE</option>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${opt eq 'boardcontent'}">
							<option value="boardcontent" selected>CONTENT</option>
						</c:when>
						<c:otherwise>
							<option value="boardcontent">CONTENT</option>
						</c:otherwise>
					</c:choose>
				</select>&nbsp;&nbsp; <input type="text" size="20" id="search" name="search"
					class="search">&nbsp;&nbsp; <input type="submit" value="검색"
					class="submit">
			</form>
			<p></p>
			<div class="panel panel-default panel-table">
				<div class="panel-heading">
					<div class="row">
						<div class="col col-xs-6">
							<h3 class="panel-title">QnA</h3>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered table-list">
						<thead>
							<tr>
								<th>NO.</th>
								<th>질문</th>
								<th>작성자 ID</th>
								<th>작성일자</th>
								<th>조회수</th>
								<th><em class="fa fa-cog"></em></th>
							</tr>
						</thead>
						<c:forEach var="vo" items="${list }">
							<tbody>
								<tr class="rows">
									<td
										onclick="location.href='/MiniProject/BoardRead.do?id=${vo.boardnumber}'">
										${vo.boardnumber}</td>
									<td
										onclick="location.href='/MiniProject/BoardRead.do?id=${vo.boardnumber}'">
										${vo.boardtitle}</td>
									<td
										onclick="location.href='/MiniProject/BoardRead.do?id=${vo.boardnumber}'">
										${vo.memberid}</td>
									<td
										onclick="location.href='/MiniProject/BoardRead.do?id=${vo.boardnumber}'">
										${vo.boarddate }</td>
									<td
										onclick="location.href='/MiniProject/BoardRead.do?id=${vo.boardnumber}'">
										${vo.boardhit }</td>
									<td align="center"><c:if
											test="${vo.memberid eq session_id }">
											<a class="btn btn-default"
												onclick="location.href='#'">
												<em class="fa fa-pencil"></em>
											</a>
											<a class="btn btn-danger"
												onclick="location.href='/MiniProject/BoardDelete.do?id=${vo.boardnumber}'"><em
												class="fa fa-trash"></em></a>
										</c:if></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>
				<div class="panel-footer">
					<div class="row">
						<div class="col col-xs-4">TotalCount ${totalCount }</div>
						<div class="col col-xs-8">
							<ul class="pagination hidden-xs pull-right">
								<li><a href="javascript:goPage(${params.finalPageNo})">>></a></li>
							</ul>
							<ul class="pagination hidden-xs pull-right">
								<li><a href="javascript:goPage(${params.nextPageNo})">></a></li>
							</ul>
							<ul class="pagination hidden-xs pull-right">
								<c:forEach var="i" begin="${params.startPageNo}"
									end="${params.endPageNo}" step="1">
									<c:choose>
										<c:when test="${i eq params.pageNo}">
											<li><a href="javascript:goPage(${i})">${i}</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="javascript:goPage(${i})">${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
							<ul class="pagination hidden-xs pull-right">
								<li><a href="javascript:goPage(${params.prevPageNo})">
										<</a></li>
							</ul>
							<ul class="pagination hidden-xs pull-right">
								<li><a href="javascript:goPage(${params.firstPageNo})">
										<<</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<c:if test="${auth ne null }">
				<div align="center">
					<button type="button" class="btn btn-sm btn-primary btn-create"
						onclick="location.href='/MiniProject/jsp/board/boardNew.jsp?id=${vo.memberid}'">Create
						New</button>
				</div>
			</c:if>
			<div align="center">
				<p>&nbsp;
				<p />
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
	</div>
	<script>
		function goPage(page) {
			let opt = document.getElementById("opt").value;
			let search = document.getElementById("search").value;

			location.href = "BoardList.do?pageNum=" + page + "&opt=" + opt
					+ "&search=" + search;
		}
	</script>

</body>
<jsp:include page="/jsp/menu/footer.jsp" />

</html>