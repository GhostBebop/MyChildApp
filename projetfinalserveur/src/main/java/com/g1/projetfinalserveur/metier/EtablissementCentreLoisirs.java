package com.g1.projetfinalserveur.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
@Entity
@DiscriminatorValue(value = "CENTRE_LOISIRS")
public class EtablissementCentreLoisirs extends Etablissement{
	
}
