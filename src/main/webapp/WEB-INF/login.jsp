<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de Sesión</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-4">
				<h1>Inicia Sesión</h1>
				
				<c:if test="${errorMessage != null}">
					<p class="text-danger">${errorMessage}</p>
				</c:if>
				
				<form action="/login" method="post">
					<div class="form-group">
						<label>Username</label>
						<input type="text" class="form-control" name="username" />
					</div>
					<div class="form-group">
						<label>Password</label>
						<input type="password" class="form-control" name="password" />
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<input type="submit" class="btn btn-info" value="Iniciar Sesión" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>