package com.g1.projetfinalserveur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.g1.projetfinalserveur.metier.Demande;


@Repository
public interface DemandeDAO extends JpaRepository<Demande, Long>{
	@Query("SELECT d FROM Demande d WHERE d.maDemandeFiche.idFiche = :x")
	List<Demande> findAllDemandeFiche(@Param("x") long idFiche);
	
	@Query("SELECT d FROM Demande d WHERE d.maDemandeEnfant.idEnfant = :x")
	List<Demande> findAllDemandeEnfant(@Param("x") long idEnfant);
	
	@Query("SELECT d FROM Demande d WHERE d.maDemandeEtablissement.idUser = :x")
	List<Demande> findAllDemandeEtablissement(@Param("x") long idEtablissement);
}
