package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Usuario;

public class ModeloUsuario extends Conector{
	
	public Usuario getUsuario(int id) {
		
		String st = "SELECT * FROM usuarios WHERE id = ?";
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement(st);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			
			Usuario usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellido(rs.getString("apellido"));
			usuario.setDni(rs.getString("dni"));
			usuario.setEdad(rs.getInt("edad"));
			usuario.setFecha(rs.getDate("fecha"));
			usuario.setUsuario(rs.getString("usuario"));
			usuario.setContrasena(rs.getString("contrasena"));
			
			return usuario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	 public ArrayList<Usuario> getUsuarios() {
		 
		 String st = "SELECT * FROM usuarios";
		 
		 try {
			PreparedStatement pst = super.conexion.prepareStatement(st);
			
			ResultSet rs = pst.executeQuery();
			ArrayList<Usuario> usuarios = new ArrayList<>();
			
			while (rs.next()) {
				usuarios.add(getUsuario(rs.getInt("id")));
			}
			
			return usuarios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return null;
	}
	 
	 public boolean insertarUsuario(Usuario usuario) {
		
		 String st = "insert into usuarios (nombre, apellido, dni, edad, fecha, usuario, contrasena) values (?, ?, ? , ?, ?, ?, ?)";
		 
		 try {
			PreparedStatement pst = super.conexion.prepareStatement(st);
			
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setString(3, usuario.getDni());
			pst.setInt(4, usuario.getEdad());
			pst.setDate(5,new Date(usuario.getFecha().getTime()));
			pst.setString(6, usuario.getUsuario());
			pst.setString(7, usuario.getContrasena());
			
			pst.execute();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return false;
	}
	 
	public boolean eliminarUsuario(int id) {
		
		String st = "delete from usuarios where id=?";
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement(st);
			pst.setInt(1, id);
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean modificarUsuario(Usuario usuario) {
		
		String st = "UPDATE usuarios SET nombre = ?, apellido = ?, dni = ?, edad = ?, fecha = ?, usuario = ?, contrasena = ? WHERE id = ?";
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement(st);
			
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getApellido());
			pst.setString(3, usuario.getDni());
			pst.setInt(4, usuario.getEdad());
			pst.setDate(5,new Date(usuario.getFecha().getTime()));
			pst.setString(6, usuario.getUsuario());
			pst.setString(7, usuario.getContrasena());
			pst.setInt(8, usuario.getId());
			
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
