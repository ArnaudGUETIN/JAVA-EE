package fasoyaar.vue;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasoyaar.entity.commande.Commande;
import com.fasoyaar.session.commande.ICommandeLocal;

@WebServlet(name="vuecmd",urlPatterns={"/vueCmd"})
public class ControlleurVueCmd extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ICommandeLocal commande;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCl=request.getParameter("idCl");
		String idCmd=request.getParameter("idCmd");
		ArrayList<Commande> commandes=commande.getCommande(Long.parseLong(idCl));
		request.setAttribute("commandes", commandes);
		request.getRequestDispatcher("vueCmd.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
