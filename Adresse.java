package com.fasoyaar.entity.client;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_adresse")
public class Adresse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAddress;
	@Column(name="ville",length=60)
	private String city;
	@Column(name="rue",length=60)
	private String street;
	@Column(name="pays",length=60)
	private String Country;
	
	
	
	
	
	public Long getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	/**
	 * 
	 */
	public Adresse() {
		super();
	}
	/**
	 * @param idAddress
	 * @param city
	 * @param street
	 * @param country
	 */
	public Adresse(String city, String street, String country) {
		super();
		this.city = city;
		this.street = street;
		Country = country;
	}
}
