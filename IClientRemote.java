package com.fasoyaar.session.client;

import java.util.List;

import javax.ejb.Remote;

import com.fasoyaar.entity.client.Adresse;
import com.fasoyaar.entity.client.Client;

@Remote
public interface IClientRemote {
	
	Client createClient(Client cl,Adresse ad);
	Client findCient(Long Idclient);
	void   deleteClient(Long idCl);
	Client UpdateClient(Long idCl,Adresse ad);
	List<Client> getAllClients();

}
