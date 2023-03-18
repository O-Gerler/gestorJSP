package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloUsuario;

/**
 * Servlet implementation class ControladorEliminarUsuario
 */
@WebServlet("/ControladorEliminarUsuario")
public class ControladorEliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorEliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		int id = Integer.parseInt(request.getParameter("id"));
		modeloUsuario.eliminarUsuario(id);
		request.getRequestDispatcher("ControladorVerUsuario").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		modeloUsuario.conectar();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (modeloUsuario.eliminarUsuario(id)) {
			request.getRequestDispatcher("usuarioEliminado.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("usuarioNoEliminado.jsp").forward(request, response);
		}
	}

}
