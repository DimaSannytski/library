<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ff</title>
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>

	<div class="container">
		<h1>Створені ордери</h1>
		<table class="table table-hover table-bordered">
			<c:forEach items="${createdOrders}" var="createdOrder">

				<tr>
					<td>${createdOrder.id}</td>
				<td> ${createdOrder.book.title} </td>		
				<td> ${createdOrder.orderStatus.title} </td>	
				<td> ${createdOrder.createdAt} </td>				
				</tr>		
			</c:forEach>
	</table>
	</div>
</body>
</html>