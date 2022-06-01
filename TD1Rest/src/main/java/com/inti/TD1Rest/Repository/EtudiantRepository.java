package com.inti.TD1Rest.Repository;

import java.util.List;

import com.inti.TD1Rest.model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>
{
	@Query(value = "select * from Etudiant where id_ecole =:idEcole", nativeQuery = true) // au format sql
	List<Etudiant> findAllByIdEcole(@Param("idEcole") int idEcole);
	
	@Query(value = " select * from Etudiant where id_ecole in "
			+ "(select id from Ecole where ville = 'Lyon')", nativeQuery = true)
	List<Etudiant> findAllByVille();
	
	
	@Query(value = "select e.* from etudiant e, professeur p, professeur_etudiant pe"
			+ "where e.id=pe.id_etudiant and p.id = pe.id_professeur and p.id=:id", nativeQuery = true)
	List<Etudiant> getAllStudentsByTeacher(@Param("id") int id);

}
