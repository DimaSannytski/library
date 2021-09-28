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
		<c:forEach items="${orderStatus}" var="orderStat">

    <div style="margin-left: 60px;">
				
				<span class="left-top">
						${orderStat.title} </span>

			</div>
		</c:forEach>

	</div>
</body>
</html>