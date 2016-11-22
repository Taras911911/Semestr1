<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/newStyle.css">
    <title>О специальности</title>
</head>
<body>
<div class="TablesDiv">

    <c:if test="${current_user != null}">
        <a class="UpGoTo" href="/myPage">Личный кабинет</a><br>
        <a class="UpGoTo" href="/myPage?exit=true">Выйти из аккаунта </a><br>
    </c:if>
    <c:if test="${current_user == null}">
        <a class="UpGoTo" href="/login">Войти</a><br>
        <a class="UpGoTo" href="/registration">Зарегистрироваться</a><br>
    </c:if>

    <h1>${doctor.name}</h1><br>
    <hr>
    <p class="labelLK">Специальность: </p>
    <p class="labelLK">${doctor.speciality.name}</p>
    <br>
    <p class="labelLK">Достижения: </p>
    <c:forEach items="${doctor.achivements}" var="achivment">
        <p class="labelLK">${achivment.type}</p><br>
    </c:forEach>
    <p class="labelLK"> Время, на которое можно записаться:</p><br>

    <table>
        <tbody>

        <tr>
            <th>День недели</th>
            <th>Время</th>
        </tr>

        <c:forEach items="${doctor.times}" var="time">
            <c:if test="${!time.use}">
                <tr>
                    <td><c:out value="${time.day.name}"></c:out></td>
                    <td><a href="/doctors?timeId=${time.id}">${time.time}</a></td>
                </tr>
            </c:if>
            <c:if test="${time.use}">
                <tr>
                    <td><c:out value="${time.day.name}"></c:out></td>
                    <td><c:out value="${time.time}"></c:out></td>
                </tr>
            </c:if>
        </c:forEach>

        </tbody>

    </table>

    <a class="GoTo" href="/doctors"> Вернуться к списку докторов</a><br>
    <a class="GoTo" href="/index.jsp">Домой</a><br>

</div>
</body>
</html>
