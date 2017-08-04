package com.fasoyaar.services.webservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.fasoyaar.entity.categorie.Article;
import com.fasoyaar.entity.categorie.Categorie;
import com.fasoyaar.entity.categorie.Produit;
import com.fasoyaar.entity.client.Adresse;
import com.fasoyaar.entity.client.Client;
import com.fasoyaar.entity.commande.Commande;
import com.fasoyaar.session.catalogue.ICatalogueLocal;
import com.fasoyaar.session.client.IClientLocal;
import com.fasoyaar.session.commande.ICommandeLocal;

@Stateless
@WebService
public class FasoyaarSercvice {
	
	@EJB(beanName="CommandeMetier")
	private ICommandeLocal commandeLocale;
	@EJB(beanName="ClientMetier")
	private IClientLocal clientLocal;
	@EJB(beanName="CatalogueMetier")
	private ICatalogueLocal catalogueLocal;
	
	/* methodes de l'interface locale des commandes*/
	@WebMethod
	public void deleteCommande(@WebParam(name="commande") Commande cmd){
		
		commandeLocale.deleteCommande(cmd);
	}
	@WebMethod
	public ArrayList<Commande> getCommande(Long idCl){
		
		return commandeLocale.getCommande(idCl);
	}
	@WebMethod
	public Commande updateCommande(@WebParam(name="adresse") Adresse adr,@WebParam(name="commande") Commande cmd){
		
		return commandeLocale.updateCommande(cmd);
	}
	
	/* methodes de l'interface locale du client*/
	
    
    
    @WebMethod
    public Client createClient(@WebParam(name="nom")String nom,@WebParam(name="email")String email,@WebParam(name="prenom")String prenom,@WebParam(name="login")String login,@WebParam(name="password")String password,@WebParam(name="telephone")String tel,@WebParam(name="ville")String ville,@WebParam(name="pays")String pays,@WebParam(name="rue")String rue){
    	Date date =new Date();
		Client clt=new Client( nom, prenom, tel, password,email, login, date);
		Adresse ad= new Adresse(ville,rue, pays);
    	return clientLocal.createClient(clt, ad);
	}
    
    @WebMethod
    public Client findCient(@WebParam(name="id_client")Long Idclient){
		
    	return clientLocal.findCient(Idclient); 
	}
    
    @WebMethod
    public Client UpdateClient(@WebParam(name="idClient")Long idCl,@WebParam(name="adresse")Adresse ad){
		
    	return clientLocal.UpdateClient(idCl, ad);
	}
    
    
    /* methodes de l'interface locale du catalogue*/
    
    @WebMethod
    public Categorie findCategorie(@WebParam(name="id_categorie")Long idCat){
    	
    	return catalogueLocal.findCategorie(idCat);
    }
    
    @WebMethod
	public Produit findProduit(@WebParam(name="id_produit")Long idPrct){
    	
    	return catalogueLocal.findProduit(idPrct);
    }
    
    @WebMethod
	public Article findArticle(@WebParam(name="id_article")Long idArt){
    	
    	return catalogueLocal.findArticle(idArt);
    }
    
    @WebMethod
	public List<Article> searchArticle(@WebParam(name="idCat") Long idCat){
    	
    	return catalogueLocal.getAllArticles(idCat);
    	
    }
}
