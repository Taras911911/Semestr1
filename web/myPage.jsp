
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/newStyle.css">
    <title>Личный кабинет</title>
</head>
<body>

<div class="myPageDiv">

<h1>Добро пожаловать, ${user.surname} ${user.name}</h1>

    <a class="UpGoTo" href="/index.jsp">Домой</a><br>
    <a class="UpGoTo" href="/myPage?exit=true" >Выйти из аккаунта </a><br>

<p id="whatToDo">Здесь вы можете посмотреть свои записи.</p>

<hr>

    <table>
        <tbody>

        <tr>
            <th>Доктор</th>
            <th>День недели</th>
            <th>Время</th>
        </tr>

        <c:forEach items="${times}" var="time">
            <tr>
                <td><a href="/doctors?id=${time.doctor.id}">${time.doctor.name}</a></td>
                <td><c:out value="${time.day.name}"></c:out></td>
                <td><c:out value="${time.time}"></c:out></td>
            </tr>
        </c:forEach>

        </tbody>

    </table>


</div>
</body>
</html>
