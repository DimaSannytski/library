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
		<h1>Статуси замовлень</h1>
		<a href="/orderstatus/create"> Створити</a> <br>
		<table class="table table-hover table-bordered">
			<c:forEach items="${orderStatus}" var="orderStat">

				<tr>
					<td><span class="left-top"> ${orderStat.title} </span></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>