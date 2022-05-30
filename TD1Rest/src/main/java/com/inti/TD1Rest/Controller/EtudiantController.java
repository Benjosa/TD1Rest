package com.inti.TD1Rest.Controller;

import java.util.List;

import com.inti.TD1Rest.Repository.EtudiantRepository;
import com.inti.TD1Rest.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantController 
{
	
	@Autowired
	EtudiantRepository er;
	
	
	@GetMapping("/test")
	public String hello()
	{
		
		return "Hello World!";
	}
	
	@PostMapping("/addEtudiant")
	public String insertEtudiant()
	{
		Etudiant e1 = new Etudiant("test", "test", "test@test", "123456789", "2019");
		Etudiant e2 = new Etudiant("alice", "alice", "alice@test", "123456789", "2020");
		Etudiant e3 = new Etudiant("Claire", "Claire", "Claire@test", "123456789", "2021");
		Etudiant e4 = new Etudiant("titi", "titi", "titi@test", "123456789", "2017");
		Etudiant e5 = new Etudiant("Anahi", "Anahi", "Anahi@test", "123456789", "2018");
		
		er.save(e1);
		er.save(e2);
		er.save(e3);
		er.save(e4);
		er.save(e5);
		
		return "etudiants Enregistrer";
	}
	
	@GetMapping("/allEtudiants")
	public List<Etudiant> getAll()
	{
		
		return er.findAll();
	}
	
	@GetMapping("/deleteEtudiant")
	public String deleteEtudiant()
	{
		er.deleteById(1);
		
		return "Etudiant Supprimer";
	}
	
	@GetMapping("/getEtudiant")
	public Etudiant getEtudiant(@Param("id") int id)
	{
		
		return er.getById(id);
	}
	
	
	
	

}
