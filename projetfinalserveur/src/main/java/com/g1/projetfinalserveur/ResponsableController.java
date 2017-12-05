package com.g1.projetfinalserveur;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.g1.projetfinalserveur.metier.Fiche;
import com.g1.projetfinalserveur.metier.FicheImage;
import com.g1.projetfinalserveur.metier.FicheMedical;
import com.g1.projetfinalserveur.metier.FichePrincipale;
import com.g1.projetfinalserveur.metier.FicheVaccin;
import com.g1.projetfinalserveur.metier.Responsable;
import com.g1.projetfinalserveur.service.IserviceResponsable;

/**
 * Handles requests for the application home page.
 */
@CrossOrigin
@RestController
public class ResponsableController {

	@Autowired
	private IserviceResponsable service;

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @return
	 */

	/*
	 * 
	 * @RequestMapping(value = "/", method=RequestMethod.POST)
	 * 
	 * @RequestBody
	 */

	// **********************responsable**********************

	@RequestMapping(value = "/saveResponsable", method = RequestMethod.POST)
	public Responsable saveResponsable(@RequestBody Responsable r) {
		service.createResponsable(r);
		return r;
	}

	@RequestMapping(value = "/updateResponsable")
	public Responsable updateResponsable(Responsable r) {
		service.updateResponsable(r);
		return r;
	}

	@RequestMapping(value = "/getResponsable")
	public Responsable getResponsable(long idUser) {
		return service.getResponsable(idUser);

	}

	@RequestMapping(value = "/linkConnexionResponsable",method=RequestMethod.GET)
	public void linkConnexionResponsable(@RequestParam long idResponsable,@RequestParam long idConnexion) {
		Responsable r;
		r = service.getResponsable(idResponsable);
		r.setMaConnexion(service.getConnexion(idConnexion));
		service.updateResponsable(r);
	}

	// **********************enfant**********************

	@RequestMapping(value = "/saveEnfant", method = RequestMethod.POST)
	public Enfant saveEnfant(@RequestBody Enfant e) {
		service.createEnfant(e);
		return e;
	}

	@RequestMapping(value = "/updateEnfant")
	public Enfant updateEnfant(Enfant e) {
		service.updateEnfant(e);
		return e;
	}

	@RequestMapping(value = "/deleteEnfant")
	public void deleteEnfant(long idEnfant) {

	}

	@RequestMapping(value = "/getEnfant")
	public Enfant getEnfant(long idEnfant) {
		return service.getEnfant(idEnfant);
	}

	@RequestMapping(value = "/linkEnfantResponsable", method = RequestMethod.GET)
	public void linkEnfantResponsable(@RequestParam long idResponsable,@RequestParam long idEnfant) {
		Enfant e = new Enfant();
		e = service.getEnfant(idEnfant);
		Responsable r = service.getResponsable(idResponsable);
		e.setMonResponsable(r);
		service.updateEnfant(e);
	}

	@RequestMapping(value = "/listEnfantResponsable",method=RequestMethod.GET)
	public List<Enfant> list(@RequestParam long idUser) {
		return service.findAllEnfantResponsable(idUser);
	}

	// **********************FichePrincipale**********************

	@RequestMapping(value = "/saveFichePrincipale",method=RequestMethod.POST)
	public FichePrincipale saveFichePrincipale(@RequestBody FichePrincipale fp) {
		service.createFichePrincipale(fp);
		return fp;
	}

	@RequestMapping(value = "/updateFichePrincipale",method=RequestMethod.POST)
	public FichePrincipale updateFichePrincipale(@RequestBody FichePrincipale fp) {
		service.updateFichePrincipale(fp);
		return fp;
	}
	
	@RequestMapping(value = "/getFichePrincipale",method=RequestMethod.GET)
	public FichePrincipale getFichePrincipale(@RequestParam long idFiche) {
		return service.getFichePrincipale(idFiche);
	}
	
	@RequestMapping(value = "/listFichePrincipaleEnfant",method=RequestMethod.GET)
	public List<FichePrincipale> listFichePrincipale(@RequestParam long idEnfant) {
		return service.findAllFichePrincipaleEnfant(idEnfant);
	}


