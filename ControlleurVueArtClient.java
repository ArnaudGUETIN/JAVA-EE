package fasoyaar.vue;

import java.io.IOException;
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
import com.fasoyaar.session.catalogue.ICatalogueLocal;
import com.fasoyaar.session.client.IClientLocal;




@WebServlet(name="vueart",urlPatterns={"/articles"})
public class ControlleurVueArtClient extends HttpServlet {

	/**
	 * 
	 */
	@EJB
	private ICatalogueLocal metier;
	@EJB
	private IClientLocal client;
	
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//String s=request.getParameter("ajouter");
		//request.setAttribute("a", s);
		//request.setAttribute("articles", arts);
		String catId=request.getParameter("categorie");
		String nom=(String)request.getAttribute("client");
		Long idCl=(Long) request.getAttribute("idCl");
		if(nom!=null){
		request.setAttribute("client", nom);
		request.setAttribute("idCl", idCl);
		
		}
		if(catId==null) catId="0";
		//request.setAttribute("article", cat);
		Long id =Long.parseLong(catId);
		if(id==0L){
			List<Article> arts=metier.getAllArticles();
			
			request.setAttribute("articles", arts);	
			
		}else{
		List<Article> arts=metier.getAllArticles(id);
		
		request.setAttribute("articles", arts);
		
		}
		request.getRequestDispatcher("VueArticles.jsp").forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		this.doGet(request, response);
	}
}
