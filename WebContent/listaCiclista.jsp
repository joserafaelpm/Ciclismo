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
<title>Lista de Ciclistas</title>
</head>
<body>

<jsp:useBean class="dao.CyclistDAO" id="ciclistaDAO"></jsp:useBean>
<h1>
		<b>Ciclistas</b>
	</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nombre</th>
				<th scope="col">Fecha de Nacimiento</th>
				<th scope="col">Email</th>
				<th scope="col">Pais</th>
				<th scope="col">Equipo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ciclistaDAO.list()}" var="ciclista">
				<tr>
					<th scope="row"><c:out value="${ciclista.id}" /></th>
					<td><c:out value="${ciclista.name}" /></td>
					<td><c:out value="${ciclista.birthdate}" /></td>
					<td><c:out value="${ciclista.email}" /></td>
					<td><c:out value="${ciclista.countryBean.getName()}" /></td>
					<td><c:out value="${ciclista.teamBean.getName()}" /></td>
					<td><a href="CiclistaServlet?action=eliminar&id=${ciclista.id}">Eliminar</a></td>
					<td><a href="CiclistaServlet?action=mostrar&id=${ciclista.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>