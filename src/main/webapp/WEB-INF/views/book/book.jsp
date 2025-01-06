<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${bookModel.title}</title>
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	<div class="container">
		${bookModel.title} <br> Про книгу: ${bookModel.description} <br>
		Дата публікації: ${bookModel.publicationDate} <br> Автор:
		${bookModel.authorFirstName} ${bookModel.authorLastName} <br>
		Жанр: ${bookModel.genre} <br> В наявності:
		${bookModel.availableCopys} <br>
		<sec:authorize access="hasRole('USER') or hasRole('ADMIN')">
			<a href="/book/edit/${bookModel.id}"> Редагувати</a>
		</sec:authorize>
		<br>
		<c:if test="${bookModel.availableCopys > 0}">
			<form:form method="POST" action="/order/book?id=${bookModel.id}" >
				<button class="btn btn-outline-success">Замовити</button>
			</form:form>
		</c:if>
		<br>
	</div>
</body>
</html>