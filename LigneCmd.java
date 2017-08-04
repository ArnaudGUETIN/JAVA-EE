package com.fasoyaar.entity.commande;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasoyaar.entity.categorie.Article;

@Entity
@Table(name="t_ligneCmd")
public class LigneCmd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idLigneCmd;
	private Integer quantite;
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinColumn(name="article_fk")
	private Article article;
	/**
	 * 
	 */
	public LigneCmd() {
		super();
	}
	/**
	 * @param idLigneCmd
	 * @param quantite
	 * @param article
	 */
	public LigneCmd( Integer quantite, Article article) {
		super();
		
		this.quantite = quantite;
		this.article = article;
	}
	public Long getIdLigneCmd() {
		return idLigneCmd;
	}
	public void setIdLigneCmd(Long idLigneCmd) {
		this.idLigneCmd = idLigneCmd;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
}
