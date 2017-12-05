package com.g1.projetfinalserveur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.g1.projetfinalserveur.metier.Connexion;
import com.g1.projetfinalserveur.metier.Etablissement;
import com.g1.projetfinalserveur.metier.Responsable;
import com.g1.projetfinalserveur.metier.User;

@Repository
public interface ConnexionDAO extends JpaRepository<Connexion, Long> {
	@Query("SELECT c FROM Connexion c where c.login like :x and c.mdp like :y")
	public Connexion findMaConnexion(@Param("x") String login,@Param("y") String mdp);
	
	@Query("SELECT r FROM Responsable r where r.maConnexion.login like :x and r.maConnexion.mdp like :y")
	public Responsable findResponsable(@Param("x") String login,@Param("y") String mdp);
	
	@Query("SELECT e FROM Etablissement e where e.maConnexion.login like :x and e.maConnexion.mdp like :y")
	public Etablissement connexionEtablissement(@Param("x") String login,@Param("y") String mdp);
	
	
	@Query("SELECT u FROM User u where u.maConnexion.login like :x and u.maConnexion.mdp like :y")
	public User findObjectConnexion(@Param("x") String login,@Param("y") String mdp);
}
