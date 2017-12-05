package com.g1.projetfinalserveur.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
@Entity
@DiscriminatorValue(value = "FICHE_VACCIN")
public class FicheVaccin extends Fiche {
	private String statutVaccins;

	public String getStatutVaccins() {
		return statutVaccins;
	}

	public void setStatutVaccins(String statutVaccins) {
		this.statutVaccins = statutVaccins;
	}

	
	
	
	

}
