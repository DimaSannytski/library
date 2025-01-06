<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Авторизація</title>
</head>
<body>
 <%@include file="/WEB-INF/views/includes/header.jsp" %>
 <div class="container">
 <div class="p-3 border bg-light">
	<form:form action="/login" method="POST" class="login">
		<br>
		<h1 style="text-align: center; color: #464646;">Авторизація</h1>
		<br>
	<div class="input-group mb-3">
		<input type="email" placeholder="Введіть email" name="email"
			id="email" />
		</div>
		<input type="password" placeholder="Введіть пароль" name="password"
			id="password" pattern="[A-Za-z0-9]{3,}">
		<br>
                	Запам'ятати мене:
	<div class="input-group mb-3"><input type="checkbox" name="rememberme"> </div>
		
		<button value="login" class="btn btn-outline-success">Увійти</button>

		<c:if test="${param.fail}">
			<p style="color: red;">Login or password is incorrect</p>
		</c:if>
	</form:form>
	<form class="login">Ще немає аккаунту?<a class="exit" href="/auth"> Зареєструйтесь</a>
	</form>
	</div>
	</div>
</body>
</html>