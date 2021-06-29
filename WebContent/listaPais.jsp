<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Lista de Paises</title>
</head>
<body>
	<jsp:useBean class="dao.CountryDAO" id="countryDAO"></jsp:useBean>
	<h1>
		<b>Paises</b>
	</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nombre</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${countryDAO.list()}" var="country">
				<tr>
					<th scope="row"><c:out value="${country.id}" /></th>
					<td><c:out value="${country.name}" /></td>
					<td><a href="CountryServlet?action=eliminar&id=${country.id}">Eliminar</a></td>
					<td><a href="CountryServlet?action=mostrar&id=${country.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>