package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Usuario;
import modelo.ModeloUsuario;

/**
 * Servlet implementation class ControladorInsertarUsuario
 */
@WebServlet("/ControladorInsertarUsuario")
public class ControladorInsertarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorInsertarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		int edad = Integer.parseInt(request.getParameter("edad"));
		Date fecha = null;
		try {
			fecha = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		String nombreUsuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		
		if (Usuario.confirmarContrasena(contrasena)) {
			Usuario usuario = new Usuario();
			
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setDni(dni);
			usuario.setEdad(edad);
			usuario.setFecha(fecha);
			usuario.setUsuario(nombreUsuario);
			usuario.setContrasena(contrasena);
			
			if (modeloUsuario.insertarUsuario(usuario)) {
				request.getRequestDispatcher("usuarioAgregado.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("usuarioNoAgregado.jsp").forward(request, response);
			}
			
			modeloUsuario.cerrar();
		} else
			request.getRequestDispatcher("usuarioNoAgregado.jsp").forward(request, response);
		
	}

}
