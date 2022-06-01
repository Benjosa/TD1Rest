package com.inti.TD1Rest.Repository;

import com.inti.TD1Rest.model.Ecole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Integer>
{
	@Query(value = "select ec.* from etudiant e, ecole ec\n"
			+ "where e.id_ecole=ec.id and e.email =:mail", nativeQuery = true)
	Ecole findSchoolByEmailStudent(@Param("mail") String mail);
	
	@Query(value = "select ec.* from ecole ec, etudiante where ec.id=e.id_ecole and e.nom =:nom and e.prenom =:prenom", nativeQuery = true)
	Ecole findSchoolByNomAndPrenom(@Param("nom") String nom, @Param("prenom") String prenom);
	
	
}
