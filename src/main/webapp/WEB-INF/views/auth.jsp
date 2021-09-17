<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
 <%@include file="/WEB-INF/views/includes/header.jsp" %>

	<form:form action="/libr" method="POST"
		modelAttribute="registerModel" class="login">
		<br>
		<h1 style="text-align: center; color: #464646">Реєстрація</h1>
		<br>
		<br>
		<form:input type="email"
			pattern="[a-zA-Z0-9_]+(?:\.[A-Za-z0-9!#$%&amp;'*+/=?^_`{|}~-]+)*@(?!([a-zA-Z0-9]*\.[a-zA-Z0-9]*\.[a-zA-Z0-9]*\.))(?:[A-Za-z0-9](?:[a-zA-Z0-9-]*[A-Za-z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?"
			placeholder="Введіть email" path="email" />
		<form:errors path="email" cssClass="error" />
		<br>
		<br>
		<form:input type="text" placeholder="Ім'я" path="firstName"
			pattern="[A-Za-z]{2,}" name="userLogin" />
		<form:errors path="firstName" cssClass="error" />
		<br>
		<br>
		<form:input type="text" placeholder="Прізвище" path="lastName"
			pattern="[A-Za-z]{2,}" name="userLogin" />
		<form:errors path="lastName" cssClass="error" />
		<br>
		<br>
		<form:select path="sex">
			<c:forEach items="${sexs}" var="sex">
				<form:option value="${sex}">${sex.sex}</form:option>
			</c:forEach>
		</form:select>
		<br><br>
		<form:input type="password" placeholder="Введіть пароль"
			id="password1" name="userPass"
			pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
			title="Не менеше 6 символів, як мінімум одна цифра і одна велика літера"
			path="password" />
		<form:errors path="password" cssClass="error" />
		<br><br>
		<form:input type="password" placeholder="Повторіть пароль"
			id="password" name="userPass1"
			pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
			path="passwordConfirm" />
		<br><br>
		<button id="register">Реєстрація</button>


	</form:form>
</body>
</html>