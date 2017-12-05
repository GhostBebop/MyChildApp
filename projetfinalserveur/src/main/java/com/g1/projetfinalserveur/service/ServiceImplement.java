package com.g1.projetfinalserveur.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.g1.projetfinalserveur.dao.CentreLoisirsDAO;
import com.g1.projetfinalserveur.dao.ClubDAO;
import com.g1.projetfinalserveur.dao.ConnexionDAO;
import com.g1.projetfinalserveur.dao.DemandeDAO;
import com.g1.projetfinalserveur.dao.EcoleDAO;
import com.g1.projetfinalserveur.dao.EnfantDAO;

import com.g1.projetfinalserveur.dao.FicheImageDAO;
import com.g1.projetfinalserveur.dao.FicheMedicalDAO;
import com.g1.projetfinalserveur.dao.FichePrincipaleDAO;
import com.g1.projetfinalserveur.dao.FicheVaccinDAO;

import com.g1.projetfinalserveur.dao.ResponsableDAO;
import com.g1.projetfinalserveur.metier.Connexion;
import com.g1.projetfinalserveur.metier.Demande;
import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.Etablissement;
import com.g1.projetfinalserveur.metier.EtablissementCentreLoisirs;
import com.g1.projetfinalserveur.metier.EtablissementClub;
import com.g1.projetfinalserveur.metier.EtablissementEcole;

import com.g1.projetfinalserveur.metier.Fiche;
import com.g1.projetfinalserveur.metier.FicheImage;
import com.g1.projetfinalserveur.metier.FicheMedical;
import com.g1.projetfinalserveur.metier.FichePrincipale;
import com.g1.projetfinalserveur.metier.FicheVaccin;

import com.g1.projetfinalserveur.metier.Responsable;

@Service
public class ServiceImplement implements IserviceResponsable, IserviceEtablissement {

	@Autowired
	EnfantDAO enfantDao;
	@Autowired
	ResponsableDAO responsableDao;
	@Autowired
	ClubDAO clubDao;
	@Autowired
	EcoleDAO ecoleDao;
	@Autowired
	CentreLoisirsDAO centreLoisirsDao;
	@Autowired
	FicheImageDAO ficheImageDao;
	@Autowired
	FicheMedicalDAO ficheMedicalDao;
	@Autowired
	FichePrincipaleDAO fichePrincipaleDao;
	@Autowired
	FicheVaccinDAO ficheVaccinDao;

	@Autowired
	ConnexionDAO connexionDao;

	@Autowired
	DemandeDAO demandeDao;

	// ******CRUD RESPONSABLE
	@Override
	public void createResponsable(Responsable r) {
		// TODO Auto-generated method stub
		responsableDao.save(r);
	}

	@Override
	public List<Responsable> findResponsables() {
		// TODO Auto-generated method stub
		return responsableDao.findAll();
	}

	@Override
	public void deleteResponsable(Responsable r) {
		// TODO Auto-generated method stub
		responsableDao.delete(r);
	}

	@Override
	public Responsable updateResponsable(Responsable r) {
		// TODO Auto-generated method stub
		return responsableDao.saveAndFlush(r);
	}

	@Override
	public Responsable getResponsable(long idResponsable) {
		// TODO Auto-generated method stub
		return responsableDao.findById(idResponsable).get();
	}

	// *****CRUD CLUB
	@Override
	public void createClub(EtablissementClub ec) {
		// TODO Auto-generated method stub
		clubDao.save(ec);
	}

	@Override
	public List<EtablissementClub> findClubs() {
		// TODO Auto-generated method stub
		return clubDao.findAll();
	}

	@Override
	public void deleteClub(EtablissementClub ec) {
		// TODO Auto-generated method stub
		clubDao.delete(ec);
	}

	@Override
	public EtablissementClub updateClub(EtablissementClub ec) {
		// TODO Auto-generated method stub
		return clubDao.saveAndFlush(ec);
	}

	@Override
	public EtablissementClub getClub(long idClub) {
		// TODO Auto-generated method stub
		return clubDao.findById(idClub).get();
	}

