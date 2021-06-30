package controladores;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.TextFormat.ParseException;

import dao.CountryDAO;
import dao.CyclistDAO;
import dao.TeamDAO;
import modelo.Country;
import modelo.Cyclist;
import modelo.Team;

/**
 * Servlet implementation class CiclistaServlet
 */
@WebServlet("/CiclistaServlet/*")
public class CiclistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private CyclistDAO cDAO;
		private CountryDAO couDAO;
		private TeamDAO tDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CiclistaServlet() {
        super();
        cDAO = new CyclistDAO();
        couDAO = new CountryDAO();
        tDAO = new TeamDAO();
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
			try {
				this.registrar(request, response);
			} catch (java.text.ParseException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "actualizar":
			try {
				this.actualizar(request, response);
			} catch (java.text.ParseException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException, ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String team = request.getParameter("team");
		String country = request.getParameter("country");
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String birthdate = request.getParameter("birthdate");
		Cyclist c = new Cyclist();
		Team t = tDAO.find(team);
		Country coun = couDAO.find(country);
		c.setName(name);
		c.setEmail(email);
		c.setTeamBean(t);
		c.setCountryBean(coun);
		c.setBirthdate(sd.parse(birthdate));
		cDAO.insert(c);
		request.getRequestDispatcher("registroCiclista.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException, ServletException, IOException  {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String team = request.getParameter("team");
		String country = request.getParameter("country");
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String birthdate = request.getParameter("birthdate");
		Cyclist c = new Cyclist();
		Team t = tDAO.find(team);
		Country coun = couDAO.find(country);
		c.setName(name);
		c.setEmail(email);
		c.setTeamBean(t);
		c.setCountryBean(coun);
		c.setBirthdate(sd.parse(birthdate));
		cDAO.update(c);
		request.getRequestDispatcher("listaCiclista.jsp").forward(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cyclist c = new Cyclist();
		c.setId(id);
		Cyclist aux = cDAO.find(c.getId());
		request.getSession().setAttribute("cyclist", aux);
		request.getRequestDispatcher("registroCiclista.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cyclist c = new Cyclist();
		Cyclist aux = cDAO.find(id);
		c.setId(id);
		cDAO.delete(aux);
		request.getRequestDispatcher("listaCiclista.jsp").forward(request, response);
		
	}

	private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Cyclist c = new Cyclist();
		c.setId(id);
		Cyclist aux = cDAO.find(c.getId());
		request.getSession().setAttribute("cyclist", aux);
		request.getRequestDispatcher("registroCiclista.jsp").forward(request, response);
		
	}
	
}
