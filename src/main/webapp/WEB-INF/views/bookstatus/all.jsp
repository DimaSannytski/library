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
	<div class="container">
		<h1>Статуси книжок</h1>
		<a href="/bookstatus/create"> Створити</a> <br>

		<table class="table table-hover table-bordered">
			<c:forEach items="${bookStatus}" var="bookStatus">
				<tr>
					<td><a href="/bookstatus/${bookStatus.id}"><span
							class="left-top"> ${bookStatus.title} </span></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>