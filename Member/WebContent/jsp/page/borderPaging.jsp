<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>paging.jsp</title>
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
			margin: 0 4px;
		}

		.pagination a.active {
			background-color: lightsalmon;
			border: 1px solid lightsalmon;
			color: white;
		}

		.pagination a:hover:not(.active) {
			background-color: #ddd;
		}
	</style>
</head>

<body>
	<div>${params}</div>
	<div class="pagination">
		<a href="javascript:goPage(${params.firstPageNo})" class="first"><<</a>
		<a href="javascript:goPage(${params.prevPageNo})" class="prev"><</a>
		<span>
			<c:forEach var="i" begin="${params.startPageNo}" end="${params.endPageNo}" step="1">
				<c:choose>
					<c:when test="${i eq params.pageNo}">
						<a href="javascript:goPage(${i})" class="active">${i}</a>
					</c:when>
					<c:otherwise>
						<a href="javascript:goPage(${i})">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</span> 
		<a href="javascript:goPage(${params.nextPageNo})" class="next">></a>
		<a href="javascript:goPage(${params.finalPageNo})" class="last">>></a>
	</div>
	<script>
		function goPage(page) {
			location.href = "/Member/BorderList.do?pageNum=" + page;
		}
	</script>
</body>

</html>