	// **********************FicheMedical**********************

	@RequestMapping(value = "/saveFicheMedical",method=RequestMethod.POST)
	public FicheMedical saveFicheMedical(@RequestBody FicheMedical fm) {
		service.createFicheMedical(fm);
		return fm;
	}

	@RequestMapping(value = "/updateFicheMedical",method=RequestMethod.POST)
	public FicheMedical updateFicheMedical(@RequestBody FicheMedical fm) {
		service.updateFicheMedical(fm);
		return fm;
	}

	@RequestMapping(value = "/getFicheMedical")
	public FicheMedical getFicheMedical(long idFiche) {
		return service.getFicheMedical(idFiche);
	}

	@RequestMapping(value = "/listFicheMedicalEnfant",method = RequestMethod.GET)
	public List<FicheMedical> listFicheMedical(@RequestParam long idEnfant) {
		return service.findAllFicheMedicalEnfant(idEnfant);
	}

	// **********************FicheVaccin**********************

	@RequestMapping(value = "/saveFicheVaccin",method = RequestMethod.POST)
	public FicheVaccin saveFicheVaccin(@RequestBody FicheVaccin fv) {
		service.createFicheVaccin(fv);
		return fv;
	}

	@RequestMapping(value = "/updateFicheVaccin",method = RequestMethod.POST)
	public FicheVaccin updateFicheVaccin(@RequestBody FicheVaccin fv) {
		service.updateFicheVaccin(fv);
		return fv;
	}

	@RequestMapping(value = "/getFicheVaccin")
	public FicheVaccin getFicheVaccin(long idFiche) {
		return service.getFicheVaccin(idFiche);
	}

	@RequestMapping(value = "/listFicheVaccinEnfant",method = RequestMethod.GET)
	public List<FicheVaccin> listFicheVaccin(@RequestParam long idEnfant) {
		return service.findAllFicheVaccinEnfant(idEnfant);
	}


	// **********************FicheImage**********************

	@RequestMapping(value = "/saveFicheImage", method = RequestMethod.POST)
	public FicheImage saveFicheImage(@RequestBody FicheImage fi) {
		service.createFicheImage(fi);
		return fi;
	}

	@RequestMapping(value = "/updateFicheImage",method = RequestMethod.POST)
	public FicheImage updateFicheImage(@RequestBody FicheImage fi) {
		service.updateFicheImage(fi);
		return fi;
	}

	@RequestMapping(value = "/getFicheImage")
	public FicheImage getFicheImage(long idFiche) {
		return service.getFicheImage(idFiche);
	}

	@RequestMapping(value = "/listFicheImageEnfant")
	public List<FicheImage> listFicheImage(long idEnfant) {
		return service.findAllFicheImageEnfant(idEnfant);
	}


	// *************connexion************************

	@RequestMapping(value = "/createConnexionResponsable",method=RequestMethod.POST)
	public Connexion CreateConnexion(@RequestBody Connexion c) {
		service.createConnexion(c);
		return service.getConnexion(c.getIdConnexion());
	}

	@RequestMapping(value = "/findResponsable",method=RequestMethod.POST)
	public Responsable findResponsable(@RequestBody Connexion c) {
		return service.findResponsable(c.getLogin(), c.getMdp());
	}

	@RequestMapping(value = "/findMaConnexion")
	public Connexion findMaConnexion(Connexion c) {
		return service.findMaConnexion(c.getLogin(), c.getMdp());
	}

	@RequestMapping(value = "/findObjectConnexion")
	public Object findObjectConnexion(String login, String mdp) {
		return service.findObjectConnexion(login, mdp);

	}
	
	
	// *************unlink************************

	@RequestMapping(value = "/unLinkFicheEnfant")

