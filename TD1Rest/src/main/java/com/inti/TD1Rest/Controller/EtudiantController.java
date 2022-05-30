package com.inti.TD1Rest.Controller;

import java.util.List;

import com.inti.TD1Rest.Repository.EtudiantRepository;
import com.inti.TD1Rest.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  //WEB SERVICE
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
	public ResponseEntity<Etudiant> saveStudent(@RequestBody Etudiant etudiant)
	{
		
		return new ResponseEntity<Etudiant>(er.save(etudiant), HttpStatus.CREATED);
	}
	
	@GetMapping("/allEtudiants")
	public ResponseEntity<List<Etudiant>> getAllEtudiants()
	{
		
		return new ResponseEntity<List<Etudiant>>(er.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/deleteEtudiant")
	public String deleteEtudiant()
	{
		er.deleteById(1);
		
		return "Etudiant Supprimer";
	}
	
	@GetMapping("/getEtudiant")
	public Etudiant getEtudiant()
	{
		
		return er.getById(3);
	}
	
	
	
	

}
