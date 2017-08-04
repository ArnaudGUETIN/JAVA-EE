package com.fasoyaar.session.client;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fasoyaar.entity.client.Adresse;
import com.fasoyaar.entity.client.Client;


@Stateless(name="ClientMetier")
public class ClientImpl implements IClientLocal,IClientRemote{
	
	@PersistenceContext(unitName="UP_FasoYaar")
	private EntityManager em;
	
	
	@Override
	public void deleteClient(Long idCl) {
		// TODO Auto-generated method stub
		Client cl=em.find(Client.class, idCl);
		Long idAd=cl.getAdresse().getIdAddress();
		em.remove(em.find(Adresse.class, idAd));
		em.remove(em.find(Client.class, idCl));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		Query query;
		List<Client> clients;
		query=em.createQuery("SELECT c FROM Client c");
		clients=query.getResultList();
		return clients;
	}

	

	@Override
	public Client createClient(Client cl, Adresse ad) {
		// TODO Auto-generated method stub
		cl.setAdresse(ad);
		em.persist(cl);
		return cl;
	}

	@Override
	public Client findCient(Long Idclient) {
		// TODO Auto-generated method stub
		Client client;
		client=em.find(Client.class, Idclient);
		return client;
	}

	@Override
	public Client UpdateClient(Long idCl, Adresse ad) {
		// TODO Auto-generated method stub
		Client clt=em.find(Client.class, idCl);
		Adresse adr=clt.getAdresse();
		adr.setCity(ad.getCity());
		adr.setCountry(ad.getCountry());
		adr.setStreet(ad.getStreet());
		em.persist(clt);
		
		return clt;
	}

}
