<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Login</title>
</head>
<body>

 <form:form method="POST" commandName="user" action="/">
     <fieldset>
         <form:label path="login">Логин</form:label>
         <form:input path="login"/>

         <form:label path="password">Пароль</form:label>
         <form:password path="password"/>
     </fieldset>

     <footer><input type="submit" value="Войти"/></footer>
 </form:form>

</body>
</html>
