package com.g1.projetfinalserveur;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

import com.g1.projetfinalserveur.service.IserviceEtablissement;

@CrossOrigin
@RestController
public class EtablissementController {
	@Autowired
	private IserviceEtablissement service;
	

	// saveEtablissement

	@RequestMapping(value = "/saveCentreLoisirs",method=RequestMethod.POST)
	public EtablissementCentreLoisirs saveCentreLoisirs(@RequestBody EtablissementCentreLoisirs e) {
		service.createCentreLoisirs(e);
		return e;
	}
	
	@RequestMapping(value = "/saveEcole",method=RequestMethod.POST)
	public EtablissementEcole saveEcole(@RequestBody EtablissementEcole e) {
		service.createEcole(e);
		return e;
	}

	@RequestMapping(value = "/saveClub",method=RequestMethod.POST)
	public EtablissementClub saveClub(@RequestBody EtablissementClub e) {
		service.createClub(e);
		return e;
	}

	// updateEtablissement

	@RequestMapping(value = "/updateCentreLoisirs")
	public EtablissementCentreLoisirs updateCentreLoisirs(EtablissementCentreLoisirs e) {
		service.updateCentreLoisirs(e);
		return e;
	}

	@RequestMapping(value = "/updateEcole",method=RequestMethod.POST)
	public EtablissementEcole updateEcole(@RequestBody EtablissementEcole e) {
		service.updateEcole(e);
		return e;
	}

	@RequestMapping(value = "/updateClub")
	public EtablissementClub updateClub(EtablissementClub e) {
		service.updateClub(e);
		return e;
	}

	// deleteEtablissement

	@RequestMapping(value = "/deleteCentreLoisirs")
	public EtablissementCentreLoisirs deleteCentreLoisirs(EtablissementCentreLoisirs e) {
		service.deleteCentreLoisirs(e);
		return e;
	}

	@RequestMapping(value = "/deleteEcole")
	public EtablissementEcole deleteEcole(EtablissementEcole e) {
		service.deleteEcole(e);
		return e;
	}

	@RequestMapping(value = "/deleteClub")
	public EtablissementClub deleteClub(EtablissementClub e) {
		service.deleteClub(e);
		return e;
	}

	// getEtablissement

	@RequestMapping(value = "/getEtablissement")
	public Object getEtablissement(long idEtablissement) {
		return service.getEtablissement(idEtablissement);
	}

	// findAll

	@RequestMapping(value = "/findAllEnfant")
	public List<Enfant> findAllEnfant() {
		return service.findAllEnfant();
	}

	@RequestMapping(value = "/findAllFiche",method=RequestMethod.GET)
	public List<Fiche> findAllFiche() {
		return service.findAllFiche();
	}

	@RequestMapping(value = "/findAllFicheEnfant",method=RequestMethod.GET)
	public List<Fiche> findAllFicheEnfant(@Param("x") long idEnfant) {
		return service.findAllFicheEnfant(idEnfant);
	}
	// list

	@RequestMapping(value = "/findAllEnfantEtablissement")
	public List<Enfant> findAllEnfantEtablissement(long idEtablissement) {
		return service.findAllEnfantEtablissement(idEtablissement);
	}

	@RequestMapping(value = "/findAllFicheEtablissement",method=RequestMethod.GET)
	public List<Fiche> findAllFicheEtablissement(@RequestParam long idEtablissement) {
		return service.findAllFicheEtablissement(idEtablissement);
	}

	@RequestMapping(value = "/findAllFichePrincipaleEtablissement",method=RequestMethod.GET)
	public List<FichePrincipale> findAllFichePrincipaleEtablissement(@RequestParam long idEtablissement) {
		return service.findAllFichePrincipaleEtablissement(idEtablissement);
	}

	@RequestMapping(value = "/findAllFicheMedicalEtablissement",method=RequestMethod.GET)
	public List<FicheMedical> findAllFicheMedicalEtablissement(@RequestParam long idEtablissement) {
		return service.findAllFicheMedicalEtablissement(idEtablissement);
	}
	
	@RequestMapping(value = "/findAllFicheVaccinEtablissement",method=RequestMethod.GET)
	public List<FicheVaccin> findAllFicheVaccinEtablissement(@RequestParam long idEtablissement) {
		return service.findAllFicheVaccinEtablissement(idEtablissement);
	}
	
	@RequestMapping(value = "/findAllFicheImageEtablissement",method=RequestMethod.GET)
	public List<FicheImage> findAllFicheImageEtablissement(@RequestParam long idEtablissement) {
		return service.findAllFicheImageEtablissement(idEtablissement);
	}
	

	
	// demande

	
	@RequestMapping(value = "/demande",method=RequestMethod.GET)
	public Demande createDemande(@RequestParam long idEtablissement,@RequestParam long idFiche, @RequestParam long idEnfant) {
		Demande d = new Demande();
		d.setMaDemandeFiche((Fiche) service.getFiche(idFiche));
		d.setMaDemandeEnfant((Enfant) service.getEnfant(idEnfant));
		d.setMaDemandeEtablissement((Etablissement) service.getEtablissement(idEtablissement));
		service.createDemande(d);
		service.updateDemande(d);
		return d;
		
	}

	@RequestMapping(value = "/deleteDemande",method=RequestMethod.GET)
	public void deleteDemande(@RequestParam long idDemande) {
		Demande d = service.getDemande(idDemande);
		service.deleteDemande(d);
	}

	@RequestMapping(value = "/getDemande")
	public Demande getDemande(long idDemande) {
		return service.getDemande(idDemande);
	}

	@RequestMapping(value = "/findAllDemandeEtablissement",method=RequestMethod.GET)
	public List<Demande> findAllDemandeEtablissement(@RequestParam long idEtablissement) {
		return service.findAllDemandeEtablissement(idEtablissement);
	}

	// connexion

	@RequestMapping(value = "/connexionEtablissement",method=RequestMethod.POST)
	public Etablissement connexionEtablissement(@RequestBody Connexion c) {
		return service.connexionEtablissement(c.getLogin(), c.getMdp());
	}

	@RequestMapping(value = "/createConnexionEtablissement",method=RequestMethod.POST)
	public Connexion createConnexion(@RequestBody Connexion c) {
		service.createConnexion(c);
		return c;
	}

	@RequestMapping(value = "/linkConnexionEtablissement",method=RequestMethod.GET)
	public void linkConnexionEtablissement(@RequestParam long idEtablissement,@RequestParam long idConnexion) {
		
		Etablissement e = (Etablissement) service.getEtablissement(idEtablissement);
		e.setMaConnexion(service.getConnexion(idConnexion));
	
		try {
			service.updateEcole((EtablissementEcole) e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		}
		try {
			service.updateClub((EtablissementClub) e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		}
		try {
			service.updateCentreLoisirs((EtablissementCentreLoisirs) e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
		}
		
	}
	@RequestMapping(value = "/findAllFicheNoDemdandeEtablissement",method=RequestMethod.GET)
	public List<Fiche> findAllFicheNoDemdandeEtablissement(@RequestParam long idEtablissement) {
		return service.findAllFicheNoDemdandeEtablissement(idEtablissement);
		
	}

	
	
}
