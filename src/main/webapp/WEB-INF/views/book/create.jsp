<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Створити книгу</title>
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	<div class="container">
		<div class="p-3 border bg-light">
			<form:form method="POST" action="/book/create/"
				modelAttribute="createBook">
				<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-small">Назва</span>
					<form:input type="text" placeholder="Назва" path="title" />
				</div>
				<br>
				<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-small">Опис</span>
					<form:textarea type="text" placeholder="Опис" path="description" />
				</div>
				<br>
				<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-small">Дата публікації</span>
					<form:input type="date" placeholder="Дата" path="publicationDate" />
				</div>

				<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-small">Автор</span>
					<form:select path="authorId">
						<c:forEach items="${authors}" var="author">
							<form:option value="${author.id}">${author.firstName} ${author.lastName}</form:option>
						</c:forEach>
					</form:select>
				</div>
					<div class="input-group mb-3">
					<span class="input-group-text" id="inputGroup-sizing-small">Жанр</span>
					<form:select path="genreId">
						<c:forEach items="${genres}" var="genre">
							<form:option value="${genre.id}">${genre.title}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-small">Кількість копій</span>
					<form:input type="number"  path="copyCount" />
				</div>
				<button class="btn btn-outline-success">Створити</button>
			</form:form>
		</div>
	</div>
</body>
</html>