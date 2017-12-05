package com.g1.projetfinalserveur.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.g1.projetfinalserveur.metier.EtablissementEcole;


@Repository
public interface EcoleDAO extends JpaRepository<EtablissementEcole, Long>{
	@Query( "select distinct ee from EtablissementEcole ee join ee.mesFiches f where f.idFiche = :x" )
	public List<EtablissementEcole> findAllEcoleFiche(@Param("x") long idFiche);
	
	@Query( "select distinct ee from EtablissementEcole ee join ee.mesEnfants en where en.idEnfant = :x" )
	public List<EtablissementEcole> findAllEcoleEnfant(@Param("x") long idEnfant);
	
	
}
