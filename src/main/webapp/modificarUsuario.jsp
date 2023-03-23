<%@page import="clases.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%> 
<%@page import="java.text.SimpleDateFormat"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Usuario</title>
</head>
<body>

	<%Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
	
	<h1>Modificar Usuario</h1>
	<%=usuario %>
	<form action="ControladorModificarUsuario" method="post">
		<input type="hidden" name="id" value="<%=usuario.getId()%>" >
		
		<label for="nombre">Nombre</label>
        <input type="text" name="nombre" value="<%=usuario.getNombre()%>">
        <br>
        <label for="apellido">Apellido</label>
        <input type="text" name="apellido" value="<%=usuario.getApellido()%>">
        <br>
        <label for="dni">DNI</label>
        <input type="text" name="dni" value="<%=usuario.getDni()%>">
        <br>
        <label for="edad">Edad</label>
        <input type="text" name="edad" value="<%=usuario.getEdad()%>">
        <br>
        <label for="fecha">Fecha</label>
        <input type="date" name="fecha" value="<%=(usuario.getFecha() == null ? "Sin fecha" : new SimpleDateFormat("yyyy-MM-dd").format(usuario.getFecha()))%>">-
        <br>
         <label for="usuario">Usuario</label>
        <input type="text" name="usuario" value="<%=usuario.getUsuario()%>">
        <br>
        <label for="contrasena">Contraseña</label>
        <input type="text" name="contrasena" value="<%=usuario.getContrasena()%>">
        <br>
        <input type="submit" value="Enviar">
	</form>
</body>
</html>