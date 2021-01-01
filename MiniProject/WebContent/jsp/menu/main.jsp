<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
</head>
<jsp:include page="head.jsp" />

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
							<h1 class="fashion_taital">
								따끈따끈, 신규 강의를 만나보세요! 🙋🏻‍♀️<span
									style="color: red; font-size: 15px;">NEW!!</span>
							</h1>
							<div class="fashion_section_2">
								<div class="row">
									<div class="row row-cols-1 row-cols-md-3 g-4">
										<c:forEach var="vo1" items="${listNew }">
											<div class="fuck">
												<div class="card" style="width: 18rem; height: 25rem"
													onclick="location.href='/MiniProject/EduRead.do?id=${vo1.eduNumber}'">
													<img class="card-img-top" src="images/${vo1.eduImg}"
														alt="Card image cap">
													<div class="card-body">
														<h5 class="card-title" style="height: 60px">${vo1.eduTitle }</h5>
														<h5 class="card-text">${vo1.eduLecturer }</h5>
														<h5 class="card-text">난이도 : ${vo1.eduDifficulty }</h5>
														<a href="#" class="btn btn-primary">${vo1.eduPrice }</a>
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
							<h1 class="fashion_taital">
								인기강의, 여기서 시작해 보세요! 🏃🏻‍♀️<span
									style="color: red; font-size: 15px;">READY!!</span>
							</h1>
							<div class="fashion_section_2">
								<div class="row">
									<div class="row row-cols-1 row-cols-md-3 g-4">
										<c:forEach var="vo1" items="${listGood }">
											<div class="fuck">
												<div class="card" style="width: 18rem; height: 25rem" onclick="location.href='/MiniProject/EduRead.do?id=${vo1.eduNumber}'">
													<img class="card-img-top" src="images/${vo1.eduImg}"
														alt="Card image cap">
													<div class="card-body">
														<h5 class="card-title" style="height: 60px">${vo1.eduTitle }</h5>
														<h5 class="card-text">${vo1.eduLecturer }</h5>
														<h5 class="card-text">${vo1.eduDifficulty }</h5>
														<a href="#" class="btn btn-primary">$ ${vo1.eduPrice }</a>
													</div>
												</div>
												&nbsp;
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
<jsp:include page="footer.jsp" />

</html>