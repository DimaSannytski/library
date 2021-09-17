<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	<form:form method="POST" action="/bookauthor/create/"
		modelAttribute="createAuthor">
		<form:input type="text" placeholder="Ім'я" path="firstName" />
		<br>
		<form:input type="text" placeholder="Прізвище" path="lastName" />
		<br>



		<button>Створити</button>
	</form:form>

</body>
</html>