	public void unLinkFiche(long idFiche) {
		Object f;
		f = service.getFiche(idFiche);
		((Fiche) f).setMonEnfant(null);
		try {
			service.updateFichePrincipale((FichePrincipale) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateFicheMedical((FicheMedical) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateFicheVaccin((FicheVaccin) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateFicheImage((FicheImage) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}

	}

	@RequestMapping(value = "/unLinkFicheEtablissement",method=RequestMethod.GET)
	public void unLinkFicheEtablissement(@RequestParam long idFiche,@RequestParam long idEtablissement) {

		Fiche f = (Fiche) service.getFiche(idFiche);
		HashSet<Long> ids = new HashSet<Long>();

		Iterator<Etablissement> it = f.getMesEtablissementsFiche().iterator();
		while (it.hasNext()) {
			Etablissement e = it.next();
			if (e.getIdUser() != idEtablissement) {
				System.out.println(e.getIdUser());
				ids.add(e.getIdUser());
			}
		}

		f.getMesEtablissementsFiche().clear();

		try {
			service.updateFichePrincipale((FichePrincipale) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateFicheMedical((FicheMedical) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateFicheVaccin((FicheVaccin) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateFicheImage((FicheImage) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}

		Iterator<Long> it1 = ids.iterator();
		while (it1.hasNext()) {
			Long a = it1.next();
			f = (Fiche) service.getFiche(idFiche);
			System.out.println(a);
			Etablissement e = (Etablissement) service.getEtablissement(a);
			f.getMesEtablissementsFiche().add(e);
			try {
				service.updateFichePrincipale((FichePrincipale) f);
			} catch (Exception e1) {
				// TODO Auto-generated catch block

			}
			try {
				service.updateFicheMedical((FicheMedical) f);
			} catch (Exception e1) {
				// TODO Auto-generated catch block

			}
			try {
				service.updateFicheVaccin((FicheVaccin) f);
			} catch (Exception e1) {
				// TODO Auto-generated catch block

			}
			try {
				service.updateFicheImage((FicheImage) f);
			} catch (Exception e1) {
				// TODO Auto-generated catch block

			}
		}

	}

	// ********************link***********************

	@RequestMapping(value = "/linkFicheEtablissement",method=RequestMethod.GET)
	public void linkFicheEtablissement(@RequestParam long idEtablissement,@RequestParam long idFiche) {
		Object f;
		Object e;
		e = service.getEtablissement(idEtablissement);
		f = service.getFiche(idFiche);

		((Fiche) f).getMesEtablissementsFiche().add((Etablissement) e);

		try {
			service.updateFichePrincipale((FichePrincipale) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateFicheMedical((FicheMedical) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateFicheVaccin((FicheVaccin) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateFicheImage((FicheImage) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}

	}

	@RequestMapping(value = "/linkFicheEnfant",method=RequestMethod.GET)
	public void linkFicheEnfant(@RequestParam long idEnfant,@RequestParam long idFiche) {
		Object f;
		Object e;
		e = service.getEnfant(idEnfant);
		f = service.getFiche(idFiche);

		((Fiche) f).setMonEnfant((Enfant) e);

		try {
			service.updateFichePrincipale((FichePrincipale) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateFicheMedical((FicheMedical) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateFicheVaccin((FicheVaccin) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateFicheImage((FicheImage) f);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}

	}

	// *************************get**************

	@RequestMapping(value = "/getFiche",method=RequestMethod.GET)
	public Fiche getFiche(@RequestParam long idFiche) {
		return (Fiche) service.getFiche(idFiche);
	}

	@RequestMapping(value = "/deleteFiche",method=RequestMethod.GET)
	public void deleteFiche(@RequestParam long idFiche) {
		
		try {
			service.deleteFichePrincipale((FichePrincipale) service.getFiche(idFiche));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		try {
			service.deleteFicheMedical((FicheMedical) service.getFiche(idFiche));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		try {
			service.deleteFicheVaccin((FicheVaccin) service.getFiche(idFiche));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		try {
			service.deleteFicheImage((FicheImage) service.getFiche(idFiche));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}
	@RequestMapping(value = "/findAllEtablissementFiche")
	public List<Etablissement> findAllEtablissementFiche(long idFiche) {
		return service.findAllEtablissementFiche(idFiche);
	}
	@RequestMapping(value = "/findAllDemandeEnfant",method=RequestMethod.GET)
	public List<Demande> findAllDemandeEnfant(@RequestParam long idEnfant){
		return service.findAllDemandeEnfant(idEnfant);
	}
}
