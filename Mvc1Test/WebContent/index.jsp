<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- meta, title, script, style in <head/>  -->
<meta charset="UTF-8">
<title>my home</title>
</head>
<body>
	<!-- jsp forward action tag를 이용해서 redirect 수행. 
	<jsp:forward page="jsp/main/main.jsp" />-->


	<!-- response 객체를 이용해서 redirect 수행. 
response.sendRedirect("jsp/main/main.jsp");"); %>-->
			
	<!-- javascript 이용하여 redirect -->
	<script type="text/javascript">
		location.href = "jsp/main/main.jsp"
	</script>
</body>
</html>
