package com.g1.projetfinalserveur.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.g1.projetfinalserveur.metier.Enfant;


@Repository
public interface EnfantDAO extends JpaRepository<Enfant, Long> {
	@Query("select e from Enfant e where e.monResponsable.idUser = :x")
	List<Enfant> findAllEnfantResponsable(@Param("x") long idUser);

	@Query("select distinct e from Enfant e join e.mesEtablissementsEnfant et where et.idUser = :x")
	public List<Enfant> findAllEnfantEtablissement(@Param("x") long idEtablissement);

}
