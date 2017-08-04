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
import com.fasoyaar.session.client.IClientLocal;
import com.fasoyaar.session.commande.ICommandeLocal;

/**
 * Servlet implementation class ControlleurCommande
 */
@WebServlet(name="commande",urlPatterns={"/commande"})
public class ControlleurCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int nb=1;
	@EJB
	private ICommandeLocal commande;
       
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		getServletContext().getRequestDispatcher("/vueCmd").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String idCl = request.getParameter("idCl");
		String idArt =request.getParameter("idArt");
		ArrayList<Commande> cmd=commande.getCommande(Long.parseLong(idCl));
		if(!cmd.isEmpty())
		{
			for(int i=0;i <cmd.size();i++){
				if(cmd.get(i).getClient().getIdCl()==Long.parseLong(idCl))
{
		commande.addLigneCommande((cmd.get(i)).getIdCmd(),Long.parseLong(idArt));
		request.setAttribute("idCmd",(cmd.get(i)).getIdCmd() );
}
			}
		getServletContext().getRequestDispatcher("/articles").forward(request, response);
		}else{
			Commande c=commande.createCommande(Long.parseLong(idCl));
			commande.addLigneCommande(c.getIdCmd(),Long.parseLong(idArt));
			request.setAttribute("idCmd",c.getIdCmd() );
			getServletContext().getRequestDispatcher("/articles").forward(request, response);
		}
		
	}

}
