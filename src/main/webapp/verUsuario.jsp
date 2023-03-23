<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="clases.Usuario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver usuario</title>
<script type="text/javascript">
	function volverHome() {
		window.location.href = 'ControladorVerUsuario'
	}
</script>
</head>
<body>

<%Usuario usuario = (Usuario) request.getAttribute("usuario"); %>

<h1>Usuario</h1>
<p>Id: <%=usuario.getId() %><br>Nombre: <%=usuario.getNombre() %><br>Apellido: <%=usuario.getApellido() %> <br>
DNI: <%=usuario.getDni() %><br> Edad: <%=usuario.getEdad()%><br><span>Fecha: <%=(usuario.getFecha() == null ? "Sin fecha" : new SimpleDateFormat("yyyy/MM/dd").format(usuario.getFecha()))%></span>
<br><span>Usuario : <%=usuario.getUsuario() %></span><br><span>Contraseña : <%=usuario.getContrasena() %></span></p>
<button onclick="volverHome()">Volver</button>

</body>
</html>