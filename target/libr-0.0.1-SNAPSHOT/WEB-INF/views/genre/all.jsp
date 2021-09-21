<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp"%>

<br>


<h1>Жанри</h1>
<a href="/genre/create"> Створити</a>
<br>
<c:forEach items="${genres}" var="genre">1

    <div style="margin-left: 60px;">
        <a href="/genre/${genre.id}"><span class="left-top">
                ${genre.title} </span></a>

    </div>
</c:forEach>
</body>
</html>