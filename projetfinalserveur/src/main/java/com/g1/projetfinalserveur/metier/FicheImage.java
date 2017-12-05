package com.g1.projetfinalserveur.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
@Entity
@DiscriminatorValue(value = "FICHE_IMAGE")
public class FicheImage extends Fiche {
	private String classe;
	private String statutImage;

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getStatutImage() {
		return statutImage;
	}

	public void setStatutImage(String statutImage) {
		this.statutImage = statutImage;
	}

	

}
