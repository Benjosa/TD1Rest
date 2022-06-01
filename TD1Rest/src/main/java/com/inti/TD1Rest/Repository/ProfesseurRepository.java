package com.inti.TD1Rest.Repository;

import java.util.List;

import com.inti.TD1Rest.model.Professeur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer>
{
	
	@Query(value = "select p.* from professeur p, ecole e, ecole_professeur pe"
			+ "where p.id = pe.id_professeur and e.id = pe.id_ecole and e.id=:id"
			+ "order by salaire", nativeQuery = true)
	List<Professeur> getProfBySchoolOrderBySalaire(@Param("id") int id);

}
