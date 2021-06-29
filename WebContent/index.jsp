<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Ciclismo</title>
</head>
<body>
	<h1>
		<b>Pais</b>
	</h1>
	<div class="col-sm-10">
		<a href="${pageContext.request.contextPath}/buscarPais.jsp"
			class="btn btn-primary">Buscar Pais</a> <a
			href="${pageContext.request.contextPath}/registroPais.jsp"
			class="btn btn-primary">Registrar Pais</a> <a
			href="${pageContext.request.contextPath}/listaPais.jsp"
			class="btn btn-primary">Lista De Paises</a>
	</div>
	<h1>
		<b>Equipo</b>
	</h1>
	<div class="col-sm-10">
		<a href="${pageContext.request.contextPath}/buscarEquipo.jsp"
			class="btn btn-primary">Buscar Equipo</a> <a
			href="${pageContext.request.contextPath}/registroEquipo.jsp"
			class="btn btn-primary">Registrar Equipo</a> <a
			href="${pageContext.request.contextPath}/listaEquipo.jsp"
			class="btn btn-primary">Lista De Equipos</a>
	</div>
	<h1>
		<b>Ciclista</b>
	</h1>
	<div class="col-sm-10">
		<a href="${pageContext.request.contextPath}/buscarCiclista.jsp"
			class="btn btn-primary">Buscar Ciclista</a> <a
			href="${pageContext.request.contextPath}/registroCiclista.jsp"
			class="btn btn-primary">Registrar Ciclista</a> <a
			href="${pageContext.request.contextPath}/listaCiclista.jsp"
			class="btn btn-primary">Lista De Ciclistas</a>
	</div>
</body>
</html>