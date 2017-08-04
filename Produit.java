package com.fasoyaar.entity.categorie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_produit")
public class Produit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @param idPrct
	 * @param nomPrct
	 * @param descPrct
	 * @param categorie
	 * @param articles
	 */
	public Produit(Long idPrct, String nomPrct, String descPrct, Categorie categorie, List<Article> articles) {
		super();
		this.idPrct = idPrct;
		this.nomPrct = nomPrct;
		this.descPrct = descPrct;
		this.categorie = categorie;
		this.articles = articles;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPrct;
	@Column(name="nom_produit",nullable=false,length=60)
	private String nomPrct;
	@Column(name="desc_produit",nullable=false,length=60)
	private String descPrct;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="categorie_fk")
	private Categorie categorie;
	
	@Override
	public String toString() {
		return "Produit [idPrct=" + idPrct + ", nomPrct=" + nomPrct + ", descPrct=" + descPrct + ", categorie="
				+ categorie + ", articles=" + articles + "]";
	}

	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	private List<Article> articles;
	
	
	/**
	 * 
	 */
	public Produit() {
		super();
	}
	/**
	 * @param idPrct
	 * @param nomPrct
	 * @param descPrct
	 */
	public Produit( String nomPrct, String descPrct) {
		super();
		
		this.nomPrct = nomPrct;
		this.descPrct = descPrct;
	}
	public Long getIdPrct() {
		return idPrct;
	}
	public void setIdPrct(Long idPrct) {
		this.idPrct = idPrct;
	}
	public String getNomPrct() {
		return nomPrct;
	}
	public void setNomPrct(String nomPrct) {
		this.nomPrct = nomPrct;
	}
	public String getDescPrct() {
		return descPrct;
	}
	public void setDescPrct(String descPrct) {
		this.descPrct = descPrct;
	}

}
