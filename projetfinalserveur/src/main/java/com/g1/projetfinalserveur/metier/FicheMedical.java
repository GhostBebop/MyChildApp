package com.g1.projetfinalserveur.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
@Entity
@DiscriminatorValue(value = "FICHE_MEDICAL")
public class FicheMedical extends Fiche {
	private String statutSpecialiste;
	private String observation;
	private String traitement;

	public String getStatutSpecialiste() {
		return statutSpecialiste;
	}

	public void setStatutSpecialiste(String statutSpecialiste) {
		this.statutSpecialiste = statutSpecialiste;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getTraitement() {
		return traitement;
	}

	public void setTraitement(String traitement) {
		this.traitement = traitement;
	}

}
