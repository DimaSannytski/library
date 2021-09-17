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
	<form:form action="/search" method="POST">
		<input name="search" placeholder="Введіть назву" type="text" />
		<input type="submit" value="Знайти">
	</form:form>
	<br>


	<h1>Книги</h1>
	<a href="/book/create"> Створити</a>
	<br>
	<c:forEach items="${bookModel}" var="book">

		<div style="margin-left: 60px;">
			<a href="/book/${book.id}"><span class="left-top">
					${book.title} </span></a>

		</div>
	</c:forEach>
</body>
</html>