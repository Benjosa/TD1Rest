package com.inti.TD1Rest.Controller;

import java.util.List;

import com.inti.TD1Rest.Repository.ProfesseurRepository;
import com.inti.TD1Rest.model.Professeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesseurController 
{
	@Autowired
	ProfesseurRepository pr;
	
	@PostMapping("/addProf")
	public ResponseEntity<Professeur> saveProf(@RequestBody Professeur p)
	{
		
		return new ResponseEntity<Professeur>(pr.save(p), HttpStatus.CREATED);
	}
	
	@GetMapping("/allProfesseur")
	public ResponseEntity<List<Professeur>> getAllProfesseur()
	{
		
		return new ResponseEntity<List<Professeur>>(pr.findAll(), HttpStatus.OK);
	}
	
	@PutMapping("/uptdateProfesseur/{id}")
	public String uptdateProfesseur(@RequestBody Professeur p, @PathVariable int id)
	{
		Professeur p1 = pr.getReferenceById(id);
		
		pr.save(p1);
		
		return "the teacher : " + p1 + "has been update";
	}
	
	@DeleteMapping("/deleteProfesseur")
	public String deleteProfesseur(@RequestParam("id") int id)
	{
		pr.deleteById(id);
		
		return "teacher deleted";
	}

}
