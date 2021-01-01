<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="/jsp/menu/head.jsp" />

<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<!-- 플로팅 배너 -->
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function () {
			$(window).scroll(function () {
				var top = $(window).scrollTop();
				$(".main_right").animate({
					"top": top + 50 + "px"
				}, 30);
			});
			$(".main_right").click(function () {
				$("html,body").animate({
					scrollTop: 0
				}, 100);
			});
		});
	</script>

	<script>
		$.fn.generateStars = function () {
			return this.each(function (i, e) {
				$(e).html($('<p/>').width($(e).text() * 16));
			});
		};

		// 숫자 평점을 별로 변환하도록 호출하는 함수
		$('.star-prototype').generateStars();
	</script>

	<style>
		div>div.jumbotron {
			width: 298px;
			height: 450px;
			float: right;
			margin-right: 3%;
		}

		,
		div.padding_main {
			margin-left: 3%;
		}

		,
		iframe {
			margin-left: 3%;
			margin-right: 10%;
		}

		,
		div>div>iframe#descriptTable {
			margin-left: 10%;
			margin-right: 10%;
		}
	</style>


</head>

<body>
	<div>
		<div class="jumbotron">
			<a class="detailFont">강의명: ${vo.eduTitle}</a>
			<p class="detailFont">강사: ${vo.eduLecturer}</p>
			<p class="detailFont">조회수: ${vo.eduHit}</p>
			<p class="detailFont">키워드: ${vo.eduKeyword}</p>
			<a class="btn btn-primary btn-lg" href="#" role="button">장바구니</a>
		</div>
		<div class="padding_main">
			<div>
				<img width="20%" src="images/${vo.eduImg}"> <a class="detailFont">강의명: ${vo.eduTitle}</a>

			</div>

			<div class='main_nav'>
				<div id='main_right' class='main_right'>
					<p class="navFont">강의료:${vo.eduPrice}</p>
					<p class="navFont">분야: ${vo.eduSkill }</p>
					<p class="navFont">별점:${vo.eduDifficulty}</p>
				</div>

			</div>
		</div>
	</div>
</body>
<jsp:include page="/jsp/menu/footer.jsp" />

</html>