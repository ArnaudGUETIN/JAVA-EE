package com.fasoyaar.session.commande;

import java.util.List;

import javax.ejb.Remote;

import com.fasoyaar.entity.client.Adresse;
import com.fasoyaar.entity.commande.Commande;

@Remote
public interface ICommandeRemote {
	
	public void deleteCommande(Commande cmd);
	public List<Commande> findAllCommande();
	public Commande findCommande(Long idCmd);
	public Commande updateCommande(Adresse adr,Commande cmd);
	
	
	

}
