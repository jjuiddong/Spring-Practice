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
    <h2>��� ȭ��</h2>
    <div>
        �Է��� �ؽ�Ʈ�� '<span><c:out value="${echoForm.text}" /></span>' �Դϴ�.
    </div>
    <br>
    <div>
        <a href="<c:url value='/' />">�ֻ��� �������� �̵�</a>
    </div>
</body>
</html>