package com.inti.TD1Rest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.inti.TD1Rest.Repository.EcoleRepository;
import com.inti.TD1Rest.model.Ecole;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EcoleRepositoryTest 
{
	@Autowired
	EcoleRepository er;
	
	Ecole e1;
	
	@BeforeEach
	public void setUp()
	{
		e1 = new Ecole("inti", "adresse", 1234, "ville");
	}
	
	@Test
	public void testGetSchoolByStudentsNameAndPrenom()
	{
		
		Ecole ecole = er.findSchoolByNomAndPrenom("Alice", "Alice");
		
		assertThat(ecole).isNotNull();
		assertThat(ecole.getNom()).isEqualTo("inti");
	}
	

}
