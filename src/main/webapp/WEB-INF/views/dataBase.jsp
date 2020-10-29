<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>
<html>
<head>
    <title>Database of Project</title>
    <style>
        <%@include file="resources/style.css" %>
    </style>
</head>

<body>
<h1>Database of the Project</h1>

<c:if test="${empty listAllUrls}">
    <h1>Our database is still empty</h1>
</c:if>

<c:if test="${!empty listAllUrls}">
    <table class="gridtable">
        <tr>
            <th>Path</th>
            <th>Word</th>
            <th>Count</th>
        </tr>
        <c:forEach var="url" items="${listAllUrls}">
            <tr>
                <td>${url.path}</td>
                <td>${url.word}</td>
                <td>${url.count}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<a href="/">Back to base page</a>

<br/>

<p>© Guzenko A.A., 2020</p>
<p>artemiyguzenko@gmail.com</p>

</body>
</html>
