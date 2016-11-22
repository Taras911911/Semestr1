
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/newStyle.css">
    <title>Врачи</title>
</head>
<body>


<div class="TablesDiv">

    <h1>Список врачей</h1>

    <c:if test="${current_user != null}">
        <a class="UpGoTo" href="/myPage">Личный кабинет</a><br>
        <a class="UpGoTo" href="/myPage?exit=true">Выйти из аккаунта </a><br>
    </c:if>
    <c:if test="${current_user == null}">
        <a class="UpGoTo" href="/login">Войти</a><br>
        <a class="UpGoTo" href="/registration">Зарегистрироваться</a><br>
    </c:if>

    <hr>

    <table>
        <tbody>

        <tr>
            <th>ФИО</th>
            <th>Специальность</th>
            <th>Достижения</th>
        </tr>

        <c:forEach items="${doctors}" var="doctor">
            <tr>
                <td><a href="/doctors?id=${doctor.id}">${doctor.name}</a></td>
                <td><c:out value="${doctor.speciality.name}"></c:out></td>
                <td><c:out value="${doctor.getAchToString()}"></c:out></td>
            </tr>
        </c:forEach>

        </tbody>

    </table>


    <a class="GoTo" href="/index.jsp">Домой</a><br>

</div>

</body>
</html>
