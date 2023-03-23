package clases;

import java.util.Date;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private int edad;
	private Date fecha;
	private String nombreUsuario;
	private String contrasena;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return nombreUsuario;
	}
	public void setUsuario(String usuario) {
		this.nombreUsuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public static boolean confirmarContrasena(String contrasena) {
		
		if (contrasena.length() < 8) {
			return false;
		}
		
		char[] clave = contrasena.toCharArray();
		for (char c : clave) {
			if(Character.isDigit(c))
				return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", edad=" + edad
				+ "]";
	}
	
}
