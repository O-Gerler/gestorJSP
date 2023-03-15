package controlador;

import java.io.IOException;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setDni(dni);
		usuario.setEdad(edad);
		
		if (modeloUsuario.insertarUsuario(usuario)) {
			request.getRequestDispatcher("usuarioAgregado.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("usuarioNoAgregado.jsp").forward(request, response);
		}
		
		modeloUsuario.cerrar();
		
		
	}

}
