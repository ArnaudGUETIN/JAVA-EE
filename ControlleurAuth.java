package fasoyaar.vue;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasoyaar.entity.client.Client;
import com.fasoyaar.session.client.IClientLocal;

@WebServlet(name="auth",urlPatterns={"/login"})
public class ControlleurAuth extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IClientLocal client;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("authent.jsp").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		String ids=request.getParameter("id");
		if(ids==null) ids="0";
		Long id=Long.parseLong(ids);
		if(id==null) id=0L;
		Client cl=client.findCient(id);
		
		String reponse="";
		if(cl==null){
			reponse="Erreur veillez ressayer";
			request.setAttribute("reponse", reponse);
			request.getRequestDispatcher("authent.jsp").forward(request, response);
		}
		else if (login.equals(cl.getLogin()) && password.equals(cl.getPassword()) ) {
			
			request.setAttribute("client", cl.getNomCl());
			request.setAttribute("idCl", cl.getIdCl());
			getServletContext().getRequestDispatcher("/articles").forward(request, response);
			
		}
		else {
			
			reponse="Cient introuvable";
			request.setAttribute("reponse", reponse);
			request.getRequestDispatcher("authent.jsp").forward(request, response);
		}
			
		}
			
		
	}


