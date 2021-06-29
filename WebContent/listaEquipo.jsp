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
<title>Lista de Equipos</title>
</head>
<body>
<jsp:useBean class="dao.TeamDAO" id="teamDAO" ></jsp:useBean>
<h1>
		<b>Equipos</b>
	</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nombre</th>
				<th scope="col">Pais</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${teamDAO.list()}" var="team">
				<tr>
					<th scope="row"><c:out value="${team.id}" /></th>
					<td><c:out value="${team.name}" /></td>
					<td><c:out value="${team.countryBean.getName()}" /></td>
					<td><a href="TeamServlet?action=eliminar&id=${team.id}">Eliminar</a></td>
					<td><a href="TeamServlet?action=mostrar&id=${team.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>