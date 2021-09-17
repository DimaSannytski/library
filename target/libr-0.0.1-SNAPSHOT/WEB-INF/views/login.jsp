<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/login" method="POST" class="login">
		<br>
		<h1 style="text-align: center; color: #464646;">Авторизація</h1>
		<br>

		<input type="email" placeholder="Введіть email" name="email"
			id="email" />
		<br>
		<input type="password" placeholder="Введіть пароль" name="password"
			id="password" pattern="[A-Za-z0-9]{3,}">
		<br>
                	Запам'ятати мене:
	<input type="checkbox" name="rememberme">
		<br>
		<button value="login">Увійти</button>

		<c:if test="${param.fail}">
			<p style="color: red;">Login or password is incorrect</p>
		</c:if>

	</form:form>
	<form class="login">Ще немає аккаунту?<a class="exit" href="/auth"> Зареєструйтесь</a>
	</form>
</body>
</html>