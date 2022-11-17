<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Телефонная книга</title>
<%--    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">--%>
</head>
<body>
<form action="/action_page.php">
    <label for="fname">First name:</label><br>
    <input type="text" id="fname" name="fname" value="John"><br>
    <label for="lname">Last name:</label><br>
    <input type="text" id="lname" name="lname" value="Doe"><br><br>
    <input type="submit" value="Submit">
</form>
<table>
    <thead>
    <tr>
        <th>Отдел</th>
        <th>Работники</th>
        <th>Номера телефонов</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${departments}" var="department">
        <% out.print("dep"); %>
        <tr>
            <td>${department.department}</td>

            <td>
                <table>
                <c:forEach items="${department.workers}" var="worker">
                    <tr>
                        <td>${worker.surname}</td>
                    </tr>
                </c:forEach>
                </table>
            </td>

            <td>
                <table>
                    <c:forEach items="${department.numbers}" var="number">
                        <tr><td>${number}</td></tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>