<%@ page import="com.example.IT_CONTROLNO.model.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.IT_CONTROLNO.DAO.MovieDAO" %>
<%@ page import="java.sql.SQLException" %>
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
<% List<Movie> cityList = null;
   List<Movie> movieList=null;
  MovieDAO movieDAO=new MovieDAO();
    try{
        cityList= movieDAO.selectCityOfProjection();
        movieList=movieDAO.selectMoviesOfProjections();
    } catch (SQLException | ClassNotFoundException throwables) {
        throwables.printStackTrace();
    }
    request.setAttribute("cityList",cityList);
    request.setAttribute("movieList",movieList);


%>
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
            <input type="hidden" id="search"name="search">
            <h2 class="recentClient">Добре дошли: ${recentNameClient}</h2>
        </form>
    </div>
    <div id="content">
        <form action="AfterSearchServlet" method="post">
        Изберете град: &nbsp
        <select name="cities" id="cities">
            <c:forEach var="city" items="${cityList}">
                <option value="${city.city_movie}">${city.city_movie}</option>
                </option>
            </c:forEach>
        </select>
        Изберете филм: &nbsp
        <select name="movies" id="movies">
            <c:forEach var="movie" items="${movieList}">
                <option value="${movie.name_movie}">${movie.name_movie}</option>
                </option>
            </c:forEach>
        </select>
        Изберете дата: &nbsp
        <input type="date" name="projDate">
            или
        <input type="text" name="nameMovie" id="nameMovie">
        <input type="submit" name="search" value="Търси">
        <input type="hidden" name="city" id="city">
        <input type="hidden" name="movie" id="movie">
        </form>
    </div>
    <div id="footer">
        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
        <p>ABD Cinema.All rights reserved.2021</p>
    </div>
</div>
</body>
</html>