	// *****CRUD ECOLE
	@Override
	public List<EtablissementEcole> findEcoles() {
		// TODO Auto-generated method stub
		return ecoleDao.findAll();
	}

	@Override
	public void deleteEcole(EtablissementEcole ee) {
		// TODO Auto-generated method stub
		ecoleDao.delete(ee);
	}

	@Override
	public EtablissementEcole updateEcole(EtablissementEcole ee) {
		// TODO Auto-generated method stub
		return ecoleDao.saveAndFlush(ee);
	}

	@Override
	public void createEcole(EtablissementEcole ee) {
		// TODO Auto-generated method stub
		ecoleDao.save(ee);
	}

	@Override
	public EtablissementEcole getEcole(long idEcole) {
		// TODO Auto-generated method stub
		return ecoleDao.findById(idEcole).get();
	}

	// *****CRUD CENTRE LOISIR
	@Override
	public void createCentreLoisirs(EtablissementCentreLoisirs ecl) {
		// TODO Auto-generated method stub
		centreLoisirsDao.save(ecl);
	}

	@Override
	public List<EtablissementCentreLoisirs> findCentreLoisirs() {
		// TODO Auto-generated method stub
		return centreLoisirsDao.findAll();
	}

	@Override
	public void deleteCentreLoisirs(EtablissementCentreLoisirs ecl) {
		// TODO Auto-generated method stub
		centreLoisirsDao.delete(ecl);
	}

	@Override
	public EtablissementCentreLoisirs updateCentreLoisirs(EtablissementCentreLoisirs ecl) {
		// TODO Auto-generated method stub
		return centreLoisirsDao.saveAndFlush(ecl);
	}

	@Override
	public EtablissementCentreLoisirs getCentreLoisirs(long idCentreLoisir) {
		// TODO Auto-generated method stub
		return centreLoisirsDao.findById(idCentreLoisir).get();
	}

	// *****CRUD ENFANT
	@Override
	public void createEnfant(Enfant e) {
		// TODO Auto-generated method stub
		enfantDao.save(e);
	}

	@Override
	public List<Enfant> findAllEnfantResponsable(long idUser) {
		// TODO Auto-generated method stub
		return enfantDao.findAllEnfantResponsable(idUser);
	}

	@Override
	public void deleteEnfant(Enfant e) {
		// TODO Auto-generated method stub
		enfantDao.delete(e);
	}

	@Override
	public Enfant updateEnfant(Enfant e) {
		// TODO Auto-generated method stub
		return enfantDao.saveAndFlush(e);
	}

