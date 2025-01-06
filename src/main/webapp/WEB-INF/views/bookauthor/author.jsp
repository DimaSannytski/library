<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${authorModel.firstName} ${authorModel.lastName}</title>
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
		<div class="container">
	${authorModel.firstName}
	<br> ${authorModel.lastName}
	<br>
</div>
</body>
</html>