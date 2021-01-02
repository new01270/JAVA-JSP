<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="/jsp/menu/head.jsp" />

<head>
	<meta charset="UTF-8">
	<title>eduRead.jsp</title>
	<style>
		video {
			max-width: 50%;
			display: block;
			margin: 20px auto;
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
											<img width="20%" src="images/${vo.eduImg}"> <br>
											<hr>
										</div>
									</div>
									<div class="row mb-3">
										<div class="col-md-12" align="center">
											<div class="card">
												<div class="card-body">
													<P
														style="color: black;; font-size: 28px; font-weight: bold; height: 2rem">
														${vo.eduTitle}</P>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12" align="center">
											<video muted autoplay loop>
												<source src="video/semiVideo.mp4" type="video/mp4">
											</video>
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
									<P style="font-size: 20px; font-weight: bold">SKILL</p>
									<h4>${vo.eduSkill}</h4>
								</div>
							</div>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-md-12" align="center">
							<div class="card">
								<div class="card-body">
									<P style="font-size: 20px; font-weight: bold">${vo.eduPrice}</p>
									<button type="button" class="btn btn-sm btn-primary2 btn-create">수강하기</button>
								</div>
							</div>
						</div>
					</div>
					<div align="center">
						<p>&nbsp;
							<p />
					</div>
				</div>
			</div>
		</div>
	</section>
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
</body>
<jsp:include page="/jsp/menu/footer.jsp" />

</html>