	@Override
	public Enfant getEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return enfantDao.findById(idEnfant).get();
	}

	// *****CRUD FICHE PRINCIPALE
	@Override
	public void createFichePrincipale(FichePrincipale fp) {
		// TODO Auto-generated method stub
		fichePrincipaleDao.save(fp);
	}

	@Override
	public List<FichePrincipale> findAllFichePrincipaleEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findAllFichePrincipaleEnfant(idEnfant);
	}

	@Override
	public void deleteFichePrincipale(FichePrincipale fp) {
		// TODO Auto-generated method stub
		fichePrincipaleDao.delete(fp);
	}

	@Override
	public FichePrincipale updateFichePrincipale(FichePrincipale fp) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.saveAndFlush(fp);
	}

	@Override
	public FichePrincipale getFichePrincipale(long idFichePrincipal) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findById(idFichePrincipal).get();
	}

	// *****CRUD FICHE MEDICAL
	@Override
	public void createFicheMedical(FicheMedical fm) {
		// TODO Auto-generated method stub
		ficheMedicalDao.save(fm);
	}

	@Override
	public List<FicheMedical> findAllFicheMedicalEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return ficheMedicalDao.findAllFicheMedicalEnfant(idEnfant);
	}

	@Override
	public void deleteFicheMedical(FicheMedical fm) {
		// TODO Auto-generated method stub
		ficheMedicalDao.delete(fm);
	}

	@Override
	public FicheMedical updateFicheMedical(FicheMedical fm) {
		// TODO Auto-generated method stub
		return ficheMedicalDao.saveAndFlush(fm);
	}

	@Override
	public FicheMedical getFicheMedical(long idFicheMedical) {
		// TODO Auto-generated method stub
		return ficheMedicalDao.findById(idFicheMedical).get();
	}

	// *****CRUD FICHE VACCIN
	@Override
	public void createFicheVaccin(FicheVaccin fv) {
		// TODO Auto-generated method stub
		ficheVaccinDao.save(fv);
	}

	@Override
	public List<FicheVaccin> findAllFicheVaccinEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return ficheVaccinDao.findAllFicheVaccinEnfant(idEnfant);
	}

	@Override
	public void deleteFicheVaccin(FicheVaccin fv) {
		// TODO Auto-generated method stub
		ficheVaccinDao.delete(fv);
	}

	@Override
	public FicheVaccin updateFicheVaccin(FicheVaccin fv) {
		// TODO Auto-generated method stub
		return ficheVaccinDao.saveAndFlush(fv);
	}

	@Override
	public FicheVaccin getFicheVaccin(long idFicheVaccin) {
		// TODO Auto-generated method stub
		return ficheVaccinDao.findById(idFicheVaccin).get();
	}

	// CRUD FICHE IMAGE
	@Override
	public void createFicheImage(FicheImage fi) {
		// TODO Auto-generated method stub
		ficheImageDao.save(fi);
	}

	@Override
	public List<FicheImage> findAllFicheImageEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return ficheImageDao.findAllFicheImageEnfant(idEnfant);
	}

	@Override
	public void deleteFicheImage(FicheImage fi) {
		// TODO Auto-generated method stub
		ficheImageDao.delete(fi);
	}

	@Override
	public FicheImage updateFicheImage(FicheImage fi) {
		// TODO Auto-generated method stub
		return ficheImageDao.saveAndFlush(fi);
	}

	@Override
	public FicheImage getFicheImage(long idFicheImage) {
		// TODO Auto-generated method stub
		return ficheImageDao.findById(idFicheImage).get();
	}

	// CRUD CONNEXION
	@Override
	public void createConnexion(Connexion c) {
		// TODO Auto-generated method stub
		connexionDao.save(c);
	}

	@Override
	public void deleteConnexion(Connexion m) {
		// TODO Auto-generated method stub

	}

	@Override
	public Connexion updateConnexion(Connexion m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connexion getConnexion(long idConnexion) {
		// TODO Auto-generated method stub
		return connexionDao.findById(idConnexion).get();
	}

	@Override
	public Connexion findMaConnexion(String login, String mdp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findObjectConnexion(String login, String mdp) {
		// TODO Auto-generated method stub
		return connexionDao.findObjectConnexion(login, mdp);
	}

	@Override
	public Responsable findResponsable(String login, String mdp) {
		// TODO Auto-generated method stub
		return connexionDao.findResponsable(login, mdp);
	}

	// Method ManyToMany

	@Override
	public List<EtablissementEcole> findAllEcoleFiche(long idFiche) {
		// TODO Auto-generated method stub
		return ecoleDao.findAllEcoleFiche(idFiche);
	}

	@Override
	public List<Enfant> findAllEnfantEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return enfantDao.findAllEnfantEtablissement(idEtablissement);
	}

	@Override
	public List<FicheImage> findAllFicheImageEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return ficheImageDao.findAllFicheImageEtablissement(idEtablissement);
	}

	@Override
	public List<FicheMedical> findAllFicheMedicalEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return ficheMedicalDao.findAllFicheMedicalEtablissement(idEtablissement);
	}

	@Override
	public List<FicheVaccin> findAllFicheVaccinEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return ficheVaccinDao.findAllFicheVaccinEtablissement(idEtablissement);
	}

	@Override
	public List<EtablissementCentreLoisirs> findAllCentreLoisirFiche(long idFiche) {
		// TODO Auto-generated method stub
		return centreLoisirsDao.findAllCentreLoisirFiche(idFiche);
	}

	@Override
	public List<EtablissementClub> findAllClubFiche(long idFiche) {
		// TODO Auto-generated method stub
		return clubDao.findAllClubFiche(idFiche);
	}

	@Override
	public List<EtablissementCentreLoisirs> findAllCentreLoisirEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return centreLoisirsDao.findAllCentreLoisirEnfant(idEnfant);
	}

	@Override
	public List<EtablissementClub> findAllClubEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return clubDao.findAllClubEnfant(idEnfant);
	}

	@Override
	public List<EtablissementEcole> findAllEcoleEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return ecoleDao.findAllEcoleEnfant(idEnfant);
	}

	@Override
	public List<FichePrincipale> findAllFichePrincipaleEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findAllFichePrincipaleEtablissement(idEtablissement);
	}

	// CRUD Demande

	@Override
	public void createDemande(Demande d) {
		// TODO Auto-generated method stub
		demandeDao.save(d);
	}

	@Override
	public void deleteDemande(Demande d) {
		// TODO Auto-generated method stub
		demandeDao.delete(d);
	}

	@Override
	public Demande updateDemande(Demande d) {
		// TODO Auto-generated method stub
		return demandeDao.saveAndFlush(d);
	}

	@Override
	public Demande getDemande(long idDemande) {
		// TODO Auto-generated method stub
		return demandeDao.findById(idDemande).get();
	}

	@Override
	public List<Demande> findAllDemandeEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return demandeDao.findAllDemandeEtablissement(idEtablissement);
	}

	@Override
	public List<Demande> findAllDemandeFiche(long idFiche) {
		// TODO Auto-generated method stub
		return demandeDao.findAllDemandeFiche(idFiche);
	}

	@Override
	public Object getFiche(long idFiche) {
		// TODO Auto-generated method stub
		Object o = null;

		try {
			o = fichePrincipaleDao.findById(idFiche).get();
			return o;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

		try {
			o = ficheMedicalDao.findById(idFiche).get();
			return o;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

		try {
			o = ficheVaccinDao.findById(idFiche).get();
			return o;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

		try {
			o = ficheImageDao.findById(idFiche).get();
			return o;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return o;
	}

	@Override
	public Object getEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		Object o = null;
		try {
			o = ecoleDao.findById(idEtablissement).get();
			return o;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

		try {
			o = clubDao.findById(idEtablissement).get();
			return o;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

		try {
			o = centreLoisirsDao.findById(idEtablissement).get();
			return o;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return o;
	}

	@Override
	public List<Enfant> findAllEnfant() {
		// TODO Auto-generated method stub
		return enfantDao.findAll();
	}

	@Override
	public List<Fiche> findAllFicheEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findAllFicheEnfant(idEnfant);
	}

	@Override
	public Etablissement connexionEtablissement(String login, String mdp) {
		// TODO Auto-generated method stub
		return connexionDao.connexionEtablissement(login, mdp);
	}

	@Override
	public List<Fiche> findAllFicheEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findAllFicheEtablissement(idEtablissement);
	}

	@Override
	public List<Etablissement> findAllEtablissementFiche(long idFiche) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findAllEtablissementFiche(idFiche);
	}

	@Override
	public List<Fiche> findAllFiche() {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findAllFiche();
	}

	@Override
	public List<Demande> findAllDemandeEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return demandeDao.findAllDemandeEnfant(idEnfant);
	}

	@Override
	public List<Fiche> findAllFicheNoDemdandeEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub

		List<Demande> mesDemandes = demandeDao.findAllDemandeEtablissement(idEtablissement);
		List<Fiche> AllFiches = fichePrincipaleDao.findAllFiche();
		List<Fiche> mesFiches = fichePrincipaleDao.findAllFicheEtablissement(idEtablissement);
		List<Fiche> affiche = new ArrayList<Fiche>();
		boolean ok = true;
		for (Fiche f : AllFiches) {
			for (Fiche mf : mesFiches) {
				if (f.getIdFiche() == mf.getIdFiche()) {
					ok = false;
				}

			}
			for (Demande d : mesDemandes) {
				if (f.getIdFiche() == d.getMaDemandeFiche().getIdFiche()) {
					ok = false;
				}

			}

			if (ok) {
				affiche.add(f);
			}
			ok = true;
		}

		return affiche;

	}

}
