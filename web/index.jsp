
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/newStyle.css">
    <title>Справочник пациента</title>
</head>

<div class="IndexDiv">

    <h1>Справочник пациента</h1>


    <c:if test="${current_user != null}">
        <a class="UpGoTo" href="/myPage">Личный кабинет</a><br>
        <a class="UpGoTo" href="/myPage?exit=true">Выйти из аккаунта </a><br>
    </c:if>
    <c:if test="${current_user == null}">
        <a class="UpGoTo" href="/login">Войти</a><br>
        <a class="UpGoTo" href="/registration">Зарегистрироваться</a><br>
    </c:if>

    <hr>

    <a class="link" href="/hospitals">Список больниц</a><br><br>
    <a class="link" href="/doctors">Список врачей</a><br>


</div>
</body>
</html>

