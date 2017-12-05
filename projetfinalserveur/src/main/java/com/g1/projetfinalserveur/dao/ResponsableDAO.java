package com.g1.projetfinalserveur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.g1.projetfinalserveur.metier.Responsable;

@Repository
public interface ResponsableDAO extends JpaRepository<Responsable, Long>{
	
}
