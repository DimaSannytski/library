<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<div class="container">
<div class="p-3 border bg-light">
<form:form method="POST" action="/genre/create/"
           modelAttribute="createGenre">
           <div class="input-group mb-3">
    <form:input type="text" placeholder="Назва жанру" path="title" />
    </div>
    <br>
    <button class="btn btn-outline-success">Створити</button>
</form:form>
</div>
</div>
</body>
</html>