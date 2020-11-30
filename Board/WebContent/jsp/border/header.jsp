<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>header.jsp</title>
	<style>
		ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
			background-color: lightblue;
		}

		ul:after {
			content: '';
			display: block;
			clear: both;
		}

		li {
			float: left;
		}

		li a {
			display: block;
			color: white;
			text-align: center;
			padding: 14px 16px;
			text-decoration: none;
		}

		li a:hover:not(.active) {
			background-color: pink;
		}

		.active {
			backgound-color: lightblue;
		}
	</style>
</head>

<body>
	<div align="center">
		<ul>
			<li><a class="action" href="index.jsp">HOME</a></li>
			<li><a href="#news">NEWS</a></li>
			<li><a href="#contanc">CONTACT</a></li>
			<li><a href="#about">ABOUT</a></li>
			<li><a href="BorderList.do">NOTICE</a></li>
		</ul>
		<div>
			<h1>게시판만들기</h1>
		</div>
		<hr>
	</div>
</body>

</html>