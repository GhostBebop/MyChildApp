package com.g1.projetfinalserveur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.g1.projetfinalserveur.metier.Etablissement;
import com.g1.projetfinalserveur.metier.Fiche;
import com.g1.projetfinalserveur.metier.FichePrincipale;

@Repository
public interface FichePrincipaleDAO extends JpaRepository<FichePrincipale, Long>{
	@Query("SELECT fp FROM FichePrincipale fp WHERE fp.monEnfant.idEnfant = :x")
	List<FichePrincipale> findAllFichePrincipaleEnfant(@Param("x") long idEnfant);
	
	@Query("SELECT f FROM Fiche f WHERE f.monEnfant.idEnfant = :x")
	List<Fiche> findAllFicheEnfant(@Param("x") long idEnfant);
	
	

	@Query("SELECT f FROM Fiche f")
	List<Fiche> findAllFiche();
	
	
	


	@Query( "select distinct fp from FichePrincipale fp join fp.mesEtablissementsFiche e where e.idUser = :x" )
	public List<FichePrincipale> findAllFichePrincipaleEtablissement(@Param("x") long idEtablissement);
	
	@Query( "select distinct f from Fiche f join f.mesEtablissementsFiche e where e.idUser = :x" )
	public List<Fiche> findAllFicheEtablissement(@Param("x") long idEtablissement);
	
	@Query( "select distinct e from Etablissement e join e.mesFiches f where f.idFiche = :x" )
	public List<Etablissement> findAllEtablissementFiche(@Param("x") long idFiche);
	
}
