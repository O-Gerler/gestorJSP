<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controlador.ControladorEliminarUsuario"%>
<%@page import="clases.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver usuarios</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript">
	function paginaInsertar() {
		window.location.href = 'agregarUsuario.jsp'
	}
	
	function paginaEliminar() {
		window.location.href = 'eliminarUsuario.jsp'
	}
	
	function paginaVerUsuario() {
		window.location.href = 'buscarUsuario.jsp'
	}
	
	function paginaBuscarUsuarioModificar() {
		window.location.href = 'buscarUsuarioModificar.jsp'
	}
</script>
</head>
<body>

	<div>
		<c:forEach items="${ usuarios }" var="user">
			<p><span>ID: ${ user.id }</span>							
			<span>Nombre: ${ user.getNombre() }</span>
			<span>Apellido: ${ user.getApellido() }</span>
			<span>DNI: ${ user.getDni() }</span>
			<span>Edad: ${ user.getEdad() }</span>
			<span>Usuario: ${ user.getUsuario() }</span>
			<span>Contraseña: ${ user.getContrasena() }</span>
			<span>Fecha: ${ user.fecha}</span>
			<a href=ControladorEliminarUsuario?id= ${user.getId()}>Eliminar</a>
			<a href=ControladorRellenarCampos?id= ${user.getId()}>Modificar</a>
			<a href=ControladorVerUnicoUsuario?id= ${user.getId()}>Ver</a>}
			</p>
		</c:forEach>
		
		<div>
			<button onclick="paginaInsertar()" style="width: 80px">Insertar Usuario</button>
			<button onclick="paginaEliminar()" style="width: 80px">Eliminar Usuario</button>
			<button onclick="paginaVerUsuario()" style="width: 80px">Ver Usuario</button>
			<button onclick="paginaBuscarUsuarioModificar()" style="width: 80px">Modificar Usuario</button>
		</div>
		
	</div>

</body>
</html>