package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CountryDAO;
import modelo.Country;

/**
 * Servlet implementation class CountryServlet
 */
@WebServlet("/CountryServlet/*")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CountryDAO cDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryServlet() {
        super();
        cDAO = new CountryDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch (action) {
		case "eliminar":
			this.eliminar(request, response);
			break;
		case "mostrar":
			this.showForm(request, response);
			break;
			/*	case "/buscar":
			this.buscar(request, response);
			break;	 */
		default:
			break;
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) { 
		case "buscar":
			this.buscar(request, response);
			break; 	
		case "registrar":
			this.registrar(request, response);
			break;
		case "actualizar":
			this.actualizar(request, response);
			break;
		default:
			break;
		}
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Country coun = new Country();
		coun.setId(id);
		coun.setName(name);
		cDAO.insert(coun);
		request.getRequestDispatcher("registroPais.jsp").forward(request, response);
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Country coun = new Country();
		coun.setId(id);
		coun.setName(name);
		cDAO.update(coun);
		request.getRequestDispatcher("listaPais.jsp").forward(request, response);
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Country coun = new Country();
		coun.setId(id);
		Country aux = cDAO.find(coun.getId());
		request.getSession().setAttribute("country", aux);
		request.getRequestDispatcher("registroPais.jsp").forward(request, response);
		
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Country coun = new Country();
		Country aux = cDAO.find(id);
		coun.setId(id);
		cDAO.delete(aux);
		request.getRequestDispatcher("listaPais.jsp").forward(request, response);
		
	}

	private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Country coun = new Country();
		coun.setId(id);
		Country aux = cDAO.find(coun.getId());
		request.getSession().setAttribute("country", aux);
		request.getRequestDispatcher("registroPais.jsp").forward(request, response);
		
	}


}
