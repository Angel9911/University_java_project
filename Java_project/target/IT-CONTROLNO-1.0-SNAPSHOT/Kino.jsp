<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="MainStyle.css">
    <title>Начало</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1>ABD Cinema</h1>
    </div>
    <div class="navigation">
        <form>
            <a class="active" href="#home">Начало</a>
            <button type="submit" name="kino">Кина</button>
            <a href="Login.jsp">Вход</a>
            <a href="Registration.jsp">Регистрация</a>
        </form>
    </div>
    <div id="content">
            <table class="UserTble">
                <tr>
                    <th>Град</th>
                    <th>Дата на прожекция</th>
                    <th>Време на прожекция</th>
                    <th>Общ брой Места в залата</th>
                </tr>
                <tr>
                    <c:forEach var="kino" items="${cinemaList}">
                    <td><c:out value="${kino.city_projetion}"/></td>
                        <td><c:out value="${kino.projection_date}"/></td>
                        <td><c:out value="${kino.projection_time}"/></td>
                    <td><c:out value="${kino.max_seats}"/></td>
                </tr>
                </c:forEach>

            </table>
    </div>
    <div id="footer">
        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
        <p>ABD Cinema.All rights reserved.2021</p>
    </div>
</div>
</body>
