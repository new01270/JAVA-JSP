<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>loginResult.jsp</title>
</head>

<body>
    <div align="center"><br>
        <h1>가입이 완료되었습니다.</h1><br><hr>
        <h2>로 그 인</h2>
        <form action="#" id="frm" name="frm" method="POST">
            <table border="1" style="border-collapse: collapse">
                <tr>
                    <th width="100" style="background:pink;">회원 ID</th>
                    <td><input type="text" id="id" name="id" size="20"></td>
                </tr>
                <tr>
                    <th style="background:pink;">패스워드</th>
                    <td><input type="password"" id="password"" name=" password" size="20"></td>
                </tr>
            </table><br>
            <input type="button" onclick="" value="로그인">&nbsp;&nbsp;&nbsp;
            <input type="button" onclick="location.href='../index.jsp'" value="취 소">
        </form>
    </div>
</body>

</html>