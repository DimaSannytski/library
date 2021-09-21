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
<form:form method="POST" action="/bookstatus/create/"
           modelAttribute="createBookStatus">
    <form:input type="text" placeholder=" Статус" path="title" />
    <br>
    <button>Створити</button>
</form:form>
</body>
</html>