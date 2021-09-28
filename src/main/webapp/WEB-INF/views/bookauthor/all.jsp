<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Автори</title>

</head>
<body>


	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	
		<div class="container">
	<form:form action="/bookauthor/search" method="POST">
		<input name="search" placeholder="Введіть назву" type="text" />
		<input type="submit" value="Знайти">
	</form:form>
	<br>


	<h1>Автори</h1>
	<a href="/bookauthor/create"> Створити</a>
	<br>
		<table class="table table-hover table-bordered">
			<c:forEach items="${authors}" var="author">

				<tr>
					<td><a href="/bookauthor/${author.id}">
							${author.firstName} </a></td>
				
					<td>${author.lastName}</td>
				</tr>

			</c:forEach>

		</table>
	</div>
</body>
</html>