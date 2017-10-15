<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Login</title>
</head>
<body>

<c:if test="${not empty error}">
    ${error}
</c:if>

<form name="login" action="/login" method="POST">
    <label> Логин:
        <input type="text" name="user_login" value=""/>
    </label>
    <label> Пароль:
        <input type="password" name="user_password"/>
    </label>

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <button type="submit">Войти</button>
</form>

</body>
</html>
