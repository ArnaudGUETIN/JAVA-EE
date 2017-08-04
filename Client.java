package com.fasoyaar.entity.client;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//@MappedSuperclass
@Entity
@Table(name="t_client")
public class Client implements Serializable{
	
	@Override
	public String toString() {
		return "Client [idCl=" + idCl + ", nomCl=" + nomCl + ", prenom=" + prenom + ", telephone=" + telephone
				+ ", password=" + password + ", email=" + email + ", login=" + login + ", dateNaiss=" + dateNaiss;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long idCl;
	@Column(name="nom_client",length=60)
	protected String nomCl;
	@Column(name="prenom_client",length=60)
	protected String prenom;
	@Column(name="tel_client",length=60)
	protected String telephone;
	@Column(name="mot_de_passe",length=60)
	protected String password;
	@Column(name="mail",length=60)
	protected String email;
	@Column(nullable=false,length=60)
	protected String login;
	@Column(nullable=false)
	protected Date   dateNaiss;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="adresse_fk",nullable=true)
	protected Adresse adresse;
	
	
	public Long getIdCl() {
		return idCl;
	}
	public void setIdCl(Long idCl) {
		this.idCl = idCl;
	}
	public String getNomCl() {
		return nomCl;
	}
	public void setNomCl(String nomCl) {
		this.nomCl = nomCl;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Date getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	/**
	 * 
	 */
	public Client() {
		super();
	}
	/**
	 * @param idCl
	 * @param nomCl
	 * @param prenom
	 * @param telephone
	 * @param password
	 * @param email
	 * @param login
	 * @param dateNaiss
	 */
	public Client( String nomCl, String prenom, String telephone, String password, String email, String login,
			Date dateNaiss) {
		super();
		
		this.nomCl = nomCl;
		this.prenom = prenom;
		this.telephone = telephone;
		this.password = password;
		this.email = email;
		this.login = login;
		this.dateNaiss = dateNaiss;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
