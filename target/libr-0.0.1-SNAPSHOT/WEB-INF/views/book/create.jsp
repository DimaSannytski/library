<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Створити книгу</title>
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	
		<div class="container">
	<div class="p-3 border bg-light">	
	<form:form method="POST" action="/book/create/"
		modelAttribute="createBook"><div class="input-group mb-3">
		<form:input type="text" placeholder="Назва" path="title" /></div>
		<br><div class="input-group mb-3">
		<form:textarea type="text" placeholder="Опис" path="description" /></div>
		<br>
		<div class="input-group mb-3">
		<form:input type="date" placeholder="Дата" path="publicationDate" /></div>



		<button class="btn btn-outline-success">Створити</button>
	</form:form>
	</div>
</div>
</body>
</html>