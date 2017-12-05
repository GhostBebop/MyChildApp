package com.g1.projetfinalserveur.metier;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
@Entity
public class Demande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDemande;

	@ManyToOne(fetch = FetchType.EAGER)
	private Fiche maDemandeFiche;
	@ManyToOne(fetch = FetchType.EAGER)
	private Enfant maDemandeEnfant;
	@ManyToOne(fetch = FetchType.EAGER)
	private Etablissement maDemandeEtablissement;

	
	
	

	public Enfant getMaDemandeEnfant() {
		return maDemandeEnfant;
	}

	public void setMaDemandeEnfant(Enfant maDemandeEnfant) {
		this.maDemandeEnfant = maDemandeEnfant;
	}

	public long getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(long idDemande) {
		this.idDemande = idDemande;
	}

	

	public Fiche getMaDemandeFiche() {
		return maDemandeFiche;
	}

	public void setMaDemandeFiche(Fiche maDemandeFiche) {
		this.maDemandeFiche = maDemandeFiche;
	}

	public Etablissement getMaDemandeEtablissement() {
		return maDemandeEtablissement;
	}

	public void setMaDemandeEtablissement(Etablissement maDemandeEtablissement) {
		this.maDemandeEtablissement = maDemandeEtablissement;
	}

}
