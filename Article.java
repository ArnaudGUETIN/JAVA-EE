package com.fasoyaar.entity.categorie;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_article")
public class Article implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idArt;
	@Column(name="nom_article",length=60)
	private String nomArt;
	@Column(name="prix_unitaire")
	private Float pu;
	@Column(name="chemin_image",length=255)
	private String imagePath;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="produit_fk")
	private Produit produit;
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	/**
	 * @param idArt
	 * @param nomArt
	 * @param pu
	 * @param imagePath
	 */
	public Article( String nomArt, Float pu, String imagePath) {
		super();
		this.nomArt = nomArt;
		this.pu = pu;
		this.imagePath = imagePath;
	}
	/**
	 * 
	 */
	public Article() {
		super();
	}
	@Override
	public String toString() {
		return "Article [idArt=" + idArt + ", nomArt=" + nomArt + ", pu=" + pu + ", imagePath=" + imagePath + "]";
	}
	public Long getIdArt() {
		return idArt;
	}
	public void setIdArt(Long idArt) {
		this.idArt = idArt;
	}
	public String getNomArt() {
		return nomArt;
	}
	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}
	public Float getPu() {
		return pu;
	}
	public void setPu(Float pu) {
		this.pu = pu;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	

}
