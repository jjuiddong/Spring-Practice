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
    <h2>�Է� ȭ��</h2>
    <form:form modelAttribute="echoForm">
        <div>�ؽ�Ʈ�� �Է��� �ּ���:</div>
        <div>
            <form:input path="text" />
            <form:errors path="text" />
        </div>
        <div>
            <form:button>����</form:button>
        </div>
    </form:form>
</body>
</html>
