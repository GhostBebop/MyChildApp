package com.g1.projetfinalserveur.metier;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Scope(value = "prototype")
@Component
@Entity
public class Connexion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idConnexion;
	private String login;
	private String mdp;
	
	@JsonIgnore
	@OneToOne(mappedBy = "maConnexion", fetch = FetchType.LAZY,cascade =CascadeType.ALL)
	private User monUser;

	public User getMonUser() {
		return monUser;
	}

	public void setMonUser(User monUser) {
		this.monUser = monUser;
	}

	public long getIdConnexion() {
		return idConnexion;
	}

	public void setIdConnexion(long idConnexion) {
		this.idConnexion = idConnexion;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
