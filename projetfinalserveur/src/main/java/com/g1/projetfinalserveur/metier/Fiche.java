package com.g1.projetfinalserveur.metier;

import java.util.Set;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Scope(value = "prototype")
@Component
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_FICHE")
public abstract class Fiche {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idFiche;

	@ManyToOne(fetch = FetchType.EAGER)
	private Enfant monEnfant;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "fiche_user", joinColumns = @JoinColumn(name ="mesFiches_idFiche" , referencedColumnName = "idFiche"), inverseJoinColumns = @JoinColumn(name = "mesEtablissementsFiche_idUser", referencedColumnName ="idUser" ))
	private Set<Etablissement> mesEtablissementsFiche;
	
	
	private String typeFiche;
	
	

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="maDemandeEtablissement")
	private Set<Demande> mesDemandesEtablissement;
	
	
	
	public Set<Demande> getMesDemandesEtablissement() {
		return mesDemandesEtablissement;
	}

	public void setMesDemandesEtablissement(Set<Demande> mesDemandesEtablissement) {
		this.mesDemandesEtablissement = mesDemandesEtablissement;
	}

	public long getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(long idFiche) {
		this.idFiche = idFiche;
	}

	public Enfant getMonEnfant() {
		return monEnfant;
	}

	public void setMonEnfant(Enfant monEnfant) {
		this.monEnfant = monEnfant;
	}

	public Set<Etablissement> getMesEtablissementsFiche() {
		return mesEtablissementsFiche;
	}

	public void setMesEtablissementsFiche(Set<Etablissement> mesEtablissementsFiche) {
		this.mesEtablissementsFiche = mesEtablissementsFiche;
	}

	public String getTypeFiche() {
		return typeFiche;
	}

	public void setTypeFiche(String typeFiche) {
		this.typeFiche = typeFiche;
	}
	

}
