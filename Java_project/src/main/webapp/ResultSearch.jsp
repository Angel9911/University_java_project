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
</head>
<body>
<script type="text/javascript">
 function addition(){
    var table = document.getElementById('myTable');

    for(var i = 1; i < table.rows.length; i++)
    {
        table.rows[i].onclick = function()
        {
            //rIndex = this.rowIndex;
            document.getElementById("date").value = this.cells[0].innerHTML;
            document.getElementById("city").value = this.cells[1].innerHTML;
            document.getElementById("time").value = this.cells[2].innerHTML;
        };
    }
 }
</script>
<div id="wrapper">
    <div id="header">
        <h1>ABD Cinema</h1>
    </div>
    <div class="navigation">

        <a class="active" href="#home">Начало</a>
        <a href="#new">Кина</a>
        <a href="Login.jsp">Вход</a>
        <a href="Registration.jsp">Регистрация</a>
    </div>
    <div id="content">
        <p></p>
        <form action="ReseravtionServlet">

        <h2>${NameMovie}</h2>   <p>${GenreMovie}</p>   <p>${ActorsMovie}</p>    <p>${DirectorMovie}</p>   <p>${SummaryMovie}</p>  <p>${LenghtMovie}</p>
        <p>${RatingMovie}</p>   <p>${Genres}</p>   <p>${city}</p>

        <table id="myTable">
            <tr>
                <th>Дата на Прожекция</th>
                <th>Кино(град)</th>
                <th>Време на прожекция</th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <c:forEach var="kino" items="${ListProjectiosName}">
                <td><c:out value="${kino.projection_date}"/></td>
                <td ><c:out value="${kino.city_projetion}"/></td>
                <td ><c:out value="${kino.projection_time}"/></td>
                <td><button onclick="addition()" type="submit">Избери час</button></td>
            </tr>
            </c:forEach>

        </table>
        </form>
        result table:
        First Name:<input type="hidden" name="date" id="date"><br><br>
        Last Name:<input type="hidden" name="city" id="city"><br><br>
        Age:<input type="hidden" name="time" id="time"><br><br>
    </div>
    <div id="footer">
        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
        <p>ABD Cinema.All rights reserved.2021</p>
    </div>
</div>
</body>
</html>
