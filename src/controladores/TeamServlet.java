package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CountryDAO;
import dao.TeamDAO;
import modelo.Country;
import modelo.Team;

/**
 * Servlet implementation class TeamServlet
 */
@WebServlet("/TeamServlet/*")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private TeamDAO tDAO;
       private CountryDAO cDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamServlet() {
        super();
        tDAO = new TeamDAO();
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
		String country = request.getParameter("country");
		Country coun = cDAO.find(country);
		Team team = new Team();
		team.setId(id);
		team.setName(name);
		team.setCountryBean(coun);
		tDAO.insert(team);
		request.getRequestDispatcher("registroEquipo.jsp").forward(request, response);
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		Country coun = cDAO.find(country);
		Team team = new Team();
		team.setId(id);
		team.setName(name);
		team.setCountryBean(coun);
		tDAO.update(team);
		request.getRequestDispatcher("registroEquipo.jsp").forward(request, response);
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Team t = new Team();
		t.setId(id);
		Team aux = tDAO.find(t.getId());
		request.getSession().setAttribute("team", aux);
		request.getRequestDispatcher("registroEquipo.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Team t = new Team();
		Team aux = tDAO.find(id);
		t.setId(id);
		tDAO.delete(aux);
		request.getRequestDispatcher("listaEquipo.jsp").forward(request, response);
		
	}

	private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Team t = new Team();
		t.setId(id);
		Team aux = tDAO.find(t.getId());
		request.getSession().setAttribute("team", aux);
		request.getRequestDispatcher("registroEquipo.jsp").forward(request, response);
		
	}
}
