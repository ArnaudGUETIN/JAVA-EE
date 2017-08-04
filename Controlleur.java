package fasoyaar.vue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasoyaar.entity.categorie.Article;
import com.fasoyaar.entity.client.Adresse;
import com.fasoyaar.entity.client.Client;
import com.fasoyaar.entity.commande.Commande;
import com.fasoyaar.entity.commande.LigneCmd;
import com.fasoyaar.session.catalogue.ICatalogueLocal;
import com.fasoyaar.session.client.IClientLocal;
import com.fasoyaar.session.commande.ICommandeLocal;

@WebServlet(name="controlleur",urlPatterns={"/controlleur"})
public class Controlleur extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IClientLocal metier;
	@EJB
	private ICommandeLocal commande;
	@EJB
	private ICatalogueLocal catalogue;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Client> clts=(ArrayList<Client>)metier.getAllClients();
		//Commande cmd = commande.getCommande((Client)clts[1]);
		//commande.deleteCommande(cmd);
		request.setAttribute("clients", clts);
		request.getRequestDispatcher("client.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String login=request.getParameter("login");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String ville=request.getParameter("ville");
		String pays=request.getParameter("pays");
		String telephone=request.getParameter("telephone");
		String idClient=request.getParameter("id");
		Adresse a= new Adresse(ville, "", pays);
		
		if(!nom.isEmpty() && !prenom.isEmpty() && !login.isEmpty() && !email.isEmpty() && !password.isEmpty()){
		Client cl=metier.createClient(new Client(nom, prenom, telephone, password,email, login,new Date()),a);
		//commande.deleteCommande(commande.getCommande(cl));
		//commande.createCommande(cl,commande.createLigneCommande(2, new Article()) );
		//commande.getCommande(cl);
		
		}
		
		

			
		
		doGet(request, response);
		
		
	}
}
