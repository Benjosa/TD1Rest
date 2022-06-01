package com.inti.TD1Rest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.inti.TD1Rest.Repository.EtudiantRepository;
import com.inti.TD1Rest.model.Etudiant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EtudiantRepositoryTest 
{
	@Autowired
	EtudiantRepository er;
	
	Etudiant etudiant1, etudiant2, etudiant3;
	
	@BeforeEach
	public void setUp()
	{
		etudiant1 = new Etudiant();
		etudiant2 = new Etudiant("ToTo", "Toto", "toto@toto", "11111", "2");
		etudiant3 = new Etudiant("titi", "titi", "titi@titi", "99999", "3");
	}
	
	@Test
	public void TestSaveEtudiant()
	{
		// WHEN
		Etudiant saveEtudiant = er.save(etudiant2);
		
		//Then
		assertThat(saveEtudiant).isNotNull();
//		assertThat(saveEtudiant.getAnneeEtude()).isGreaterThan("2");
		
	}
	
	@Test
	public void testGetEtudiant()
	{
		// when 
		Etudiant getEtudiant = er.getReferenceById(2);
		
		// then 
		assertThat(getEtudiant).isNotNull();
//		assertThat(getEtudiant.getNom()).isGreaterThan("titi");
//		assertThat(getEtudiant.getId()).isEqualTo(2);
	}
	
	@Test
	public void testFindAllStudents()
	{
		//When 
		List<Etudiant> listeEtudiants =er.findAll();
		
		// THEN
		assertThat(listeEtudiants).isNotEmpty();
		assertThat(listeEtudiants).hasSize((int) er.count());
//		assertThat(listeEtudiants.get(1)).hasSameClassAs(Etudiant.class);
//		assertThat(listeEtudiants.get(1)).hasToString(etudiant2.toString());
		
	}
	
	
	

}
