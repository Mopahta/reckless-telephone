<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Телефонная книга</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script><%@include file="../../scripts/index.js"%></script>
</head>
<body>

<form action="${pageContext.request.contextPath}/" method="GET">
    <label for="fullname">Полное имя:</label><br>
    <input type="text" id="fullname" name="fullname" value=""><br>
    <label for="number">Номер телефона:</label><br>
    <input type="text" id="number" name="number" value=""><br><br>
    <label for="mail">Рабочая почта:</label><br>
    <input type="text" id="mail" name="mail" value=""><br><br>
    <label for="position">Должность:</label><br>
    <input type="text" id="position" name="position" value=""><br><br>
    <label for="department">Отдел:</label><br>
    <input type="text" id="department" name="department" value=""><br><br>
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
                        <td>${worker.name}</td>
                        <td>${worker.workingMail}</td>
                        <td>${worker.position}</td>
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
