package com.g1.projetfinalserveur.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.g1.projetfinalserveur.metier.EtablissementCentreLoisirs;


@Repository
public interface CentreLoisirsDAO extends JpaRepository<EtablissementCentreLoisirs, Long> {
	@Query("select distinct cl from EtablissementCentreLoisirs cl join cl.mesFiches f where f.idFiche = :x")
	public List<EtablissementCentreLoisirs> findAllCentreLoisirFiche(@Param("x") long idFiche);
	
	@Query( "select distinct cl from EtablissementCentreLoisirs cl join cl.mesEnfants e where e.idEnfant = :x" )
	public List<EtablissementCentreLoisirs> findAllCentreLoisirEnfant(@Param("x") long idEnfant);
}


















