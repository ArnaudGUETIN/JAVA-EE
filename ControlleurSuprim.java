package fasoyaar.vue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasoyaar.entity.client.Client;
import com.fasoyaar.session.client.IClientLocal;
@WebServlet(name="suprim",urlPatterns={"/suprim"})
public class ControlleurSuprim extends HttpServlet{

	@EJB
	private IClientLocal metier;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("controlleur").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idClient=request.getParameter("id");
		if(!idClient.isEmpty() && metier.findCient(Long.parseLong(idClient))!=null){
			metier.deleteClient(Long.parseLong(idClient));
		}
		request.getRequestDispatcher("controlleur").forward(request, response);
	}
}
