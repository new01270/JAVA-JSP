<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>login.jsp</title>
    <script type="text/javascript">
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

            if (form.id.value == "hong" && form.password.value == "1234") {
                form.submit();
                alert("로그인 성공")
            } else {
            	form.submit();
                alert("로그인 실패")
            }

        }
    </script>
</head>

<body>
    <div align="center"><br>
        <h2>로 그 인</h2>
        <form action="/Test1130/TestLogin.do" id="frm" name="frm" method="post" onsubmit="return checkValue()">
            <table border="1" style="border-collapse: collapse">
                <tr>
                    <th width="100" style="background:pink;">회원 ID</th>
                    <td><input type="text" id="id" name="id" size="20"></td>
                </tr>
                <tr>
                    <th style="background:pink;">패스워드</th>
                    <td><input type="password"" id=" password" name="password" size="20"></td>
                </tr>
            </table><br>
            <input type="button" onclick="checkValue()" value="로그인">&nbsp;&nbsp;&nbsp;
            <input type="button" onclick="location.href='../index.jsp'" value="취 소">
        </form>
    </div>
</body>

</html>