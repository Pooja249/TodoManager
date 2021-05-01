<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>hello</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center">Welcome to TODO.</h1>

		<c:if test="${not empty msg }">


			<div class="alert alert-success">

				<b><c:out value="${msg}"></c:out></b>
			</div>
		</c:if>
		<div class="row mt-5">
		<div class="col-md-3 text-center">

				<div class="list-group">
					<button type="button"
						class="list-group-item list-group-item-action active">Menu</button>
					<a href='<c:url value='/add'></c:url>'
						class="list-group-item list-group-item-action">Add Todo</a> 
					
					
					
					<a href='<c:url value='/home'></c:url>'
						class="list-group-item list-group-item-action">View Todo</a>

				</div>
			</div>
			<div class="col-md-9 text-center">
				<h3>
					<h1 class="text-center">Update Todo</h1>
					<br>
					<form:form action="${pageContext.request.contextPath }/saveTodo" method="post" modelAttribute="todo">
					<div class="form-group">
							<form:input path="todoId" class="form-control"
								placeholder="Enter title" />
						</div>
						<div class="form-group">
							<form:input path="todoTitle" class="form-control"
								placeholder="Enter title" />
						</div>
						<div class="form-group">
							<form:textarea path="todoContent" class="form-control"
								placeholder="Enter Content" cssStyle="height:300px" />
						</div>
						<div class="container text-center">
							<button class="btn btn-outline-success">Update Todo</button>
						</div>
					</form:form>
				</h3>

			</div>
		</div>
	</div>


</body>
</html>