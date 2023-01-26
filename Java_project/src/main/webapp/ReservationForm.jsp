<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="MainStyle.css">
    <title>Начало</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/jquery.min.js"></script>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1>ABD Cinema</h1>
    </div>
    <div class="navigation">
        <form action="HelloServlet" method="post">
            <a class="active" href="#home">Начало</a>
            <button type="submit" name="kino">Прожекции</button>
            <a href="Login.jsp">Вход</a>
            <a href="Registration.jsp">Регистрация</a>
        </form>
    </div>
    <div id="content">
       <h2>Вие избрахте:</h2>
    </div>
    <div id="footer">
        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
        <p>ABD Cinema.All rights reserved.2021</p>
    </div>
</div>
</body>
</html>
