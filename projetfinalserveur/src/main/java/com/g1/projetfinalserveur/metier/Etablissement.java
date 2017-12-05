package com.g1.projetfinalserveur.metier;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Scope(value = "prototype")
@Component
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Etablissement extends User {

	@JsonIgnore
	@ManyToMany(mappedBy = "mesEtablissementsFiche", fetch = FetchType.EAGER)
	private Set<Fiche> mesFiches;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "mesEtablissementsEnfant")
	private Set<Enfant> mesEnfants;

	@JsonIgnore
	@OneToMany(mappedBy = "maDemandeFiche", fetch = FetchType.LAZY)
	private Set<Demande> mesDemandesFiche;
	
	private String typeEtablissement;
	
	

	public String getTypeEtablissement() {
		return typeEtablissement;
	}

	public void setTypeEtablissement(String typeEtablissement) {
		this.typeEtablissement = typeEtablissement;
	}

	public Set<Demande> getMesDemandesFiche() {
		return mesDemandesFiche;
	}

	public void setMesDemandesFiche(Set<Demande> mesDemandesFiche) {
		this.mesDemandesFiche = mesDemandesFiche;
	}

	public Set<Enfant> getMesEnfants() {
		return mesEnfants;

	}

	public void setMesEnfants(Set<Enfant> mesEnfants) {
		this.mesEnfants = mesEnfants;
	}

	public Set<Fiche> getMesFiches() {
		return mesFiches;
	}

	public void setMesFiches(Set<Fiche> mesFiches) {
		this.mesFiches = mesFiches;
	}
	
	 

}
