<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<html>
<head>
	<meta charset="EUC-KR">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<ul>
	<li><a href="<c:url value='/echo' />">에코 애플리케이션으로 이동</a></li>
</ul>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
