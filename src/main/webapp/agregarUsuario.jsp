<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form  method="post" action="ControladorInsertarUsuario">
        <label for="nombre">Nombre</label>
        <input type="text" name="nombre">
        <br>
        <label for="apellido">Apellido</label>
        <input type="text" name="apellido">
        <br>
        <label for="dni">DNI</label>
        <input type="text" name="dni">
        <br>
        <label for="edad">Edad</label>
        <input type="text" name="edad">
        <br>
        <label for="fecha">Fecha</label>
        <input type="date" name="fecha">
        <br>
        <label for="usuario">Usuario</label>
        <input type="text" name="usuario">
        <br>
        <label for="contrasena">Contraseña</label>
        <input type="text" name="contrasena">
        <br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>