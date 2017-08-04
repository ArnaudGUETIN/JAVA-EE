package com.fasoyaar.session.catalogue;

import java.util.List;

import javax.ejb.Remote;

import com.fasoyaar.entity.categorie.Article;
import com.fasoyaar.entity.categorie.Categorie;
import com.fasoyaar.entity.categorie.Produit;

@Remote
public interface ICatalogueRemote {
	
	public Categorie createCategorie(Categorie cat);
	public Categorie findCategorie(Long idCat);
	public void deleteCategorie(Long idCat);
	public Categorie updateCategorie(Categorie cat);
	public List<Categorie> getAllCategories();
	
	public Produit createProduit(Produit p,Long idCat);
	public Produit findProduit(Long idPrct);
	public void deleteProduit(Long idPrct);
	public Produit updateProduit(Produit p);
	public List<Produit> getAllProduits(Long idCat);
	public Produit addArticle(Produit p,Article a);
	
	public Article createArticle(Article a,Long idPrct);
	public Article findArticle(Long idArt);
	public void deleteArticle(Long idArt);
	public Article updateArticle(Article a);
	public List<Article> getAllArticles(Long idPrct);
	public List<Article> getAllArticles();
	
	
	
	

}
