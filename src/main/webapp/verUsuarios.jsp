<%@page import="clases.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver usuaios</title>
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