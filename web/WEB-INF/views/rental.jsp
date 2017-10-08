<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Rental</title>
</head>
<body>
<p> Hello, ${user.login}</p>
<p> Your password is ${user.password}</p>
<form:form method="POST" action="/logout">
    <input type="submit" value="Выйти"/>
</form:form>
</body>
</html>
