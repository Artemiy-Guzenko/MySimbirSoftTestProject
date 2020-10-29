<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>
<html>
<head>
    <title>Result for current URL</title>
    <style>
        <%@include file="resources/style.css" %>
    </style>
</head>

<body>
<h1>List of unique word on page:</h1>
<p>${url.path}</p>

<c:if test="${!empty resultMap}">
    <table class="gridtable">
        <tr>
            <th>Word</th>
            <th>Count</th>
        </tr>
        <c:forEach var="entry" items="${resultMap}">
            <tr>
                <td>${entry.key}</td>
                <td>${entry.value}</td>
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
