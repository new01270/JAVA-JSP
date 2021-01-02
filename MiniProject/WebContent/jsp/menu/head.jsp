<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="viewport" content="initial-scale=1, maximum-scale=1">
	<title>MiniProject</title>
	<link rel="stylesheet" type="text/css" href="/MiniProject/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/MiniProject/css/style.css">
	<link rel="stylesheet" href="/MiniProject/css/responsive.css">
	<link rel="icon" href="/MiniProject/images/fevicon.png" type="image/gif" />
	<link rel="stylesheet" href="/MiniProject/css/jquery.mCustomScrollbar.min.css">
	<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css"
		href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext"
		rel="stylesheet">
	<link rel="stylesheet" href="/MiniProject/css/owl.carousel.min.css">
	<link rel="stylesoeet" href="/MiniProject/css/owl.theme.default.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
		media="screen">
</head>

<script type="text/javascript">
	function SearchData() {
		var data = document.frm.search.value;
		location.href = "/MiniProject/EduSearch.do?search=" + data;
	}
</script>

<body>
	<div class="cotainer">
		<div class="banner_bg_main">
			<!-- header top section start -->
			<div class="container">
				<div class="header_section_top">
					<div class="row">
						<div class="col-sm-12">
							<div class="custom_menu">
								<ul>
									<li><a href="/MiniProject/HomeController.do">HOME</a></li>
									<li><a href="/MiniProject/EduMain.do">EDU</a></li>
									<li><a href="/MiniProject/BoardList.do">COMMUNITY</a></li>
									<li><a href="/MiniProject/BoardList.do">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
									<li><a class="it_tag">IT의 시작은 세미콜론에서🤑</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- header top section start -->
			<!-- logo section start -->
			<div class="logo_section" align="center">
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<div class="logo">
								<a href="/MiniProject/index.jsp">
									<p class="head_logo">MiniProject;</p>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- logo section end -->
			<!-- header section start -->
			<div class="header_section">
				<div class="container">
					<div class="containt_main">
						<div id="mySidenav" class="sidenav">
							<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a> <a
								href="/MiniProject/HomeController.do">Home</a> <a href="/MiniProject/EduMain.do">EDU</a>
							<a href="/MiniProject/BoardList.do">COMMUNITY</a>
						</div>
						<span class="toggle_icon" onclick="openNav()"><img
								src="/MiniProject/images/toggle-icon.png"></span>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
								data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">강의들</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

								<a class="dropdown-item"
									href="/MiniProject/EduProgramming.do?programming=programming">개발·
									프로그래밍</a> <a class="dropdown-item"
									href="/MiniProject/EduNetwork.do?network=network">보안 · 네트워크</a> <a
									class="dropdown-item"
									href="/MiniProject/EduDatabase.do?database=database">데이터베이스</a> <a
									class="dropdown-item" href="/MiniProject/EduSkill.do?skill=skill">업무
									스킬</a> <a class="dropdown-item"
									href="/MiniProject/EduCareer.do?career=career">커리어</a> <a class="dropdown-item"
									href="/MiniProject/EduLife.do?life=life">라이프</a>
							</div>
						</div>
						<div class="main">
							<!-- Another variation with a button -->
							<form id="frm" name="frm" method="post">
								<div class="input-group">
									<input id="search" name="search" type="text" class="form-control"
										placeholder="원하는 IT 강좌를 입력해주세요.">
									<div class="input-group-append">
										<button class="btn btn-secondary" type="button" onclick="SearchData()"
											style="background-color: #f26522; border-color: #f26522">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</form>
						</div>
						<div class="header_box">
							<div class="login_menu">
								<ul>
									<c:choose>
										<c:when test="${id eq null }">
											<li><a href="/MiniProject/jsp/member/signUp.jsp"> <i class="fa fa-user"
														aria-hidden="true"></i> <span class="padding_10">SIGNUP</span>
												</a></li>
											<li><a href="/MiniProject/jsp/member/login.jsp"> <i class="fa fa-user"
														aria-hidden="true"></i> <span class="padding_10">LOGIN</span>
												</a></li>
										</c:when>
										<c:otherwise>
											<li><span class="padding_10">${name} 님은 훌륭한 개발자('◡') </span></li>
											<br>
											<li><a href="/MiniProject/jsp/member/myPage.jsp"> <i class="fa fa-user"
														aria-hidden="true"></i> <span class="padding_10">MYPAGE</span>
												</a></li>
											<li><a href="/MiniProject/Logout.do"> <i class="fa fa-user"
														aria-hidden="true"></i> <span
														class="padding_10">LOGOUT</span></a></li>
											<li><a href="#"> <i class="fa fa-shopping-cart" aria-hidden="true"></i>
													<span class="padding_10">CART</span>
												</a></li>

										</c:otherwise>
									</c:choose>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- header section end -->
			<div class="header_section">
				<div class="container"></div>
			</div>
		</div>
	</div>

	<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "250px";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
		}
	</script>

</body>

</html>