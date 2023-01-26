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
        <a class="active" href="#home">Начало</a>
        <button type="submit" name="kino">Прожекции</button>
        <a href="Login.jsp">Вход</a>
        <a href="Registration.jsp">Регистрация</a>
    </div>
    <div id="content">
        <form action="RegistServlet" method="post">
            <p class="paragraph1">Потребителско Име</p>
            <input type="text" name="nameClient" placeholder="Въведете вашето име">
            <p class="paragraph1">Въведете имейл</p>
            <input type="text"  name="emailClient" placeholder="Въведете вашият имейл">
            <p class="paragraph1">Въведете телефон</p>
            <input type="text" name="phoneClient" placeholder="Въведете вашият телефон">
            <p class="paragraph1">Въведете възраст</p>
            <input type="text" name="ageClient" placeholder="Въведете вашата възраст">
            <p class="paragraph1">Въведете парола</p>
            <input type="password" name="passClient" placeholder="Въведете парола">
            <input type="submit" name="registration" value="Регистрация">
        </form>
    </div>
    <div id="footer">
        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
        <p>ABD Cinema.All rights reserved.2021</p>
    </div>
</div>
</body>
</html>
