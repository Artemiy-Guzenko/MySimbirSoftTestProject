<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>

<html>
<head>
    <title>My SimbitSoft Test Project</title>
    <style>
        <%@include file="resources/style.css" %>
    </style>
</head>

<body>
<h1>My SimbirSoft Test Project</h1>
<br/>
<p>Подсчёт количества уникальных слов на странице</p>

<br/>
<hr>
<div class="button_box2">
<form class="form-wrapper-2 cf" method="post" action="/result">
    <label for="url">URL</label>
    <input name="url" type="text" id="url" placeholder="https://">
    <br>
    <input type="submit" value="GO!">
</form>
</div>

<br/>
<br/>
<br/>
<br/>

<hr>
<a href="/dataBase">Просмотр Базы Данных</a>

<br/>
<br/>
<br/>
<hr>
<p>© Guzenko A.A., 2020</p>
<p>artemiyguzenko@gmail.com</p>

</body>
</html>
