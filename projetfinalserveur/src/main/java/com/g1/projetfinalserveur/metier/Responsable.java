package com.g1.projetfinalserveur.metier;

import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Scope(value = "prototype")
@Component
@Entity
@DiscriminatorValue(value = "RESPONSABLE")
public class Responsable extends User {

	@JsonIgnore
	@OneToMany(mappedBy = "monResponsable", fetch = FetchType.LAZY)
	private Set<Enfant> mesEnfants;

	private String prenom;

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<Enfant> getMesEnfants() {
		return mesEnfants;
	}

	public void setMesEnfants(Set<Enfant> mesEnfants) {
		this.mesEnfants = mesEnfants;
	}

}
