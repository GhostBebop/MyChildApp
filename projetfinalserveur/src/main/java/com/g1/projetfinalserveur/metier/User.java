package com.g1.projetfinalserveur.metier;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Scope(value = "prototype")
@Component
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_USER")
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUser;

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	private Connexion maConnexion;

	private String nom;
	private String adresse;
	private String codePostal;
	private String ville;

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Connexion getMaConnexion() {
		return maConnexion;
	}

	public void setMaConnexion(Connexion maConnexion) {
		this.maConnexion = maConnexion;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nom=" + nom + "]";
	}


	
	
	
}
