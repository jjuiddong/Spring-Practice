<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Input</title>
</head>
<body>
    <h2>입력 화면</h2>
    <form:form modelAttribute="echoForm">
        <div>텍스트를 입력해 주세요:</div>
        <div>
            <form:input path="text" />
            <form:errors path="text" />
        </div>
        <div>
            <form:button>전송</form:button>
        </div>
    </form:form>
</body>
</html>
