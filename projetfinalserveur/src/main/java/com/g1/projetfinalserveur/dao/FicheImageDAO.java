package com.g1.projetfinalserveur.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.g1.projetfinalserveur.metier.FicheImage;

@Repository
public interface FicheImageDAO extends JpaRepository<FicheImage, Long>{
	@Query("SELECT fi FROM FicheImage fi WHERE fi.monEnfant.idEnfant = :x")
	List<FicheImage> findAllFicheImageEnfant(@Param("x") long idEnfant);
	
	@Query( "select distinct fi from FicheImage fi join fi.mesEtablissementsFiche e where e.idUser = :x" )
	public List<FicheImage> findAllFicheImageEtablissement(@Param("x") long idEtablissement);
}
