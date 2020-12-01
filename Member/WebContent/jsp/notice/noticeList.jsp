<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>noticeList.jsp</title>
</head>

<body>
    <div align="center">
        <div><br>
            <h2>공지사항 목록</h2>
        </div>
        <div align="center">
            <table border="1" style="border-collapse: collapse">
                <tr>
                    <th width="100" height="40">순번</th>
                    <th width="250" height="40">제목</th>
                    <th width="150" height="40">작성일자</th>
                    <th width="150" height="40">작성자</th>
                    <th width="100" height="40">조회수</th>
                    <th width="150" height="40">첨부파일</th>
                </tr>
                <c:forEach var="vo" items="${list}">
                    <tr>
                        <td height="30">${vo.noticeid}</td>
                        <td height="30">${vo.noticetitle}</td>
                        <td height="30">${vo.noticedate}</td>
                        <td height="30">${vo.noticewriter}</td>
                        <td height="30">${vo.noticehit}</td>
                        <c:if test="${vo.noticeattach ne null }">
                            <td align="center">😍</td>
                        </c:if>
                        <c:if test="${vo.noticeattach eq null }">
                            <td align="center">🤢</td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <div>
                <form action="#" id="frm" name="frm" method="POST">
                    <input type="hidden" id="no" name="no">
                    <c:if test="${auth eq 'admin'}">
                        <button type="button" onclick="location.href='jsp/notice/noticeForm.jsp'">글쓰기</button>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</body>

</html>