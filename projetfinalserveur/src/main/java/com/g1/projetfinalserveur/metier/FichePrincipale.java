package com.g1.projetfinalserveur.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope(value = "prototype")
@Component
@Entity
@DiscriminatorValue(value = "FICHE_PRINCIPALE")
public class FichePrincipale extends Fiche {
	private String adresse;
	private String codePostal;
	private String ville;
	private String telMaison;
	private String email;
	private String regimeCantine;
	private String statutGarderie;
	private String statutEtude;
	private String statutSortie;
	private String transport;
	private String pension;
	private String travailPere;
	private String telTravailPere;
	private String portablePere;
	private String nomResponsablePere;
	private String telResponsablePere;
	private String travailMere;
	private String telTravailMere;
	private String portableMere;
	private String nomResponsableMere;
	private String telResponsableMere;

	public String getPension() {
		return pension;
	}

	public void setPension(String pension) {
		this.pension = pension;
	}

	public String getTravailPere() {
		return travailPere;
	}

	public void setTravailPere(String travailPere) {
		this.travailPere = travailPere;
	}

	public String getTelTravailPere() {
		return telTravailPere;
	}

	public void setTelTravailPere(String telTravailPere) {
		this.telTravailPere = telTravailPere;
	}

	public String getPortablePere() {
		return portablePere;
	}

	public void setPortablePere(String portablePere) {
		this.portablePere = portablePere;
	}

	public String getNomResponsablePere() {
		return nomResponsablePere;
	}

	public void setNomResponsablePere(String nomResponsablePere) {
		this.nomResponsablePere = nomResponsablePere;
	}

	public String getTelResponsablePere() {
		return telResponsablePere;
	}

	public void setTelResponsablePere(String telResponsablePere) {
		this.telResponsablePere = telResponsablePere;
	}

	public String getTravailMere() {
		return travailMere;
	}

	public void setTravailMere(String travailMere) {
		this.travailMere = travailMere;
	}

	public String getTelTravailMere() {
		return telTravailMere;
	}

	public void setTelTravailMere(String telTravailMere) {
		this.telTravailMere = telTravailMere;
	}

	public String getPortableMere() {
		return portableMere;
	}

	public void setPortableMere(String portableMere) {
		this.portableMere = portableMere;
	}

	public String getNomResponsableMere() {
		return nomResponsableMere;
	}

	public void setNomResponsableMere(String nomResponsableMere) {
		this.nomResponsableMere = nomResponsableMere;
	}

	public String getTelResponsableMere() {
		return telResponsableMere;
	}

	public void setTelResponsableMere(String telResponsableMere) {
		this.telResponsableMere = telResponsableMere;
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

	public String getTelMaison() {
		return telMaison;
	}

	public void setTelMaison(String telMaison) {
		this.telMaison = telMaison;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegimeCantine() {
		return regimeCantine;
	}

	public void setRegimeCantine(String regimeCantine) {
		this.regimeCantine = regimeCantine;
	}

	public String getStatutGarderie() {
		return statutGarderie;
	}

	public void setStatutGarderie(String statutGarderie) {
		this.statutGarderie = statutGarderie;
	}

	public String getStatutEtude() {
		return statutEtude;
	}

	public void setStatutEtude(String statutEtude) {
		this.statutEtude = statutEtude;
	}

	public String getStatutSortie() {
		return statutSortie;
	}

	public void setStatutSortie(String statutSortie) {
		this.statutSortie = statutSortie;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	

}
