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
</head>
<body>

	<%
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
	%>
	
	<div>
		<%
			for (Usuario user : usuarios){
				out.println("<p>" + "<span>Nombre: " + user.getNombre() + "</span>" 
							+ "<span>Apellido: " + user.getApellido() + "</span>"
							+ "<span>DNI: " + user.getDni() + "</span>"
							+ "<span>Edad: " + user.getEdad() + "</span>"
							+"</p>");
			}
		%>
	</div>

</body>
</html>