<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<form:form method="POST" action="/genre/create/"
           modelAttribute="createGenre">
    <form:input type="text" placeholder="Назва жанру" path="title" />
    <br>

    <button>Створити</button>
</form:form>
</body>
</html>