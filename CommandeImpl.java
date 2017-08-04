package com.fasoyaar.session.commande;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.fasoyaar.entity.categorie.Article;
import com.fasoyaar.entity.client.Adresse;
import com.fasoyaar.entity.client.Client;
import com.fasoyaar.entity.commande.Commande;
import com.fasoyaar.entity.commande.LigneCmd;
import com.fasoyaar.session.catalogue.ICatalogueLocal;
import com.fasoyaar.session.client.IClientLocal;

@Stateless(name="CommandeMetier")
public class CommandeImpl implements ICommandeLocal,ICommandeRemote {
 
	@EJB
	private IClientLocal client;
	@PersistenceContext(unitName="UP_FasoYaar")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> findAllCommande() {
		// TODO Auto-generated method stub
		Query query;
		List<Commande> commandes;
		query=em.createQuery("SELECT c FROM Commande c");
		commandes=query.getResultList();
		return commandes;
	}

	@Override
	public Commande findCommande(Long idCmd) {
		// TODO Auto-generated method stub

		Commande cmd;
		cmd=em.find(Commande.class,idCmd);
		return cmd;
	}

	@Override
	public void deleteCommande(Commande cmd) {
		// TODO Auto-generated method stub
		em.remove(em.merge(cmd));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Commande> getCommande(Long idCl) {
		// TODO Auto-generated method stub
		Query query=em.createQuery("select c from Commande c where c.client.idCl="+idCl+"");
		
		return (ArrayList<Commande>) query.getResultList();
	}

	@Override
	public Commande updateCommande(Adresse adr,Commande cmd) {
		// TODO Auto-generated method stub
		em.merge(cmd);
		//cmd.setAddresse(adr);
		em.refresh(cmd);
		return cmd;
	}

	@Override
	public Commande createCommande(Long idCl) {
		// TODO Auto-generated method stub
		Client cl=client.findCient(idCl);
		Commande c= new Commande();
		c.setClient(cl);
		c.setDateCmd(new Date());
		c.setAddresse((cl.getAdresse()));
		em.persist(c);
		return c;
	}

	@Override
	public LigneCmd createLigneCommande(Long idArt) {
		// TODO Auto-generated method stub
		Article a=em.find(Article.class, idArt);
		LigneCmd lc=new LigneCmd();
		Adresse ad= em.find(Adresse.class, 23L);
		lc.setArticle(a);
		lc.setQuantite(1);
		em.persist(lc);
		return lc;
	}

	@Override
	public Commande addLigneCommande(Long idCmd, Long idArt) {
		// TODO Auto-generated method stub
		Commande c=em.find(Commande.class, idCmd);
		int i=0;
		
		if(c.getLignesDeCmd().isEmpty()){
			List<LigneCmd> lignes= new ArrayList<LigneCmd>();
			
			LigneCmd ligne=this.createLigneCommande(idArt);
			lignes.add(ligne);
			c.setLignesDeCmd(lignes);
			em.persist(c);
		}
		else{
		//Iterator<LigneCmd> it=lc.iterator();
			List<LigneCmd> lc=c.getLignesDeCmd();
		for (LigneCmd ligne : lc) {
			if(ligne.getArticle().getIdArt()==idArt){
				ligne.setQuantite(ligne.getQuantite()+1);
				em.persist(c);
				i++;
				
			}
		}
		if(i==0){
			List<LigneCmd> lcs=c.getLignesDeCmd();
			LigneCmd lign=this.createLigneCommande(idArt);
			lcs.add(lign);
			c.setLignesDeCmd(lcs);
			em.persist(c);
			
		}
		
		}
		
		
			
			
		return c;
	}

	@Override
	public Commande deletLigneCommande(Commande cmd, LigneCmd ligne) {
		// TODO Auto-generated method stub
		em.merge(cmd);
		ArrayList<LigneCmd> lc=(ArrayList<LigneCmd>)cmd.getLignesDeCmd();
		int i;
			if(lc.contains(ligne)){
			i=lc.indexOf(ligne);
			LigneCmd l=lc.get(i);
			l.setQuantite(l.getQuantite()-1);
			lc.set(i, l);
			cmd.setLignesDeCmd(lc);
		}
			em.refresh(cmd);
		return cmd;
	}

	@Override
	public Commande updateCommande(Commande cmd) {
		// TODO Auto-generated method stub
		em.merge(cmd);
		em.refresh(cmd);
		return null;
	}

	

}
