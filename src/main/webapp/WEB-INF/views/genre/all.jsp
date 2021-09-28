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

	<br>

	<div class="container">
		<h1>Жанри</h1>
		<a href="/genre/create"> Створити</a> <br>
		<table class="table table-hover table-bordered">
			<c:forEach items="${genres}" var="genre">


				<tr>
					<td><a href="/genre/${genre.id}"><span class="left-top">
								${genre.title} </span></a></td>

				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>