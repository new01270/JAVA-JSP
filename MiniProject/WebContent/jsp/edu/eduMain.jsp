<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="../menu/head.jsp" />
<html>

<head>
<meta charset="UTF-8">
<title>eduMain.jsp</title>
</head>

<body>
	<div align="center">
		<p>&nbsp;
		<p />
	</div>
	<div class="banner_section layout_padding">
		<div class="fashion_section">
			<div id="main_slider" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<div class="container">
							<a class="category_click"
								href="/MiniProject/EduProgramming.do?programming=programming">
								<h1 class="fashion_taital">Programming >> <span
									style="color: red; font-size: 15px;">START!!</span></h1>
							</a>
							<div class="fashion_section_2">
								<div class="row">
									<div class="row row-cols-1 row-cols-md-3 g-4">
										<c:forEach var="vo_p" items="${listProgramming }">
											<div class="fuck">
												<div class="card" style="width: 18rem; height: 25rem"
													onclick="location.href='/MiniProject/EduRead.do?id=${vo_p.eduNumber}'">
													<img class="card-img-top" src="images/${vo_p.eduImg}"
														alt="Card image cap">
													<div class="card-body">
														<h5 class="card-title" style="height: 60px">${vo_p.eduTitle }</h5>
														<h5 class="card-text">${vo_p.eduLecturer }</h5>
														<h5 class="card-text">난이도 : ${vo_p.eduDifficulty }</h5>
														<a href="#" class="btn btn-primary">$ ${vo_p.eduPrice }</a>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="banner_section layout_padding">
		<div class="fashion_section">
			<div id="main_slider" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<div class="container">
							<a href="/MiniProject/EduNetwork.do?network=network">
								<h1 class="fashion_taital">Security · NETWORK >> <span
									style="color: red; font-size: 15px;">START!!</span></h1>
							</a>
							<div class="fashion_section_2">
								<div class="row">
									<div class="row row-cols-1 row-cols-md-3 g-4">
										<c:forEach var="vo_n" items="${listNetwork }">
											<div class="fuck">
												<div class="card" style="width: 18rem; height: 25rem" onclick="location.href='/MiniProject/EduRead.do?id=${vo_n.eduNumber}'">
													<img class="card-img-top" src="images/${vo_n.eduImg}"
														alt="Card image cap">
													<div class="card-body">
														<h5 class="card-title" style="height: 60px">${vo_n.eduTitle }</h5>
														<h5 class="card-text">${vo_n.eduLecturer }</h5>
														<h5 class="card-text">${vo_n.eduDifficulty }</h5>
														<a href="#" class="btn btn-primary">$ ${vo_n.eduPrice }</a>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="banner_section layout_padding">
		<div class="fashion_section">
			<div id="main_slider" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<div class="container">
							<a href="/MiniProject/EduDatabase.do?database=database">
								<h1 class="fashion_taital">DataBase >> <span
									style="color: red; font-size: 15px;">START!!</span></h1>
							</a>
							<div class="fashion_section_2">
								<div class="row">
									<div class="row row-cols-1 row-cols-md-3 g-4">
										<c:forEach var="vo_d" items="${listDatabase }">
											<div class="fuck">
												<div class="card" style="width: 18rem; height: 25rem" onclick="location.href='/MiniProject/EduRead.do?id=${vo_d.eduNumber}'">
													<img class="card-img-top" src="images/${vo_d.eduImg}"
														alt="Card image cap">
													<div class="card-body">
														<h5 class="card-title" style="height: 60px">${vo_d.eduTitle }</h5>
														<h5 class="card-text">${vo_d.eduLecturer }</h5>
														<h5 class="card-text">${vo_d.eduDifficulty }</h5>
														<a href="#" class="btn btn-primary">$ ${vo_d.eduPrice }</a>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="banner_section layout_padding">
		<div class="fashion_section">
			<div id="main_slider" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<div class="container">
							<a href="/MiniProject/EduSkill.do?skill=skill">
								<h1 class="fashion_taital">Work Skill >> <span
									style="color: red; font-size: 15px;">START!!</span></h1>
							</a>
							<div class="fashion_section_2">
								<div class="row">
									<div class="row row-cols-1 row-cols-md-3 g-4">
										<c:forEach var="vo_s" items="${listskill }">
											<div class="fuck">
												<div class="card" style="width: 18rem; height: 25rem" onclick="location.href='/MiniProject/EduRead.do?id=${vo_s.eduNumber}'">
													<img class="card-img-top" src="images/${vo_s.eduImg}"
														alt="Card image cap">
													<div class="card-body">
														<h5 class="card-title" style="height: 60px">${vo_s.eduTitle }</h5>
														<h5 class="card-text">${vo_s.eduLecturer }</h5>
														<h5 class="card-text">${vo_s.eduDifficulty }</h5>
														<a href="#" class="btn btn-primary">$ ${vo_s.eduPrice }</a>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="banner_section layout_padding">
		<div class="fashion_section">
			<div id="main_slider" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<div class="container">
							<a href="/MiniProject/EduCareer.do?career=career">
								<h1 class="fashion_taital">My Career >> <span
									style="color: red; font-size: 15px;">START!!</span></h1>
							</a>
							<div class="fashion_section_2">
								<div class="row">
									<div class="row row-cols-1 row-cols-md-3 g-4">
										<c:forEach var="vo_c" items="${listCareer }">
											<div class="fuck">
												<div class="card" style="width: 18rem;height: 25rem" onclick="location.href='/MiniProject/EduRead.do?id=${vo_c.eduNumber}'">
													<img class="card-img-top" src="images/${vo_c.eduImg}"
														alt="Card image cap">
													<div class="card-body">
														<h5 class="card-title" style="height: 60px">${vo_c.eduTitle }</h5>
														<h5 class="card-text">${vo_c.eduLecturer }</h5>
														<h5 class="card-text">${vo_c.eduDifficulty }</h5>
														<a href="#" class="btn btn-primary">$ ${vo_c.eduPrice }</a>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="banner_section layout_padding">
		<div class="fashion_section">
			<div id="main_slider" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<div class="container">
							<a href="/MiniProject/EduLife.do?life=life">
								<h1 class="fashion_taital">My Life is Good >> <span
									style="color: red; font-size: 15px;">START!!</span></h1>
							</a>
							<div class="fashion_section_2">
								<div class="row">
									<div class="row row-cols-1 row-cols-md-3 g-4">
										<c:forEach var="vo_l" items="${listLife }">
											<div class="fuck">
												<div class="card" style="width: 18rem; height: 25rem" onclick="location.href='/MiniProject/EduRead.do?id=${vo_l.eduNumber}'">
													<img class="card-img-top" src="images/${vo_l.eduImg}"
														alt="Card image cap">
													<div class="card-body">
														<h5 class="card-title" style="height: 60px">${vo_l.eduTitle }</h5>
														<h5 class="card-text">${vo_l.eduLecturer }</h5>
														<h5 class="card-text">${vo_l.eduDifficulty }</h5>
														<a href="#" class="btn btn-primary">$ ${vo_l.eduPrice }</a>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
<jsp:include page="../menu/footer.jsp" />