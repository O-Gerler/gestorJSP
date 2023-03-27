<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controlador.ControladorEliminarUsuario"%>
<%@page import="clases.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

	<%
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
	%>
	
	<div>
		<%
			for (Usuario user : usuarios){
				out.println("<p>" + "<span>ID: " + user.getId() + "</span>"
							+ "<span>Nombre: " + user.getNombre() + "</span>" 
							+ "<span>Apellido: " + user.getApellido() + "</span>"
							+ "<span>DNI: " + user.getDni() + "</span>"
							+ "<span>Edad: " + user.getEdad() + "</span>"
							+ "<span>Fecha: " + (user.getFecha() == null ? "Sin fecha" : new SimpleDateFormat("yyyy/MM/dd").format(user.getFecha())) + "</span>"
							+ "<span>Usuario: " + user.getUsuario() + "</span>"
							+ "<span>Contraseña: " + user.getContrasena() + "</span>"
							+ "<a href=ControladorEliminarUsuario?id=" + user.getId() + ">Eliminar</a>"
							+ "<a href=ControladorRellenarCampos?id=" + user.getId() + ">Modificar</a>"
							+ "<a href=ControladorVerUnicoUsuario?id=" + user.getId() + ">Ver</a>"
							+"</p>");
			}
		%>
		<div>
			<button onclick="paginaInsertar()" style="width: 80px">Insertar Usuario</button>
			<button onclick="paginaEliminar()" style="width: 80px">Eliminar Usuario</button>
			<button onclick="paginaVerUsuario()" style="width: 80px">Ver Usuario</button>
			<button onclick="paginaBuscarUsuarioModificar()" style="width: 80px">Modificar Usuario</button>
		</div>
		
	</div>

</body>
</html>