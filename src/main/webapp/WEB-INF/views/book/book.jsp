<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${bookModel.title}</title>
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	
		<div class="container">
	${bookModel.title}
	
	
	<br> Про книгу: ${bookModel.description}
	<br> Дата публікації: ${bookModel.publicationDate}
	<br> Автор: ${bookModel.authorFirstName} ${bookModel.authorLastName}
	<br> Жанр: ${bookModel.genre}
	<br> В наявності: ${bookModel.availableCopys}
	
	<br> 
	<a href="/book/edit/${bookModel.id}"> Редагувати</a> 
	
	</div>
</body>
</html>