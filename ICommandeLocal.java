package com.fasoyaar.session.commande;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import com.fasoyaar.entity.categorie.Article;
import com.fasoyaar.entity.client.Adresse;
import com.fasoyaar.entity.client.Client;
import com.fasoyaar.entity.commande.Commande;
import com.fasoyaar.entity.commande.LigneCmd;
import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;

@Local
public interface ICommandeLocal {

	public Commande createCommande(Long idCl);
	public void deleteCommande(Commande cmd);
	public LigneCmd createLigneCommande(Long idArt);
	public Commande addLigneCommande(Long idCmd,Long idArt);
	public Commande deletLigneCommande(Commande cmd,LigneCmd ligne);
	public ArrayList<Commande> getCommande(Long idCl);
	public Commande updateCommande(Commande cmd);
	
}
