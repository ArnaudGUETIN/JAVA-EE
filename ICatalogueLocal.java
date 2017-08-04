package com.fasoyaar.session.catalogue;

import java.util.List;

import javax.ejb.Local;

import com.fasoyaar.entity.categorie.Article;
import com.fasoyaar.entity.categorie.Categorie;
import com.fasoyaar.entity.categorie.Produit;
import com.fasoyaar.entity.client.Client;
import com.fasoyaar.entity.commande.Commande;

@Local
public interface ICatalogueLocal {
	
	public Categorie findCategorie(Long idCat);
	public Produit findProduit(Long idPrct);
	public Article findArticle(Long idArt);
	public List<Article> getAllArticles(Long idCat);
	public List<Produit> getAllProduits(Long idCat);
	public List<Categorie> getAllCategories();
	public List<Article> getAllArticles();
	
	
	
}
