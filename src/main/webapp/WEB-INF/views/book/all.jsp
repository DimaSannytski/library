<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Книги</title>
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>

	<div class="container">

		<form:form action="/book/search" method="POST">
			<input name="search" placeholder="Введіть назву" type="text" />
			<input type="submit" value="Знайти">
		</form:form>
		<br>


		<h1>Книги</h1>
		<a href="/book/create"> Створити</a> <br>
		<table class="table table-hover table-bordered">
			
			<c:forEach items="${bookModel}" var="book">

				<tr>
				 <td>
				 <div style="margin-left: 60px;">
				<a href="/book/${book.id}">	${book.title} </a>
				</div>
				</td>
				
				</tr>		
			</c:forEach>
		</table>
	</div>
</body>
</html>