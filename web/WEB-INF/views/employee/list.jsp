<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mikhail
  Date: 22.10.2017
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список сотрудников</title>
</head>
<body>
<form:form name="employeeTable" commandName="employeeTable" modelAttribute="employeeTable" method="POST" action="/employee/">
    <button type="submit" name="remove">Удалить</button>
<table>
    <c:forEach items="${employeeTable.employeeRows}" var="employeeRow" varStatus="vs">
        <tr>
            <td><form:label path="employeeRows[${vs.index}].check">
                <form:checkbox path="employeeRows[${vs.index}].check" value="${employeeRow.check}" />
            </form:label></td>
            <td><form:label path="employeeRows[${vs.index}].secondName">
                <form:input path="employeeRows[${vs.index}].secondName" type="text" value="${employeeRow.secondName}" />
            </form:label></td>
            <td><form:label path="employeeRows[${vs.index}].firstName">
                <form:input path="employeeRows[${vs.index}].firstName" type="text" value="${employeeRow.firstName}" />
            </form:label></td>
            <td><form:label path="employeeRows[${vs.index}].middleName">
                <form:input path="employeeRows[${vs.index}].middleName" type="text" value="${employeeRow.middleName}" />
            </form:label></td>
            <td><form:label path="employeeRows[${vs.index}].phoneNumber">
                <form:input path="employeeRows[${vs.index}].phoneNumber" type="text" value="${employeeRow.phoneNumber}" />
            </form:label></td>
            <td><form:label path="employeeRows[${vs.index}].birthDay">
                <form:input path="employeeRows[${vs.index}].birthDay" type="text" value="${employeeRow.birthDay}" />
            </form:label></td>
        </tr>
    </c:forEach>
    <%-- EXAMPLE

    http://viralpatel.net/blogs/spring-mvc-multi-row-submit-java-list/--%>

</table>
</form:form>
</body>
</html>
