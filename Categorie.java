package com.fasoyaar.entity.categorie;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_categorie")

public class Categorie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCat;
	@Column(name="nom_categorie")
	private String nomCat;
	@Column(name="desc_categorie")
	private String descCat;
	
	@OneToMany(mappedBy="categorie",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	private List<Produit> produits;
	
	
	/**
	 * 
	 */
	public Categorie() {
		super();
	}
	
	/**
	 * @param idCat
	 * @param nomCat
	 * @param descCat
	 */
	public Categorie( String nomCat, String descCat) {
		super();
		
		this.nomCat = nomCat;
		this.descCat = descCat;
	}

	public Long getIdCat() {
		return idCat;
	}
	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	public String getDescCat() {
		return descCat;
	}
	public void setDescCat(String descCat) {
		this.descCat = descCat;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	

}
