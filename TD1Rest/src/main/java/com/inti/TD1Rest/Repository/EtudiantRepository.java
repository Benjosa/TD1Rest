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

}
