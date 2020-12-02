<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>index.jsp</title>
    <script>
        function checkValue() {
            var form = document.frm;

            if (!form.id.value) {
                alert("아이디를 입력하세요.")
                return false;
            }

            if (!form.password.value) {
                alert("비밀번호를 입력하세요.")
                return false;
            }
            return true;
        }
    </script>
</head>

<body align="center">
    <div align="center">
        <h2>로 그 인</h2>
        <form action="/EncryptionTest/Encryption.do" id="frm" name="frm" method="post" onsubmit="return checkValue()">
            ID <input type="text" id="id" name="id" size="20"><br><br>
            패스워드<input type="password" " id=" password" name="password" size="20">
            <input type="hidden" id="encpassword" name="encpassword">
            <br> <br> <input type="submit" value="등록">&nbsp;&nbsp;&nbsp;
        </form>
    </div>
    <br>
</body>

</html>