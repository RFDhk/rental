<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mikhail
  Date: 16.10.2017
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новый Сотрудник</title>
</head>
<body>
<form:form name="createEmp" action="/employee/create" commandName="employee" method="POST">
    <form:label path="secondName">Фамилия <form:input type="text" path="secondName" required="required"
                                                      value=""/></form:label>
    <form:errors path="secondName" cssClass="error"/><br/>
    <form:label path="firstName">Имя <form:input type="text" path="firstName" required="required"
                                                 value=""/></form:label>
    <form:errors path="firstName" cssClass="error"/><br/>
    <form:label path="middleName">Отчество <form:input type="text" path="middleName" required="required"
                                                       value=""/></form:label>
    <form:errors path="middleName" cssClass="error"/><br/>
    <form:label path="birthDay">Дата рождения <form:input type="date" path="birthDay" required="required"
                                                          value=""/></form:label>
    <form:errors path="birthDay" cssClass="error"/><br/>
    <form:label path="phoneNumber">Телефон <form:input type="text" path="phoneNumber" required="required"
                                                       value=""/></form:label>
    <form:errors path="phoneNumber" cssClass="error"/><br/>
    <form:label path="email">Эл. почта <form:input type="text" path="email" required="required" value=""/></form:label>
    <form:errors path="email" cssClass="error"/><br/><br/>


    <label>Логин<input type="text" name="login" required="required" value="${login}"></label>
    <span id="loginError">${loginError}</span><br/>
    <label>Пароль <input type="password" name="password" required="required" value=""/></label>
    <span id="passwordError">${passwordError}</span><br/>
    <label>Повторите пароль <input type="password" name="repeatPassword" required="required" value=""/></label>
    <span id="repeatPasswordError">${repeatPasswordError}</span><br/>
    <button type="submit">Создать</button>
</form:form>
</body>
</html>

