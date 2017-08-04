package com.fasoyaar.session.catalogue;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fasoyaar.entity.categorie.Article;
import com.fasoyaar.entity.categorie.Categorie;
import com.fasoyaar.entity.categorie.Produit;

@Stateless(name="CatalogueMetier")
public class CatalogueImpl implements ICatalogueLocal,ICatalogueRemote{

	@PersistenceContext(unitName="UP_FasoYaar")
	private EntityManager em;
	@Override
	public Categorie createCategorie(Categorie cat) {
		// TODO Auto-generated method stub
		em.persist(cat);
		return cat;
	}

	@Override
	public void deleteCategorie(Long idCat) {
		// TODO Auto-generated method stub
		Categorie c= em.find(Categorie.class, idCat);
		if(c==null) throw new RuntimeException("Categorie introuvable");
		else
		em.remove(c);
	}

	@Override
	public Categorie updateCategorie(Categorie cat) {
		// TODO Auto-generated method stub
		Categorie categ=em.find(Categorie.class, cat.getIdCat());
		categ.setNomCat(cat.getNomCat());
		categ.setDescCat(cat.getDescCat());
		em.persist(cat);
		return categ;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		Query request=em.createQuery("select c from Categorie c");
		return request.getResultList();
		
	}

	@Override
	public Produit createProduit(Produit p,Long idCat) {
		// TODO Auto-generated method stub
		p.setCategorie(em.find(Categorie.class, idCat));
		em.persist(p);
		return p;
	}

	@Override
	public void deleteProduit(Long idPrct) {
		// TODO Auto-generated method stub
		Produit p= em.find(Produit.class, idPrct);
		if(p==null) throw new RuntimeException("Produit introuvable");
		else
		em.remove(p);
	}

	@Override
	public Produit updateProduit(Produit p) {
		// TODO Auto-generated method stub
		em.merge(p);
		Produit prd=em.find(Produit.class, p.getIdPrct());
		prd.setNomPrct(p.getNomPrct());
		prd.setDescPrct(p.getDescPrct());
		em.persist(p);
		return prd;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getAllProduits(Long idCat){
		// TODO Auto-generated method stub
		Query request=em.createQuery("select p from Produit p where p.categorie.idCat="+idCat+"");
		return request.getResultList();
	}

	@Override
	public Article createArticle(Article a,Long idPrct) {
		// TODO Auto-generated method stub
		a.setProduit(em.find(Produit.class,idPrct));
		em.persist(a);
		return a;
	}

	@Override
	public void deleteArticle(Long idArt) {
		// TODO Auto-generated method stub
		Article a= em.find(Article.class, idArt);
		if(a==null) throw new RuntimeException("Article introuvable");
		else
		em.remove(a);
	}

	@Override
	public Article updateArticle(Article a) {
		// TODO Auto-generated method stub
		em.merge(a);
		Article art=em.find(Article.class, a.getIdArt());
		art.setNomArt(a.getNomArt());
		art.setPu(a.getPu());
		art.setImagePath(a.getImagePath());
		em.persist(a);
		return art;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles(Long idCat) {
		// TODO Auto-generated method stub
		List<Article> arts =this.getAllArticle(idCat);
		return arts;
	}

	
	@Override
	public Categorie findCategorie(Long idCat) {
		// TODO Auto-generated method stub
		
		return em.find(Categorie.class, idCat);
	}

	@Override
	public Produit findProduit(Long idPrct) {
		// TODO Auto-generated method stub
		
		return em.find(Produit.class, idPrct);
	}

	@Override
	public Article findArticle(Long idArt) {
		// TODO Auto-generated method stub
		Article art=em.find(Article.class, idArt);
		return art;
	}

	@Override
	public Produit addArticle(Produit p, Article a) {
		// TODO Auto-generated method stub
		em.find(Produit.class, p.getIdPrct());
		em.flush();
		em.find(Article.class, a.getIdArt());
		 a.setProduit(p);
		 
			
		return p; 
		
	}
	@SuppressWarnings("unchecked")
	public List<Article> getAllArticle(Long idCat) {
		// TODO Auto-generated method stub
		List<Article> arts;
		Query request=em.createQuery("SELECT c FROM Article c where c.produit.categorie.idCat="+idCat+"");
		arts=request.getResultList();
		return (arts);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		List<Article> arts;
		Query request=em.createQuery("SELECT c FROM Article c ");
		
		return request.getResultList();
	}

	
}
