package com.g1.projetfinalserveur.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.g1.projetfinalserveur.metier.EtablissementClub;
;

@Repository
public interface ClubDAO extends JpaRepository<EtablissementClub, Long>{
	@Query( "select distinct c from EtablissementClub c join c.mesFiches f where f.idFiche = :x" )
	public List<EtablissementClub> findAllClubFiche(@Param("x") long idFiche);
	

	@Query( "select distinct c from EtablissementClub c join c.mesEnfants e where e.idEnfant = :x" )
	public List<EtablissementClub> findAllClubEnfant(@Param("x") long idEnfant);
}
