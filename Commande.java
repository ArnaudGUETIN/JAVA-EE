package com.fasoyaar.entity.commande;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasoyaar.entity.client.Adresse;
import com.fasoyaar.entity.client.Client;

@Entity
@Table(name="t_commande")
public class Commande implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCmd;
    @Column(name="date_commande",updatable=false)
    @Temporal(TemporalType.DATE)
	private Date dateCmd;
    @ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="client_fk")
	private Client client;
    @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="adress_fk")
    private Adresse addresse;
    @OneToMany(/*cascade=CascadeType.ALL,*/fetch=FetchType.EAGER)
    @JoinTable(name="cmd_ligneCmd", joinColumns={@JoinColumn(name="cmd_fk")},inverseJoinColumns={@JoinColumn(name="ligneCmd_fk")})
	private List<LigneCmd> lignesDeCmd;
	/**
	 * 
	 */
	public Commande() {
		super();
	}
	/**
	 * @param idCmd
	 * @param dateCmd
	 * @param client
	 * @param lignesDeCmd
	 */
	public Commande( Date dateCmd, Client client) {
		super();
		this.dateCmd = dateCmd;
		this.client = client;
		
	}
	/**
	 * @param dateCmd
	 * @param client
	 * @param addresse
	 * @param lignesDeCmd
	 */
	public Commande(Date dateCmd, Client client, Adresse addresse, List<LigneCmd> lignesDeCmd) {
		super();
		this.dateCmd = dateCmd;
		this.client = client;
		//this.addresse = addresse;
		this.lignesDeCmd = lignesDeCmd;
	}
	public Long getIdCmd() {
		return idCmd;
	}
	public void setIdCmd(Long idCmd) {
		this.idCmd = idCmd;
	}
	public Date getDateCmd() {
		return dateCmd;
	}
	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<LigneCmd> getLignesDeCmd() {
		return lignesDeCmd;
	}
	public void setLignesDeCmd(List<LigneCmd> lignesDeCmd) {
		this.lignesDeCmd = lignesDeCmd;
	}
	public Adresse getAddresse() {
		return addresse;
	}
	public void setAddresse(Adresse addresse) {
		this.addresse = addresse;
	}
	
	

}
