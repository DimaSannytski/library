<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Створити автора</title>
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
		<div class="container">
		<div class="p-3 border bg-light">
	<form:form method="POST" action="/bookauthor/create/"
		modelAttribute="createAuthor">
		<div class="input-group mb-3">
		<form:input type="text" placeholder="Ім'я" path="firstName" /></div>
		<br>
		<div class="input-group mb-3">
		<form:input type="text" placeholder="Прізвище" path="lastName" /> </div>
		<br>
		<button class="btn btn-outline-success">Створити</button>
	</form:form>

	</div>
</div>
</body>
</html>