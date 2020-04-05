<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Output</title>
</head>
<body>
    <h2>출력 화면</h2>
    <div>
        입력한 텍스트는 '<span><c:out value="${echoForm.text}" /></span>' 입니다.
    </div>
    <br>
    <div>
        <a href="<c:url value='/' />">최상위 페이지로 이동</a>
    </div>
</body>
</html>