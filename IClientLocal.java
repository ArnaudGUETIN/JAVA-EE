package com.fasoyaar.session.client;

import java.util.List;

import javax.ejb.Local;
import javax.jws.WebParam;

import com.fasoyaar.entity.client.Adresse;
import com.fasoyaar.entity.client.Client;
import com.fasoyaar.entity.commande.Commande;

@Local
public interface IClientLocal {

	
	public Client createClient(Client cl,Adresse ad);
	public Client findCient(Long Idclient);
	public Client UpdateClient(Long idCl,Adresse ad);
	void   deleteClient(Long idCl);
	List<Client> getAllClients();
	
	

}
