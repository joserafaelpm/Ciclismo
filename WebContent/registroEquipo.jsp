<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  </script>
<title>Registro Equipo</title>
</head>
<body>
<jsp:useBean class="dao.TeamDAO" id="teamDAO"></jsp:useBean>
<jsp:useBean class="dao.CountryDAO" id="counDAO"></jsp:useBean>

<h1> <b>Registra Equipo</b> </h1>
<c:if test="${team != null}">
                           <%--  <form action="${pageContext.request.contextPath}/ActualizarEmpleado?accion=edita&codigo=${empleado.codigo}"  method="post"> --%>
                           <form action="TeamServlet?action=actualizar&id=${team.id}"  method="POST">
                        </c:if>
                        <c:if test="${team == null}">
                           <%--  <form action="${pageContext.request.contextPath}/AgregarEmpleado?accion=agregar&codigo=${empleado.codigo}"  method="POST"> --%>
                            <form action="TeamServlet?action=registrar"  method="POST">
                        </c:if>
 <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Id:</label>
    <div class="col-sm-10">
      <input type="text" name="id" value="${team.id}"  class="form-control" id="inputEmail3">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Nombre:</label>
    <div class="col-sm-10">
      <input type="text" name="name" value="${team.name}"  class="form-control" id="inputEmail3">
    </div>
  </div>
  
  <fieldset class="form-group">
					<label>Pais</label> 
					<select class="form-control"
						id="exampleFormControlSelect1" name="country">
						<option selected value="${team.countryBean.getId()} ">
							<c:out value="${team.countryBean.getName()} " />
						</option>
						<c:forEach items="${counDAO.list()}" var="coun">
							<option value="${coun.id} ">
								<c:out value="${coun.name} " />
							</option>
						</c:forEach>
					</select>
				</fieldset>
				
		  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Registrar</button>
     <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary">Volver</a>
    </div>
    </div>	
	
</body>
</html>